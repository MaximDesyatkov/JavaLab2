package ru.nsu.ccfit.desyatkov.lab2.exception;

public class InstructionException extends Exception {
    InstructionException(String message) {
        super("Problem with executing Instruction: "+message);
    }
}
