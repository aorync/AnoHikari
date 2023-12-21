package com.syntxr.anohikari.domain.utils

sealed class SortType{
    data object Ascending: SortType()
    data object Descending: SortType()
}
