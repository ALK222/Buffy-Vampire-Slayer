package control.exceptions;

public class NoMoreVampiresException extends CommandExecuteException {

    /**
     *
     */
    private static final long serialVersionUID = -4757449231753500370L;

    /**
     * Void constructor
     */
    public NoMoreVampiresException() {
        super();
    }

    /**
     * Constructor with a message
     * 
     * @param message message string
     */
    public NoMoreVampiresException(String message) {
        super(message);
    }

    /**
     * Constructor with a message and a cause for the exception
     * 
     * @param message message of the exception
     * @param cause   cause of the exception
     */
    public NoMoreVampiresException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with a cause for the exception
     * 
     * @param cause cause of the exception
     */
    public NoMoreVampiresException(Throwable cause) {
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
    NoMoreVampiresException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
