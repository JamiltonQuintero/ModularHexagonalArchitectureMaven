package com.jamiltonquintero.hexagonalmodularmaven.user.rest.advice;


import com.jamiltonquintero.hexagonalmodularmaven.user.model.exception.UserException;
import com.jamiltonquintero.hexagonalmodularmaven.user.model.exception.UserTaskAssignationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> handleEmptyInput(UserException emptyInputException){
        return new ResponseEntity<>(emptyInputException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserTaskAssignationException.class)
    public ResponseEntity<String> handleEmptyInput(UserTaskAssignationException emptyInputException){
        return new ResponseEntity<>(emptyInputException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }

}
