package com.coletz.droidwiki.dagger

import com.coletz.droidwiki.Homepage
import com.coletz.droidwiki.Wiki
import com.coletz.droidwiki.WikiApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WikiModule(private val lang: String) {

  @Provides
  @Singleton
  fun provideWiki(api: WikiApi) = Wiki(api, lang)

  @Provides
  @Singleton
  fun provideHomepage(api: WikiApi) = Homepage(api, lang)
}