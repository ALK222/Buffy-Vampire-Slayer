package control.exceptions;

public class NotEnoughCoinsException extends CommandExecuteException {

    /**
     *
     */
    private static final long serialVersionUID = 6602719392249494385L;

    /**
     * Void constructor
     */
    public NotEnoughCoinsException() {
        super();
    }

    /**
     * Constructor with a message
     * 
     * @param message message string
     */
    public NotEnoughCoinsException(String message) {
        super(message);
    }

    /**
     * Constructor with the cost and the product of the exception
     * 
     * @param product product tried to buy
     * @param cost    cost of the product
     */
    public NotEnoughCoinsException(String product, int cost) {
        super("[ERROR]: " + product + " cost is " + cost + ": Not enough coins");
    }

    /**
     * Constructor with a message and a cause for the exception
     * 
     * @param message message of the exception
     * @param cause   cause of the exception
     */
    public NotEnoughCoinsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with a cause for the exception
     * 
     * @param cause cause of the exception
     */
    public NotEnoughCoinsException(Throwable cause) {
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
    NotEnoughCoinsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
