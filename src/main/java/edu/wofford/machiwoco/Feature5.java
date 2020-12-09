package edu.wofford.machiwoco;

import org.apache.commons.lang3.StringUtils;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

/**
 * This is a class built to represent the Phase 3 version of Machi Koro.
 *
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */


public class Feature5 extends Feature4 {

    Establishment cheeseFactory;
    Establishment furnitureFactory;
    Establishment farmersMarket;

    /**
     * MachiWoco constructor representing the Phase 3 version of the game.
     * @param numPlayers an integer representing the number of Players.
     */

    public Feature5(int numPlayers) {
        super(2);
        NUMBER_OF_PLAYERS = numPlayers;
        
        cheeseFactory = new Establishment("Cheese Factory", 5, Card.Color.GREEN, Card.Color_ab.G, Card.Icon.FACTORY, Card.Icon_ab.F,
        "| Get 3 coins from the  |\n" +
                  "|   bank for each {C}   |\n" +
                  "|   establishment you   |\n" +
                  "|         own.          |\n" +
                  "|   (your turn only)    |\n",
        "7", "receive", "bank", 3, "icon", "cow");

        furnitureFactory = new Establishment("Furniture Factory", 3, Card.Color.GREEN, Card.Color_ab.G, Card.Icon.FACTORY,Card.Icon_ab.F,
                "| Get 3 coins from the  |\n" +
                          "|   bank for each {G}   |\n" +
                          "|   establishment you   |\n" +
                          "|         own.          |\n" +
                          "|   (your turn only)    |\n",
                "8", "receive", "bank", 3, "icon", "gear");

        farmersMarket = new Establishment("Farmers Market", 2, Card.Color.GREEN, Card.Color_ab.G, Card.Icon.FRUITO, Card.Icon_ab.O,
        "| Get 2 coins from the  |\n" +
                  "|   bank for each {W}   |\n" +
                  "|   establishment you   |\n" +
                  "|         own.          |\n" +
                  "|   (your turn only)    |\n",
        "11-12", "receive", "bank", 2, "icon", "wheat");


        market.put(getWheat(), 6);
        market.put(getRanch(),6);
        market.put(getForest(),6);
        market.put(getBakery(), 6);
        market.put(getConvenience(),6);
        market.put(getMine(),6);
        market.put(getOrchard(),6);
        market.put(cheeseFactory, 6);
        market.put(furnitureFactory, 6);
        market.put(farmersMarket, 6);

        sc = new Scanner(System.in);

        EST_ORDER.remove(getMine());
        EST_ORDER.remove(getOrchard());
        EST_ORDER.add(cheeseFactory);
        EST_ORDER.add(furnitureFactory);
        EST_ORDER.add(getMine());
        EST_ORDER.add(getOrchard());
        EST_ORDER.add(farmersMarket);

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
        }
        players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        if(player_num == 3) {
            players.add(player3);
        }
    }

    /**
     * Creates the Landmarks to be used by Players in Phase 3
     */

    @Override
    protected void landmarkInit() {
        NUMBER_OF_LANDMARKS = 3;

        startingLandmarks = new Landmark[3];
        startingLandmarks[1] = new Landmark("City Hall", 7, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  This is a city hall  |\n");
        startingLandmarks[0] = new Landmark("Train Station", 4, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  You may roll 1 or 2  |\n" +
                        "|         dice.         |\n");
        startingLandmarks[2] = new Landmark("Shopping Mall", 10, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|   Your {U} and {B}    |\n" +
                        "|  establishments earn  |\n" +
                                "|     +1 coin when      |\n" +
                                        "|      activated.       |\n");

        startingLandmarks1 = new Landmark[3];
        startingLandmarks1[1] = new Landmark("City Hall", 7, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  This is a city hall  |\n");
        startingLandmarks1[0] = new Landmark("Train Station", 4, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  You may roll 1 or 2  |\n" +
                        "|         dice.         |\n");
        startingLandmarks1[2] = new Landmark("Shopping Mall", 10, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|   Your {U} and {B}    |\n" +
                        "|  establishments earn  |\n" +
                                "|     +1 coin when      |\n" +
                                        "|      activated.       |\n");

        startingLandmarks2 = new Landmark[3];
        startingLandmarks2[1] = new Landmark("City Hall", 7, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  This is a city hall  |\n");
        startingLandmarks2[0] = new Landmark("Train Station", 4, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  You may roll 1 or 2  |\n" +
                        "|         dice.         |\n");
        startingLandmarks2[2] = new Landmark("Shopping Mall", 10, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|   Your {U} and {B}    |\n" +
                        "|  establishments earn  |\n" +
                                "|     +1 coin when      |\n" +
                                        "|      activated.       |\n");
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
     * Gets the Cheese Factory establishment.
     * @return the Establishment Cheese Factory.
     */

    public Establishment getCheeseFactory() {
        return cheeseFactory;    
    }

    /**
     * Gets the Furniture Factory establishment.
     * @return the Establishment Furniture Factory.
     */

    public Establishment getFurnitureFactory() {
        return furnitureFactory;    
    }

    /**
     * Gets the Farmers Market establishment.
     * @return the Establishment Farmers Market.
     */

    public Establishment getFarmersMarket() {
        return farmersMarket;    
    }

    /**
     * Starts the Phase 3 version of Machi Koro.
     * @param args a String array representing the user's console arguments.
     */

    public static void main(String[] args) {
        Feature5 feature5 = new Feature5(Integer.parseInt(args[1]));
        feature5.playGame();
    }
}