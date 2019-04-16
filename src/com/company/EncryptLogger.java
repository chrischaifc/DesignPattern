package com.company;


public class EncryptLogger {
    private EncryptionStrategy currEncryptionStrategy;
    private FileLogger logger;

    public EncryptLogger(FileLogger inp_logger) {
        logger = inp_logger;

        // TODO set the default encryption strategy
        currEncryptionStrategy = new SimpleEncryption();

    }

    public void log(String fileName, String msg) {
        /*Added functionality*/

    /*
	TODO
    	Now forward the encrypted text to the FileLogger 
    	for storage
    */

        logger.log(fileName, encrypt(msg));



    }

    public String encrypt(String msg) {
    /*
	TODO
     	Apply encryption using the current encryption strategy
     */
        String encryptedMsg = currEncryptionStrategy.encrypt(msg);
        return encryptedMsg;

    }

    public void setEncryptionStrategy(
            EncryptionStrategy strategy) {
        //TODO
        currEncryptionStrategy = strategy;
    }

    public EncryptionStrategy getCurrEncryptionStrategy() {
        return currEncryptionStrategy;
    }

    public FileLogger getLogger() {
        return logger;
    }
}
