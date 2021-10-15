package com.server.shruti.streaming.datasource.dummy

import com.server.shruti.streaming.repository.DummyRepositoryImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DummyRepositoryImplTest {
    private val dummyRepository = DummyRepositoryImpl()

    @Test
    fun `before provide a list of dummy users`() {
        val list = dummyRepository.getDummyUserList()
        assertThat(list).isNotEmpty
    }

    @Test
    fun `should provide proper dummy users`() {
        val list = dummyRepository.getDummyUserList()
        assertThat(list).allMatch { it.username.isNotEmpty() }
        assertThat(list).allMatch { it.userId != 0 }
    }
}