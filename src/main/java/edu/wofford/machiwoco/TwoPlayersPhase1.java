package edu.wofford.machiwoco;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

/**
 * This is a class built to represent the Phase 1 version of Machi Koro.
 *
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */

public class TwoPlayersPhase1 {

    //**********DECLARATION************//

    protected Player player1;
    protected Player player2;
    //protected Player[] players;
    protected ArrayList<Player> players;
    Map<Establishment,Integer> market;
    Map<Establishment,Integer> startingEstablishments;
    Map<Establishment,Integer> startingEstablishments2;

    int NUMBER_OF_PLAYERS;

    int NUMBER_OF_LANDMARKS;

    Scanner sc;

    protected int dice1;
    protected int dice2;
    protected int diceSum;

    Establishment wheat;
    Establishment ranch;
    Establishment forest;
    ArrayList<Establishment> EST_ORDER;

    Landmark[] startingLandmarks;

    protected boolean buyFinished;

    protected GameStateSubject gameSubject;
    protected InputSubject inputSubject;

    private boolean ai;

    protected List<GameListener> listeners;
    protected ConsoleListener consoleListener;
    protected ActivationListener activationListener;


    //**********CONSTRUCTOR************//

    /**
     * MachiWoco constructor serving as the infrastructure of the Phase 1 version of the game.
     * @param ai a boolean holding true if the game will contain an AI player.
     * @param num an integer representing the number of players.
     */

    public TwoPlayersPhase1(boolean ai,int num) {

        this.ai = ai;

        consoleListener = new ConsoleListener();
        activationListener = new ActivationListener();

        listeners = new ArrayList<>();
        addListener(consoleListener);
        addListener(activationListener);


        //List of Establishments
        wheat = new Establishment("Wheat Field", 1, Card.Color.BLUE, Card.Color_ab.B, Card.Icon.WHEAT, Card.Icon_ab.W,
                "|  Get 1 coin from the  |\n" +
                        "|         bank.         |\n" +
                        "|    (anyone's turn)    |\n",
                "1", "receive", "bank", 1, "none", "none");

        //**********Establishment ranch creation************//
        ranch = new Establishment("Ranch", 1, Card.Color.BLUE, Card.Color_ab.B, Card.Icon.COW, Card.Icon_ab.C,
                "|  Get 1 coin from the  |\n" +
                        "|         bank.         |\n" +
                        "|    (anyone's turn)    |\n",
                "2", "receive", "bank", 1, "none", "none");


        forest = new Establishment("Forest", 3, Card.Color.BLUE, Card.Color_ab.B, Card.Icon.GEAR, Card.Icon_ab.G,
                "|  Get 1 coin from the  |\n" +
                        "|         bank.         |\n" +
                        "|    (anyone's turn)    |\n",
                "5", "receive", "bank", 1, "none", "none");

        //MARKET PLACE FOR ESTABLISHMENTS
        market = new HashMap<>();
        market.put(wheat, 6);
        market.put(ranch,6);
        market.put(forest,6);

        // Starting Establishments
        startingEstablishments = new HashMap<>();
        startingEstablishments2 = new HashMap<>();
        startingEstablishments.put(wheat,1);
        startingEstablishments2.put(wheat,1);

        // Scanner to read in data
        sc = new Scanner(System.in);

        //EST_ORDER = new Establishment[] {wheat, ranch, forest};
        EST_ORDER = new ArrayList<Establishment>();
        EST_ORDER.add(wheat);
        EST_ORDER.add(ranch);
        EST_ORDER.add(forest);

        landmarkInit();
        playerInit(ai,num);
    }

    /**
     * Adds listener
     * @param l the GameListener being added to the list of listeners
     */

    public void addListener(GameListener l) {
        listeners.add(l);
    }

    /**
     * Gets the current game state's listeners
     * @return current game state's listeners 
     */

    public List<GameListener> getListeners() {
        return listeners;
    }

    /**
     * Initializes the Landmark used in the Phase 1 version of the game.
     */

    protected void landmarkInit() {
        NUMBER_OF_LANDMARKS = 1;
        Landmark city = new Landmark("City Hall", 7, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  This is a city hall  |\n");
        startingLandmarks = new Landmark[1];
        startingLandmarks[0] = city;
    }

    /**
     * Creates either ai or human players
     * @param ai a boolean holding true if the player being created should be an AI
     * @param num an integer representing the number of players to be created
     */

    protected void playerInit(boolean ai,int num) {
        if (ai) {
            playerInitAI(num);
        } else {
            playerInitHuman(num);
        }
    }

    /**
     * Creates two human players.
     * @param num an integer representing the number of human Players.
     */

    protected void playerInitHuman(int num) {
        NUMBER_OF_PLAYERS = num;
        player1 = new Player(startingEstablishments, startingLandmarks, 3,1, false);
        player2 = new Player(startingEstablishments2, startingLandmarks, 3,2, false);
        //players = new Player[NUMBER_OF_PLAYERS];
        players = new ArrayList<Player>();
        //players[0] = player1;
        //players[1] = player2;
        players.add(player1);
        players.add(player2);
    }

    /**
     * Creates one human and one AI player.
     * @param num an integer representing the number of AI players.
     */

    protected void playerInitAI(int num) {
        NUMBER_OF_PLAYERS = num;
        player1 = new Player(startingEstablishments, startingLandmarks, 3,1, false);
        player2 = new Player(startingEstablishments2, startingLandmarks, 3,2, true);
        //players = new Player[NUMBER_OF_PLAYERS];
        //players[0] = player1;
        //players[1] = player2;
        players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
    }

    /**
     * Returns an ArrayList of Landmarks that the Player can afford
     * @param player the player who's coin count is being checked
     * @return a Landmark ArrayList containing available and affordable Landmark cards
     */
    public ArrayList<Landmark> getAffordableLandmarks(Player player) {
        // cycle through the Landmarks... if player's coin count is >= cost of Landmark, add Landmark to array
        Landmark[] landmarkArr = player.getLandmarks();
        ArrayList<Landmark> resultArr = new ArrayList<Landmark>();
        for (Landmark landmark : landmarkArr) {
            if (player.getCoinCount() >= landmark.getCost() && !landmark.is_constructed) {
                resultArr.add(landmark);
            }
        }

        // sort the arrayList
        Collections.sort(resultArr, new SortByCost());

        return resultArr;
    }

    //**********FUNCTIONS FOR ToSTRING()************//

    /**
     * Generates padding for the toString() of the class
     * @param s the string to which padding is being added
     * @return the final padded string
     */
    protected String generate_pure_padding(String s) {
        return StringUtils.center("", 42, s) + "\n";
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

    protected String generateStaticMarket() {
        return generate_pure_padding("*") +
                generate_title("MARKET") +
                generate_pure_padding("-");
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

    public String generateActivation(String s) {
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
     * Generates the market to be displayed to the player
     * @return a string representing the current market
     */

    protected  String generateMarket() {
        StringBuilder s = new StringBuilder();
        for (Establishment e : EST_ORDER) {
            s.append(generateSingleMarketItem(e, market.get(e)));
        }
//        System.out.print(s);
        return generateStaticMarket() + s + "\n";
    }

    /**
     * Generates the player's coin count to be displayed
     * @param p the player who's coin count is being displayed
     * @return a string displaying the given player's coin count
     */

    protected String generatePlayerCoin(Player p) {
        String account = "(" + p.getCoinCount() + " coins)";
        return StringUtils.center(account, 42, " ") + "\n";
    }

    /**
     * Generates a string dispaying the current player
     * @param p the player being observed
     * @param num the player's number
     * @param active a boolean that holds true if the given player is active
     * @return a string displaying the current player
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
     * Generates a string displaying the given player's current Establishments
     * @param p the player who's establishments are being displayed
     * @return a string displaying the player's current Establishments
     */

    protected String generatePlayerEst(Player p) {
        Map<Establishment,Integer> estOwned = p.getEstOwned();
        StringBuilder s = new StringBuilder();
        for (Establishment e : EST_ORDER) {
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
     * Generates a string displaying the given player's current Landmark(s)
     * @param p the player who's landmark(s) are being displayed
     * @return a StringBuilder object displaying the player's current Landmark(s)
     */

    protected StringBuilder generatePlayerLandMark(Player p) {
        StringBuilder s = new StringBuilder();
        for (Landmark l : p.getLandmarks()) {
            s.append(generateLandmark(l));
        }
        return s;
    }

    /**
     * Generates a string displaying information about a given player
     * @param p the player to be displayed
     * @param num the given player's number
     * @param active a boolean that holds true if the given player is active
     * @return a string displaying the given player's coins, establishments, and landmarks
     */

    protected String generatePlayer(Player p, int num, boolean active) {
        return generatePlayerLine(p, num, active) +
                generate_pure_padding("-") +
                generatePlayerCoin(p) +
                generatePlayerEst(p) +
                generate_pure_padding(".") +
                generatePlayerLandMark(p) + "\n";
    }

    //**********GAME STEP 1: START GAME************//

    /**
     * Prints a message to the console indicating the start of the game
     */

    protected void startGame() { System.out.println( "The game has started. Player 1 will go first."); }

    //**********GAME STEP 2: PRINT TURN************//

    /**
     * Prints a message to the console indicating the current player's turn
     */

    protected void printTurn() {
        for(int i = 0; i < NUMBER_OF_PLAYERS; i++) {
            //if(players[i].isTurn()) {
            if(players.get(i).isTurn()) {
                System.out.println("Turn started for Player " + (i + 1) + ".");
            }
        }
    }

    //**********GAME STEP 3: CURRENT GAME STATE************//

    /**
     * Generates a string representing the current game state
     * @return a string displaying the current game state
     */

    protected String getCurrentGameState() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            s.append(generatePlayer(players.get(i), i + 1, players.get(i).isTurn()));
        }
        return generateMarket() + s + StringUtils.center("", 42, "*");
    }




    //**********GAME STEP 4: ROLL THE DICE************//

    /**
     * Returns a dice roll value
     * @return an integer representing a dice roll value
     */

    protected int roll() {
        dice1 = (int) (Math.random() * 6 + 1);
        dice2 = 0;
        diceSum = dice1 +dice2;
        return diceSum;
    }

    /**
     * Finds which player's turn it is and provides their player number
     * @return the current player's number
     */

    protected int getTurn() {
        for(int i = 0; i < NUMBER_OF_PLAYERS; i++) {
            if(players.get(i).isTurn()) {
                return i + 1;
            }
        }
        return 0;
    }
    //**********GAME STEP 5: Activation************//

    /**
     * Passes in the dice to the Player function
     */

    protected void activationTest() {
        for(int i = 0; i < NUMBER_OF_PLAYERS; i++) {
            players.get(i).getActivationNumbers(diceSum,players.get(i).isTurn());
        }
    }

    /**
     * The logic involved with buying Establishment cards
     * @return an ArrayList of Establishments that are available to purchase
     */

    protected ArrayList<Establishment> buyEstablishmentLogic() {
        int amountOwned = getCurrentPlayer().getCoinCount();
        ArrayList<Establishment> e = getAffordableEstablishments(getCurrentPlayer(),amountOwned);
        return e;
    }

    /**
     * Provides a list of affordable establishments available to a given player
     * @param player the player who's affordable establishments are being presented
     * @param owned the amount of coins owned by the given player
     * @return an ArrayList of Establishments that are available to purhcase by a given player
     */
    public ArrayList<Establishment> getAffordableEstablishments(Player player, int owned) {
        ArrayList<Establishment> eResult = new ArrayList<Establishment>();
        for(Establishment est: EST_ORDER) {
            if (market.containsKey(est)) {
                int cost = est.getCost();
                int numberLeft = market.get(est);
                if (owned >= cost && numberLeft != 0) {
                    if (!est.getColor_ab().equals(Card.Color_ab.P)) {
                        eResult.add(est);
                    } else {
                        if (est.getName().equals("Stadium") && !player.isStadiumOwned()) {
                            eResult.add(est);
                        } else if (est.getName().equals("Business Center") && !player.isBusinessComplexOwned()) {
                            eResult.add(est);
                        } else if (est.getName().equals("TV Station") && !player.isTVStationOwned(player.getEstOwned())) {
                            eResult.add(est);
                        }
                    }

                }
            }
        }
        return eResult;
    }

    //**********GAME STEP 5.5: PURCHASE AND CONSTRUCT************//

    /**
     * Receives buy/construct input and calls buyCard() to buy Establishment
     * or buyLandmark() to construct Landmark
     * @param index the index of the Establishment/Landmark/Escape Key
     * @return boolean as to whether the buy input was valid
     */
    protected boolean getBuyInput(int index) {
        ArrayList<Establishment> listOfEstablishments = getAffordableEstablishments(getCurrentPlayer(), getCurrentPlayer().getCoinCount());
        ArrayList<Landmark> listOfLandmarks = getAffordableLandmarks(getCurrentPlayer());
        int numberOfLandmarks = listOfLandmarks.size();
        int numberOfEstablishments = listOfEstablishments.size();
        if(index == 99) {
            System.out.println("Player "  + getTurn() + " chose not to make improvements.");
            return true;
        } else if(index <= numberOfEstablishments && index > 0) {
            Establishment e = listOfEstablishments.get(index-1);
            getCurrentPlayer().buyCard(e);
            int numberLeft = market.get(e) - 1;
            market.put(e,numberLeft);

            System.out.println("Player "  + getTurn() + " purchased the " + e.getName() + ".");
            return true;
        } else if(index <= numberOfEstablishments + numberOfLandmarks && index > 0) {
            Landmark l = listOfLandmarks.get(index-numberOfEstablishments-1);
            getCurrentPlayer().buyLandmark(l);
            System.out.println("Player "  + getTurn() + " constructed the " +l.getName() + ".");
            return true;
        } else {
            return false;
        }
    }



    /**
     * Constructs the static portion of the menu to be displayed
     * @param s the string representing the static portion of the menu
     * @return the static portion of the menu to be displayed
     */

    protected String getMenuStatic(String s) {
        String name = StringUtils.center("", 9, "-") +
                StringUtils.center(s, 24, " ") + StringUtils.center("", 9, "-");
        return name + "\n";
    }

    /**
     * Constructs the available landmarks in string format
     * @param i the index to where the landmark is going to be placed
     * @return the string that displays the available landmarks
     */

    protected String getAvailLandmark(int i) {
        ArrayList<Landmark> l = getAffordableLandmarks(getCurrentPlayer());
        StringBuilder s = new StringBuilder();
        int count = i;
        if (l.size() != 0) {
            for (Landmark land : l) {
                String order = count + ".";
                s.append(StringUtils.leftPad(order, 3, " ")).append(" ").append(generateLandmark(land));
                count++;
            }
            return getMenuStatic("CONSTRUCT") + s;
        }
        return "";
    }

    /**
     * Constructs the available establishments in string format
     * @param i the index to where the establishment is going to be placed
     * @return the string that displays the available establishments
     */

    protected String getAvailEst(int i) {
        ArrayList<Establishment> e = buyEstablishmentLogic();

        StringBuilder s = new StringBuilder();
        int count = i;
        if (e.size() != 0) {
            for (Establishment est : e) {
                String order = count + ".";
                s.append(StringUtils.leftPad(order, 3, " ")).append(" ").append(generateSingleMarketItem(est, market.get(est)));
                count ++;
            }
            return getMenuStatic("PURCHASE") + s;
        }

        return "";
    }

    /**
     * Gets the menu to display in String format
     * @return the game menu in string format
     */

    protected String getMenu() {
        int count = 1;
        String s = generate_pure_padding("=") + getAvailEst(count);
        count = buyEstablishmentLogic().size() + 1;
        return s + getAvailLandmark(count) +
                getMenuStatic("CANCEL") +
                "99. " + StringUtils.rightPad("Do nothing", (42-4), " ") + "\n" +
                StringUtils.center("", 42, "=");
    }



    /**
     * Gets the current player
     * @return the current Player's instance
     */

    public Player getCurrentPlayer() {
        for(int i = 0; i < NUMBER_OF_PLAYERS; i++) {
            if(players.get(i).isTurn()) {
                return players.get(i);
            }
        }
        return null;
    }



    //**********GAME STEP 6: END TURN************//

    /**
     * Ends the current player's turn and checks to see if the game has ended
     */

    protected void endTurn() {
        int curPlayerIndex = getTurn() - 1;
        System.out.println("Turn ended for Player " + getTurn() +".");
        if(curPlayerIndex == NUMBER_OF_PLAYERS-1) {
            players.get(0).setTurn(true);
            players.get(curPlayerIndex).setTurn(false);
        } else {
            players.get(curPlayerIndex).setTurn(false);
            players.get(curPlayerIndex+1).setTurn(true);
        }

    }

    /**
     * Checks to see if the game is over
     * @return a boolean holding true if the game is over
     */

    protected boolean isGameOver() {
        if(allLandmarksConstructed()) {
            System.out.println("The game is over. Player " + getTurn() + " is the winner.");
            return true;
        }
        return false;
    }

    /**
     * Checks to see if all Landmarks have been constructed
     * @return a boolean holding true if all landmarks have been constructed
     */

    protected boolean allLandmarksConstructed() {
        Landmark[] l;
        for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
            int count = 0;

            l = players.get(i).getLandmarks();
            for(int j = 0; j < NUMBER_OF_LANDMARKS; j++) {
                if(l[j].is_constructed) {
                    count++;
                }
            }

            if(count==NUMBER_OF_LANDMARKS) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if the given string is numeric
     * @param string the string being checked
     * @return a boolean holding true if the given string is numeric
     */

    protected static boolean isNumeric(String string) {
        if(string.length() == 0 ) { return false;}
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    /**
     * Checks to see if all Landmarks have been constructed
     * @param input is the string input from the user.
     * @return a boolean as to whether the turn has been completed
     */
    protected boolean handleInput(String input) {
        ArrayList<Establishment> listOfEstablishments = getAffordableEstablishments(getCurrentPlayer(), getCurrentPlayer().getCoinCount());
        ArrayList<Landmark> listOfLandmarks = getAffordableLandmarks(getCurrentPlayer());
        Establishment e;
        Landmark l;
        int numberOfLandmarks = listOfLandmarks.size();
        int numberOfEstablishments = listOfEstablishments.size();

        if(isNumeric(input.trim())) {
            return getBuyInput(Integer.parseInt(input));
        } else if(input.substring(0,4).toLowerCase().trim().equals("view")) {
            input = input.replaceAll("\\D+","");
            int index = Integer.parseInt(input);
            if(index <= numberOfEstablishments) {
                e = listOfEstablishments.get(index-1);
                System.out.println(e.toString());
                return false;
            } else if (index <= numberOfEstablishments + numberOfLandmarks && index > 0) {
                l = listOfLandmarks.get(index-numberOfEstablishments-1);
                System.out.println(l.toString());
                return false;
            }
            return false;
        } else {
            return false;
        }
    }

    /**
     * Check to see if the player can afford an available card
     * @param player the Player who can or cannot afford a card
     * @return a boolean holding true if the player can afford a card
     */

    protected boolean canAffordCard(Player player) {
        for (Establishment e : EST_ORDER) {
            int cost = e.getCost();
            if (player.getCoinCount() >= cost) {
                return true;
            }
        }
        return false;
    }

    /**
     * Initialize game to be played
     */

    protected void gameInit() {
        startGame();
        players.get(0).setTurn(true);

//        observer pattern
        gameSubject = new GameStateSubject(EST_ORDER, getPlayers(), getMarket());
        inputSubject = new InputSubject(getCurrentPlayer(),getPlayers(), "x");

//      subscribe to subjects
        new GameStateObserver(gameSubject);
        new InputObserver(inputSubject);
    }

    /**
     * AI Logic for making a move
     */
    protected void aiLogic() {
        System.out.println(getMenu());
        int estSize = buyEstablishmentLogic().size();
        int lmkSize = getAffordableLandmarks(getCurrentPlayer()).size();
        // add last option of "99. Do Nothing" to AI
        int ai_choices = estSize + lmkSize + 1;
        int ai_input = (int) (Math.random() * ai_choices + 1);
        if (ai_input == ai_choices) {
            ai_input = 99;
        }
        handleInput(Integer.toString(ai_input));
    }

    /**
     * Human Input makes moves for human
     */
    private void humanInput() {
        // human player input
        if(canAffordCard(getCurrentPlayer())) {
            String s = "Player " + getTurn() + " would you like to purchase an \n" + "establishment or construct a landmark?" + " (" + getCurrentPlayer().getCoinCount() +
                    "\n" + "coins) \n" + "(To view details of an item, type 'view'  \n" +
                    "followed by the item number. For example, \n" +
                    "to view item 6, type 'view 6'.)           ";

            System.out.println(s);
            System.out.println(getMenu());

            while (!buyFinished) {
                System.out.println(StringUtils.center("Choose a number to purchase or construct: ", 42, " "));
                String input = sc.nextLine();

                buyFinished = handleInput(input);
            }
        } else {
            System.out.println("Player " + getTurn() + "did not have enough money to make \n" +
                    "improvements.");
        }
    }

    /**
     * Driver for making the move
     */
    public void makeMove() {
        buyFinished = false;
//            Random AI Action
        if (getCurrentPlayer().isAi()) {
            aiLogic();
        } else {
//            human input
            humanInput();
        }
    }

    /**
     * Check if all landmarks are constructed. If so, game ends
     */

    protected void gameEnded() {
        if(!allLandmarksConstructed()) {
            endTurn();
        }
    }

    /**
     * Retreives the dice roll and its corresponding activations.
     */

    protected void actionsDiceRolled() {
        for (GameListener l : listeners) {
            l.diceRolled(dice1, dice2, getCurrentPlayer());
            l.diceActivation((dice1 + dice2), players);
        }
    }

    /**
     * Rolls the die.
     * @param rollTwo a boolean holding true if the Player chooses to roll two die.
     */

    protected void betterRollDice(boolean rollTwo) {
        dice1 = (int) (Math.random() * 6 + 1);
        if (rollTwo) {
            dice2 = (int) (Math.random() * 6 + 1);
        } else{
            dice2 = 0;
        }
    }

    /**
     * Performs the dice roll and checks for any actions associated with the roll.
     * @param rollTwo a boolean holding true if the Player chooses to roll two die.
     */

    protected void wayBetterRollDice(boolean rollTwo) {
        betterRollDice(rollTwo);
        actionsDiceRolled();
    }



    //PASSES IN DICE ROLL AND PLAYERS
    // RETURNS ARRAYLIST OF PLAYERS PLAYER NUMS
//    protected P playersActivated() {
//        if(!allLandmarksConstructed()) {
//            endTurn();
//        }
//    }


    /**
     * Play the MachiWoCo game in its entirety
     */

    public void playGame() {
        gameInit();

        while (!isGameOver()) {

            // (1) print turn and (2) print current game state
            gameSubject.notifyObservers();

            // (3) ROLL THE DICE AND THE CORRESPONDING ACTIVATIONS
            wayBetterRollDice(false);

            // (4) either human or ai player make moves
            makeMove();

            // (5) check if Game has ended
            gameEnded();
        }
    }


    //**********GETTERS AND SETTERS************//

    /**
     * Gets player 1
     * @return player1's instance
     */

    public Player getPlayer1() {
        return player1;
    }

    /**
     * Sets the given player to be player1
     * @param player1 the given player to be set to player1
     */

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    /**
     * Gets player 2
     * @return player2's instance
     */

    public Player getPlayer2() {
        return player2;
    }

    /**
     * Sets the given player to be player2
     * @param player2 the given player to be set to player2
     */

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    /**
     * Gets the full list of available players
     * @return an array of Players to take part in the game
     */

    //public Player[] getPlayers() {
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Sets the players to partake in the game
     * @param players an array of Players to take part in the game
     */

    //public void setPlayers(Player[] players) {
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Gets the wheat establishment
     * @return the wheat establishment
     */

    public Establishment getWheat() {
        return wheat;
    }

    /**
     * Sets the given Establishment to represent the wheat establishment
     * @param wheat the Establishment to represent the wheat establishment
     */

    public void setWheat(Establishment wheat) {
        this.wheat = wheat;
    }

    /**
     * Gets the ranch establishment
     * @return the ranch establishment
     */

    public Establishment getRanch() {
        return ranch;
    }

    /**
     * Gets the current market
     * @return the current market as a Map object
     */

    public Map<Establishment, Integer> getMarket() {
        return market;
    }

    /**
     * Sets the market
     * @param market a Map object to represent the current market
     */

    public void setMarket(Map<Establishment, Integer> market) {
        this.market = market;
    }

    /**
     * Sets the given Establishment to represent the ranch establishment
     * @param ranch the Establishment to represent the ranch establishment
     */

    public void setRanch(Establishment ranch) {
        this.ranch = ranch;
    }

    /**
     * Gets the forest establishment
     * @return the forest establishment
     */

    public Establishment getForest() {
        return forest;
    }

    /**
     * Sets the given Establishment to represent the forest establishment
     * @param forest the Establishment to represent the forest establishment
     */

    public void setForest(Establishment forest) {
        this.forest = forest;
    }


    /**
     * Initializes the playing of the Phase1 version of Machi Koro based on human/human Players or human/AI.
     * @param args a String array representing the user's console arguments.
     * @param i an integer representing the number of players.
     */

    public static void main(String[] args, int i) {
        boolean ai_mode = false;
        if (args.length > 1 && args[1].equals("--ai")) {
            ai_mode = true;
        }
        TwoPlayersPhase1 f2 = new TwoPlayersPhase1(ai_mode,2);
        f2.playGame();

    }

}