package com.jamiltonquintero.hexagonalmodularmaven.task.rest.advice;


import com.jamiltonquintero.hexagonalmodularmaven.task.model.exception.TaskException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskControllerAdvice {

    @ExceptionHandler(TaskException.class)
    public ResponseEntity<String> handleEmptyInput(TaskException emptyInputException){
        return new ResponseEntity<>(emptyInputException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }

}
