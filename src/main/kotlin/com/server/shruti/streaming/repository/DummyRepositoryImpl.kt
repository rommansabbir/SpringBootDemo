package com.server.shruti.streaming.repository

import com.server.shruti.streaming.datasource.DummyModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class DummyRepositoryImpl : DummyRepository {
    @Autowired
    private lateinit var repository: DummyMongoRepository

    override fun getDummyUserList(): Collection<DummyModel> {
        val list = repository.findAll()
        if (list.isEmpty()){
            throw NoDummyModelFoundException("No dummy model found.")
        }
        return list
    }

    override fun saveModel(model: DummyModel): Boolean {
        repository.save(model)
        return true
    }
}