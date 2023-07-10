package com.jamiltonquintero.hexagonalmodularmaven.task.model.exception;

public class TaskException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errorMessage;

    public TaskException( String errorMessage) {

        this.errorMessage = errorMessage;
    }

    public TaskException() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
