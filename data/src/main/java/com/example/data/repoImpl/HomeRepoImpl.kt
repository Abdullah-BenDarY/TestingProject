package com.example.data.repoImpl

import com.example.data.dataSource.onlineDataSource.contract.HomeDataSource
import com.example.domain.handleState.ApiResult
import com.example.domain.models.ModelAllMeals
import com.example.domain.repo.HomeRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepoImpl @Inject constructor(private val homeDataSource: HomeDataSource) : HomeRepo {

    override fun getMealByName(name: Char): Flow<ApiResult<ModelAllMeals>> =
        homeDataSource.getMealByName(name= name)

}