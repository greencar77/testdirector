package testdirector.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testdirector.core.action.Action;
import testdirector.core.action.TxtAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

public abstract class TestCase {

    private static final Logger LOG = LoggerFactory.getLogger(TestCase.class);
    private static final Logger OUT = registerOutput(TestCase.class);

    public String testExecutionId = UUID.randomUUID().toString();
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public TestCase() {
        OUT.info("testExecutionId=" + testExecutionId);
    }

    public static Logger registerOutput(Class<?> clazz) {
        return LoggerFactory.getLogger("out-" + TestCase.class.getName());
    }

    public abstract void run();

    public void add(Action action) {

    }

    public void add(TxtAction action) {
        LOG.info(action.getMessage());
        OUT.info(action.getMessage());
        //System.out.println(action.getMessage());
    }

    protected void pause() {
        System.out.print("Pause (q-quit):");
        try {
            if (input.readLine().toUpperCase().equals("Q")) {
                throw new UserBreakException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
