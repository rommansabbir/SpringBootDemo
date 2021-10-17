package com.server.shruti.streaming.datasource.dummy

import com.server.shruti.streaming.datasource.DummyModel
import com.server.shruti.streaming.repository.DummyMongoRepository
import com.server.shruti.streaming.repository.DummyRepositoryImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class DummyRepositoryImplTest {
    private val dummyRepository = DummyRepositoryImpl()
//
//    @Test
//    fun `before provide a list of dummy users`() {
//        val list = dummyRepository.getDummyUserList()
//        assertThat(list).isNotEmpty
//    }
//
//    @Test
//    fun `should provide proper dummy users`() {
//        val list = dummyRepository.getDummyUserList()
//        assertThat(list).allMatch { it.username.isNotEmpty() }
//        assertThat(list).allMatch { it.userId != 0 }
//    }

//    @Test
//    fun `object should be saved`(){
//        val newObject = DummyModel(1, 1, "rommansabbir")
//        assertThat(dummyRepository.saveModel(newObject, repositoryImplTest))
//    }
}