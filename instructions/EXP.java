package ru.nsu.ccfit.desyatkov.lab2.instructions;
import ru.nsu.ccfit.desyatkov.lab2.instructionexception.*;
import ru.nsu.ccfit.desyatkov.lab2.CalculatorContext;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EXP implements Instruction {
    public void Execute(Object[] args, CalculatorContext ctx) throws ArgsException {
        if (ctx.getStack().isEmpty())
            throw new ArgsException("there isn't such operands in stack (EXP)");
        Double first = ctx.getStack().pop();
        if (ctx.getStack().isEmpty())
            throw new ArgsException("there isn't such operands in stack (EXP)");
        Double second = ctx.getStack().pop();

        ctx.getStack().addFirst(Math.pow(first, second));

        Logger.getGlobal().log(Level.FINEST, second+" EXP "+first);
    }
}
