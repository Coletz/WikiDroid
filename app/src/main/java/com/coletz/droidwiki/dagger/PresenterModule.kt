package com.coletz.droidwiki.dagger

import android.content.Context
import com.coletz.droidwiki.ui.search.EntryPresenter
import com.coletz.droidwiki.ui.search.EntryPresenterImpl
import com.coletz.droidwiki.ui.homepage.HomepagePresenter
import com.coletz.droidwiki.ui.homepage.HomepagePresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {
  @Provides
  @Singleton
  fun provideEntryPresenter(context: Context): EntryPresenter = EntryPresenterImpl(context)

  @Provides
  @Singleton
  fun provideHomepagePresenter(context: Context): HomepagePresenter = HomepagePresenterImpl(context)
}