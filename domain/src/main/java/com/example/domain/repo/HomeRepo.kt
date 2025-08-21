package com.example.domain.repo

import com.example.domain.handleState.ApiResult
import com.example.domain.models.ModelAllMeals
import kotlinx.coroutines.flow.Flow

interface HomeRepo {
    fun getMealByName(name : Char): Flow<ApiResult<ModelAllMeals>>
}