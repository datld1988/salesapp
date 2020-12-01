package com.salesapp.customerservice.exception;

import com.salesapp.common.dto.Message;
import com.salesapp.common.utils.ErrorCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SalesException.class)
    public final ResponseEntity<Object> handleAllExceptions(SalesException ex) {
        SalesExceptionSchema exceptionResponse = new SalesExceptionSchema(ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AuthenticationException.class)
    public final ResponseEntity<Object> handleAuthenticationExceptionException(AuthenticationException ex) {
        return new ResponseEntity<>(ex.getMessages(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Tất cả các Exception không được khai báo sẽ được xử lý tại đây
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleDefaultException(Exception ex) {
        if (ex instanceof org.springframework.security.authentication.InsufficientAuthenticationException) {
            return new ResponseEntity<>(new Message(ErrorCode.AUTHENTICATION, ex.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(new Message(ErrorCode.SERVICE_ERROR, ex.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    @Nonnull
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, @Nonnull HttpHeaders headers, @Nonnull HttpStatus status, @Nonnull WebRequest request) {
        Map<String, String> errorMap = new HashMap<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorMap.put(fieldName, errorMessage);
        }

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

}