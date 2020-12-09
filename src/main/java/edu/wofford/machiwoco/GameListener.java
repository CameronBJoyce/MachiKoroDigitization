package edu.wofford.machiwoco;

import java.util.*;

/**
 * An interface used to implement user actions including dice rolls and card activations.
 * 
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */

public interface GameListener {
    void diceRolled (int dice1, int dice2, Player p);
    void diceActivation (int dice, List<Player> players);
}
