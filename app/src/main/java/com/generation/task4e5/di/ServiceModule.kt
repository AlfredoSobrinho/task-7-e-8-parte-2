package com.generation.task4e5.di

import com.generation.task4e5.reporitory.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideRepository(): Repository {

        return Repository()
    }
}