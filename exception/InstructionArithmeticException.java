package ru.nsu.ccfit.desyatkov.lab2.exception;

public class InstructionArithmeticException extends InstructionException {
    InstructionArithmeticException(String message) {
        super("Problem with executing Instructions arithmetic "+message);
    }
}
