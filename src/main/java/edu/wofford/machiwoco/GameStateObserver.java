package edu.wofford.machiwoco;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * This class uses GameSubject to output the current game state.
 *
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */

public class GameStateObserver extends Observer{

    private GameStateSubject gameSubject;

    /**
     * A constructor that creates a GameSubject instance and adds itself to GameSubject's list of observers.
     * @param gameSubject a GameSubject instance that will be used to access the info needed in the output.
     */

    public GameStateObserver(GameStateSubject gameSubject){
        this.gameSubject = gameSubject;
        this.gameSubject.attach(this);
    }

    /**
     * Generates padding for a given string
     * @param s string that needs to be padded to 42 characters
     * @return the 42 character formatted string
     */
    protected String generate_pure_padding(String s) {
        return StringUtils.center("", 42, s) + "\n";
    }

    /**
     * Generates formatted line for player statement in marketplace
     * @param p Player to be passed in
     * @param num  Player Number
     * @param active is current player active
     * @return the 42 character formatted string
     */
    protected String generatePlayerLine(Player p, int num, boolean active) {
        String player;
        if (active) {
            player = "Player " + num + "* [YOU]";
        } else {
            player = "Player " + num;
        }
        return StringUtils.center(player, 42, " ") + "\n";
    }

    /**
     * Generates formatted line for showing the number of coins a player owns
     * @param p Player to be passed in
     * @return the 42 character formatted string for Coins
     */
    protected String generatePlayerCoin(Player p) {
        String account = "(" + p.getCoinCount() + " coins)";
        return StringUtils.center(account, 42, " ") + "\n";
    }

    /**
     * Generates formatted line for player establishment list
     * @param p Player to be passed in
     * @return String of player establishment listings
     */
    protected String generatePlayerEst(Player p) {
        Map<Establishment,Integer> estOwned = p.getEstOwned();
        StringBuilder s = new StringBuilder();
        for (Establishment e : gameSubject.getEstOrder()) {
            if (estOwned.containsKey(e)) {
                s.append(generateSingleMarketItem(e, estOwned.get(e)));
            }
        }
        return s + "";
    }

    /**
     * Generates a string displaying the given Landmark
     * @param l the Landmark instance to be displayed
     * @return a string displaying the given Landmark
     */
    protected String generateLandmark(Landmark l) {
        String construct = "[" + l.isConstructed(l.is_constructed) + "]";
        return StringUtils.rightPad(l.getName(), 18, " ") +
                " " + l.getColor_ab() + l.getIcon_ab() + " " +
                generateCost(l.getCost()) + " " +
                construct + "\n";

    }

    /**
     * Generates formatted list of landmarks a player has
     * @param p Player to be passed in
     * @return The list of player landmarks
     */
    protected StringBuilder generatePlayerLandMark(Player p) {
        StringBuilder s = new StringBuilder();
        for (Landmark l : p.getLandmarks()) {
            s.append(generateLandmark(l));
        }
        return s;
    }

    /**
     * Generates formatted player menu
     * @param p Player to be passed in
     * @param num the player's number
     * @param active a boolean representing true if the player is active
     * @return The complete player output
     */
    protected String generatePlayer(Player p, int num, boolean active) {
        //        System.out.println("PLAYER: "+ active);
        return generatePlayerLine(p, num, active) +
                generate_pure_padding("-") +
                generatePlayerCoin(p) +
                generatePlayerEst(p) +
                generate_pure_padding(".") +
                generatePlayerLandMark(p) + "\n";
    }

    /**
     * Provides the given cost in string form
     * @param cost the cost of the card
     * @return the string representing the cost of the card to be used in toString()
     */
    protected String generateCost(int cost) {
        String act = "(" + cost + ")";
        return StringUtils.rightPad(act, 4, " ");
    }

    /**
     * Provides the given activation range in string form
     * @param s the activation range in string format
     * @return the string representing the activation range of the card
     */
    protected String generateActivation(String s) {
        String act = "[" + s + "]";
        return StringUtils.rightPad(act, 7, " ");
    }

    /**
     * Generates a given market item to be displayed to the player
     * @param e an Establishment instance to be displayed within the market
     * @param count the available number of a given Establishment instance
     * @return a string representing the market item of an Establishment card
     */
    protected String generateSingleMarketItem(Establishment e, int count) {
        return StringUtils.rightPad(e.getName(), 18, " ") + " " +
                e.getColor_ab() + e.getIcon_ab() + " " +
                generateCost(e.getCost()) + " " +
                generateActivation(e.getActivation()) + " " +
                " #" + Integer.toString(count) + "\n";
    }

    /**
     * Generates the static market in string form
     * @return a string representing the static market
     */
    protected String generateStaticMarket() {
        return generate_pure_padding("*") +
                generate_title("MARKET") +
                generate_pure_padding("-");
    }

    /**
     * Generates the title for the toString() of the class
     * @param s the string to which the title is being added
     * @return the resulting title string
     */

    protected String generate_title(String s) {
        return StringUtils.center(s, 42, " ") + "\n";
    }

    /**
     * Generates the static market in string form
     * @return a string representing the static market
     */

    protected  String generateMarket() {
        StringBuilder s = new StringBuilder();
        for (Establishment e : gameSubject.getEstOrder()) {
            if (gameSubject.getMarket().containsKey(e)) {
                s.append(generateSingleMarketItem(e, gameSubject.getMarket().get(e)));
            }
        }
        return generateStaticMarket() + s + "\n";
    }

    /**
     * Generates a StringBuilder representing player information
     * @return the StringBuilder instance representing player information
     */

    protected StringBuilder playerStringBuilder() {
        StringBuilder s = new StringBuilder();
        ArrayList<Player> playersArr = gameSubject.getPlayers();
        for (int i = 0; i < playersArr.size(); i++) {
            s.append(generatePlayer(playersArr.get(i), i + 1, playersArr.get(i).isTurn()));
        }
        return s;
    }

    /**
     * Generates a string used to display the current player's turn
     * @return a string representing the current player's turn
     */

    protected String printTurn() {
        String result = "";
        for(int i = 0; i < gameSubject.getPlayers().size(); i++) {
            if(gameSubject.getPlayers().get(i).isTurn()) {
                result = "Turn started for Player " + (i + 1) + ".\n";
                return result;
            }
        }
        return result;
    }

    /**
     * Prints out the current game state to the console.
     */

    @Override
    public void update() {
        System.out.println(printTurn() + generateMarket() + playerStringBuilder() + StringUtils.center("", 42, "*"));
    }
}