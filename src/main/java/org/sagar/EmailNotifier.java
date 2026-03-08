package org.sagar;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class EmailNotifier implements LibraryObserver{
    private static final Logger logger = LoggerFactory.getLogger(EmailNotifier.class);

    @Override
    public void update(String message){
        logger.info("Sending email notification: {}", message);
    }
}
