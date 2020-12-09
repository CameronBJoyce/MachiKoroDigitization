package edu.wofford.machiwoco;

import java.util.ArrayList;
import java.util.*;
import java.util.Random;

/**
 * This is a class built to represent the Phase 5 version of Machi Koro.
 *
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */


public class Feature7 extends Feature6 {

    Establishment tvStation;
    Establishment businessComplex;
    Establishment stadium;
    Random rand;

    /**
     * MachiWoco constructor representing the Phase 5 version of the game.
     * @param numPlayers an integer representing the number of Players.
     */

    public Feature7(int numPlayers) {
        super(2);
        NUMBER_OF_PLAYERS = numPlayers;
        rand = new Random();
        
        // Establishments go here
        tvStation = new Establishment("TV Station",
                7, Card.Color.PURPLE, Card.Color_ab.P, Card.Icon.TOWER, Card.Icon_ab.T,
                "| Take 5 coins from an  |\n" +
                          "|       opponent.       |\n" +
                          "|   (your turn only)    |\n",
                "6", "receive", "choice", 5, "none", "none");
        
        stadium = new Establishment("Stadium",
                6, Card.Color.PURPLE, Card.Color_ab.P, Card.Icon.TOWER, Card.Icon_ab.T,
                "|   Take 2 coins from   |\n" +
                            "|    each opponent.     |\n" +
                            "|   (your turn only)    |\n",
                "6", "receive", "others", 2, "none", "none");

        businessComplex = new Establishment("Business Complex", 8, Card.Color.PURPLE, Card.Color_ab.P, Card.Icon.TOWER, Card.Icon_ab.T,
                "| Exchange one of your  |\n" +
                            "|       non-tower       |\n" +
                            "| establishments for 1  |\n" +
                            "|   an opponent owns.   |\n" +
                            "|   (your turn only)    |\n",
                "6", "exchange", "choice", 0, "none", "none");

        /*
        HashMap a = wheat, ranch, bakery, cafe , convenience, forest
        HashMap b = Cheese, Funiture, Mine, Family , Orchard, Farmer
        HashMap c = Stadium, TV, BusComplex

    Bennett
        Stack DeckA;
        while (a.size() != 0) {
            Get an random Establishment.
            Push it to DeckA
        }
        Same for DeckB and DeckC

    Eric
    *****Already randomlized*****
        DeckA
        DeckB
        DeckC
    *****************************
        market.put(   ) until market have 5 from A, 5 from B and 2 from C

        setDeck(DeckA, 5);
        setDeck(DeckB, 5);
        setDeck(DeckC, 2);

        


    Ivan
    Test and Documentation


        Establishment = random(a)
        while (DeckA.size < 6) {
            DeckA.push(Establishment)
            a.put(Establishment, a.get(Establishment) -1)
        }


        market.put(     );


         */


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
        market.put(getCafe(), 6);
        market.put(getFamilyRestaurant(), 6);
        market.put(tvStation, numPlayers);
        market.put(businessComplex, numPlayers);
        market.put(stadium, numPlayers);

        sc = new Scanner(System.in);

        // EST_ORDER
        EST_ORDER = new ArrayList<Establishment>();
        EST_ORDER.add(getWheat());
        EST_ORDER.add(getRanch());
        EST_ORDER.add(getBakery());
        EST_ORDER.add(getCafe());
        EST_ORDER.add(getConvenience());
        EST_ORDER.add(getForest());
        EST_ORDER.add(stadium);
        EST_ORDER.add(tvStation);
        EST_ORDER.add(businessComplex);
        EST_ORDER.add(getCheeseFactory());
        EST_ORDER.add(getFurnitureFactory());
        EST_ORDER.add(getMine());
        EST_ORDER.add(getFamilyRestaurant());
        EST_ORDER.add(getOrchard());
        EST_ORDER.add(getFarmersMarket());

        landmarkInit();
        playerInit(numPlayers);
    }

    /**
     * Builds the Players to take part in the Phase 5 version of Machi Koco.
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
     * Creates the Landmarks to be used by Players in Phase 5
     */

    @Override
    protected void landmarkInit() {
        NUMBER_OF_LANDMARKS = 4;

        startingLandmarks = new Landmark[4];
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
        startingLandmarks[3] = new Landmark("Radio Tower", 22, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                        "|  Once per turn, you   |\n" +
                                "| may reroll the dice.  |\n");

        startingLandmarks1 = new Landmark[4];
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
        startingLandmarks1[3] = new Landmark("Radio Tower", 22, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  Once per turn, you   |\n" +
                        "| may reroll the dice.  |\n");                        

        startingLandmarks2 = new Landmark[4];
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
        startingLandmarks2[3] = new Landmark("Radio Tower", 22, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  Once per turn, you   |\n" +
                        "| may reroll the dice.  |\n");  

        startingLandmarks3 = new Landmark[4];
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
        startingLandmarks3[3] = new Landmark("Radio Tower", 22, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  Once per turn, you   |\n" +
                        "| may reroll the dice.  |\n");  
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
     * Provides an ArrayList of Establishments available to be targeted by the Business Complex.
     * @param player the Player being targeted.
     * @return an ArrayList of Establishments available to be targeted.
     */

    public ArrayList<Establishment> availEstBusComplex(Player player) {
        ArrayList<Establishment> targetableEst = new ArrayList<>();
        for (Establishment est : EST_ORDER) {
            if (player.getEstOwned().containsKey(est)) {
                if ((est.getColor_ab() != Card.Color_ab.P) &&
                        !((est == getWheat() || est == getBakery()) && player.getEstOwned().get(est) == 1)) {
                    targetableEst.add(est);
                }
            }
        }
        return targetableEst;
    }

    /**
     * Provides an ArrayList of Players available to be targeted by the TV Station.
     * @param players an ArrayList of all current Players.
     * @return an ArrayList of Players available to be targeted.
     */

    public ArrayList<Player> availPlayersTV(ArrayList<Player> players) {
        ArrayList<Player> availPlayers = new ArrayList<>();
        for (Player p : players) {
            if (!p.isTurn() && p.getCoinCount() > 0) {
                availPlayers.add(p);
            }
        }
        return availPlayers;
    }

    /**
     * Provides an ArrayList of Players available to be targeted by the Business Complex.
     * @param players an ArrayList of all current Players.
     * @return an ArrayList of Players available to be targeted.
     */

    public ArrayList<Player> availPlayersBus(ArrayList<Player> players) {
        ArrayList<Player> availPlayers = new ArrayList<>();
        for (Player p : players) {
            if (!p.isTurn()) {
                int wheat_num = p.getEstOwned().get(wheat);
                int bakery_num = p.getEstOwned().get(bakery);
                int purpleCount = 0;
                for (Establishment e : p.getEstOwned().keySet()) {
                    if (e.getColor_ab().equals(Card.Color_ab.P)) {purpleCount++;}
                }
                if (!(wheat_num == 1 && bakery_num == 1 && p.getEstOwned().size() == 2+purpleCount)) {
                    availPlayers.add(p);
                }
            }
        }
        return availPlayers;
    }

    /**
     * Provides a Player for the AI to randomly target.
     * @param players an ArrayList of all current Players.
     * @return the Player to be targeted by the AI.
     */

    public Player aiPlayerChoice(ArrayList<Player> players) {
//  nextInt(upperbound) generates random numbers in the range 0 to upperbound-1
        return players.get(rand.nextInt(players.size()));
    }

    /**
     * Provides an Establishment for the AI to randomly target or select.
     * @param establishments an ArrayList of available Establishments
     * @return the Establishment to be targeted or selected by the AI.
     */

    public Establishment aiEstChoice(ArrayList<Establishment> establishments) {
        return establishments.get(rand.nextInt(establishments.size()));
    }

    /**
     * Conducts all logic associated with the activation of the TV Station establishment.
     */

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
                    playerToTarget = aiPlayerChoice(availPlayersTV(players));
                }
                activationListener.takeMoney(playerToTarget, getCurrentPlayer(), 5);
            } else {
                System.out.println("TV Station activated, but no player is available to target.");
            }
        }

    /**
     * Conducts all logic associated with the activation of the Business Complex establishment.
     */

    public void busComplexLogic() {
        Player playerToTarget;
        Establishment estToTake;
        Establishment estToGive;
        if (getCurrentPlayer().isAi()) {
            playerToTarget = aiPlayerChoice(availPlayersBus(players));
            estToTake = aiEstChoice(availEstBusComplex(playerToTarget));
            estToGive = aiEstChoice(availEstBusComplex(getCurrentPlayer()));
        } else {
            playerToTarget = consoleListener.playerChooseTarget(EST_ORDER, sc, getCurrentPlayer(), players, false);
            estToTake = consoleListener.playerChooseEst(sc, playerToTarget, availEstBusComplex(playerToTarget), getCurrentPlayer().getPlayerNumber());
            estToGive = consoleListener.playerChooseEst(sc, getCurrentPlayer(), availEstBusComplex(getCurrentPlayer()), getCurrentPlayer().getPlayerNumber());
        }
        activationListener.swap(playerToTarget, getCurrentPlayer(), estToTake, estToGive);
    }

    public boolean radioTowerLogic() {
        if (getCurrentPlayer().isAi()) {return rand.nextBoolean();}
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

//        if ((dice1 + dice2) == 6 && getCurrentPlayer().isBusinessCenterOwned()) {
//            Player playerToTarget = consoleListener.playerChooseTarget(sc, getCurrentPlayer(), players, false);
//            Establishment estToTake = consoleListener.playerChooseEst(sc, playerToTarget);
//            Establishment estToGive = consoleListener.playerChooseEst(sc, getCurrentPlayer());
//            activationListener.exchangeEst(playerToTarget, getCurrentPlayer(), estToTake, estToGive);
//        }
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
        }
    }

    /**
     * Returns stadium establishment.
     * @return stadium establishment.
     */
    protected Establishment getStadium() {
        return stadium;
    }

    /**
     * Returns tvStation establishment.
     * @return tvStation establishment.
     */
    protected Establishment getTvStation() {
        return tvStation;
    }

    /**
     * Returns businessComplex establishment.
     * @return buinessComplex establishment.
     */
    protected Establishment getBusiness() {
        return businessComplex;
    }


    /**
     * Starts the Phase 5 version of Machi Koro.
     * @param args a String array representing the user's console arguments.
     */

    public static void main(String[] args) {
        Feature7 feature7 = new Feature7(Integer.parseInt(args[1]));
//        feature7.getPlayer1().getEstOwned().put(feature7.businessComplex, 1);
//        feature7.getPlayer1().getEstOwned().put(feature7.tvStation, 1);
//        feature7.getPlayer1().getEstOwned().put(feature7.stadium, 1);
//        feature7.getPlayer1().getEstOwned().put(feature7.orchard, 2);
//        feature7.getPlayer1().getLandmarks()[3].is_constructed = true;
        feature7.playGame();
    }
}