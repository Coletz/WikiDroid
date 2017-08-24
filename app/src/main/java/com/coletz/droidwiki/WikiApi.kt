package com.coletz.droidwiki

import okhttp3.Call
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WikiApi @Inject constructor(private val client: OkHttpClient) {

  companion object {
    val PROTOCOL = "https://"
    val BASE_URL = ".wikipedia.org/w/api.php"
  }

  fun search(lang: String, query: String): Call {

    val urlBuilder = HttpUrl.parse("$PROTOCOL$lang$BASE_URL")?.newBuilder()
        ?.addQueryParameter("action", "query")
        ?.addQueryParameter("list", "search")
        ?.addQueryParameter("format", "json")
        ?.addQueryParameter("srsearch", query)

    return Request.Builder()
        .url(urlBuilder?.build())
        .get()
        .build()
        .let {
          client.newCall(it)
        }

  }

  fun getHomepage(lang: String): Call {

    val urlBuilder = HttpUrl.parse("$PROTOCOL$lang$BASE_URL")?.newBuilder()
        ?.addQueryParameter("action", "parse")
        ?.addQueryParameter("page", "Main Page")
        ?.addQueryParameter("format", "json")

    return Request.Builder()
        .url(urlBuilder?.build())
        .get()
        .build()
        .let {
          client.newCall(it)
        }

  }
}