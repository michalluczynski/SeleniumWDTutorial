package log4jDemo;

import org.apache.logging.log4j.*;

public class LoggingDemo {


    // Defining instance of logger; it has to be static & final, bc it has to be the same instance in all classes continuesly, without creating new objects

    private static final Logger log = LogManager.getLogger (LoggingDemo.class.getName ());

    public static void main(String[] args) {

        log.debug ("Debug message logged");
        log.error ("Error message logged");
        log.fatal ("Fatal message logged");

    }
}
