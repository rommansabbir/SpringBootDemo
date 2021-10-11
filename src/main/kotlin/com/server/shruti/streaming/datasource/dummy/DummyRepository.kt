package com.server.shruti.streaming.datasource.dummy

import com.server.shruti.streaming.datasource.DummyModel

interface DummyRepository {
    fun getDummyUserList(): MutableList<DummyModel>
}