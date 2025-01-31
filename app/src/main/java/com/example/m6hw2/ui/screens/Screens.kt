package com.example.m6hw2.ui.screens

import com.example.m6hw2.data.BookModel

sealed class Screens {

    data object Main : Screens()
    data class Detail(val book: BookModel) : Screens()
}