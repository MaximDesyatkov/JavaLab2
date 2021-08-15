package blocks;

import exception.*;

import java.util.Vector;
import java.util.ArrayList;

public class Sort implements Operation {
    public void execute(ArrayList<String> text, Vector<String> args) throws WrongNumberOfArgs {
        if (args.size() != 0){
            throw new WrongNumberOfArgs("Only 1 argument expected");
        }

        text.sort((arg1, arg2) -> arg1.compareToIgnoreCase(arg2));
    }

    public OperationTypes getType() {
        return OperationTypes.IN_OUT;
    }
}
