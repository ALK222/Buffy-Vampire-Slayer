package control.exceptions;

/**
 * Game execution exceptions
 */
public abstract class GameException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -6884346077456421106L;

    /**
     * Void constructor
     */
    public GameException() {
        super();
    }

    /**
     * Constructor with a message
     * 
     * @param message message string
     */
    public GameException(String message) {
        super(message);
    }

    /**
     * Constructor with a message and a cause for the exception
     * 
     * @param message message of the exception
     * @param cause   cause of the exception
     */
    public GameException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with a cause for the exception
     * 
     * @param cause cause of the exception
     */
    public GameException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor with a message and a cause for the exception
     * 
     * @param message            message of the exception
     * @param cause              cause of the exception
     * @param enableSuppresion   whether or not supresion is enable
     * @param writableStackTrace whether or not the stack trace should be writable
     */
    GameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
