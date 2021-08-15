package blocks;

import exception.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

public class Writefile implements Operation {
    public OperationTypes getType(){
        return OperationTypes.OUT;
    }
    public void execute(ArrayList<String> text, Vector<String> args) throws WrongNumberOfArgs, IOException {

        if (args.size() - 1 != 1){
            throw new WrongNumberOfArgs("Only 1 argument expected");
        }

        FileWriter fileWriter;
        PrintWriter printWriter;

        fileWriter = new FileWriter(args.get(0));
        printWriter = new PrintWriter(fileWriter);

        for (String word : text) {
            printWriter.println(word);
        }

        fileWriter.close();
        printWriter.close();
    }

}
