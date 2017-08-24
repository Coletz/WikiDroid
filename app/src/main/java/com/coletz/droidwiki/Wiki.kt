package com.coletz.droidwiki

import javax.inject.Singleton

@Singleton
class Wiki(private val api: WikiApi, private val lang: String) {
  fun search(query: String) = api.search(lang, query)
}
