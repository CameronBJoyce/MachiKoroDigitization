package edu.wofford.machiwoco;

import javax.swing.*;
import java.util.Map;
import java.util.Set;

/** 
 * This is a class built to represent a Player.
 * 
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */

public class Player {
    private int coinCount;
    private Map<Establishment,Integer> estOwned;
    private Landmark[] landmarks;
    private boolean turn;
    private boolean ai;
    private boolean smart;

    private int playerNumber;

    /**
     * Player constructor that contains all necessary info about a given player within the game
     * @param estOwned a Map object containing the Player's owned Establishments
     * @param landmarks an array containing the game's Landmarks
     * @param coinCount an integer representing the Player's total coins
     * @param playerNumber an integer representing the Player's number
     * @param ai a boolean holding true if the Player is an AI
     */

    public Player(Map<Establishment,Integer> estOwned, Landmark[] landmarks, int coinCount, int playerNumber, boolean ai) {
      this.estOwned = estOwned;
      this.landmarks = landmarks;
      this.coinCount = coinCount;
      this.playerNumber = playerNumber;
      turn = false;
      this.ai = ai;
      smart = false;
    }

    /**
     * Returns a boolean representing if the current Player is strategic.
     * @return a boolean holding true if the Player is strategic.
     */

    public boolean isSmart() {
        return smart;
    }

    /**
     * Sets whether or not the current Player is strategic.
     * @param smart a boolean holding true if the Player is set to be strategic.
     */

    public void setSmart(boolean smart) {
        this.smart = smart;
    }

    /**
     * A function returning the random (and valid) choice made by the AI.
     * @param range an integer representing the last valid choice available to the AI.
     * @return an integer representing the AI's random choice.
     */

    protected int random_ai_choice(int range) {
        int ai_input = (int) (Math.random() * range + 1);
        if (ai_input == range) {
            ai_input = 99;
        }
        return ai_input;
    }

    /**
     * Calls the action to be performed based on the Player's dice roll
     * @param diceRoll an integer representing the result of the Player's dice roll
     * @param isTurn  boolean representing whether the player's turn is active
     * @return an integer representing 
     */

    protected int peekActivation(int diceRoll, boolean isTurn){
        int potential = 0;
        Set<Establishment> keys = estOwned.keySet();
        for(Establishment est: keys){
            int activation = 0;
            int activation2 = 0;
            switch (est.getName()) {
                case "Bakery":
                    activation = 2;
                    activation2 = 3;
                    break;
                case "Farmers Market":
                    activation = 11;
                    activation2 = 12;
                    break;
                case "Family Restaurant":
                    activation = 9;
                    activation2 = 10;
                    break;
                default:
                    activation = Integer.parseInt(est.getActivation());
                    break;
            }
            int numberOwned = estOwned.get(est);
            if(diceRoll == activation || diceRoll == activation2) {
                if(est.getColor_ab().equals(Card.Color_ab.B)) {
                    potential = peekAction(est,numberOwned);
                } else if(est.getColor_ab().equals(Card.Color_ab.G)) {
                    if (isTurn && est.getModifierType().equals("icon")) {
                        potential = peekActionIcon(est, numberOwned);
                    } else if (isTurn) {
                        potential = peekAction(est, numberOwned);
                    }
                }
            }
        }
        return potential;
    }

    /**
     * Calls the action to be performed based on the Player's dice roll
     * @param diceRoll an integer representing the result of the Player's dice roll
     * @param isTurn  boolean representing whether the player's turn is active
     */

    public void getActivationNumbers(int diceRoll, boolean isTurn){
        Set<Establishment> keys = estOwned.keySet();

        for(Establishment est: keys){
            int activation = 0;
            int activation2 = 0;
            switch (est.getName()) {
                case "Bakery":
                    activation = 2;
                    activation2 = 3;
                    break;
                case "Farmers Market":
                    activation = 11;
                    activation2 = 12;
                    break;
                case "Family Restaurant":
                    activation = 9;
                    activation2 = 10;
                    break;
                default:
                    activation = Integer.parseInt(est.getActivation());
                    break;
            }
            int numberOwned = estOwned.get(est);
            if(diceRoll == activation || diceRoll == activation2) {
                if(est.getColor_ab().equals(Card.Color_ab.B)) {
                    performAction(est,numberOwned);
                } else if(est.getColor_ab().equals(Card.Color_ab.G)) {
                    if (isTurn && est.getModifierType().equals("icon")) {
                        performActionIcon(est, numberOwned);
                    } else if (isTurn) {
                        performAction(est, numberOwned);
                    }
                }
            }
        }
    }


//   protected boolean isShoppingMallConstructed() {
//       return sh
//   }

    /**
     * Takes coins from player. If insufficient funds, the player then have 0 coins.
     * @param coinCount the amount to be taken from the player
     * @return the amount actually taken from the player
     */

    public int takeCoin(int coinCount) {
        int coinTaken;
        if(this.coinCount - coinCount >= 0) {
            this.coinCount -= coinCount;
            coinTaken = coinCount;
        } else {
            coinTaken = this.coinCount;
            this.coinCount = 0;
        }
        return coinTaken;
    }


    /**
     * Constructs/Buys Landmark
     * @param l The landmark needed to match another landmark in the player's landmarks array
     */
    public void buyLandmark(Landmark l) {
        int cost = l.getCost();
        int counter = 0;
        for(Landmark loop: landmarks) {
            if(loop.equals(l) && coinCount >= cost) {
                landmarks[counter].setIs_constructed(true);
                coinCount = coinCount - cost;
            }
            counter++;
        }
    }

    /**
     * Return true if Stadium is owned
     * @return boolean whether stadium is owned
     */
    public boolean isStadiumOwned() {
        for(Establishment e:estOwned.keySet()) {
            if(e.getName().equals("Stadium")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return true if Business Complex is owned
     * @return boolean whether Business Complex is owned
     */
    public boolean isBusinessComplexOwned() {
        for(Establishment e:estOwned.keySet()) {
            if(e.getName().equals("Business Complex")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return true if TV Station is owned
     * @param p The map of establishments owned
     * @return boolean whether TV Station is owned
     */
    public boolean isTVStationOwned(Map<Establishment, Integer> p) {
        for (Establishment e : getEstOwned().keySet()) {
            if (e.getName().equals("TV Station")) {
                return true;
            }
        }
        return false;
    }




    /**
     * Return the number of Cafes for a player
     * @param p The map of players
     * @return number of Cafes owned
     */
    public int numOfCafe(Map<Establishment,Integer> p) {
        for(Establishment e:estOwned.keySet()) {
            if(e.getName().equals("Cafe")) {
                return estOwned.get(e);
            }
        }
        return 0;
    }

    /**
     * Return the number of Restaurant for a player
     * @param p The map of players
     * @return number of Restaurant owned
     */
    public int numOfRestaurant(Map<Establishment,Integer> p) {
        for(Establishment e:estOwned.keySet()) {
            if(e.getName().equals("Family Restaurant")) {
                return estOwned.get(e);
            }
        }
        return 0;
    }

    /**
     * Buying Card Action
     * @param e the Establishment upon which an action is being performed
     */

    public void buyCard(Establishment e) {
        int cost = e.getCost();
        if(estOwned.containsKey(e)) {
            int numberOwned = estOwned.get(e);
            estOwned.put(e,numberOwned+1);
            setCoinCount(getCoinCount() - cost);
        } else {
            estOwned.put(e,1);
            setCoinCount(getCoinCount() - cost);
        }
    }

    /**
     * Removeing Card Action
     * @param e the Establishment to be removed
     */

    protected void removeCard(Establishment e) {
        if(estOwned.containsKey(e)) {
            int numberOwned = estOwned.get(e);
             if(numberOwned == 1) {
                 estOwned.remove(e);
             } else if (numberOwned > 1) {
                estOwned.put(e, numberOwned - 1);
            }
        }
    }

    /**
     * Removeing Card Action
     * @param e the Establishment to be removed
     */

    public void addCard(Establishment e) {
        if(estOwned.containsKey(e)) {
            int numberOwned = estOwned.get(e);
            estOwned.put(e, numberOwned + 1);
        } else {
            estOwned.put(e, 1);
        }
    }

    /**
     * Returns the potential value of activating blue or green cards in order to plan out the best move available.
     * @param e the Establishment being observed.
     * @param numberOwned an integer representing how many of the specified Establishments are owned by the Player.
     * @return an integer representing the potential value of the given Establishment's activation.
     */

    protected int peekAction(Establishment e, int numberOwned) {
        int potential = 0;
        String type = e.getType();
        int amount = e.getAmount();
        String target = e.getTarget();
        if(type.equals("receive") && target.equals("bank")) {
            potential = amount * numberOwned;
        }
        if(landmarks.length > 2 && (!e.getColor_ab().equals(Card.Color_ab.R))
                && isShoppingMallConstructed()
                && (e.getIcon_ab().name().equals("U") || e.getIcon_ab().name().equals("B"))) {
            potential += numberOwned;
        }
        return potential;
    }



    /**
     * Performs the action associated with the given Establishment
     * @param e the Establishment upon which an action is being performed
     * @param numberOwned an integer representing the amount of coins owned by the Player
     */

    private void performAction(Establishment e, int numberOwned) {
        String type = e.getType();
        int amount = e.getAmount();
        String target = e.getTarget();
        if(type.equals("receive") && target.equals("bank")) {
            addCoins(amount * numberOwned);
        }


        if(landmarks.length > 2 && (!e.getColor_ab().equals(Card.Color_ab.R)) && isShoppingMallConstructed() && (e.getIcon_ab().name().equals("U") || e.getIcon_ab().name().equals("B"))) {
            addCoins(numberOwned);
        }
    }

    /**
     * Performs the action associated with the given Establishment if said Establishment relies on icons.
     * @param e the Establishment upon which an action is being performed
     * @param numberOwned an integer representing the amount of coins owned by the Player
     * @return an integer representing how many coins have been awarded after the activation of the given Establishment.
     */

    protected int peekActionIcon(Establishment e, int numberOwned) {
        int amount = e.getAmount();
        int numberOwnedIcon = 0;
        // it's getting icon ab of cheese factory
        String modifier = e.getModifier();
        switch (modifier) {
            case "cow":
                numberOwnedIcon = getNumberOwnedIcon("C");
                break;
            case "gear":
                numberOwnedIcon = getNumberOwnedIcon("G");
                break;
            case "wheat":
                numberOwnedIcon = getNumberOwnedIcon("W");
                break;
        }
        return amount * numberOwned * numberOwnedIcon;
    }

    /**
     * Performs the action associated with the given Establishment if said Establishment relies on icons.
     * @param e the Establishment upon which an action is being performed
     * @param numberOwned an integer representing the amount of coins owned by the Player
     */

    private void performActionIcon(Establishment e, int numberOwned) {
        int amount = e.getAmount();
        int numberOwnedIcon = 0;
        // it's getting icon ab of cheese factory
        String modifier = e.getModifier();
        switch (modifier) {
            case "cow":
                numberOwnedIcon = getNumberOwnedIcon("C");
                break;
            case "gear":
                numberOwnedIcon = getNumberOwnedIcon("G");
                break;
            case "wheat":
                numberOwnedIcon = getNumberOwnedIcon("W");
                break;
        }
        addCoins(amount * numberOwned * numberOwnedIcon);
    }

    /**
     * Gets the number of Establishments owned corresponding to a specific icon.
     * @param icon_ab the icon of the card(s) being observed.
     * @return an integer representing the number of Establishments owned corresponding to a specific icon.
     */

    public int getNumberOwnedIcon(String icon_ab) {
        int count = 0;

        for (Map.Entry<Establishment, Integer> est : estOwned.entrySet()) {
            if (est.getKey().getIcon_ab().name().equals(icon_ab)) {
                count = count + estOwned.get(est.getKey());
            }
        }

        return count;
    }

    /**
     * Gets whether or not the Shopping Mall landmark is constructed.
     * @return a boolean holding true if the Player has constructed the Shopping Mall landmark.
     */
    public boolean isShoppingMallConstructed() {
        for (Landmark landmark : landmarks) {
            //if (landmark.getName().equals("Shopping Mall")) {
            if (landmark.getName().equals("Shopping Mall") && landmark.getIsConstructed()) {
                return true;
                //return landmark.getIsConstructed();
            }
        }
        return false;
    }

    /**
     * Gets whether or not the TV Station landmark is constructed.
     * @return a boolean holding true if the Player has constructed the TV Station landmark.
     */
    public boolean isTVStationConstructed() {
        for (Establishment e : estOwned.keySet()) {
            if (e.name.equals("TV Station")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets whether or not the Radio Tower landmark is constructed.
     * @return a boolean holding true if the Player has constructed the Radio Tower landmark.
     */
    public boolean isRadioTowerConstructed() {
        for (Landmark l: landmarks) {
            if (l.getName().equals("Radio Tower") && l.getIsConstructed()) {return true;}
        }
        return false;
    }


    /**
     * Gets whether or not the Amusement Park landmark is constructed.
     * @return a boolean holding true if the Player has constructed the Amusement Park landmark.
     */
    public boolean isAmusementConstructed() {
        for (Landmark landmark : landmarks) {
            //if (landmark.getName().equals("Amusement Park")) {
            if (landmark.getName().equals("Amusement Park") && landmark.getIsConstructed()) {
                //return landmark.getIsConstructed();
                return true;
            }
        }
        return false;
    }

    /**
     * Adds the given coin total to the Player's coin count
     * @param coinCount an integer representing the amount of coins to be added to the Player's coin count
     */

    public void addCoins(int coinCount) {
        this.coinCount += coinCount;
    }

    /**
     * Sets the Player's turn to be active (true) or not (false)
     * @param setter a boolean holding 'true' if it is the Player's turn
     */

    protected void setTurn(boolean setter) {
        turn = setter;
    }

    /**
     * Gets the Player's number
     * @return an integer representing the Player's number
     */

    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * States whether or not it is the given Player's turn
     * @return a boolean representing whether it is the Player's turn
     */

    public boolean isTurn() { return turn; }

    /**
     * Gets the Player's coin count
     * @return an integer representing the Player's coin count
     */

    public int getCoinCount() {
        return coinCount;
    }

   /**
    * Gets the Player's landmarks
    * @return an array of current Landmarks
    */

    public Landmark[] getLandmarks() {
        return landmarks;
    }

    /**
     * Sets the player's coin total
     * @param coinCount the amount of coins the current Player has in total
     */

    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }

    /**
     * Gets the Player's owned establishments
     * @return a Map object containing the Player's owned Establishments
     */

    public Map<Establishment, Integer> getEstOwned() {
        return estOwned;
    }

    /**
     * Sets the Player's owned establishments
     * @param estOwned a Map object containing the Player's owned Establishments
     */

    public void setEstOwned(Map<Establishment, Integer> estOwned) {
        this.estOwned = estOwned;
    }

    /**
     * Checks if the player is an AI
     * @return a boolean holding true if the player is an AI
     */

    public boolean isAi() {
        return ai;
    }

    /**
     * Sets the player's AI status
     * @param ai a boolean holding true if the player is to be an AI
     */

    public void setAi(boolean ai) {
        this.ai = ai;
    }

    /**
     * Sets the Player's owned Landmarks
     * @param landmarks an array containing the game's Landmarks
     */

    public void setLandmarks(Landmark[] landmarks) {
        this.landmarks = landmarks;
    }

}