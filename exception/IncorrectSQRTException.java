package ru.nsu.ccfit.desyatkov.lab2.exception;

public class IncorrectSQRTException extends InstructionArithmeticException {
    public IncorrectSQRTException(String message) {
        super("can't take root: "+message);
    }
}
