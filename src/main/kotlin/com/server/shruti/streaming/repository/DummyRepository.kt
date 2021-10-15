package com.server.shruti.streaming.repository

import com.server.shruti.streaming.datasource.DummyModel

interface DummyRepository {
    fun getDummyUserList(): Collection<DummyModel>
}