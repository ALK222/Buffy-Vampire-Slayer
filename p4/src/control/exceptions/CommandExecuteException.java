package control.exceptions;

public abstract class CommandExecuteException extends GameException {

    /**
     *
     */
    private static final long serialVersionUID = 9204441167544498113L;

    /**
     * Void constructor
     */
    public CommandExecuteException() {
        super();
    }

    /**
     * Constructor with a message
     * 
     * @param message message string
     */
    public CommandExecuteException(String message) {
        super(message);
    }

    /**
     * Constructor with a message and a cause for the exception
     * 
     * @param message message of the exception
     * @param cause   cause of the exception
     */
    public CommandExecuteException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with a cause for the exception
     * 
     * @param cause cause of the exception
     */
    public CommandExecuteException(Throwable cause) {
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
    CommandExecuteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
