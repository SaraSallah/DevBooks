package com.example.storyscope.di

import com.example.storyscope.data.api.StoryScopeServices
import com.example.storyscope.data.repository.StoryScopeRepository
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
    fun provideBookRepository(api : StoryScopeServices):StoryScopeRepository{
        return StoryScopeRepository(api)
    }

}