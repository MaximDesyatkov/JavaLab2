package ru.nsu.ccfit.desyatkov.lab2.instructions;

import ru.nsu.ccfit.desyatkov.lab2.CalculatorContext;
import ru.nsu.ccfit.desyatkov.lab2.instructionexception.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SQRT implements Instruction {
    public void Execute(Object[] args, CalculatorContext ctx) throws InstructionException {
        if (ctx.getStack().isEmpty())
            throw new ArgsException("there isn't such operands in stack (SQRT)");
        Double operand = ctx.getStack().pop();
        if (operand < 0 || operand.isNaN() || operand.isInfinite())
            throw new IncorrectSQRTException("SQRT");
        ctx.getStack().addFirst(Math.sqrt(operand));
        Logger.getGlobal().log(Level.FINEST, "SQRT "+operand);
    }
}
