package edu.wofford.machiwoco;

import java.util.ArrayList;
import java.util.*;
import java.util.Random;

/**
 * This is a class built to represent the Phase 6 version of Machi Koro.
 *
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */


public class Feature8 extends Feature7 {

    Random rand;
    Map<Establishment,Integer> a;
    Map<Establishment,Integer> b;
    Map<Establishment,Integer> c;

    Stack<Establishment> DeckA;
    Stack<Establishment> DeckB;
    Stack<Establishment> DeckC;

    int uniqueA;
    int uniqueB;
    int uniqueC;




    /**
     * MachiWoco constructor representing the Phase 6 version of the game.
     * @param numPlayers an integer representing the number of Players.
     */

    public Feature8(int numPlayers) {
        super(2);
        //market/
        NUMBER_OF_PLAYERS = numPlayers;
        rand = new Random();

        DeckA = new Stack<>();
        DeckB = new Stack<>();
        DeckC = new Stack<>();

        a = new HashMap<>();
        b = new HashMap<>();
        c = new HashMap<>();

        a.put(getWheat(),6);
        a.put(getRanch(),6);
        a.put(getBakery(),6);
        a.put(getCafe(),6);
        a.put(getConvenience(),6);
        a.put(getForest(),6);

        b.put(getCheeseFactory(),6);
        b.put(getFurnitureFactory(),6);
        b.put(getMine(),6);
        b.put(getFamilyRestaurant(),6);
        b.put(getOrchard(),6);
        b.put(getFarmersMarket(),6);

        c.put(getBusiness(),numPlayers);
        c.put(getStadium(),numPlayers);
        c.put(getTvStation(),numPlayers);

        shuffleMaps(a,DeckA,36);
        shuffleMaps(b,DeckB,36);
        shuffleMaps(c,DeckC,c.size()*numPlayers);

        market.remove(wheat);
        market.remove(ranch);
        market.remove(cafe);
        market.remove(bakery);
        market.remove(convenience);
        market.remove(forest);
        market.remove(cheeseFactory);
        market.remove(furnitureFactory);
        market.remove(mine);
        market.remove(familyRestaurant);
        market.remove(orchard);
        market.remove(farmersMarket);
        market.remove(getBusiness());
        market.remove(getStadium());
        market.remove(getTvStation());



        setDeck(DeckA, 5, 0);
        setDeck(DeckB, 5, 0);
        setDeck(DeckC, 2, 0);
        uniqueA = 5;
        uniqueB = 5;
        uniqueC = 2;

        sc = new Scanner(System.in);

        // EST_ORDER
        EST_ORDER = new ArrayList<Establishment>();
        EST_ORDER.add(getWheat());
        EST_ORDER.add(getRanch());
        EST_ORDER.add(getBakery());
        EST_ORDER.add(getCafe());
        EST_ORDER.add(getConvenience());
        EST_ORDER.add(getForest());
        EST_ORDER.add(getStadium());
        EST_ORDER.add(getTvStation());
        EST_ORDER.add(getBusiness());
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
     * Populates the deck with shuffled maps
     * @param x the separates hashmaps (A, B, or C) to randomly pull establishments from
     * @param deckToPushTo deck to push the values from hashmap x into
     * @param totalCards total number of cards in the hashmap
     */
    protected void shuffleMaps(Map<Establishment, Integer> x, Stack<Establishment> deckToPushTo,int totalCards) {
        Random r = new Random();
        while(deckToPushTo.size() < totalCards){
            x.values().removeAll(Collections.singleton(0));
            List<Establishment> keysAsArray = new ArrayList<>(x.keySet());
            Establishment e = keysAsArray.get(r.nextInt(keysAsArray.size()));
            deckToPushTo.push(e);
//            System.out.println("MY NAME IS: " + e.getName() + "\n");
            if (x.get(e) > 0) {x.put(e, x.get(e)-1);}
            else {x.remove(e);}
        }
    }

    /**
     * Establishes the market in 5-5-2 format.
     * @param deck a stack representing one of the 3 decks that will be used in the creation of the market itself.
     * @param maxSize the size of the visible cards.
     * @param curSize an integer representing the current size of the deck.
     * @return an integer representing the number of unique cards in the deck.
     */
    protected int setDeck(Stack<Establishment> deck,int maxSize, int curSize) {
        int unique = curSize;
        while (unique !=maxSize && deck.size() > 0) {
            Establishment e = deck.pop();
            if (market.containsKey(e)) {
                market.put(e,market.get(e)+1);
            } else {
                unique++;
                market.put(e, 1);
            }
        }
        return unique;
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
     * Creates the Landmarks to be used by Players in Phase 6
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
     * Removes any Establishments that would appear in the market with a count of 0.
     */

    public void removeZeroesMarket() {
        for (Establishment e: market.keySet()) {
            if (market.get(e) == 0) {
                if (e.getName().equals("Bakery")) {
                    uniqueA--;
                } else if (e.getName().equals("Family Restaurant") || e.getName().equals("Farmers Market")) {
                    uniqueB--;
                } else if (Integer.parseInt(e.getActivation()) < 6) {
                    uniqueA--;
                } else if (Integer.parseInt(e.getActivation()) == 6) {
                    uniqueC--;
                } else if (Integer.parseInt(e.getActivation()) > 6) {
                    uniqueB--;
                }
            }
        }
        market.values().removeAll(Collections.singleton(0));
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
     * Starts the Phase 6 version of Machi Koro.
     * @param args a String array representing the user's console arguments.
     */

    public static void main(String[] args) {
        Feature8 feature8 = new Feature8(Integer.parseInt(args[1]));
//        feature8.player1.setCoinCount(50);
        feature8.playGame();
    }
}