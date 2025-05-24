package hust.soict.hedspi.aims.Exception;

public class NegativePriceException extends Exception {
    private static final String DEFAULT_MESSAGE = "Price cannot be negative";

    public NegativePriceException() {
        super(DEFAULT_MESSAGE);
    }

    public NegativePriceException(String message) {
        super(message);
    }

    public NegativePriceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativePriceException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public NegativePriceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
