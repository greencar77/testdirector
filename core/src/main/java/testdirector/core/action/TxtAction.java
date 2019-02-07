package testdirector.core.action;

public class TxtAction extends Action {
    private String message;

    public TxtAction(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
