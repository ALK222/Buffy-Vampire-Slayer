package control.exceptions;

public class UnvalidPositionException extends CommandExecuteException {

    /**
     *
     */
    private static final long serialVersionUID = -6845150033740196161L;

    /**
     * Void constructor
     */
    public UnvalidPositionException() {
        super();
    }

    /**
     * Constructor with a message
     * 
     * @param message message string
     */
    public UnvalidPositionException(String message) {
        super(message);
    }

    /**
     * Constructor with the coordinates of the exception
     * 
     * @param x x coordinate
     * @param y y coordinate
     */
    public UnvalidPositionException(int x, int y) {
        super("[ERROR]: Position (" + x + "," + y + "): Unvalid position");
    }

    /**
     * Constructor with a message and a cause for the exception
     * 
     * @param message message of the exception
     * @param cause   cause of the exception
     */
    public UnvalidPositionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with a cause for the exception
     * 
     * @param cause cause of the exception
     */
    public UnvalidPositionException(Throwable cause) {
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
    UnvalidPositionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
