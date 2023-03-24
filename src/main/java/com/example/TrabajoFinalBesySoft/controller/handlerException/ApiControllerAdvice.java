package com.example.TrabajoFinalBesySoft.controller.handlerException;

import com.example.TrabajoFinalBesySoft.dto.Response.ExceptionDto;
import com.example.TrabajoFinalBesySoft.exception.ExistException;
import com.example.TrabajoFinalBesySoft.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



    @ControllerAdvice(annotations = RestController.class)
    @Slf4j
    public class ApiControllerAdvice {

        @ExceptionHandler
        @ResponseBody
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ExceptionDto exceptionHandler(MethodArgumentNotValidException ex) {
            List<FieldError> errorList = ex.getBindingResult().getFieldErrors();
            Map<String, String> detalle = new HashMap<>();
            errorList.forEach(e -> detalle.put(e.getField(), e.getDefaultMessage()));
            return new ExceptionDto(HttpStatus.BAD_REQUEST.value(), "Validaciones", detalle);
        }

        @ExceptionHandler
        @ResponseBody
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ExceptionDto IsExist(ExistException ex) {
            return new ExceptionDto(
                    HttpStatus.BAD_REQUEST.value(),
                    ex.getMessage(),
                    null
            );
        }

        @ExceptionHandler
        @ResponseBody
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ExceptionDto NotFound(NotFoundException ex) {
            return new ExceptionDto(
                    HttpStatus.BAD_REQUEST.value(),
                    ex.getMessage(),
                    null
            );
        }


    }

