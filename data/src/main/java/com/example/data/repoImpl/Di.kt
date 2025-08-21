package com.example.data.repoImpl

import com.example.domain.repo.HomeRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceBind{

    @Binds
    abstract fun bindAnalyticsService(
        homeRepoImpl: HomeRepoImpl
    ): HomeRepo
}