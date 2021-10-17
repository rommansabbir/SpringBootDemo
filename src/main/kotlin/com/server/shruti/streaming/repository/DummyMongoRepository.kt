package com.server.shruti.streaming.repository

import com.server.shruti.streaming.datasource.DummyModel
import org.springframework.data.mongodb.repository.MongoRepository

interface DummyMongoRepository : MongoRepository<DummyModel, String> {
}