package blocks;

import exception.*;

import java.util.ArrayList;
import java.util.Vector;

public class Grep implements Operation {
    public OperationTypes getType() {
        return OperationTypes.IN_OUT;
    }

    public void execute(ArrayList<String> text, Vector<String> args) throws WrongNumberOfArgs {

        if (args.size() != 1){
            throw new WrongNumberOfArgs("Only 1 argument expected");
        }

        String word = args.get(0);

        for (int i = 0; i < text.size(); i++) {
            if (!text.get(i).contains(word)) {
                text.remove(i);
                i--;
            }
        }
    }


}
