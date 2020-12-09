package gradle.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.greaterThan;


import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;


public class FeatureSteps {

    private static boolean DEBUG = false;


    //***********************************************************************************************

    private static List<String> expectedProperties;

    public static class Player {
        public Map<String, Integer> properties;
        public int number;
        public int coins;
        public boolean tvStationActivated;
        public boolean businessComplexActivated;
        public Player(int number) {
            this.number = number;
            properties = new HashMap<>();
            coins = 0;
            tvStationActivated = false;
            businessComplexActivated = false;
        }
        public Player(Player p) {
            number = p.number;
            coins = p.coins;
            tvStationActivated = p.tvStationActivated;
            businessComplexActivated = p.businessComplexActivated;
            properties = new HashMap<>(p.properties);
        }

        public boolean owns(String property) {
            return properties.containsKey(property);
        }

        public int copies(String property) {
            if (properties.containsKey(property)) {
                return properties.get(property);
            }
            return 0;
        }

        public int icons(String icon) {
            int total = 0;
            for (String key : properties.keySet()) {
                if (icon.equals("wheat")) {
                    if (key.equals("Wheat Field") || key.equals("Apple Orchard")) {
                        total += properties.get(key);
                    }
                } else if (icon.equals("cow")) {
                    if (key.equals("Ranch")) {
                        total += properties.get(key);
                    }
                } else if (icon.equals("gear")) {
                    if (key.equals("Forest") || key.equals("Mine")) {
                        total += properties.get(key);
                    }
                }
            }
            return total;
        }

        public void add(String property) {
            if (properties.containsKey(property)) {
                properties.put(property, properties.get(property) + 1);
            } else {
                properties.put(property, 1);
            }
        }

        @Override
        public String toString() {
            String s = "PLAYER " + number + "  (" + coins + "):\n";
            for (String prop : properties.keySet()) {
                s += prop + " #" + properties.get(prop) + "\n";
            }
            return s.trim();
        }
    }

    public static class State {
        public List<Player> players;
        public Map<String, Integer> market;

        public State() {
            players = new ArrayList<>();
            market = new LinkedHashMap<>();
        }

        public Map<String, Integer> getMarket() {
            return new LinkedHashMap<>(market);
        }

        @Override
        public String toString() {
            String s = "MARKET:\n";
            for (String key : market.keySet()) {
                s += key + " (" + market.get(key) + ")\n";
            }
            for (Player p : players) {
                s += p.toString() + "\n";
            }
            return s;
        }
    }

    public static class Result {
        public enum Type { SUCCESS, FAILURE };
        public Type type;
        public String info;
        public Result() {
            this(Type.SUCCESS, "");
        }
        public Result(String info) {
            this(Type.FAILURE, info);
        }
        public Result(Type type, String info) {
            this.type = type;
            this.info = info;
        }
    }

    public static <K, V> String mapToString(Map<K, V> map) {
        String s = "";
        Map<K, V> copy = new java.util.TreeMap<>(map);
        for (K key : copy.keySet()) {
            s += key + "=" + copy.get(key) + ",";
        }
        return "{" + s + "}";
    }

    public static void activate(List<Player> players, int playerNumber, int roll) {
        for (Player p : players) {
            p.tvStationActivated = false;
            p.businessComplexActivated = false;
        }
        Player active = players.get(playerNumber - 1);
        int smBonus = (active.owns("Shopping Mall"))? 1 : 0;
        if (roll == 1) {
            for (Player p : players) {
                p.coins += p.copies("Wheat Field");
            }
        } else if (roll == 2) {
            for (Player p : players) {
                p.coins += p.copies("Ranch");
            }
            active.coins += (1 + smBonus) * active.copies("Bakery");
        } else if (roll == 3) {
            int index = playerNumber - 1;
            int count = 1;
            while (count < players.size()) {
                count++;
                index = (index - 1 < 0)? players.size() - 1 : index - 1;
                if (players.get(index).owns("Cafe")) {
                    int mod = (players.get(index).owns("Shopping Mall"))? 1 : 0;
                    int owed = (mod + 1) * players.get(index).copies("Cafe");
                    int paid = (active.coins >= owed)? owed : active.coins;
                    active.coins -= paid;
                    players.get(index).coins += paid;
                }
            }
            active.coins += (1 + smBonus) * active.copies("Bakery");
        } else if (roll == 4) {
            active.coins += (3 + smBonus) * active.copies("Convenience Store");
        } else if (roll == 5) {
            for (Player p : players) {
                p.coins += p.copies("Forest");
            }
        } else if (roll == 6) {
            if (active.owns("Stadium")) {
                for (int i = 0; i < players.size(); i++) {
                    if (i != playerNumber - 1) {
                        int paid = (players.get(i).coins >= 2)? 2 : players.get(i).coins;
                        players.get(i).coins -= paid;
                        active.coins += paid;
                    }
                }
            }
            if (active.owns("TV Station")) {
                active.tvStationActivated = true;
            }
            if (active.owns("Business Complex")) {
                active.businessComplexActivated = true;
            }
        } else if (roll == 7) {
            active.coins += 3 * active.copies("Cheese Factory") * active.icons("cow");
        } else if (roll == 8) {
            active.coins += 3 * active.copies("Furniture Factory") * active.icons("gear");
        } else if (roll == 9) {
            int index = playerNumber - 1;
            int count = 1;
            while (count < players.size()) {
                count++;
                index = (index - 1 < 0)? players.size() - 1 : index - 1;
                if (players.get(index).owns("Family Restaurant")) {
                    int mod = (players.get(index).owns("Shopping Mall"))? 1 : 0;
                    int owed = (mod + 2) * players.get(index).copies("Family Restaurant");
                    int paid = (active.coins >= owed)? owed : active.coins;
                    active.coins -= paid;
                    players.get(index).coins += paid;
                }
            }
            for (Player p : players) {
                p.coins += 5 * p.copies("Mine");
            }
        } else if (roll == 10) {
            int index = playerNumber - 1;
            int count = 1;
            while (count < players.size()) {
                count++;
                index = (index - 1 < 0)? players.size() - 1 : index - 1;
                if (players.get(index).owns("Family Restaurant")) {
                    int mod = (players.get(index).owns("Shopping Mall"))? 1 : 0;
                    int owed = (mod + 2) * players.get(index).copies("Family Restaurant");
                    int paid = (active.coins >= owed)? owed : active.coins;
                    active.coins -= paid;
                    players.get(index).coins += paid;
                }
            }
            for (Player p : players) {
                p.coins += 3 * p.copies("Apple Orchard");
            }
        } else if (roll == 11) {
            active.coins += 2 * active.copies("Farmers Market") * active.icons("wheat");
        } else if (roll == 12) {
            active.coins += 2 * active.copies("Farmers Market") * active.icons("wheat");
        }
    }

    public static Set<Integer> wasTvStationActivated(List<Player> players, State state) {
        boolean tv = false;
        int diffAmt = 0;
        Set<Integer> index = new HashSet<>();
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).tvStationActivated) {
                tv = true;
                index.add(i);
            }
            if (players.get(i).coins != state.players.get(i).coins) {
                diffAmt += (state.players.get(i).coins - players.get(i).coins);
                index.add(i);
            }
        }
        if (tv && index.size() == 2) {
            return index;
        } else {
            return new HashSet<>();
        }
    }

    public static Set<Integer> wasBusinessComplexActivated(List<Player> players, State state) {
        int activator = -1;
        Map<Integer, Map<String, Integer>> differences = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).businessComplexActivated) {
                activator = i;
            }
            if (!players.get(i).properties.equals(state.players.get(i).properties)) {
                Set<String> allProps = new HashSet<>(state.players.get(i).properties.keySet());
                allProps.addAll(players.get(i).properties.keySet());
                for (String prop : allProps) {
                    int n = (players.get(i).properties.containsKey(prop))? players.get(i).properties.get(prop) : 0;
                    int m = (state.players.get(i).properties.containsKey(prop))? state.players.get(i).properties.get(prop) : 0;
                    int diff = n - m;
                    if (diff != 0) {
                        if (!differences.containsKey(i)) {
                            differences.put(i, new HashMap<>());
                        }
                        differences.get(i).put(prop, diff);
                    }
                }
            }
        }

        if (activator >= 0 && differences.keySet().size() == 2) {
            Set<String> lost = new HashSet<>();
            Set<String> gained = new HashSet<>();
            for (Integer key : differences.keySet()) {
                if (differences.get(key).size() != 1 && differences.get(key).size() != 2) {
                    return new HashSet<>();
                }
                for (String innerKey : differences.get(key).keySet()) {
                    if (differences.get(key).get(innerKey) < 0) {
                        lost.add(innerKey);
                    } else if (differences.get(key).get(innerKey) > 0) {
                        gained.add(innerKey);
                    }
                }
            }
            if (!lost.equals(gained)) {
                return new HashSet<>();
            }
            return differences.keySet();
        } else {
            return new HashSet<>();
        }
    }

    public static Result evaluateGameLog(String log, int numPlayers, List<String> startingProperties, String marketType) {
        Map<String, Integer> prices = new HashMap<>();
        prices.put("Wheat Field", 1);
        prices.put("Ranch", 1);
        prices.put("Bakery", 1);
        prices.put("Cafe", 2);
        prices.put("Convenience Store", 2);
        prices.put("Forest", 3);
        prices.put("Stadium", 6);
        prices.put("TV Station", 7);
        prices.put("Business Complex", 8);
        prices.put("Cheese Factory", 5);
        prices.put("Furniture Factory", 3);
        prices.put("Mine", 6);
        prices.put("Family Restaurant", 3);
        prices.put("Apple Orchard", 3);
        prices.put("Farmers Market", 2);
        prices.put("City Hall", 7);
        prices.put("Train Station", 4);
        prices.put("Shopping Mall", 10);
        prices.put("Amusement Park", 16);
        prices.put("Radio Tower", 22);

        // Need to check for the properties in each phase.
        for (String pname : expectedProperties) {
            if (!log.contains(pname)) {
                return new Result("Missing Property Error: " + pname + " does not exist.");
            }
        }

        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player(i + 1));
            players.get(i).coins = 3;
            for (String p : startingProperties) {
                players.get(i).add(p);
            }
        }

        Map<String, Integer> market = null;

        final int NO_STATE = 0;
        final int GAME_STATE = 1;
        final int MENU_STATE = 2;
        int outputState = NO_STATE;
        String stateString = "";
        int currentPlayer = 0;
        int currentRoll = 0;
        List<Player> previousPlayers = new ArrayList<>();
        Scanner scanner = new Scanner(log);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (DEBUG) { System.out.println("####################     " + line); }
            if (outputState == GAME_STATE && line.contains("******************************************")) {
                outputState = NO_STATE;
                State state = parseState(stateString);
                market = state.getMarket();

                // Check to see if the market is ordered correctly.
                List<String> correctMarketOrder = Arrays.asList(
                        "Wheat Field",
                        "Ranch",
                        "Bakery",
                        "Cafe",
                        "Convenience Store",
                        "Forest",
                        "Stadium",
                        "TV Station",
                        "Business Complex",
                        "Cheese Factory",
                        "Furniture Factory",
                        "Mine",
                        "Family Restaurant",
                        "Apple Orchard",
                        "Farmers Market"
                );
                int currMarketIndex = -1;
                for (String key : market.keySet()) {
                    int newIndex = correctMarketOrder.indexOf(key);
                    if (newIndex > currMarketIndex) {
                        currMarketIndex = newIndex;
                    } else {
                        return new Result("Market Order Error: establishment " + key + " is out of activation order");
                    }
                }

                if (marketType.equals("standard")) {
                    List<String> loProps = Arrays.asList("Wheat Field", "Ranch", "Bakery", "Cafe", "Convenience Store", "Forest");
                    List<String> hiProps = Arrays.asList("Cheese Factory", "Furniture Factory", "Mine", "Family Restaurant", "Apple Orchard", "Farmers Market");
                    List<String> meProps = Arrays.asList("Stadium", "TV Station", "Business Complex");
                    int los = 0;
                    int his = 0;
                    int mes = 0;
                    for (String key : state.market.keySet()) {
                        if (loProps.contains(key)) los++;
                        else if (hiProps.contains(key)) his++;
                        else if (meProps.contains(key)) mes++;
                    }
                    if (los > 5) {
                        return new Result("Market Error: market has " + los + " low-activated establishments (max 5)");
                    }
                    if (his > 5) {
                        return new Result("Market Error: market has " + his + " high-activated establishments (max 5)");
                    }
                    if (mes > 2) {
                        return new Result("Market Error: market has " + mes + " major establishments (max 2)");
                    }
                } else {
                    for (String key : state.market.keySet()) {
                        if (market.get(key) != state.market.get(key)) {
                            return new Result("Market Error [" + key + "]: \nExpected " + mapToString(market) + "; Actual " + mapToString(state.market));
                        }
                    }
                }
                if (state.players.size() != players.size()) {
                    return new Result("Player Count Error: \nExpected " + players.size() + "; Actual " + state.players.size());
                }

                Set<Integer> index = wasTvStationActivated(players, state);
                for (int i = 0; i < players.size(); i++) {
                    if (players.get(i).coins != state.players.get(i).coins) {
                        if (index.contains(i)) {
                            players.get(i).coins = state.players.get(i).coins;
                        } else {
                            return new Result("Player [" + (i+1) + "] Coin Error: \nExpected " + players.get(i).coins + "; Actual " + state.players.get(i).coins);
                        }
                    }
                }
                index = wasBusinessComplexActivated(players, state);
                for (int i = 0; i < players.size(); i++) {
                    if (!players.get(i).properties.equals(state.players.get(i).properties)) {
                        if (index.contains(i)) {
                            players.get(i).properties = state.players.get(i).properties;
                        } else {
                            return new Result("Player [" + (i+1) + "] Property Error:\nExpected " + mapToString(players.get(i).properties) + "; Actual " + mapToString(state.players.get(i).properties));
                        }
                    }
                }
            } else if (outputState == MENU_STATE && line.contains("==========================================")) {
                outputState = NO_STATE;
                Map<String, String> opts = parseMarketOptions(stateString);

                List<String> correctPromptOrder = Arrays.asList(
                        "Wheat Field",
                        "Ranch",
                        "Bakery",
                        "Cafe",
                        "Convenience Store",
                        "Forest",
                        "Stadium",
                        "TV Station",
                        "Business Complex",
                        "Cheese Factory",
                        "Furniture Factory",
                        "Mine",
                        "Family Restaurant",
                        "Apple Orchard",
                        "Farmers Market",
                        "Train Station",
                        "City Hall",
                        "Shopping Mall",
                        "Amusement Park",
                        "Radio Tower",
                        "Do nothing"
                );
                int currPromptIndex = -1;
                for (String key : opts.keySet()) {
                    int newIndex = correctPromptOrder.indexOf(key);
                    if (newIndex > currPromptIndex) {
                        currPromptIndex = newIndex;
                    } else {
                        return new Result("Menu Order Error: menu item '" + key + "' is not in correct order");
                    }
                }

            } else if (outputState == NO_STATE && line.contains("******************************************")) {
                outputState = GAME_STATE;
                stateString = "";
            } else if (outputState == NO_STATE && line.contains("==========================================")) {
                outputState = MENU_STATE;
                stateString = "";
            } else if (outputState > NO_STATE) {
                stateString += line + "\n";
            } else {
                if (line.contains("Turn started for")) {
                    String tmp = line.substring(line.lastIndexOf(" ") + 1);
                    tmp = tmp.replace(".", "").trim();
                    currentPlayer = Integer.parseInt(tmp);
                } else if (line.contains("used a reroll")) {
                    players = previousPlayers;
                } else if (line.contains("rolled")) {
                    String tmp = line.substring(line.lastIndexOf("=") + 1);
                    tmp = tmp.replace(".", "").trim();
                    currentRoll = Integer.parseInt(tmp);
                    previousPlayers = new ArrayList<>();
                    for (Player p : players) {
                        previousPlayers.add(new Player(p));
                    }
                    activate(players, currentPlayer, currentRoll);
                } else if (line.contains("purchased the ") || line.contains("constructed the ")) {
                    String tmp = line.substring(line.lastIndexOf(" the ") + 5);
                    tmp = tmp.replace(".", "").trim();
                    players.get(currentPlayer - 1).add(tmp);
                    players.get(currentPlayer - 1).coins -= prices.get(tmp);
                    if (line.contains("purchased the ")) {
                        int old = market.get(tmp);
                        market.put(tmp, market.get(tmp) - 1);
                    }
                }
            }
        }
        return new Result();
    }


    public static Map<String, String> parseMarketOptions(String m) {
        Map<String, String> options = new LinkedHashMap<>();
        Scanner scanner = new Scanner(m);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.charAt(2) == '.') {
                String num = line.substring(0, 2).trim();
                String name = line.substring(4, 22).trim();
                options.put(name, num);
            }
        }
        return options;
    }


    public static State parseState(String s) {
        State state = new State();
        Scanner scanner = new Scanner(s);
        final int NONE = 0, MARKET = 1, PLAYER = 2;
        int section = NONE;
        int playerNum = 0;
        Player player = null;
        boolean landmarks = false;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("-----") || line.trim().length() == 0) {
                continue;
            }
            if (line.contains("MARKET")) {
                section = MARKET;
            } else if (line.contains("Player")) {
                section = PLAYER;
                if (playerNum > 0) {
                    state.players.add(player);
                }
                playerNum++;
                player = new Player(playerNum);
                landmarks = false;
            } else {
                if (section == MARKET) {
                    line = line.trim();
                    String name = line.substring(0, 18).trim();
                    int qty = Integer.parseInt(String.valueOf(line.charAt(line.length() - 1)));
                    state.market.put(name, qty);
                } else if (section == PLAYER) {
                    line = line.trim();
                    if (line.startsWith("(")) {
                        line = line.replace("(", "").replace(")", "").replace("coin", "").replace("s", "").trim();
                        player.coins = Integer.parseInt(line);
                    } else if (line.startsWith("......")) {
                        landmarks = true;
                    } else {
                        String name = line.substring(0, 18).trim();
                        if (landmarks && line.charAt(28) == 'X') {
                            player.properties.put(name, 1);
                        } else if (!landmarks) {
                            int qty = Integer.parseInt(String.valueOf(line.charAt(line.length() - 1)));
                            player.properties.put(name, qty);
                        }
                    }
                }
            }
        }
        state.players.add(player);
        return state;
    }

    //***********************************************************************************************




    private String programInput;
    private int numPlayers;
    private List<String> startingEstablishments;
    private String actualOutput;
    private boolean playerOneWins;


    private String playPhase0(Scanner output, PrintWriter input) {
        StringBuilder outputBuilder = new StringBuilder();
        while (output.hasNext()) {
            outputBuilder.append(output.nextLine() + "\n");
        }
        return outputBuilder.toString();
    }

    private String playPhase1(Scanner output, PrintWriter input, boolean withAi) {
        expectedProperties = Arrays.asList(
                "Wheat Field",
                "Ranch",
                "Forest",
                "City Hall"
        );
        startingEstablishments = Arrays.asList("Wheat Field");
        numPlayers = 2;
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player(i));
            for (String s : startingEstablishments) {
                players.get(i - 1).add(s);
            }
            players.get(i - 1).coins = 3;
        }

        StringBuilder outputBuilder = new StringBuilder();
        int playerNum = 0;
        boolean inMarket = false;
        String marketString = "";
        boolean guessLow = false;
        boolean guessHigh = false;
        while (output.hasNext()) {
            String line = output.nextLine();
            if (DEBUG) { System.out.println("::::::::::::::::::::     " + line); }
            if (line.contains("Choose a number to purchase or construct")) {

                Map<String, String> options = parseMarketOptions(marketString);
                if (!guessLow) {
                    input.println("0");
                    guessLow = true;
                } else if (!guessHigh) {
                    input.println("" + options.size());
                    guessHigh = true;
                } else {
                    if (options.keySet().contains("City Hall")) {
                        input.println(options.get("City Hall"));
                        playerOneWins = (playerNum == 0);
                    } else {
                        boolean chosen = false;
                        for (String option : options.keySet()) {
                            if (players.get(playerNum).copies(option) < 2 && !chosen) {
                                players.get(playerNum).add(option);
                                input.println(options.get(option));
                                chosen = true;
                            }
                        }
                        if (!chosen) {
                            input.println("99");
                        }
                    }
                }
            } else if (line.contains("Turn started for")) {
                line = line.trim();
                String tmp = line.substring(line.lastIndexOf(" ") + 1);
                tmp = tmp.replace(".", "").trim();
                playerNum = Integer.parseInt(tmp) - 1;
            } else if (inMarket && line.contains("==========================================")) {
                inMarket = false;
            } else if (line.contains("==========================================")) {
                inMarket = true;
                marketString = "";
            } else if (inMarket) {
                marketString += line + "\n";
            }
            outputBuilder.append(line + "\n");
        }
        return outputBuilder.toString();
    }

    private String playPhase2(Scanner output, PrintWriter input, int numPlayers) {
        expectedProperties = Arrays.asList(
                "Wheat Field",
                "Ranch",
                "Forest",
                "Bakery",
                "Convenience Store",
                "Mine",
                "Apple Orchard",
                "City Hall",
                "Train Station"
        );
        startingEstablishments = Arrays.asList("Wheat Field", "Bakery");
        this.numPlayers = numPlayers;
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player(i));
            for (String s : startingEstablishments) {
                players.get(i - 1).add(s);
            }
            players.get(i - 1).coins = 3;
        }
        List<String> landmarks = Arrays.asList("Train Station", "City Hall");

        StringBuilder outputBuilder = new StringBuilder();
        int playerNum = 0;
        boolean inMarket = false;
        String marketString = "";
        while (output.hasNext()) {
            String line = output.nextLine();
            if (DEBUG) { System.out.println("::::::::::::::::::::     " + line); }
            if (line.contains("Choose a number to purchase or construct")) {
                Map<String, String> options = parseMarketOptions(marketString);
                int landmarkCount = 0;
                boolean boughtLandmark = false;
                boolean ownsHigherPriority = true;
                for (String landmark : landmarks) {
                    if (options.keySet().contains(landmark) && !players.get(playerNum).owns(landmark) && ownsHigherPriority) {
                        input.println(options.get(landmark));
                        players.get(playerNum).add(landmark);
                        boughtLandmark = true;
                        if (landmarkCount == landmarks.size() - 1) {
                            playerOneWins = (playerNum == 0);
                        }
                        break;
                    } else if (!players.get(playerNum).owns(landmark)) {
                        ownsHigherPriority = false;
                    } else {
                        landmarkCount++;
                    }
                }
                if (!boughtLandmark) {
                    boolean chosen = false;
                    int minimum = players.get(playerNum).owns("Train Station")? 1 : 0;
                    for (String option : options.keySet()) {
                        if (players.get(playerNum).copies(option) < minimum && !chosen) {
                            players.get(playerNum).add(option);
                            input.println(options.get(option));
                            chosen = true;
                        }
                    }
                    if (!chosen) {
                        input.println("99");
                    }
                }
            } else if (line.contains("like to roll 1 or 2")) {
                input.println("2");
            } else if (line.contains("Turn started for")) {
                line = line.trim();
                String tmp = line.substring(line.lastIndexOf(" ") + 1);
                tmp = tmp.replace(".", "").trim();
                playerNum = Integer.parseInt(tmp) - 1;
            } else if (inMarket && line.contains("==========================================")) {
                inMarket = false;
            } else if (line.contains("==========================================")) {
                inMarket = true;
                marketString = "";
            } else if (inMarket) {
                marketString += line + "\n";
            }
            outputBuilder.append(line + "\n");
        }
        return outputBuilder.toString();
    }

    private String playPhase3(Scanner output, PrintWriter input, int numPlayers) {
        expectedProperties = Arrays.asList(
                "Wheat Field",
                "Ranch",
                "Forest",
                "Bakery",
                "Convenience Store",
                "Mine",
                "Apple Orchard",
                "City Hall",
                "Train Station",
                "Shopping Mall"
        );
        startingEstablishments = Arrays.asList("Wheat Field", "Bakery");
        this.numPlayers = numPlayers;
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player(i));
            for (String s : startingEstablishments) {
                players.get(i - 1).add(s);
            }
            players.get(i - 1).coins = 3;
        }
        List<String> landmarks = Arrays.asList("Shopping Mall", "Train Station", "City Hall");

        StringBuilder outputBuilder = new StringBuilder();
        int playerNum = 0;
        boolean inMarket = false;
        String marketString = "";
        while (output.hasNext()) {
            String line = output.nextLine();
            if (DEBUG) { System.out.println("::::::::::::::::::::     " + line); }
            if (line.contains("Choose a number to purchase or construct")) {
                Map<String, String> options = parseMarketOptions(marketString);
                int landmarkCount = 0;
                boolean boughtLandmark = false;
                boolean ownsHigherPriority = true;
                for (String landmark : landmarks) {
                    if (options.keySet().contains(landmark) && !players.get(playerNum).owns(landmark) && ownsHigherPriority) {
                        input.println(options.get(landmark));
                        players.get(playerNum).add(landmark);
                        boughtLandmark = true;
                        if (landmarkCount == landmarks.size() - 1) {
                            playerOneWins = (playerNum == 0);
                        }
                        break;
                    } else if (!players.get(playerNum).owns(landmark)) {
                        ownsHigherPriority = false;
                    } else {
                        landmarkCount++;
                    }
                }
                if (!boughtLandmark) {
                    boolean chosen = false;
                    int minimum = players.get(playerNum).owns("Shopping Mall")? 1 : 0;
                    for (String option : options.keySet()) {
                        if (!landmarks.contains(option)) {
                            if (players.get(playerNum).copies(option) < minimum && !chosen) {
                                players.get(playerNum).add(option);
                                input.println(options.get(option));
                                chosen = true;
                            }
                        }
                    }
                    if (!chosen) {
                        input.println("99");
                    }
                }
            } else if (line.contains("like to roll 1 or 2")) {
                input.println("2");
            } else if (line.contains("Turn started for")) {
                line = line.trim();
                String tmp = line.substring(line.lastIndexOf(" ") + 1);
                tmp = tmp.replace(".", "").trim();
                playerNum = Integer.parseInt(tmp) - 1;
            } else if (inMarket && line.contains("==========================================")) {
                inMarket = false;
            } else if (line.contains("==========================================")) {
                inMarket = true;
                marketString = "";
            } else if (inMarket) {
                marketString += line + "\n";
            }
            outputBuilder.append(line + "\n");
        }
        return outputBuilder.toString();
    }

    private String playPhase4(Scanner output, PrintWriter input, int numPlayers) {
        expectedProperties = Arrays.asList(
                "Wheat Field",
                "Ranch",
                "Forest",
                "Bakery",
                "Convenience Store",
                "Mine",
                "Apple Orchard",
                "Cafe",
                "Family Restaurant",
                "Train Station",
                "Shopping Mall",
                "Amusement Park"
        );
        startingEstablishments = Arrays.asList("Wheat Field", "Bakery");
        this.numPlayers = numPlayers;
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player(i));
            for (String s : startingEstablishments) {
                players.get(i - 1).add(s);
            }
            players.get(i - 1).coins = 3;
        }
        List<String> landmarks = Arrays.asList("Amusement Park", "Shopping Mall", "Train Station");

        StringBuilder outputBuilder = new StringBuilder();
        int playerNum = 0;
        boolean inMarket = false;
        String marketString = "";
        while (output.hasNext()) {
            String line = output.nextLine();
            if (DEBUG) { System.out.println("::::::::::::::::::::     " + line); }
            if (line.contains("Choose a number to purchase or construct")) {
                Map<String, String> options = parseMarketOptions(marketString);
                int landmarkCount = 0;
                boolean boughtLandmark = false;
                boolean ownsHigherPriority = true;
                for (String landmark : landmarks) {
                    if (options.keySet().contains(landmark) && !players.get(playerNum).owns(landmark) && ownsHigherPriority) {
                        input.println(options.get(landmark));
                        players.get(playerNum).add(landmark);
                        boughtLandmark = true;
                        if (landmarkCount == landmarks.size() - 1) {
                            playerOneWins = (playerNum == 0);
                        }
                        break;
                    } else if (!players.get(playerNum).owns(landmark)) {
                        ownsHigherPriority = false;
                    } else {
                        landmarkCount++;
                    }
                }
                if (!boughtLandmark) {
                    boolean chosen = false;
                    int minimum = players.get(playerNum).owns("Amusement Park")? 1 : 0;
                    for (String option : options.keySet()) {
                        if (!landmarks.contains(option)) {
                            if (players.get(playerNum).copies(option) < minimum && !chosen) {
                                players.get(playerNum).add(option);
                                input.println(options.get(option));
                                chosen = true;
                            }
                        }
                    }
                    if (!chosen) {
                        input.println("99");
                    }
                }
            } else if (line.contains("like to roll 1 or 2")) {
                input.println("2");
            } else if (line.contains("Turn started for")) {
                line = line.trim();
                String tmp = line.substring(line.lastIndexOf(" ") + 1);
                tmp = tmp.replace(".", "").trim();
                playerNum = Integer.parseInt(tmp) - 1;
            } else if (inMarket && line.contains("==========================================")) {
                inMarket = false;
            } else if (line.contains("==========================================")) {
                inMarket = true;
                marketString = "";
            } else if (inMarket) {
                marketString += line + "\n";
            }
            outputBuilder.append(line + "\n");
        }
        return outputBuilder.toString();
    }

    private String playPhase5or6(Scanner output, PrintWriter input, int numPlayers) {
        expectedProperties = Arrays.asList(
                "Wheat Field",
                "Ranch",
                "Forest",
                "Bakery",
                "Convenience Store",
                "Mine",
                "Apple Orchard",
                "Cafe",
                "Family Restaurant",
                "Stadium",
                "TV Station",
                "Business Complex",
                "Train Station",
                "Shopping Mall",
                "Amusement Park",
                "Radio Tower"
        );
        startingEstablishments = Arrays.asList("Wheat Field", "Bakery");
        this.numPlayers = numPlayers;
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player(i));
            for (String s : startingEstablishments) {
                players.get(i - 1).add(s);
            }
            players.get(i - 1).coins = 3;
        }
        List<String> landmarks = Arrays.asList("Radio Tower", "Amusement Park", "Shopping Mall", "Train Station");

        StringBuilder outputBuilder = new StringBuilder();
        int playerNum = 0;
        boolean inMarket = false;
        String marketString = "";
        while (output.hasNext()) {
            String line = output.nextLine();
            if (DEBUG) { System.out.println("::::::::::::::::::::     " + line); }
            if (line.contains("Choose a number to purchase or construct")) {
                Map<String, String> options = parseMarketOptions(marketString);
                int landmarkCount = 0;
                boolean boughtLandmark = false;
                boolean ownsHigherPriority = true;
                for (String landmark : landmarks) {
                    if (options.keySet().contains(landmark) && !players.get(playerNum).owns(landmark) && ownsHigherPriority) {
                        input.println(options.get(landmark));
                        players.get(playerNum).add(landmark);
                        boughtLandmark = true;
                        if (landmarkCount == landmarks.size() - 1) {
                            playerOneWins = (playerNum == 0);
                        }
                        break;
                    } else if (!players.get(playerNum).owns(landmark)) {
                        ownsHigherPriority = false;
                    } else {
                        landmarkCount++;
                    }
                }
                if (!boughtLandmark) {
                    boolean chosen = false;
                    int minimum = players.get(playerNum).owns("Radio Tower")? 2 : 1;
                    for (String option : options.keySet()) {
                        if (!landmarks.contains(option)) {
                            if (players.get(playerNum).copies(option) < minimum && !chosen) {
                                players.get(playerNum).add(option);
                                input.println(options.get(option));
                                chosen = true;
                            }
                        }
                    }
                    if (!chosen) {
                        input.println("99");
                    }
                }
            } else if (line.contains("select an establishment")) {
                input.println("1");
            } else if (line.contains("who would you like to target")) {
                input.println("1");
            } else if (line.contains("like to reroll")) {
                input.println("y");
            } else if (line.contains("like to roll 1 or 2")) {
                input.println("2");
            } else if (line.contains("Turn started for")) {
                line = line.trim();
                String tmp = line.substring(line.lastIndexOf(" ") + 1);
                tmp = tmp.replace(".", "").trim();
                playerNum = Integer.parseInt(tmp) - 1;
            } else if (inMarket && line.contains("==========================================")) {
                inMarket = false;
            } else if (line.contains("==========================================")) {
                inMarket = true;
                marketString = "";
            } else if (inMarket) {
                marketString += line + "\n";
            }
            outputBuilder.append(line + "\n");
        }
        return outputBuilder.toString();
    }

    private String runProgram(List<String> args) {
        List<String> command = new ArrayList<String>();
        command.add("java");
        command.add("-jar");
        command.add(System.getProperty("user.dir") + "/build/libs/machiwoco.jar");
        for (String arg : args) {
            command.add(arg);
        }
        ProcessBuilder builder = new ProcessBuilder(command);
        try {
            final Process process = builder.start();
            Scanner scanner = new Scanner(process.getInputStream());
            PrintWriter writer = new PrintWriter(process.getOutputStream(), true);
            if (args.size() == 1 && args.get(0).equals("phase0")) {
                return playPhase0(scanner, writer);
            } else if (args.size() >= 1 && args.get(0).equals("phase1")) {
                if (args.size() == 2 && args.get(1).equals("--ai")) {
                    return playPhase1(scanner, writer, true);
                } else {
                    return playPhase1(scanner, writer, false);
                }
            } else if (args.size() == 2 && args.get(0).equals("phase2")) {
                int numPlayers = Integer.parseInt(args.get(1));
                return playPhase2(scanner, writer, numPlayers);
            } else if (args.size() == 2 && args.get(0).equals("phase3")) {
                int numPlayers = Integer.parseInt(args.get(1));
                return playPhase3(scanner, writer, numPlayers);
            } else if (args.size() == 2 && args.get(0).equals("phase4")) {
                int numPlayers = Integer.parseInt(args.get(1));
                return playPhase4(scanner, writer, numPlayers);
            } else if (args.size() == 2 && args.get(0).equals("phase5")) {
                int numPlayers = Integer.parseInt(args.get(1));
                return playPhase5or6(scanner, writer, numPlayers);
            } else if (args.size() == 2 && args.get(0).equals("phase6")) {
                int numPlayers = Integer.parseInt(args.get(1));
                return playPhase5or6(scanner, writer, numPlayers);
            }
        } catch (IOException e) { System.out.println(e); }
        return "";
    }

    private void runPhaseWithArg(String phase, String arg) {
        List<String> args = new ArrayList<>();
        args.add(phase);
        if (arg.length() > 0) {
            args.add(arg);
        }
        actualOutput = runProgram(args);
    }


    @Before
    public void initialize() {
        programInput = "";
        actualOutput = "";
        playerOneWins = false;
    }

    @When("the program is run as {string}")
    public void theProgramIsRunAs(String phase) {
        runPhaseWithArg(phase, "");
    }


    @When("the program is run as {string} with argument {string}")
    public void theProgramIsRunAsWithArgument(String phase, String arg) {
        runPhaseWithArg(phase, arg);
    }


    @Then("I should see the detailed view of all of the cards")
    public void iShouldSeeTheDetailedViewOfAllOfTheCards() {
        List<String> expected = Arrays.asList(
                ".-----------------------.\n" +
                        "| <B>      [1]      {W} |\n" +
                        "|      Wheat Field      |\n" +
                        "|                       |\n" +
                        "|  Get 1 coin from the  |\n" +
                        "|         bank.         |\n" +
                        "|    (anyone's turn)    |\n" +
                        "|                       |\n" +
                        "| (1)                   |\n" +
                        "|_______________________|",
                ".-----------------------.\n" +
                        "| <B>      [2]      {C} |\n" +
                        "|         Ranch         |\n" +
                        "|                       |\n" +
                        "|  Get 1 coin from the  |\n" +
                        "|         bank.         |\n" +
                        "|    (anyone's turn)    |\n" +
                        "|                       |\n" +
                        "| (1)                   |\n" +
                        "|_______________________|",
                ".-----------------------.\n" +
                        "| <B>      [5]      {G} |\n" +
                        "|        Forest         |\n" +
                        "|                       |\n" +
                        "|  Get 1 coin from the  |\n" +
                        "|         bank.         |\n" +
                        "|    (anyone's turn)    |\n" +
                        "|                       |\n" +
                        "| (3)                   |\n" +
                        "|_______________________|");

        for (String s : expected) {
            assertThat(actualOutput, containsString(s));
        }
    }

    @Then("the game log should be accurate")
    public void theGameLogShouldBeAccurate() {
        theGameLogShouldBeAccurateUsingTheMarket("simple");
    }

    @Then("the game log should be accurate using the {string} market")
    public void theGameLogShouldBeAccurateUsingTheMarket(String marketType) {
        assertThat("Log Empty Error: No game was played.", actualOutput.trim().length(), greaterThan(0));
        assertThat("Game Over Error: The game does not end with a winner.", actualOutput, containsString("is the winner."));
        if (playerOneWins) {
            assertThat("Game Winner Error: Player 1 should win the game.", actualOutput, containsString("Player 1 is the winner."));
        } else {
            assertThat("Game Winner Error: Player 1 should NOT win the game.", actualOutput, not(containsString("Player 1 is the winner.")));
        }
        Result result = evaluateGameLog(actualOutput, numPlayers, startingEstablishments, marketType);
        if (result.type == Result.Type.FAILURE) {
            assertThat(result.info, false);
        } else {
            assertThat("all match", true);
        }
    }


}  