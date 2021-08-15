package Tests;

import blocks.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import junit.framework.TestSuite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test extends TestSuite {

    @Test
    public void dump() throws Exception {
        Dump dump = new Dump();
        ArrayList<String> text = new ArrayList<>();
        Vector<String> args = new Vector<>();

        text.add("12");
        text.add("34");
        args.add("test.txt");

        dump.execute(text, args);
        File inputFile = new File("testOut.txt");
        Scanner input = new Scanner(inputFile);
        ArrayList<String> testedOutput = new ArrayList<>();

        String inputLine;
        while (input.hasNextLine()) {
            inputLine = input.nextLine();
            testedOutput.add(inputLine);
        }

        input.close();
        assertEquals(text, testedOutput);
    }

    @Test
    public void grep()throws Exception{
        Grep grepTest = new Grep();
        ArrayList<String> text = new ArrayList<>();
        ArrayList<String> testedOutput = new ArrayList<>();
        Vector<String> args = new Vector<>();

        text.add("12");
        text.add("3554");
        args.add("hehehe");

        testedOutput.addAll(text);
        grepTest.execute(testedOutput, args);
        text.remove(2);
        assertEquals(text, testedOutput);
    }

    @Test
    public void replace() throws Exception {
        Replace replaceTester = new Replace();
        ArrayList<String> text = new ArrayList<>();
        Vector<String> args = new Vector<>();

        text.add("oope");

        ArrayList<String> testedOutput = new ArrayList<>(text);
        args.add("pe");
        args.add("p");

        replaceTester.execute(testedOutput, args);
        text.clear();

        text.add("oop");
        assertEquals(text, testedOutput);
    }

    @Test
    public void sort() throws Exception {
        Sort sortTest = new Sort();
        ArrayList<String> text = new ArrayList<>();
        Vector<String> args = new Vector<>();

        text.add("afafaf");
        text.add("dadada");
        text.add("bebebe");

        ArrayList<String> testedOutput = new ArrayList<>(text);
        sortTest.execute(testedOutput, args);
        text.clear();
        text.add("afafaf");
        text.add("bebebe");
        text.add("dadada");
        assertEquals(text, testedOutput);
    }
}
