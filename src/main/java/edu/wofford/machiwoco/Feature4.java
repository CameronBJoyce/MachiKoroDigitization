package edu.wofford.machiwoco;

import org.apache.commons.lang3.StringUtils;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

/**
 * This is a class built to represent the Phase 2 version of Machi Koro.
 *
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */


public class Feature4 extends TwoPlayersPhase1 {

    Map<Establishment,Integer> P2startingEst3;

    protected Player player3;

    Establishment bakery;
    Establishment convenience;
    Establishment mine;
    Establishment orchard;

    Landmark[] startingLandmarks1;
    Landmark[] startingLandmarks2;

    protected DiceSubject diceSubject;

    /**
     * MachiWoco constructor representing the Phase 2 version of the game.
     * @param numPlayers an integer representing the number of Players.
     */

    public Feature4(int numPlayers) {
        super(true,numPlayers);
        NUMBER_OF_PLAYERS = numPlayers;

        //**********Establishment bakery creation************//
        bakery = new Establishment("Bakery", 1, Card.Color.GREEN, Card.Color_ab.G, Card.Icon.BREAD, Card.Icon_ab.B,
                "|  Get 1 coin from the  |\n" +
                        "|         bank.         |\n" +
                        "|   (your turn only)    |\n",
                "2-3", "receive", "bank", 1, "none", "none");


        //**********Establishment convenience store creation************//
        convenience = new Establishment("Convenience Store", 2, Card.Color.GREEN, Card.Color_ab.G, Card.Icon.BREAD, Card.Icon_ab.B,
                "| Get 3 coins from the  |\n" +
                        "|         bank.         |\n" +
                        "|   (your turn only)    |\n",
                "4", "receive", "bank", 3, "none", "none");

        //**********Establishment mine creation************//
        mine = new Establishment("Mine", 6, Card.Color.BLUE, Card.Color_ab.B, Card.Icon.GEAR, Card.Icon_ab.G,
                "| Get 5 coins from the  |\n" +
                        "|         bank.         |\n" +
                        "|    (anyone's turn)    |\n",
                "9", "receive", "bank", 5, "none", "none");

        //**********Establishment orchard creation************//
        orchard = new Establishment("Apple Orchard", 3, Card.Color.BLUE, Card.Color_ab.B, Card.Icon.WHEAT, Card.Icon_ab.W,
                "| Get 3 coins from the  |\n" +
                        "|         bank.         |\n" +
                        "|    (anyone's turn)    |\n",
                "10", "receive", "bank", 3, "none", "none");

        market.put(getWheat(), 6);
        market.put(getRanch(),6);
        market.put(getForest(),6);
        market.put(bakery, 6);
        market.put(convenience,6);
        market.put(mine,6);
        market.put(orchard,6);

        P2startingEst3 = new HashMap<>();

        startingEstablishments.put(bakery, 1);
        startingEstablishments2.put(bakery, 1);

        P2startingEst3.put(getWheat(),1);
        P2startingEst3.put(bakery,1);
        sc = new Scanner(System.in);


        EST_ORDER.remove(getForest());
        EST_ORDER.add(bakery);
        EST_ORDER.add(convenience);
        EST_ORDER.add(getForest());
        EST_ORDER.add(mine);
        EST_ORDER.add(orchard);

        landmarkInit();
        playerInit(numPlayers);
    }

    /**
     * Builds the Players with the second player now being an AI.
     * @param player_num the number of players taking part in the current game
     */

    protected void playerInit(int player_num) {
        NUMBER_OF_PLAYERS = player_num;
        player1 = new Player(startingEstablishments, startingLandmarks, 3,1, false);
        player2 = new Player(startingEstablishments2, startingLandmarks1, 3,2, true);
        if(player_num == 3) {
            player3 = new Player(P2startingEst3, startingLandmarks2, 3,3, true);
        }
        players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);

        if(player_num == 3) {
            players.add(player3);
        }
    }

    /**
     * Creates the Landmarks to be used by Players in Phase 2
     */
    @Override
    protected void landmarkInit() {
        NUMBER_OF_LANDMARKS = 2;
        startingLandmarks = new Landmark[2];
        startingLandmarks[1] = new Landmark("City Hall", 7, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  This is a city hall  |\n");
        startingLandmarks[0] = new Landmark("Train Station", 4, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  You may roll 1 or 2  |\n" +
                        "|         dice.         |\n");

        startingLandmarks1 = new Landmark[2];
        startingLandmarks1[1] = new Landmark("City Hall", 7, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  This is a city hall  |\n");
        startingLandmarks1[0] = new Landmark("Train Station", 4, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  You may roll 1 or 2  |\n" +
                        "|         dice.         |\n");

        startingLandmarks2 = new Landmark[2];
        startingLandmarks2[1] = new Landmark("City Hall", 7, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  This is a city hall  |\n");
        startingLandmarks2[0] = new Landmark("Train Station", 4, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  You may roll 1 or 2  |\n" +
                        "|         dice.         |\n");
    }


    /**
     * Gets the menu to display in String format
     * Overrode to fit Phase 2.
     * @return the game menu in string format
     */
    @Override
    protected String getMenu() {
        int count = 1;
        String s = generate_pure_padding("=") + getAvailEst(count);
        count = buyEstablishmentLogic().size() + 1;
        return s + getAvailLandmark(count) +
                getMenuStatic("CANCEL") +
                "99. " + StringUtils.rightPad("Do nothing", (42-4), " ") + "\n" +
                StringUtils.center("", 42, "=") +"\n";
    }

    /**
     * Driver for making moves for either AI or Human
     */
    public void makeMove() {
        buyFinished = false;
        if (getCurrentPlayer().isAi()) {
            aiLogic();
        } else {
            humanInput();
        }
    }

    /**
     * AI Logic for making a move
     */
    protected void aiLogic() {
        if(canAffordCard(getCurrentPlayer())) {
//            System.out.println(getMenu());
            int estSize = buyEstablishmentLogic().size();
            int lmkSize = getAffordableLandmarks(getCurrentPlayer()).size();
            // add last option of "99. Do Nothing" to AI
            int ai_choices = estSize + lmkSize + 1;
            int ai_input = (int) (Math.random() * ai_choices + 1);
            if (ai_input == ai_choices) {
                ai_input = 99;
            }
//            System.out.println("AI CHOSE: " + ai_input);
            handleInput(Integer.toString(ai_input));
        } else {
            System.out.println("Player " + getTurn() + "did not have enough money to make \n" +
                    "improvements.");
        }
    }

    /**
     * Human Input for making a move
     */
    protected void humanInput() {
        // human player input
        if(canAffordCard(getCurrentPlayer())) {
            String s = "Player " + getTurn() + " would you like to purchase an \n" + "establishment or construct a landmark?" + " (" + getCurrentPlayer().getCoinCount() +
                    "\n" + "coins) \n" + "(To view details of an item, type 'view'  \n" +
                    "followed by the item number. For example, \n" +
                    "to view item 6, type 'view 6'.)           \n";
            System.out.print(s);
            System.out.print(getMenu()); //Ivan

        } else {
            System.out.println("Player " + getTurn() + "did not have enough money to make \n" +
                    "improvements.");
        }
        while(!buyFinished && canAffordCard(getCurrentPlayer())) {
            System.out.println(StringUtils.center("Choose a number to purchase or construct: ", 42, " "));
            String input = sc.nextLine();
            buyFinished = handleInput(input);
        }
    }


    /**
     * Gets the sum of a dice roll using 2 die.
     * @param input a String representing the number of die being rolled (1 or 2)
     * @return an array featuring the value of the first dice, the second dice, and the sum of the two rolls.
     */

    protected int[] roll2(String input) {
        int diceSum = 0;
        int[] result = new int[3];
        if (input.equals("2")) {
            dice1 = (int) (Math.random() * 6 + 1);
            dice2 = (int) (Math.random() * 6 + 1);
            diceSum = dice1 + dice2;

            result[0] = dice1;
            result[1] = dice2;
            result[2] = diceSum;
        } else {
            dice1 = (int) (Math.random() * 6 + 1);
            dice2 = 0;

            result[0] = dice1;
            result[1] = dice2;
            result[2] = dice1;
        }
        return result;
    }



    /**
     * Checks to see if the Train Station landmark is constructed for a certain player
     * @param player the Player instance whose Train Station construction is being checked
     * @return a boolean holding true if the Player has constructed Train Station
     */

    protected boolean isTrainStationConstructed(Player player) {
        return player.getLandmarks()[1].getIsConstructed();
    }

    /**
     * Initialize game to be played
     */
    @Override
    protected void gameInit() {
        startGame();
        //players[0].setTurn(true);
        players.get(0).setTurn(true);

//        observer pattern
        gameSubject = new GameStateSubject(EST_ORDER, getPlayers(), getMarket());
        diceSubject = new DiceSubject(getCurrentPlayer(), getPlayers(), 0, 1);
        inputSubject = new InputSubject(getCurrentPlayer(),getPlayers(), "x");

//      subscribe to subjects
        new DiceObserver(diceSubject);
        new ActivationObserver(diceSubject);
        new GameStateObserver(gameSubject);
        new InputObserver(inputSubject);
    }

    /**
     * Returns a boolean holding true if the Player rolls two die.
     * @return a boolean holding true if the Player rolls two die.
     */

    protected boolean rollTwo() {
        if (getCurrentPlayer().getLandmarks()[0].is_constructed) {
            if (getCurrentPlayer().isAi()) {
                return new Random().nextBoolean();
            } else {
                return consoleListener.rollTwo(sc, getCurrentPlayer());
            }
        } else {
            return false;
        }
    }

    /**
     * Play the MachiWoCo game in its entirety
     */
    @Override
    public void playGame() {
        gameInit();

        while(!isGameOver()) {

            // (1) print turn and (2) print current game state
            gameSubject.notifyObservers();

            // (3) ROLL THE DICE AND THE CORRESPONDING ACTIVATIONS
            wayBetterRollDice(rollTwo());

            // (5) SHOW BUY MENU
            makeMove();

            //(6) End Game
            gameEnded();
        }
    }

    /**
     * Ends the current player's turn and checks to see if the game has ended
     * @param num number of players in the game
     */
    protected void endTurn(int num) {
        int curPlayerIndex = getTurn() - 1;
        System.out.println("Turn ended for Player " + getTurn() +".");
        if(curPlayerIndex == num -1) {
            // players[0].setTurn(true);
            // players[curPlayerIndex].setTurn(false);
            players.get(0).setTurn(true);
            players.get(curPlayerIndex).setTurn(false);
        } else {
            // players[curPlayerIndex].setTurn(false);
            // players[curPlayerIndex +1].setTurn(true);
            players.get(curPlayerIndex).setTurn(false);
            players.get(curPlayerIndex+1).setTurn(true);
        }
    }

    /**
     * Gets the convenience store establishment
     * @return the convenience store establishment
     */
    public Establishment getConvenience() {
        return convenience;
    }

    /**
     * Sets the convenience store establishment
     * @param convenience the convenience store establishment
     */
    public void setConvenience(Establishment convenience) {
        this.convenience = convenience;
    }

    /**
     * Gets the Mine establishment
     * @return the Mine establishment
     */
    public Establishment getMine() {
        return mine;
    }

    /**
     * Sets the Mine establishment
     * @param mine  the Mine establishment
     */
    public void setMine(Establishment mine) {
        this.mine = mine;
    }

    /**
     * Gets the market for the Phase2 version of the game
     * @return a Map object representing the Phase 2 market
     */
    public Map<Establishment,Integer> getMarketP2() {
        return market;
    }

    /**
     * Gets the Orchard establishment
     * @return the Orchard establishment
     */
    public Establishment getOrchard() {
        return orchard;
    }

    /**
     * Sets the Orchard establishment
     * @param orchard the Orchard establishment
     */
    public void setOrchard(Establishment orchard) {
        this.orchard = orchard;
    }

    /**
     * Gets the Bakery establishment
     * @return the Baker establishment
     */
    public Establishment getBakery() {
        return bakery;
    }

    /**
     * Starts the MachiWoco game.
     * @param args a String array representing the user's console arguments.
     */

    public static void main(String[] args) {
        Feature4 feature4 = new Feature4(Integer.parseInt(args[1]));
        feature4.playGame();
    }
}