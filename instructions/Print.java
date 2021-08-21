package ru.nsu.ccfit.desyatkov.lab2.instructions;

import ru.nsu.ccfit.desyatkov.lab2.CalculatorContext;
import ru.nsu.ccfit.desyatkov.lab2.instructionexception.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Print implements Instruction{
    public void Execute(Object[] args, CalculatorContext ctx) throws ArgsException {
        if (ctx.getStack().isEmpty())
            throw new ArgsException("there isn't such operands in stack (Print)");
        double temp = ctx.getStack().getFirst();
        System.out.println(temp);
        Logger.getGlobal().log(Level.FINEST, "PRINT"+temp);
    }
}
