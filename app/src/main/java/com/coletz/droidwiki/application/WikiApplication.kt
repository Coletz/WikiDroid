package com.coletz.droidwiki.application

import android.app.Application
import com.coletz.droidwiki.dagger.*

class WikiApplication : Application() {

  lateinit var wikiComponent: AppComponent

  override fun onCreate() {
    super.onCreate()
    wikiComponent = initDagger(this)
  }

  private fun initDagger(app: WikiApplication): AppComponent = DaggerAppComponent.builder()
      .appModule(AppModule(app))
      .wikiModule(WikiModule("en"))
      .build()
}