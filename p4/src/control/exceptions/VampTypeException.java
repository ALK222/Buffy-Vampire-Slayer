package control.exceptions;

public class VampTypeException extends CommandExecuteException {

    /**
     *
     */
    private static final long serialVersionUID = 4946644222127150410L;

    /**
     * Void constructor
     */
    public VampTypeException() {
        super();
    }

    /**
     * Constructor with a message
     * 
     * @param message message string
     */
    public VampTypeException(String message) {
        super(message);
    }

    /**
     * Constructor with a message and a cause for the exception
     * 
     * @param message message of the exception
     * @param cause   cause of the exception
     */
    public VampTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with a cause for the exception
     * 
     * @param cause cause of the exception
     */
    public VampTypeException(Throwable cause) {
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
    VampTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
