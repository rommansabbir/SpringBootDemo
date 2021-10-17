package com.server.shruti.streaming.services

import com.server.shruti.streaming.base.BaseService
import com.server.shruti.streaming.datasource.DummyModel
import com.server.shruti.streaming.repository.DummyRepository
import org.springframework.stereotype.Service

@Service
class DummyServiceImpl constructor(private val repository: DummyRepository) : DummyService {
    override fun getUserList(): Collection<DummyModel> {
        saveModel(DummyModel(userId = 123, username = "rommansabbir"))
        return repository.getDummyUserList()
    }

    override fun saveModel(model: DummyModel): Boolean {
        return repository.saveModel(model)
    }

    override fun deleteModel(model: DummyModel): Boolean {
        return repository.deleteModel(model)
    }

    override fun generateLog(message: String): Boolean {
        println("Logger: $message")
        return true
    }

}


