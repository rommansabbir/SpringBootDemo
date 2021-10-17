package com.server.shruti.streaming.services

import com.server.shruti.streaming.datasource.DummyModel
import com.server.shruti.streaming.repository.DummyRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.test.context.junit.jupiter.SpringExtension

//@DataMongoTest
//@ExtendWith(SpringExtension::class)
internal class DummyServiceImplTest {
    private val repository: DummyRepository = mockk(relaxed = true)
    private val dummyService = DummyServiceImpl(repository)

    @Test
    fun `generateTestCase`() {
        val list = dummyService.getUserList()
        assert(list.isNotEmpty())
        verify(exactly = 1) { dummyService.getUserList() }
    }

    @Test
    fun `save new object`(@Autowired mongoTemplate: MongoTemplate){
        val objectToBeSaved = DummyModel(userId = 1,username =  "rommansabbir")
        assert(mongoTemplate.save(objectToBeSaved) == objectToBeSaved)
    }
}