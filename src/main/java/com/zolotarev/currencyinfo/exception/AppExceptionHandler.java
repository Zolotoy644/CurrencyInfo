package com.zolotarev.currencyinfo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.naming.NoPermissionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<WrongDateException> handleIllegalArgumentException(IllegalArgumentException e,
                                                                     WebRequest request) {
        var wrongDateException = new WrongDateException.WrongDateExceptionBuilder()
                .details(request.getDescription(false))
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(wrongDateException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<WrongDateException> handleIOException(IOException e,
                                                                    WebRequest request) {
        var errorDetails = new WrongDateException.WrongDateExceptionBuilder()
                .details(request.getDescription(false))
                .message("Курс ЦБ РФ на данную дату не установлен или указана ошибочная дата")
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }
}