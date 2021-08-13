import blocks.Operation;

import java.io.IOException;
import java.util.Properties;

public class Factory {
    private final Properties properties = new Properties();
    private static Factory factory = null;

    private Factory() throws IOException {
        var input = Factory.class.getResourceAsStream("inputOperations");

        if (input != null) {
            properties.load(input);
            input.close();
        }
    }

    public static Factory getInstance() throws IOException {
        if (factory == null) {
            synchronized (Factory.class){
                if(factory == null){
                    factory = new Factory();
                }
            }
        }
        return factory;
    }

    public Operation createOperation(String operationName) throws Exception {
        Operation currentOperation;
        var classOfOperation = Class.forName(properties.getProperty(operationName));
        var objectInstance = classOfOperation.getDeclaredConstructor().newInstance();
        currentOperation = (Operation) objectInstance;
        return currentOperation;
    }
}
