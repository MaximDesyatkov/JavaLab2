package ru.nsu.ccfit.desyatkov.lab2.exception;

public class ZeroDivisionException extends InstructionArithmeticException{
    public ZeroDivisionException(String message) {
        super("division by zero:"+message);
    }
}
