package ru.yandex.tonychem.javamoviequizz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(IOException.class)
    public ResponseEntity<Error> handleIOException(IOException exc) {
        return new ResponseEntity<>(new Error("Ошибка подключения к хосту"), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
