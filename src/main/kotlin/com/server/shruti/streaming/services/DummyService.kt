package com.server.shruti.streaming.services

import com.server.shruti.streaming.base.BaseService
import com.server.shruti.streaming.datasource.DummyModel

interface DummyService : BaseService {
    fun getUserList(): Collection<DummyModel>
    fun saveModel(model : DummyModel) : Boolean
    fun deleteModel(model: DummyModel): Boolean
}