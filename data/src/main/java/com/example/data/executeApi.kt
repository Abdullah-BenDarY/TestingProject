package com.example.data

import com.example.domain.ApiError
import com.example.domain.ApiResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import okio.IOException
import org.json.JSONObject
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.util.concurrent.TimeoutException

fun <T> executeApi(apiCall: suspend () -> T) = flow <ApiResult<T>> {
    val response = apiCall.invoke()
    emit(ApiResult.Success(data = response))
}.catch {ex ->
    val error = when (ex){
        is SocketTimeoutException , is TimeoutException -> ApiError.Timeout("Timeout")
        is IOException -> ApiError.Connection("Connection error")
        is HttpException -> {
            when (ex.code()) {
                in 400..499 ->{
                    val errorBody = ex.response()?.errorBody()?.string()
                    val errorMessage = parseErrorMessage(errorBody)
                    ApiError.Server(ex.code(), errorMessage)
                }
                in 500..599 -> ApiError.Server(ex.code(), "Server error")
                else -> ApiError.Unknown(ex.localizedMessage?: "Unknown error")
            }
        }
        else -> ApiError.Unknown(ex.message ?: "Unknown error")
    }
    emit(ApiResult.Failure(error))
}

private fun parseErrorMessage(errorBody : String?): String {
    return try{
        val json = JSONObject(errorBody?:"")
            json.optString("message", "error")
    }
    catch (e: Exception) {
        "error"
    }
}