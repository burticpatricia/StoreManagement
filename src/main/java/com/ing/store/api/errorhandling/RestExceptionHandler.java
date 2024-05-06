package com.ing.store.api.errorhandling;

import com.ing.store.exception.ApiAuthenticationException;
import com.ing.store.exception.EntityNotFoundException;
import org.openapitools.model.AuthExceptionDto;
import org.openapitools.model.StoreApiExceptionDto;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            EntityNotFoundException ex) {
        StoreApiExceptionDto apiException = new StoreApiExceptionDto(NOT_FOUND.name(), LocalDateTime.now().toString(), ex.getMessage());
        return buildStoreApiExceptionDtoResponseEntity(apiException);
    }

    @ExceptionHandler(ApiAuthenticationException.class)
    protected ResponseEntity<Object> handleAuthenticationException(ApiAuthenticationException ex) {
        AuthExceptionDto apiException = new AuthExceptionDto(LocalDateTime.now().toString(), ex.getMessage());
        return buildAuthExceptionDtoResponseEntity(apiException);
    }

    private ResponseEntity<Object> buildStoreApiExceptionDtoResponseEntity(StoreApiExceptionDto apiException) {
        return new ResponseEntity<>(apiException, HttpStatus.valueOf(apiException.getStatus()));
    }

    private ResponseEntity<Object> buildAuthExceptionDtoResponseEntity(AuthExceptionDto apiException) {
        return new ResponseEntity<>(apiException, HttpStatus.UNAUTHORIZED);
    }
}
