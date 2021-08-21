package ru.nsu.ccfit.desyatkov.lab2.exception;

public class DefineException extends InstructionException {
    public DefineException(String message) {
        super("Problem with define: "+message);
    }
}
