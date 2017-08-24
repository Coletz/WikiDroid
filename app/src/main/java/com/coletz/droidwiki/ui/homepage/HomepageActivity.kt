package com.coletz.droidwiki.ui.homepage

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.coletz.droidwiki.Homepage
import com.coletz.droidwiki.R
import com.coletz.droidwiki.application.WikiApplication
import com.coletz.droidwiki.model.WikiHomepage
import com.coletz.droidwiki.utils.errorDialog
import com.coletz.droidwiki.utils.start
import com.coletz.droidwiki.utils.parseHtml
import kotlinx.android.synthetic.main.activity_homepage.*
import javax.inject.Inject
import com.coletz.droidwiki.ui.search.SearchActivity

class HomepageActivity : Activity(), HomepageView {

  @Inject lateinit var presenter: HomepagePresenter
  @Inject lateinit var homepage: Homepage

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_homepage)

    (application as WikiApplication).wikiComponent.inject(this)

    presenter.setView(this)
    presenter.loadHomepage()

  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.homepage, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem) =
      when (item.itemId) {
        R.id.search -> {
          SearchActivity::class.start(this)
          true
        }

        else -> {
          super.onOptionsItemSelected(item)
        }
      }

  // Implementation of HomepageView

  override fun displayLoading() {
    wait_progress_bar.post {
      wait_progress_bar.visibility = View.VISIBLE
      homepage_sv.visibility = View.GONE
    }
  }

  override fun dismissLoading() {
    wait_progress_bar.post {
      wait_progress_bar.visibility = View.GONE
      homepage_sv.visibility = View.VISIBLE
    }
  }

  override fun displayHomepage(result: WikiHomepage) {
    homepage_tv.post {
      homepage_tv.text = result.htmlContent.parseHtml()
    }
  }

  override fun displayError(error: String?) {
    Log.e("ERROR", error)
    runOnUiThread {
      R.string.error.errorDialog(this)
    }
  }
}