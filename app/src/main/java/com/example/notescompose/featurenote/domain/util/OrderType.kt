package com.example.notescompose.featurenote.domain.util

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}