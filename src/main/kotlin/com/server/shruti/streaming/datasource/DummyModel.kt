package com.server.shruti.streaming.datasource

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("Dummy")
data class DummyModel(val userId: Int, val username: String){
}