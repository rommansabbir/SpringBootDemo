package com.server.shruti.streaming.apicontroller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class DummyControllerTest {
    @Autowired
    lateinit var mockMVC: MockMvc

    @Test
    fun `verify`() {
        mockMVC.get("/api/dummy/success")
            .andDo { print() }
            .andExpect {
                status {
                    isOk()
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("data[0].username") {
                        value("rommansabbir")
                    }
                }
            }

    }
}