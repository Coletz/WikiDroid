package com.coletz.droidwiki.ui.search

interface EntryPresenter {
  fun setView(entryView: EntryView)

  fun getEntry(query: String)
}