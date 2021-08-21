package ru.nsu.ccfit.desyatkov.lab2;
import ru.nsu.ccfit.desyatkov.lab2.instructionexception.InstructionException;
import ru.nsu.ccfit.desyatkov.lab2.instructions.Instruction;
import ru.nsu.ccfit.desyatkov.lab2.instructions.*;

import java.io.*;
import java.io.FileReader;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calculator {
    CalculatorContext ctx = new CalculatorContext();
    Calculator(String[] args) {

        InstructionFactory Calculator = new InstructionFactory("C:\\Users\\User\\IdeaProjects\\Lab2\\ru\\nsu\\ccfit\\desyatkov\\lab2\\Config.txt");
        try {
            if (args.length == 0) {
                Scanner in = new Scanner(System.in);
                while (in.hasNext()) {
                    String line = in.nextLine();
                    if (line.charAt(0) == '#') {
                        continue;
                    }
                    String[] comArgs;
                    String delimiter = " ";
                    comArgs = line.split(delimiter);
                    Instruction next = Calculator.makeInstruction(comArgs[0]);
                    try {
                        next.Execute(comArgs, ctx);
                    }
                    catch (Exception e) {
                        Logger.getGlobal().log(Level.WARNING, e.toString());
                    }
                }
            }
            else {
                File file = new File(args[0]);
                FileReader fileReader = new FileReader(file);
                BufferedReader buf = new BufferedReader(fileReader);
                String line = buf.readLine();

                while (line != null) {
                    if (line.charAt(0) == '#') {
                        line = buf.readLine();
                        continue;
                    }
                    String[] comArgs;
                    String delimiter = " ";
                    comArgs = line.split(delimiter);
                    Instruction next = Calculator.makeInstruction(comArgs[0]);
                    try {
                        next.Execute(comArgs, ctx);
                    }
                    catch (InstructionException e) {
                        Logger.getGlobal().log(Level.WARNING, e.toString());
                    }

                    line = buf.readLine();
                }
            }
        }
        catch (FileNotFoundException fileNotFoundErr) {
            fileNotFoundErr.printStackTrace();
        }
        catch (IOException ioErr) {
            ioErr.printStackTrace();
        }
    }
}
