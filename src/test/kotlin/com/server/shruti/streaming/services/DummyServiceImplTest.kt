package com.server.shruti.streaming.services

import com.server.shruti.streaming.repository.DummyRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class DummyServiceImplTest {
    private val repository: DummyRepository = mockk(relaxed = true)
    private val dummyService = DummyServiceImpl(repository)

    @Test
    fun `generateTestCase`() {
        val list = dummyService.getUserList()
        assert(list.isNotEmpty())
        verify(exactly = 1) { dummyService.getUserList() }
    }

}