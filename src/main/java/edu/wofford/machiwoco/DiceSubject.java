package edu.wofford.machiwoco;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents all necessary information surrounding a Player's dice roll.
 * 
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */

public class DiceSubject {

    private List<Observer> observers = new ArrayList<Observer>();
    private Player activePlayer;
    //private Player[] players;
    private ArrayList<Player> players;
    private int dice;
    private int diceNum;
    private int[] dicePair;

    /**
     * The constructor used to initialize the DiceSubject class and its necessary variables.
     * @param activePlayer a Player instance representing which Player is performing the roll.
     * @param players a Player array containing all Players in the current Machi Koro game.
     * @param dice the result of the Player's dice roll.
     * @param diceNum the number of die to be used in the Player's roll
     */

    //public DiceSubject(Player activePlayer, Player[] players, int dice, int diceNum) {
    public DiceSubject(Player activePlayer, ArrayList<Player> players, int dice, int diceNum) {
        this.activePlayer = activePlayer;
        this.players = players;
        this.dice = dice;
        this.diceNum = diceNum;
    }

    /**
     * Gets the Player conducting the dice roll.
     * @return the Player who is conducting the dice roll.
     */

    public Player getActivePlayer() {
        return activePlayer;
    }

    /**
     * Sets the Player who will conduct the dice roll.
     * @param activePlayer the Player who will be conducting the dice roll.
     */

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    /**
     * Gets the array of available Machi Koro players.
     * @return an array of Players that are taking part in the current Machi Koro game.
     */

    // public Player[] getPlayers() {
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Sets the array of available Players.
     * @param players an array of Players that will take part in the Machi Koro game.
     */

    // public void setPlayers(Player[] players) {
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Gets the result of the performed dice roll.
     * @return an integer representing the result of the performed dice roll.
     */

    public int getDice() {
        return dice;
    }

    /**
     * Sets the result of the performed dice roll.
     * @param dice an integer representing the result of the performed dice roll.
     */

    public void setDice(int dice) {
        this.dice = dice;
    }

    /**
     * Gets the number of die used for the Player's roll.
     * @return an integer representing the number of die used for the Player's roll.
     */

    public int getDiceNum() {
        return diceNum;
    }

    /**
     * Sets the number of die to be used for the Player's roll.
     * @param diceNum an integer representing the number of die to be used in the Player's roll.
     */

    public void setDiceNum(int diceNum) {
        this.diceNum = diceNum;
    }

    /**
     * Gets the value of each die rolled.
     * @return an array holding the value of each individual die that was rolled.
     */

    public int[] getDicePair() {
        return dicePair;
    }

    /**
     * Sets the array holding the values of each die rolled.
     * @param dice1 the value of the first die rolled.
     * @param dice2 the value fo the second die rolled.
     */

    public void setDicePair(int dice1, int dice2) {
        this.dicePair = new int[] {dice1, dice2};
    }

    /**
     * Adds a given Observer to the list of listeners for this class.
     * @param observer the Observer to be added.
     */

    public void attach(Observer observer){
        observers.add(observer);
    }

    /**
     * Calls the update() method for all observers of this class.
     */

    public void notifyObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
