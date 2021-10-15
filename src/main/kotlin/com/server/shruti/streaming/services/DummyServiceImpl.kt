package com.server.shruti.streaming.services

import com.server.shruti.streaming.base.BaseService
import com.server.shruti.streaming.datasource.DummyModel
import com.server.shruti.streaming.repository.DummyRepository
import org.springframework.stereotype.Service

@Service
class DummyServiceImpl constructor(private val repository: DummyRepository) : DummyService {
    override fun getUserList(): Collection<DummyModel> {
        return repository.getDummyUserList()
    }

    override fun generateLog(message: String):Boolean {
        println("Logger: $message")
        return true
    }

}


