package com.example.data.dataSource.onlineDataSource.impl

import com.example.data.dataSource.onlineDataSource.contract.HomeDataSource
import com.example.data.executeApi
import com.example.data.services.ApiCalls
import com.example.domain.handleState.ApiResult
import com.example.domain.models.ModelAllMeals
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeDataSourceImpl @Inject constructor (private val apiCalls: ApiCalls) : HomeDataSource {
    override fun getMealByName(name: Char): Flow<ApiResult<ModelAllMeals>> =
        executeApi {
            apiCalls.getMealByName(name).toDomain()
        }
}