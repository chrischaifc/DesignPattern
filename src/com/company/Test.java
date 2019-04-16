package com.company;

import static org.junit.Assert.*;

public class Test {

    @org.junit.Test
    public void simpleEncryption() {
        SimpleEncryption simpleEncryption = new SimpleEncryption();
        String input1 = "this message is to be encrypted & logged";
        String expect1 = "dthis message is to be encrypted & logge";
        String actual1 = simpleEncryption.encrypt(input1);

        String input2 = "Second message to be encrypted.";
        String expect2 = ".Second message to be encrypted";
        String actual2 = simpleEncryption.encrypt(input2);

        assertEquals(expect1,actual1);
        assertEquals(expect2,actual2);
    }

    @org.junit.Test
    public void CodeBookCypher() {
        CodeBookCypher codeBookCypher = new CodeBookCypher();
        String input1 = "This is a true statement";
        String expect1 = " Design Patterns are really useful";
        String actual1 = codeBookCypher.encrypt(input1);

        String input2 = "I love you";
        String expect2 = " I don't care";
        String actual2 = codeBookCypher.encrypt(input2);

        assertEquals(expect1,actual1);
        assertEquals(expect2,actual2);
    }

    @org.junit.Test
    public void CaesarCypher() {
        CaesarCypher caesarCypher = new CaesarCypher();

        String input1 = "this message is to be encrypted & logged";
        String expect1 = "uijt nfttbhf jt up cf fodszqufe & mphhfe";
        String actual1 = caesarCypher.encrypt(input1);

        String input2 = "Second message to be encrypted";
        String expect2 = "Sfdpoe nfttbhf up cf fodszqufe";
        String actual2 = caesarCypher.encrypt(input2);

        assertEquals(expect1,actual1);
        assertEquals(expect2,actual2);

    }

    @org.junit.Test
    public void SubstitutionCypher() {
        SubstitutionCypher substitutionCypher = new SubstitutionCypher();

        String input1 = "this message is to be encrypted & logged";
        String expect1 = "zbcy gqyymaq cy zi nq qholwjzqp & fiaaqp";
        String actual1 = substitutionCypher.encrypt(input1);

        String input2 = "Second message to be encrypted";
        String expect2 = "Sqoihp gqyymaq zi nq qholwjzqp";
        String actual2 = substitutionCypher.encrypt(input2);

        assertEquals(expect1,actual1);
        assertEquals(expect2,actual2);
    }

    @org.junit.Test
    public void EncryptLogger() {
        FileLogger fileLogger = new FileLogger();
        EncryptLogger encryptLogger = new EncryptLogger(fileLogger);
        EncryptionStrategy caesarCypher = new CaesarCypher();


        //setEncryption Test
        encryptLogger.setEncryptionStrategy(caesarCypher);
        Object expect1 = caesarCypher;
        Object actual1 = encryptLogger.getCurrEncryptionStrategy();

        assertEquals(expect1, actual1);


        //Encrypt Test
        String input1 = "this message is to be encrypted & logged";
        String expect2 = "uijt nfttbhf jt up cf fodszqufe & mphhfe";
        String actual2 = encryptLogger.encrypt(input1);

        assertEquals(expect2, actual2);


        //Log Test
        fileLogger.log("log.txt", expect2);
        FileLogger expect3 = fileLogger;

        encryptLogger.log("log.txt", input1);
        FileLogger actual3 = encryptLogger.getLogger();

        assertEquals(expect3,actual3);


    }
}