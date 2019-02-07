package testdirector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {
        System.out.println("LOG.getClass().getName()=" + LOG.getClass().getName());
        LOG.debug("debug");
        LOG.info("info");

        System.out.println( "Hello World!" );
    }
}
