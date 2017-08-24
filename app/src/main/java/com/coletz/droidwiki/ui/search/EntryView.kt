package com.coletz.droidwiki.ui.search

import com.coletz.droidwiki.model.Entry

interface EntryView {
    fun displayLoading()

    fun dismissLoading()

    fun displayEntries(results: List<Entry>)

    fun displayError(error: String?)
}