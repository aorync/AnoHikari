package com.syntxr.anohikari.data.repository

import com.syntxr.anohikari.data.source.QoranDao
import com.syntxr.anohikari.domain.model.Jozz
import com.syntxr.anohikari.domain.model.Qoran
import com.syntxr.anohikari.domain.model.Sora
import com.syntxr.anohikari.domain.repository.QoranRepository

class QoranRepositoryImpl(
    private val dao: QoranDao
): QoranRepository {

    override suspend fun getSora(): List<Sora> {
        return dao.getSora()
    }

    override suspend fun getJozz(): List<Jozz> {
        return dao.getJozz()
    }

    override suspend fun getSoraJozz(jozzNo: Int): List<Sora> {
        return dao.getSoraJozz(jozzNo)
    }

    override suspend fun getAyaSora(soraNo: Int): List<Qoran> {
        return dao.getAyaSora(soraNo)
    }

    override suspend fun getAyaJozz(jozzNo: Int): List<Qoran> {
        return dao.getAyaJozz(jozzNo)
    }
}