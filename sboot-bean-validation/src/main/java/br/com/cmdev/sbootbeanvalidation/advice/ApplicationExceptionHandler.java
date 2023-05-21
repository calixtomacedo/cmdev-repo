package br.com.cmdev.sbootbeanvalidation.advice;

import br.com.cmdev.sbootbeanvalidation.exceptions.GlobalNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> handleMap = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            handleMap.put(error.getField(), error.getDefaultMessage());
        });

        return  handleMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(GlobalNotFoundException.class)
    public Map<String, String> handleBusinessException(GlobalNotFoundException ex){
        Map<String, String> handleMap = new HashMap<>();
        handleMap.put("message", ex.getMessage());
        return  handleMap;
    }

}
