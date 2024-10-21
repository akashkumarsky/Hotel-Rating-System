package com.sky.userservice.exceptions;



import com.sky.userservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundExcetion.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundExcetion ex){
        String message = ex.getMessage();
        ApiResponse responce = ApiResponse.builder()
                .message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(responce,HttpStatus.NOT_FOUND);
    }
}
