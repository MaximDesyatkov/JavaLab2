package ru.nsu.ccfit.desyatkov.lab2.instructions;

import ru.nsu.ccfit.desyatkov.lab2.CalculatorContext;
import ru.nsu.ccfit.desyatkov.lab2.instructionexception.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Push implements Instruction {
    private boolean isNumber(String s) {
        for (char c : s.toCharArray())
        {
            if (!Character.isDigit(c) && !(c == '.'))
                return false;
        }
        return true;
    }

    public void Execute(Object[] args, CalculatorContext ctx) throws ArgsException {
        try {
            ctx.getStack().addFirst(Double.valueOf(args[1].toString()));
        }
        catch (NumberFormatException e) {
            if (!ctx.getMap().containsKey(args[1].toString()))
                throw new ArgsException("no such key in map (Push)");

            Double newVar = ctx.getMap().get(args[1].toString());
            ctx.getStack().addFirst(newVar);
        }
        Logger.getGlobal().log(Level.FINEST, "PUSH");
    }
}
