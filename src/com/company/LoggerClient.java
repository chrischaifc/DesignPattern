package com.company;

class LoggerClient {

    public static void main(String[] args) {
        FileLogger logger = new FileLogger();
        EncryptLogger eLogger = new EncryptLogger(logger);

        eLogger.log("log1.txt",
                "Second message to be encrypted");

        EncryptionStrategy strategy = new SubstitutionCypher();
        eLogger.setEncryptionStrategy(strategy);
        eLogger.log("log2.txt",
                "Second message to be encrypted");
        strategy = new CodeBookCypher();
        eLogger.setEncryptionStrategy(strategy);
        eLogger.log("log3.txt", "I love you");

        strategy = new CaesarCypher();
        eLogger.setEncryptionStrategy(strategy);
        eLogger.log("log4.txt", "Second message to be encrypted");

    }

} // End of class

