package com.coletz.droidwiki.dagger

import com.coletz.droidwiki.ui.search.EntryPresenterImpl
import com.coletz.droidwiki.ui.search.SearchActivity
import com.coletz.droidwiki.ui.homepage.HomepageActivity
import com.coletz.droidwiki.ui.homepage.HomepagePresenterImpl
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(
    AppModule::class,
    NetworkModule::class,
    PresenterModule::class,
    WikiModule::class)
)
interface AppComponent {
  fun inject(target: HomepageActivity)

  fun inject(target: HomepagePresenterImpl)

  fun inject(target: SearchActivity)

  fun inject(target: EntryPresenterImpl)
}