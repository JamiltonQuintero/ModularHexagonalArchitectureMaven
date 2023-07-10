package com.jamiltonquintero.hexagonalmodularmaven.user.model.exception;

public class UserTaskAssignationException extends RuntimeException {

    private String errorMessage;

    public UserTaskAssignationException(String errorMessage) {

        this.errorMessage = errorMessage;
    }

    public UserTaskAssignationException() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
