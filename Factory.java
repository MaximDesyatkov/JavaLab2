package ru.nsu.ccfit.desyatkov.lab2;

import ru.nsu.ccfit.desyatkov.lab2.instructions.Instruction;

import java.io.*;
import java.util.TreeMap;

public class InstructionFactory {
    private final TreeMap<String, Class> instructionNames;
    public InstructionFactory(String configFile) {
        instructionNames = new TreeMap<>();
        try {
            File file = new File(configFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader buf = new BufferedReader(fileReader);
            String line = buf.readLine();
            while (line != null) {
                try 
                {
                    String[] separateWords;
                    String delimiter = " ";
                    separateWords = line.split(delimiter);
                    instructionNames.put(separateWords[0], Class.forName(Instruction.class.getPackageName() + "." + separateWords[1]));
                    line = buf.readLine();
                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
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
    public Instruction makeInstruction(String Name) {
        Instruction newInst = null;
        
        try {
            newInst = (Instruction) instructionNames.get(Name).newInstance();
        }
        catch (InstantiationException | IllegalAccessException er) {
            er.printStackTrace();
        }
        return newInst;
    }
}
