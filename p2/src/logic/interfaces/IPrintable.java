package logic.interfaces;

public interface IPrintable {
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
}
