package logic.interfaces;

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
}
