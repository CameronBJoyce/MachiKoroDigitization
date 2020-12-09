package edu.wofford.machiwoco;

import org.apache.commons.lang3.StringUtils;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

/**
 * This is a class built to represent the Phase 4 version of Machi Koro.
 *
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */


public class Feature6 extends Feature5 {

    Establishment cafe;
    Establishment familyRestaurant;

    Player player4;
    Landmark[] startingLandmarks3;

    Map<Establishment,Integer> P4startingEst4;

    /**
     * MachiWoco constructor representing the Phase 3 version of the game.
     * @param numPlayers an integer representing the number of Players.
     */

    public Feature6(int numPlayers) {
        super(2);
        NUMBER_OF_PLAYERS = numPlayers;
        
        
        // Establishments go here
        cafe = new Establishment("Cafe", 2, Card.Color.RED, Card.Color_ab.R, Card.Icon.CUPU, Card.Icon_ab.U,
                "| Take 1 coin from the  |\n" +
                          "|    active player.     |\n" +
                          "|   (opponent's turn)   |\n",
                "3", "receive", "active", 1, "none", "none");

        familyRestaurant = new Establishment("Family Restaurant", 3, Card.Color.RED, Card.Color_ab.R, Card.Icon.CUPU, Card.Icon_ab.U,
        "| Take 2 coins from the |\n" +
                    "|    active player.     |\n" +
                    "|   (opponent's turn)   |\n",
        "9-10", "receive", "active", 2, "none", "none");


        market.put(getWheat(), 6);
        market.put(getRanch(),6);
        market.put(getForest(),6);
        market.put(getBakery(), 6);
        market.put(getConvenience(),6);
        market.put(getMine(),6);
        market.put(getOrchard(),6);
        market.put(getCheeseFactory(), 6);
        market.put(getFurnitureFactory(), 6);
        market.put(getFarmersMarket(), 6);
        market.put(cafe, 6);
        market.put(familyRestaurant, 6);

        P4startingEst4 = new HashMap<>();

        P4startingEst4.put(getWheat(),1);
        P4startingEst4.put(bakery,1);

        sc = new Scanner(System.in);

        // EST_ORDER
        EST_ORDER = new ArrayList<Establishment>();
        EST_ORDER.add(getWheat());
        EST_ORDER.add(getRanch());
        EST_ORDER.add(getBakery());
        EST_ORDER.add(cafe);
        EST_ORDER.add(getConvenience());
        EST_ORDER.add(getForest());
        EST_ORDER.add(getCheeseFactory());
        EST_ORDER.add(getFurnitureFactory());
        EST_ORDER.add(getMine());
        EST_ORDER.add(familyRestaurant);
        EST_ORDER.add(getOrchard());
        EST_ORDER.add(getFarmersMarket());

        landmarkInit();
        playerInit(numPlayers);
    }

    /**
     * Builds the Players to take part in the Phase3 version of Machi Koco.
     * @param player_num the number of players taking part in the current game
     */

    @Override
    protected void playerInit(int player_num) {
        NUMBER_OF_PLAYERS = player_num;
        player1 = new Player(startingEstablishments, startingLandmarks, 3,1, false);
        player2 = new Player(startingEstablishments2, startingLandmarks1, 3,2, true);
        if(player_num == 3) {
            player3 = new Player(P2startingEst3, startingLandmarks2, 3,3, true);
        } else if (player_num == 4) {
            player3 = new Player(P2startingEst3, startingLandmarks2, 3,3, true);
            player4 = new Player(P4startingEst4, startingLandmarks3, 3, 4, true);
        }
        players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        if(player_num == 3) {
            players.add(player3);
        } else if (player_num == 4) {
            players.add(player3);
            players.add(player4);
        }
    }

    /**
     * Creates the Landmarks to be used by Players in Phase 3
     */

    @Override
    protected void landmarkInit() {
        NUMBER_OF_LANDMARKS = 3;

        startingLandmarks = new Landmark[3];
        startingLandmarks[0] = new Landmark("Train Station", 4, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  You may roll 1 or 2  |\n" +
                        "|         dice.         |\n");
        startingLandmarks[1] = new Landmark("Shopping Mall", 10, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|   Your {U} and {B}    |\n" +
                        "|  establishments earn  |\n" +
                                "|     +1 coin when      |\n" +
                                        "|      activated.       |\n");
        startingLandmarks[2] = new Landmark("Amusement Park", 16, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "| If you roll doubles,  |\n" +
                        "|   take another turn   |\n" +
                            "|    after this one.    |\n");

        startingLandmarks1 = new Landmark[3];
        startingLandmarks1[0] = new Landmark("Train Station", 4, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  You may roll 1 or 2  |\n" +
                        "|         dice.         |\n");
        startingLandmarks1[1] = new Landmark("Shopping Mall", 10, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|   Your {U} and {B}    |\n" +
                        "|  establishments earn  |\n" +
                                "|     +1 coin when      |\n" +
                                        "|      activated.       |\n");
        startingLandmarks1[2] = new Landmark("Amusement Park", 16, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "| If you roll doubles,  |\n" +
                        "|   take another turn   |\n" +
                            "|    after this one.    |\n");                                

        startingLandmarks2 = new Landmark[3];
        startingLandmarks2[0] = new Landmark("Train Station", 4, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  You may roll 1 or 2  |\n" +
                        "|         dice.         |\n");
        startingLandmarks2[1] = new Landmark("Shopping Mall", 10, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|   Your {U} and {B}    |\n" +
                        "|  establishments earn  |\n" +
                                "|     +1 coin when      |\n" +
                                        "|      activated.       |\n");
        startingLandmarks2[2] = new Landmark("Amusement Park", 16, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "| If you roll doubles,  |\n" +
                        "|   take another turn   |\n" +
                            "|    after this one.    |\n");

        startingLandmarks3 = new Landmark[3];
        startingLandmarks3[0] = new Landmark("Train Station", 4, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  You may roll 1 or 2  |\n" +
                        "|         dice.         |\n");
        startingLandmarks3[1] = new Landmark("Shopping Mall", 10, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|   Your {U} and {B}    |\n" +
                        "|  establishments earn  |\n" +
                                "|     +1 coin when      |\n" +
                                        "|      activated.       |\n");
        startingLandmarks3[2] = new Landmark("Amusement Park", 16, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "| If you roll doubles,  |\n" +
                        "|   take another turn   |\n" +
                            "|    after this one.    |\n");
    }

     /**
      * Initialize game to be played
      */

    @Override
    protected void gameInit() {
        startGame();
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
     * Check if all landmarks are constructed. If so, game ends
     */
    @Override
    protected void gameEnded() {
        if(!allLandmarksConstructed()) {
            endTurn();
        }
    }

    /**
     * Ends the current player's turn and checks to see if the game has ended
     */
    @Override
    protected void endTurn() {
        if (!(getCurrentPlayer().isAmusementConstructed() && (dice1 == dice2))) {
            super.endTurn();
        }
    }

    /**
     * Starts the Phase 4 version of Machi Koro.
     * @param args a String array representing the user's console arguments.
     */

    public static void main(String[] args) {
        Feature6 feature6 = new Feature6(Integer.parseInt(args[1]));
        feature6.playGame();
    }

    /**
     * Gets the cafe Establishment.
     * @return the Establishment Cafe.
     */

    public Establishment getCafe() {
        return cafe;
    }

    /**
     * Gets the family restaurant Establishment.
     * @return the Establishment Family Restaurant.
     */

    public Establishment getFamilyRestaurant() {
        return familyRestaurant;
    }
}