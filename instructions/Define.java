package ru.nsu.ccfit.desyatkov.lab2.instructions;
import ru.nsu.ccfit.desyatkov.lab2.instructionexception.*;
import ru.nsu.ccfit.desyatkov.lab2.CalculatorContext;

public class Define implements Instruction {
    public void Execute(Object[] args, CalculatorContext ctx) throws InstructionException {

        if ((args[1].toString()).matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+"))
            throw new DefineException("bad 1st argument");
        try {
            ctx.getMap().put(args[1].toString(), Double.valueOf(args[2].toString()));
        }
        catch (NumberFormatException e) {
            throw new DefineException("bad 2nd argument");
        }
    }
}
