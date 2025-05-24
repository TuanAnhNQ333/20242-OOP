package hust.soict.hedspi.aims.Exception;

public class PlayerException extends Exception {
    private static final String DEFAULT_MESSAGE = "Player exception";

    public PlayerException() {
        super(DEFAULT_MESSAGE);
    }

    public PlayerException(String message) {
        super(message);
    }

    public PlayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlayerException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public PlayerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
