package com.server.shruti.streaming.repository

import com.server.shruti.streaming.datasource.DummyModel
import org.springframework.stereotype.Repository

@Repository
class DummyRepositoryImpl : DummyRepository {
    override fun getDummyUserList(): Collection<DummyModel> {
        return mutableListOf(
            DummyModel(1,"rommansabbir"),
            DummyModel(2,"naimanforhad"),
            DummyModel(3,"fakhrul")
        )
    }
}