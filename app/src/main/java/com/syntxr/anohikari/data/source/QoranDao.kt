package com.syntxr.anohikari.data.source

import androidx.room.Dao
import androidx.room.Query
import com.syntxr.anohikari.domain.model.Jozz
import com.syntxr.anohikari.domain.model.Qoran
import com.syntxr.anohikari.domain.model.Sora
import kotlinx.coroutines.flow.Flow

@Dao
interface QoranDao {

    @Query("SELECT  * FROM sora")
    suspend fun getSora(): List<Sora>

    @Query("SELECT  * FROM jozz")
    suspend fun getJozz(): List<Jozz>

    @Query("SELECT sora, sora_name_emlaey, sora_descend_place, sora_name_id, sora_name_en, sora_name_ar, COUNT(aya_no) as total_aya FROM quran WHERE jozz = :jozzNo GROUP BY sora")
   suspend fun getSoraJozz(jozzNo: Int): List<Sora>

    @Query("SELECT  * FROM quran WHERE sora = :soraNo")
    suspend fun getAyaSora(soraNo: Int): List<Qoran>

    @Query("SELECT * FROM quran WHERE jozz = :jozzNo")
    suspend fun getAyaJozz(jozzNo: Int): List<Qoran>
}