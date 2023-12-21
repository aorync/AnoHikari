package com.syntxr.anohikari.domain.repository

import com.syntxr.anohikari.domain.model.Jozz
import com.syntxr.anohikari.domain.model.Qoran
import com.syntxr.anohikari.domain.model.Sora
import kotlinx.coroutines.flow.Flow

interface QoranRepository {

    suspend fun getSora(): List<Sora>
    suspend fun getJozz(): List<Jozz>
    suspend fun getSoraJozz(jozzNo: Int): List<Sora>
    suspend fun getAyaSora(soraNo: Int): List<Qoran>
    suspend fun getAyaJozz(jozzNo: Int): List<Qoran>
}