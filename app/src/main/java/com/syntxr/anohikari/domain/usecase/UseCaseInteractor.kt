package com.syntxr.anohikari.domain.usecase

import com.syntxr.anohikari.domain.repository.QoranRepository

class UseCaseInteractor(
    private val qoranRepository : QoranRepository
): AppUseCase {

    override val qoranUseCase: QoranUseCase
        get() = QoranUseCase(qoranRepository)
}