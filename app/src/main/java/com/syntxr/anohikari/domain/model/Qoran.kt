package com.syntxr.anohikari.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quran")
data class Qoran(
    @PrimaryKey
    val id: Int? = 0,

    val jozz: Int? = 0,

    @ColumnInfo(name = "sora")
    val soraNo: Int? = 0,

    @ColumnInfo(name = "sora_name_en")
    val soraNameEn: String? = "",

    @ColumnInfo(name = "sora_name_ar")
    val soraNameAr: String? = "",

    val page: Int? = 0,

    @ColumnInfo(name = "aya_no")
    val ayaNo: Int? = 0,

    @ColumnInfo(name = "aya_text")
    val aya: String? = "",

    @ColumnInfo(name = "aya_text_emlaey")
    val ayaEmlaey: String? = "",

    @ColumnInfo(name = "translation_id")
    val translationId: String? = "",

    @ColumnInfo(name = "footnotes_id")
    val footnotesId: String? = "",

    @ColumnInfo(name = "sora_name_id")
    val soraNameId: String? = "",

    @ColumnInfo(name = "sora_descend_place")
    val soraPlace: String? = "",

    @ColumnInfo(name = "sora_name_emlaey")
    val soraNameEmlaey: String? = "",

    @ColumnInfo(name = "translation_en")
    val translationEn: String? = "",

    @ColumnInfo(name = "footnotes_en")
    val footnotesEn: String? = ""

)
