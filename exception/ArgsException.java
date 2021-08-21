package ru.nsu.ccfit.desyatkov.lab2.exception;

public class ArgsException extends InstructionException {
    public ArgsException(String message) {
        super("Problem with arguments: "+message);
    }
}
