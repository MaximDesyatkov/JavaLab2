import java.io.File;
import java.util.*;

public class Parser {
    private Map<String, String[]> operations = new HashMap<>();
    private Vector<String> operationOrder = new Vector<>();
    private boolean ifCsed;

    public Map<String, String[]> getOperations() {
        return operations;
    }

    public Vector<String> getOperationOrder() {
        return operationOrder;
    }

    public void readInput(String input) throws Exception {
        Scanner sc = new Scanner(new File(input));
        ifCsed = false;

        String currentString = sc.nextLine();
        if (!currentString.equals("desc")) {
            throw new Exception("desc wasn't found");
        }

        while (sc.hasNextLine()) {
            currentString = sc.nextLine();

            if (currentString.equals("csed")) {
                ifCsed = true;
                break;
            }
            if (currentString.equals("")) {
                continue;
            }

            String[] splittedWords = currentString.split(" ");
            String id = splittedWords[0];

            String[] word = new String[3];
            System.arraycopy(splittedWords, 2, word, 0, splittedWords.length - 2);
            operations.put(id, word);
        }


        if (!ifCsed) {
            throw new Exception("csed wasn't found");
        }

        currentString = sc.nextLine();
        if (currentString.equals("")) {
            throw new Exception("Operation queue wasn't found");
        }

        String[] wordsQueue = currentString.split(" ");

        for (int i = 0; i < wordsQueue.length; i++) {

            if ((i % 2 != 0) && !(wordsQueue[i].equals("->"))) {
                throw new Exception("Wrong input format");
            }

            if (i % 2 == 0 && !wordsQueue[i].equals("->")) {
                operationOrder.add(wordsQueue[i]);
            }

        }
    }
}
