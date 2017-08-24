package com.coletz.droidwiki.ui.search

import android.content.Context
import com.coletz.droidwiki.Wiki
import com.coletz.droidwiki.application.WikiApplication
import com.coletz.droidwiki.model.SearchResult
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class EntryPresenterImpl(context: Context) : EntryPresenter {

  private lateinit var entryView: EntryView

  @Inject lateinit var wiki: Wiki

  init {
    (context as WikiApplication).wikiComponent.inject(this)
  }

  override fun setView(entryView: EntryView) {
    this.entryView = entryView
  }

  override fun getEntry(query: String) {
    entryView.displayLoading()
    wiki.search(query).enqueue(object : Callback {
      override fun onResponse(call: Call?, response: Response?) {
        entryView.dismissLoading()
        //Everything is ok, show the result if not null
        if (response?.isSuccessful == true) {
          SearchResult(response).list?.let {
            entryView.displayEntries(it)
          }
        } else {
          entryView.displayError(response?.message())
        }
      }

      override fun onFailure(call: Call?, t: IOException?) {
        entryView.displayError(t?.message)
        t?.printStackTrace()
      }
    })

  }
}