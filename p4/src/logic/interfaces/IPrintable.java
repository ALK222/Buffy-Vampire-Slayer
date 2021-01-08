package logic.interfaces;

/**
 * Interface for printing the game
 */
public interface IPrintable {

    /**
     * 
     * @return number of columns
     */
    int getX();

    /**
     * 
     * @return number of rows
     */
    int getY();

    /**
     * String of the object in the given coordinates
     * 
     * @param x x coordinate
     * @param y y coordinate
     * @return a blank string if there is no object, the string value of the object
     *         if found
     */
    String getPositionToString(int x, int y);

    /**
     * 
     * @return the info of the game
     */
    String getInfo();

    /**
     * Serializer of the game
     * 
     * @return a serialize state of the game
     */
    String stringify();

    /**
     * Serialized information of the game
     * 
     * @return a serialized version of the game
     */
    String getSerializeInfo();
}
