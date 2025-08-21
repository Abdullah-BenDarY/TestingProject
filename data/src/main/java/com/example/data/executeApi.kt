package com.example.data

import com.example.domain.handleState.ApiError
import com.example.domain.handleState.ApiResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.util.concurrent.TimeoutException

fun <T> executeApi(api: suspend () -> T) = flow<ApiResult<T>> {
    val response = api.invoke()
    emit(ApiResult.Success(response))
}.catch { ex ->
    val error = when (ex) {
        is SocketTimeoutException, is TimeoutException ->
            ApiError.Timeout("Request timed out. Please try again.")

        is IOException ->
            ApiError.Connection("Please check your internet connection.")

        is HttpException -> {
            when (ex.code()) {
                401 -> {
                    val errorBody = ex.response()?.errorBody()?.string()
                    val serverMessage = parseErrorMessage(errorBody)
                    ApiError.Server(401, serverMessage)
                }
                404 -> ApiError.Server(404, "Resource not found.")
                500 -> ApiError.Server(500, "Server error. Please try again later.")
                else -> ApiError.Server(ex.code(), ex.message ?: "Unknown server error")
            }
        }

        else ->
            ApiError.Unknown(ex.localizedMessage ?: "Unknown error")
    }
    emit(ApiResult.Failure(error))
}

private fun parseErrorMessage(errorBody: String?): String {
    return try {
        val json = JSONObject(errorBody ?: "")
        json.optString("message", "Unauthorized. Please log in again.")
    } catch (e: Exception) {
        "Unauthorized. Please log in again."
    }
}
