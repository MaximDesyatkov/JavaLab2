package ru.nsu.ccfit.desyatkov.lab2.instructions;

import ru.nsu.ccfit.desyatkov.lab2.CalculatorContext;
import ru.nsu.ccfit.desyatkov.lab2.instructionexception.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Plus implements Instruction {
    public void Execute(Object[] args, CalculatorContext ctx) throws ArgsException {
        if (ctx.getStack().isEmpty())
            throw new ArgsException("there isn't such operands in stack (Plus)");
        Double first = ctx.getStack().pop();
        if (ctx.getStack().isEmpty())
            throw new ArgsException("there isn't such operands in stack (Plus)");
        Double second = ctx.getStack().pop();

        ctx.getStack().addFirst(first+second);

        Logger.getGlobal().log(Level.FINEST, second+"PLUS"+first);
    }
}
