package com.coletz.droidwiki.ui.homepage

import android.content.Context
import android.util.Log
import com.coletz.droidwiki.Homepage
import com.coletz.droidwiki.application.WikiApplication
import com.coletz.droidwiki.model.HomepageResult
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class HomepagePresenterImpl(context: Context) : HomepagePresenter {

  private lateinit var homepageView: HomepageView

  @Inject lateinit var loadtHomepage: Homepage

  init {
    (context as WikiApplication).wikiComponent.inject(this)
  }

  override fun setView(homepageView: HomepageView) {
    this.homepageView = homepageView
  }

  override fun loadHomepage() {
    homepageView.displayLoading()
    loadtHomepage.get().enqueue(object : Callback {
      override fun onResponse(call: Call?, response: Response?) {
        homepageView.dismissLoading()
        if (response?.isSuccessful == true) {
          response.let {
            HomepageResult(it).homepage?.let {
              homepageView.displayHomepage(it)
            } ?: run {
              homepageView.displayError(response.message())
            }
          }
        } else {
          homepageView.displayError(response?.message())
        }
      }

      override fun onFailure(call: Call?, t: IOException?) {
        homepageView.displayError(t?.message)
        t?.printStackTrace()
      }
    })
  }
}