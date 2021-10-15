package com.server.shruti.streaming.apicontroller

import com.server.shruti.streaming.base.APIErrors
import com.server.shruti.streaming.base.APIException
import com.server.shruti.streaming.base.APIResponse
import com.server.shruti.streaming.datasource.DummyModel
import com.server.shruti.streaming.services.DummyService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/dummy")
class DummyController(private val service: DummyService) {

    @GetMapping()
    fun getUsers(): APIResponse<*> = APIResponse(message = "Success", data = service.getUserList())

    @GetMapping("{userId}")
    fun getUser(@PathVariable userId: Int): APIResponse<*> {
        return try {
            return when (val itemToReturn = service.getUserList().find { it.userId == userId }) {
                null -> {
                    APIResponse<DummyModel>(
                        message = "Found not user with userId:${userId}", data = null, status = false, error =
                        mutableListOf(APIErrors.getUserNotFoundException)
                    )
                }
                else -> {
                    APIResponse(message = "Found user with userId:${userId}", data = itemToReturn)
                }
            }
        } catch (e: Exception) {
            APIResponse(
                message = "Found user with userId:${userId}", data = null, status = false, error =
                mutableListOf(APIErrors.mapTopAPIException(e))
            )
        }
    }
}

