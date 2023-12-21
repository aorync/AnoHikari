package com.syntxr.anohikari.domain.model

import androidx.room.ColumnInfo
import androidx.room.DatabaseView

@DatabaseView("SELECT sora, sora_descend_place, sora_name_ar, sora_name_emlaey, sora_name_en, sora_name_id, COUNT(aya_no) as total_aya FROM quran GROUP BY sora")
data class Sora(
    @ColumnInfo(name = "sora")
    val soraNo: Int,

    @ColumnInfo(name = "sora_descend_place")
    val soraPlace: String,

    @ColumnInfo(name = "sora_name_ar")
    val soraNameAr: String,

    @ColumnInfo(name = "sora_name_emlaey")
    val soraNameEmlaey: String,

    @ColumnInfo(name = "sora_name_en")
    val soraNameEn: String,

    @ColumnInfo(name = "sora_name_id")
    val soraNameId: String,

    @ColumnInfo(name = "total_aya")
    val ayaTotal: Int
)
