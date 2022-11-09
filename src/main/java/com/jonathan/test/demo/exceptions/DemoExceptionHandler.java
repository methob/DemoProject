package com.jonathan.test.demo.exceptions;

import org.springframework.boot.devtools.remote.server.HttpStatusHandler;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class DemoExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String NOT_BLANK = "NotBlank";
    public static final String LENGTH = "Length";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<GenericError> errors = generateErrorList(ex.getBindingResult());
        return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
    }

    private List<GenericError> generateErrorList(BindingResult bindingResult) {
        List<GenericError> errors = new ArrayList<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String userMessage = configureErrorMessageUser(fieldError);
            String developerMessage = fieldError.toString();
            errors.add(new GenericError(userMessage, developerMessage));
        }
        return errors;
    }

    private String configureErrorMessageUser(FieldError fieldError) {
        if (fieldError.getCode().equals(NOT_BLANK)) {
            return fieldError.getDefaultMessage().concat(" é obrigatório");
        } else if (fieldError.getCode().equals(LENGTH)) {
            return fieldError.getDefaultMessage().concat(
                    String.format(" deve ter entre %s e %s caracteres",
                            Objects.requireNonNull(fieldError.getArguments())[2],
                            fieldError.getArguments()[1]));
        }
        return null;
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    private ResponseEntity<Object> handleEmpResultDataAccessException(
            EmptyResultDataAccessException ex, WebRequest request
    ) {
        String userMessage = "Recurso não encontrado";
        String msgDeveloper = ex.toString();
        List<GenericError> errors = Arrays.asList(new GenericError(userMessage, msgDeveloper));
        return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST,
                request);
    }
}
