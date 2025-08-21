package com.example.data.dataSource.onlineDataSource

import com.example.data.dataSource.onlineDataSource.contract.HomeDataSource
import com.example.data.dataSource.onlineDataSource.impl.HomeDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceBind{

    @Binds
    abstract fun bindDataSource(
        homeDataSourceImpl: HomeDataSourceImpl
    ): HomeDataSource
}