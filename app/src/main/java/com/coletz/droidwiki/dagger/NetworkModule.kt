package com.coletz.droidwiki.dagger

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton


@Module
class NetworkModule {
  @Provides
  @Singleton
  fun provideHttpClient() = OkHttpClient()
}