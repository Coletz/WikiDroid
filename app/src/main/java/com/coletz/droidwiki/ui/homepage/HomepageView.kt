package com.coletz.droidwiki.ui.homepage

import com.coletz.droidwiki.model.WikiHomepage

interface HomepageView {
  fun displayLoading()

  fun dismissLoading()

  fun displayHomepage(result: WikiHomepage)

  fun displayError(error: String?)
}