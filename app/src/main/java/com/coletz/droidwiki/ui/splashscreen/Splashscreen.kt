package com.coletz.droidwiki.ui.splashscreen

import android.app.Activity
import android.os.Bundle
import com.coletz.droidwiki.ui.homepage.HomepageActivity
import com.coletz.droidwiki.utils.start

class Splashscreen : Activity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    HomepageActivity::class.start(this, true)
  }
}