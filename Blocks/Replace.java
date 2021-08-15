package blocks;

import exception.*;

import java.util.ArrayList;
import java.util.Vector;

public class Replace implements Operation {
    public OperationTypes getType() {
        return OperationTypes.IN_OUT;
    }

    public void execute(ArrayList<String> text, Vector<String> args) throws WrongNumberOfArgs {
        if (args.size() != 2){
            throw new WrongNumberOfArgs("Only 1 argument expected");
        }

        String word1, word2;
        word1 = args.get(0);
        word2 = args.get(1);

        for (int i = 0; i < text.size(); i++) {
            String currentString = text.get(i);
            currentString = currentString.replaceAll(word1, word2);

            text.add(i+1, currentString);
            text.remove(i);
        }
    }
}
