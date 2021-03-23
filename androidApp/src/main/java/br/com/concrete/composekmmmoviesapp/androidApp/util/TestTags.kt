package br.com.concrete.composekmmmoviesapp.androidApp.util

const val SCREEN_MOVIES = "movies-screen"
const val SCREEN_FAVORITES = "favorites-screen"
const val COMPONENT_LIST_MOVIES ="movies-list-view"
const val COMPONENT_ITEM_MOVIES ="movies-item-view"
private const val BUTTON_ = "button-"

fun tagButton(tag: String) = "$BUTTON_$tag"
