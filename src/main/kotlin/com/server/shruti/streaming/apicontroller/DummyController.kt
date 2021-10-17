package com.server.shruti.streaming.apicontroller

import com.server.shruti.streaming.base.APIResponse
import com.server.shruti.streaming.datasource.DummyModel
import com.server.shruti.streaming.services.DummyService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @RequestMapping(method = [RequestMethod.POST], produces = ["application/json"], path = ["/addNew/"])
    fun addNewUser(@RequestBody body: DummyModel): ResponseEntity<APIResponse<*>> {
        service.saveModel(body)
        return ResponseEntity(
            APIResponse(
                status = true,
                message = "Success",
                data = body
            ),
            HttpStatus.CREATED
        )
    }
}

