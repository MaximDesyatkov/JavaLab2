package ru.nsu.ccfit.desyatkov.lab2.instructions;

import ru.nsu.ccfit.desyatkov.lab2.CalculatorContext;
import ru.nsu.ccfit.desyatkov.lab2.instructionexception.*;

public interface Instruction {
    void Execute(Object[] args, CalculatorContext ctx) throws InstructionException;
}
