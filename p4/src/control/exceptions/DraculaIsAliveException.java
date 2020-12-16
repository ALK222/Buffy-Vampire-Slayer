package control.exceptions;

public class DraculaIsAliveException extends CommandExecuteException {

    /**
     * Void constructor
     */
    public DraculaIsAliveException() {
        super();
    }

    /**
     * Constructor with a message
     * 
     * @param message message string
     */
    public DraculaIsAliveException(String message) {
        super(message);
    }

    /**
     * Constructor with a message and a cause for the exception
     * 
     * @param message message of the exception
     * @param cause   cause of the exception
     */
    public DraculaIsAliveException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with a cause for the exception
     * 
     * @param cause cause of the exception
     */
    public DraculaIsAliveException(Throwable cause) {
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
    DraculaIsAliveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
