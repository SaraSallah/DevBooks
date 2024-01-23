package com.example.storyscope.di

import com.example.storyscope.data.api.DevBookServices
import com.example.storyscope.data.repository.DevBooksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideBookRepository(api : DevBookServices):DevBooksRepository{
        return DevBooksRepository(api)
    }

}