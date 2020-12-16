package logic.interfaces;

/**
 * Interface for executing attacks and checking if attacks land
 */
public interface IAttack {
    /**
     * Attack of an object
     */
    void attack();

    /**
     * function that checks if an object can receive an attack from a slayer. In
     * case that the object can receive the attack, it will take damage
     * 
     * @param damage value of the damage taken
     * @return true if the damage is inflicted, false if not
     */
    default boolean receiveSlayerAttack(int damage) {
        return false;
    };

    /**
     * function that checks if an object can receive an attack from a vampire. In
     * case that the object can receive the attack, it will take damage
     * 
     * @param damage value of the damage taken
     * @return true if the damage is inflicted, false if not
     */
    default boolean receiveVampireAttack(int damage) {
        return false;
    };

    /**
     * Funcion that checks if an object can receive an attack from Dracula
     * 
     * @return true if the attack is inflicted, false if not
     */
    default boolean receiveDraculaAttack() {
        return false;
    };

    /**
     * Function that checks if an object can receive a garlic push
     * 
     * @return true if pushed, false if not
     */
    default boolean receiveGarlicPush() {
        return false;
    };

    /**
     * Function that checks if an object can receive a light flash
     * 
     * @return true if received, false if not
     */
    default boolean receiveLightAttack() {
        return false;
    };

    /**
     * Checks if an object can increase its power
     * 
     * @return true if the power was increased, false if not
     */
    default boolean receiveExplosiveAttack() {
        return false;
    };
}
