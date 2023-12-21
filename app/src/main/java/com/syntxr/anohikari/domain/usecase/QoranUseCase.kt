package com.syntxr.anohikari.domain.usecase

import com.syntxr.anohikari.domain.model.Jozz
import com.syntxr.anohikari.domain.model.Qoran
import com.syntxr.anohikari.domain.model.Sora
import com.syntxr.anohikari.domain.repository.QoranRepository
import com.syntxr.anohikari.domain.utils.SortType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class QoranUseCase(
    private val repository: QoranRepository
) {

    suspend fun getSora(): List<Sora> {
        return repository.getSora()
//            .map { sora ->
//            when (sortType) {
//                is SortType.Ascending -> sora.sortedBy { it.soraNo }
//                is SortType.Descending -> sora.sortedByDescending { it.soraNo }
//            }
//        }
    }

    suspend fun getJozz(): List<Jozz> {
        return repository.getJozz()
//            .map { jozz ->
//            when(sortType){
//                is SortType.Ascending -> jozz.sortedBy { it.jozz }
//                is SortType.Descending -> jozz.sortedByDescending { it.jozz }
//            }
//        }
    }

    suspend fun getSoraJozz(jozzNo: Int): List<Sora> {
        return repository.getSoraJozz(jozzNo)
    }

    suspend fun getAyaSora(soraNo: Int): List<Qoran> {
        return repository.getAyaSora(soraNo)
    }

    suspend fun getAyaJozz(jozzNo: Int): List<Qoran> {
        return repository.getAyaJozz(jozzNo)
    }
}