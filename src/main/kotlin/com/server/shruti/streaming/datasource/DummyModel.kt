package com.server.shruti.streaming.datasource

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document

@Document("Dummy")
data class DummyModel(val userId: Int, val username: String, val id: String = ObjectId().toString())