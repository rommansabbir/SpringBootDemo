package com.server.shruti.streaming.apicontroller

import com.server.shruti.streaming.base.APIErrors
import com.server.shruti.streaming.base.APIException
import com.server.shruti.streaming.base.APIResponse
import org.springframework.beans.ConversionNotSupportedException
import org.springframework.beans.TypeMismatchException
import org.springframework.boot.context.properties.bind.BindException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.http.converter.HttpMessageNotWritableException
import org.springframework.web.HttpMediaTypeNotAcceptableException
import org.springframework.web.HttpMediaTypeNotSupportedException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingPathVariableException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.ServletRequestBindingException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.context.request.async.AsyncRequestTimeoutException
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.multipart.support.MissingServletRequestPartException
import org.springframework.web.server.MethodNotAllowedException
import org.springframework.web.servlet.NoHandlerFoundException


@ControllerAdvice
class APIExceptionHandler {
    companion object {
        /**
         * Register all kind of Exceptions here
         */
        private var exceptionListHolder: MutableMap<Class<*>, HttpStatus> = HashMap<Class<*>, HttpStatus>().apply {
            put(NullPointerException::class.java, HttpStatus.NOT_FOUND)
            put(NoSuchElementException::class.java, HttpStatus.NOT_FOUND)
            put(MethodArgumentTypeMismatchException::class.java, HttpStatus.BAD_REQUEST)
            put(MethodNotAllowedException::class.java, HttpStatus.BAD_REQUEST)
            put(HttpRequestMethodNotSupportedException::class.java, HttpStatus.BAD_REQUEST)
            put(NoHandlerFoundException::class.java, HttpStatus.NOT_FOUND)
            put(IllegalArgumentException::class.java, HttpStatus.CONFLICT)
            put(IllegalStateException::class.java, HttpStatus.CONFLICT)
            put(HttpMediaTypeNotSupportedException::class.java, HttpStatus.UNSUPPORTED_MEDIA_TYPE)
            put(HttpMediaTypeNotAcceptableException::class.java, HttpStatus.NOT_ACCEPTABLE)
            put(MissingPathVariableException::class.java, HttpStatus.INTERNAL_SERVER_ERROR)
            put(MissingServletRequestParameterException::class.java, HttpStatus.BAD_REQUEST)
            put(ServletRequestBindingException::class.java, HttpStatus.BAD_REQUEST)
            put(ConversionNotSupportedException::class.java, HttpStatus.INTERNAL_SERVER_ERROR)
            put(TypeMismatchException::class.java, HttpStatus.BAD_REQUEST)
            put(HttpMessageNotReadableException::class.java, HttpStatus.BAD_REQUEST)
            put(HttpMessageNotWritableException::class.java, HttpStatus.INTERNAL_SERVER_ERROR)
            put(MethodArgumentNotValidException::class.java, HttpStatus.BAD_REQUEST)
            put(MissingServletRequestPartException::class.java, HttpStatus.BAD_REQUEST)
            put(BindException::class.java, HttpStatus.BAD_REQUEST)
            put(AsyncRequestTimeoutException::class.java, HttpStatus.SERVICE_UNAVAILABLE)
        }
    }

    /**
     * Handle API exception here.
     * Initialize the [APIResponse] object with error status & message.
     * Find the exception from the [exceptionListHolder] list else register [Exception] as a fallback.
     * Map the error with [HttpStatus] code to custom exception object [APIException].
     *
     * Handle try catch, if any exception occur throw [HttpStatus.INTERNAL_SERVER_ERROR] with custom response object [APIResponse]
     *
     * @param exception, [Throwable] that need to be handled
     *
     * @return [ResponseEntity]
     */
    @ExceptionHandler(Throwable::class)
    @ResponseBody
    fun handleException(exception: Throwable): ResponseEntity<APIResponse<*>> {
        val response = APIResponse<Any>(status = false, message = "Error", data = null)
        return try {
            var status = exceptionListHolder[exception.javaClass]
            if (status == null) {
                status = exceptionListHolder[Exception::class.java]
            }
            response.apply {
                error.add(APIException(status!!.value(), exception.message ?: APIErrors.GENERIC_ERROR_MESSAGE))
            }
            println(response)
            ResponseEntity(response, status!!)
        } catch (e: Exception) {
            response.apply {
                error.add(
                    APIException(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        exception.message ?: APIErrors.GENERIC_ERROR_MESSAGE
                    )
                )
            }
            println(response)
            ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}