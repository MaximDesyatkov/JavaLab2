package blocks;

import exception.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Readfile implements Operation {
    public OperationTypes getType(){
        return OperationTypes.IN;
    }
    public void execute(ArrayList<String> text, Vector<String> args) throws FileNotFoundException, WrongNumberOfArgs {

        if (args.size() - 1 != 1){
            throw new WrongNumberOfArgs("Only 1 argument expected");
        }

        String currentFile = args.get(0);
        String currentString;

        Scanner input = new Scanner(new File(currentFile));
        text.clear();

        while(input.hasNextLine()){
            currentString = input.nextLine();
            String[] words = currentString.split(" ");
            for(var word : words){
                text.add(word);
            }
        }
    }
}
