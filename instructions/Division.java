package ru.nsu.ccfit.desyatkov.lab2.instructions;

import ru.nsu.ccfit.desyatkov.lab2.CalculatorContext;
import ru.nsu.ccfit.desyatkov.lab2.instructionexception.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Division implements Instruction  {
    public void Execute(Object[] args, CalculatorContext ctx) throws ArithmeticException, InstructionException {
        if (ctx.getStack().isEmpty())
            throw new ArgsException("there isn't such operands in stack (Division)");
        Double first = ctx.getStack().pop();
        if (ctx.getStack().isEmpty())
            throw new ArgsException("there isn't such operands in stack (Division)");
        Double second = ctx.getStack().pop();
        if (first == 0)
            throw new ZeroDivisionException("Division");
        ctx.getStack().addFirst(second/first);
        Logger.getGlobal().log(Level.FINEST, second+" DIVIDE "+first);
    }
}
