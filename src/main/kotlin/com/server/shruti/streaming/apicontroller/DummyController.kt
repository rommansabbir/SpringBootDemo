package com.server.shruti.streaming.apicontroller

import com.server.shruti.streaming.base.APIResponse
import com.server.shruti.streaming.services.DummyService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/dummy")
class DummyController(private val service: DummyService) {

    @RequestMapping(method = [RequestMethod.GET], produces = ["application/json"])
    fun getUsers(): ResponseEntity<APIResponse<*>> =
        ResponseEntity(APIResponse(message = "Success", data = service.getUserList()), HttpStatus.OK)

    @RequestMapping(method = [RequestMethod.GET], value = ["{userId}"], produces = ["application/json"])
    fun getUser(@PathVariable userId: Int): ResponseEntity<APIResponse<*>> =
        ResponseEntity(
            APIResponse(message = "Success", data = service.getUserList().first { it.userId == userId }),
            HttpStatus.OK
        )
}

