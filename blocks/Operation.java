package blocks;

import java.util.*;


public interface Operation {

    void execute(ArrayList<String> text, Vector<String> args) throws Exception;
    OperationTypes getType();
}
