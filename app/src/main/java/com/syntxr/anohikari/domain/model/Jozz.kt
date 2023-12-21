package com.syntxr.anohikari.domain.model

import androidx.room.DatabaseView

@DatabaseView("SELECT jozz FROM quran")
data class Jozz(
    val jozz: Int
)
