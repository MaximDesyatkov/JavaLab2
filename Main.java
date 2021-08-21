package ru.nsu.ccfit.desyatkov.lab1;

import javax.naming.NamingException;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getGlobal();
    public static void main(String[] args) throws ClassNotFoundException 
    {
        Calculator Calculator = new Calculator(args);
    }
}
