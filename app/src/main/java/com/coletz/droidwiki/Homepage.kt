package com.coletz.droidwiki

import javax.inject.Singleton

@Singleton
class Homepage(private val api: WikiApi, private val lang: String) {
  fun get() = api.getHomepage(lang)
}
