package edu.wofford.machiwoco;

import java.util.ArrayList;
import java.util.Random;

/**
 * This is a class built to represent the Phase 6 version of Machi Koro with a Strategic AI.
 *
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */

public class Feature9 extends Feature8 {

    /**
     * MachiWoco constructor representing the Phase 6 version of the game with a Strategic AI.
     * @param numPlayers an integer representing the number of Players.
     */

    public Feature9(int numPlayers) {
        super(2+numPlayers);
        player2.setSmart(true);
    }

    /**
     *  If a player owns any card that has an activation value greater than 6, roll two die.
     * @return a boolean representing the decision to roll two die.
     */

    protected boolean aiRollTwoLogic() {
        for (Establishment e: getCurrentPlayer().getEstOwned().keySet()) {
            if (e.getName().equals("Bakery")) {
                continue;
            } else if (e.getName().equals("Family Restaurant") || e.getName().equals("Farmers Market")) {
                return true;
            } else if (Integer.parseInt(e.getActivation()) > 6 ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a boolean holding true if the Player rolls two die.
     * @return a boolean holding true if the Player rolls two die.
     */
    @Override
    protected boolean rollTwo() {
        if (getCurrentPlayer().getLandmarks()[0].is_constructed) {
            if (getCurrentPlayer().isAi()) {
                if (getCurrentPlayer().isSmart()) {
                    return aiRollTwoLogic();
                } else {
                    return rand.nextBoolean();
                }
            } else {
                return consoleListener.rollTwo(sc, getCurrentPlayer());
            }
        } else {
            return false;
        }
    }

    /**
     * If the AI's potential income is less than 4, reroll.
     * @return a boolean representing the decision to reroll the die.
     */
    protected boolean rerollAILogic() {
        int potential = getCurrentPlayer().peekActivation(dice1+dice2, true);
        return potential < 4;
    }

    /**
     * Conducts the logic associated with the Radio Tower.
     * @return a boolean holding true if the Player chooses to reroll.
     */

    @Override
    public boolean radioTowerLogic() {
        if (getCurrentPlayer().isAi()) {
            if (getCurrentPlayer().isSmart()) {
                return rerollAILogic();
            } else {
                return rand.nextBoolean();
            }
        }
        return consoleListener.playerChooseReroll(sc, getCurrentPlayer());
    }

    /**
     * Conducts a diceRoll and carries out any related activations.
     * @param rollTwo a boolean holding true if the roll includes two die.
     */

    @Override
    public void wayBetterRollDice(boolean rollTwo) {
        betterRollDice(rollTwo);
        if (getCurrentPlayer().isRadioTowerConstructed()) {
            consoleListener.diceRolled(dice1, dice2, getCurrentPlayer());
            boolean reroll = radioTowerLogic();
            if (reroll) {
                betterRollDice(rollTwo());
                System.out.println("Player " + getCurrentPlayer().getPlayerNumber() + " used a reroll.");
                actionsDiceRolled();
            } else {
                consoleListener.diceActivation(dice1+dice2, players);
                activationListener.diceActivation(dice1+dice2, players);
            }
        } else { actionsDiceRolled();}

        if ((dice1 + dice2) == 6) {
            if (getCurrentPlayer().isTVStationConstructed()) {TVStationLogic();}
            if (getCurrentPlayer().isBusinessComplexOwned()) {busComplexLogic();}
        }
    }

    /**
     * Contains all logic that the Strategic AI should follow when in position to purchase a card.
     * @param availEst an ArrayList of available establishments for purchase.
     * @param availLand an ArrayList of available landmarks for purchase.
     * @return an integer representing the market selection for the AI.
     */

    protected int purchaseLogic(ArrayList<Establishment> availEst, ArrayList<Landmark> availLand) {
        if (!isTrainStationConstructed(getCurrentPlayer())) {
            int establishmentOwned = 0;
            for (Establishment est : getCurrentPlayer().getEstOwned().keySet()) {
                establishmentOwned += getCurrentPlayer().getEstOwned().get(est);
            }

            if (establishmentOwned > 4 && getCurrentPlayer().getCoinCount() > 3) {
                // purchase train somehow
                return availEst.size()+1;
            } else if (availEst.contains(getRanch())) {
                return availEst.indexOf(getRanch())+1;
            } else if (availEst.contains(getForest())) {
                return availEst.indexOf(getForest())+1;
            } else if (availEst.contains(getWheat())) {
                return availEst.indexOf(getWheat())+1;
            } else if (availEst.contains(getConvenience())) {
                return availEst.indexOf(getConvenience())+1;
            } else if (availEst.contains(getCafe())) {
                return availEst.indexOf(getCafe())+1;
            }
            return 1;
        } else {
            if (availLand.size() > 0) {
                // purchases the most expensive landmark
                return availEst.size() + availLand.size();
            } else if (availEst.contains(furnitureFactory) && getCurrentPlayer().getNumberOwnedIcon("G") > 2) {
                return availEst.indexOf(furnitureFactory)+1;
            } else if (availEst.contains(cheeseFactory) && getCurrentPlayer().getEstOwned().get(getRanch()) > 2) {
                return availEst.indexOf(cheeseFactory)+1;
            } else if (availEst.contains(getMine())) {
                return availEst.indexOf(getMine())+1;
            } else if (availEst.contains(getForest())) {
                return availEst.indexOf(getForest())+1;
            } else if (currPlayerNumLandmarkConstructed() > 2 && getCurrentPlayer().getCoinCount() > 18) {
                return 99;
            } else if (getIndexColorAB(availEst, Card.Color_ab.P)!=0) {
                return getIndexColorAB(availEst, Card.Color_ab.P);
            } else if (getIndexColorAB(availEst, Card.Color_ab.B)!=0) {
                return getIndexColorAB(availEst, Card.Color_ab.B);
            } else if (getIndexColorAB(availEst, Card.Color_ab.R)!=0) {
                return getIndexColorAB(availEst, Card.Color_ab.R);
            } else if (getIndexColorAB(availEst, Card.Color_ab.G)!=0) {
                return getIndexColorAB(availEst, Card.Color_ab.G);
            }
        }
        return 1;
    }

    /**
     * Gets the last index of the most expensive card available for purchase based off a specific color.
     * @param est an ArrayList representing available Establishments.
     * @param color an enumeration representing the abbreviated value of the desired color.
     * @return an integer representing the last index of the most expensive card available for puchase.
     */

    protected int getIndexColorAB(ArrayList<Establishment> est, Card.Color_ab color) {
        for (int i = est.size()-1; i >= 0; i--) {
            if (est.get(i).getColor_ab().equals(color)) {return i+1;}
        }
        return 0;
    }

    /**
     * Gets the number of Landmarks constructed by the current Player.
     * @return an integer representing the number of Landmarks constructed by the current Player.
     */

    protected int currPlayerNumLandmarkConstructed() {
        int count = 0;
        for (Landmark l : getCurrentPlayer().getLandmarks()) {
            if(l.is_constructed) {count++;}
        }
        return count;
    }


    /**
     * AI Logic for making a move
     */

    @Override
    protected void aiLogic() {
        if(canAffordCard(getCurrentPlayer())) {
//            System.out.println(getMenu());
            int estSize = buyEstablishmentLogic().size();
            int lmkSize = getAffordableLandmarks(getCurrentPlayer()).size();
            // add last option of "99. Do Nothing" to AI
            int ai_choices = estSize + lmkSize + 1;
            int ai_input;
            if (getCurrentPlayer().isSmart()) {
                ai_input = purchaseLogic(buyEstablishmentLogic(), getAffordableLandmarks(getCurrentPlayer()));
            } else {
                ai_input = (int) (Math.random() * ai_choices + 1);
                if (ai_input == ai_choices) {
                    ai_input = 99;
                }
            }
//            System.out.println("AI CHOSE: " + ai_input);
            handleInput(Integer.toString(ai_input));
        } else {
            System.out.println("Player " + getTurn() + "did not have enough money to make \n" +
                    "improvements.");
        }
    }

    /**
     * Driver for making moves for either AI or Human
     */

    @Override
    public void makeMove() {
        buyFinished = false;
        if (getCurrentPlayer().isAi()) {
            aiLogic();
        } else {
            humanInput();
        }
    }

    /**
     * Play the MachiWoCo game in its entirety
     */

    @Override
    public void playGame() {
        gameInit();

        while (!isGameOver()) {
            // (1) print turn and (2) print current game state
            gameSubject.notifyObservers();

            // (3) ROLL THE DICE AND THE CORRESPONDING ACTIVATIONS
            wayBetterRollDice(rollTwo());

            // (4) either human or ai player make moves
            makeMove();

            // (5) check if Game has ended
            gameEnded();

            removeZeroesMarket();
            uniqueA = setDeck(DeckA, 5, uniqueA);
            uniqueB = setDeck(DeckB, 5, uniqueB);
            uniqueC = setDeck(DeckC, 2, uniqueC);

        }
    }

    /**
     * Checks to see if the Train Station landmark is constructed for a certain player
     * @param player the Player instance whose Train Station construction is being checked
     * @return a boolean holding true if the Player has constructed Train Station
     */
    @Override
    protected boolean isTrainStationConstructed(Player player) {
        return player.getLandmarks()[0].getIsConstructed();
    }

    /**
     * Main driver for the Feature9 class.
     * @param args an array of Strings representing command line input.
     */

    public static void main(String[] args) {
        Feature9 feature9 = new Feature9(Integer.parseInt(args[1]));
//        feature9.player1.getLandmarks()[0].setIs_constructed(true);
//        feature9.player1.getEstOwned().put(feature9.businessComplex, 1);
//        feature9.player1.getEstOwned().put(feature9.tvStation, 1);
//        feature9.player1.getEstOwned().put(feature9.stadium, 1);

        feature9.playGame();
    }

    /**
     * Provides the Player to be targeted by the AI.
     * @param players an ArrayList of the current Players.
     * @param smart a boolean holding true if the AI is strategic.
     * @return the Player to be targeted by the AI.
     */

    public Player aiPlayerChoice(ArrayList<Player> players, boolean smart) {
//  nextInt(upperbound) generates random numbers in the range 0 to upperbound-1
        Player temp = players.get(0);
        for (Player p: players) {
            if (p.getCoinCount() > temp.getCoinCount()) {temp = p;}
        }
        if (smart) {
            return temp;
        }
        return players.get(rand.nextInt(players.size()));
    }

    /**
     * Conducts the logic associated with an activated TV Station establishment.
     */

    @Override
    public void TVStationLogic() {
        int coinCount = 0;
        for (Player p : players) {
            if (!p.isTurn()) {
                coinCount += p.getCoinCount();
            }
        }
        if (coinCount > 0) {
            Player playerToTarget;
            if (!getCurrentPlayer().isAi()) {
                playerToTarget = consoleListener.playerChooseTarget(EST_ORDER, sc, getCurrentPlayer(), players, true);
            } else {
                playerToTarget = aiPlayerChoice(availPlayersTV(players), getCurrentPlayer().isSmart());
            }
            activationListener.takeMoney(playerToTarget, getCurrentPlayer(), 5);
        } else {
            System.out.println("TV Station activated, but no player is available to target.");
        }
    }


}
