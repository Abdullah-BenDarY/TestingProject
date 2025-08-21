package com.example.data.dataSource.onlineDataSource.contract

import com.example.domain.handleState.ApiResult
import com.example.domain.models.ModelAllMeals
import kotlinx.coroutines.flow.Flow

interface HomeDataSource{
    fun getMealByName(name : Char): Flow<ApiResult<ModelAllMeals>>
}