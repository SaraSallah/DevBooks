package com.example.storyscope.ui.home

sealed class HomeUiEffect {
    object ClickSearchUiEffect : HomeUiEffect()
    data class ClickBookUiEffect(val id: String) : HomeUiEffect()

}

