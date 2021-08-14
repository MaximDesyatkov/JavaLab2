import blocks.*;
import exception.OperationQueueError;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Logger;

public class Workflow {
    private static Logger log = Logger.getLogger(Workflow.class.getName());

    public void run(String input) throws Exception {
        ArrayList<String> text = new ArrayList<>();

        Parser parser = new Parser();

        parser.readInput(input);
        Map<String, String[]> operations = parser.getOperations();
        Vector<String> operationOrder = parser.getOperationOrder();

        log.info("Start working with input file");

        for (int i = 0; i < operationOrder.size(); i++) {

            String operationName = operations.get(operationOrder.get(i))[0];

            Vector<String> args = new Vector<>();

            for (int j = 1; j < operations.get(operationOrder.get(i)).length; j++) {
                args.add(operations.get(operationOrder.get(i))[j]);
            }

            Operation currentOperation = Factory.getInstance().createOperation(operationName);

            if (i == 0 && currentOperation.getType() != OperationTypes.IN) {
                throw new OperationQueueError("Wrong input");
            }

            if (i == operations.size() - 1 && currentOperation.getType() != OperationTypes.OUT) {
                throw new OperationQueueError("Wrong output");
            }

            try {
                currentOperation.execute(text, args);
                log.info(operationName + " executed successfully");
            } catch (Exception e){
                log.warning("Couldn't execute  " + operationName);
            }
        }

        log.info("Program executed successfully");
    }

}
