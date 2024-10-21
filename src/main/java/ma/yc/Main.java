package ma.yc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main ( String[] args ) {
        logger.info("This is an INFO message.");
        logger.warn("This is a WARN message.");
        logger.error("This is an ERROR message.");
    }
}