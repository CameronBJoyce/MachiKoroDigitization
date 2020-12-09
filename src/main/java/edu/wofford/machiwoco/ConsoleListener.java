package edu.wofford.machiwoco;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.*;

/**
 * A class used to output messages to the Player through the console regarding dice rolls and activated Establishments.
 * 
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */

public class ConsoleListener implements GameListener {

    /**
     * Outputs the Player's dice roll to the console.
     * @param dice1 an integer representing the first die's total.
     * @param dice2 an integer representing the second die's total.
     * @param p the Player instance that conducted the dice roll.
     */

    @Override
    public void diceRolled(int dice1, int dice2, Player p) {
        if (dice2 == 0) {
            System.out.println("Player " + p.getPlayerNumber() +
                    " rolled ["+dice1+"] = " + dice1 + ".");
        } else {
            System.out.println("Player " + p.getPlayerNumber() +
                    " rolled ["+dice1+"]" + "[" + dice2 + "] = " + (dice1 + dice2) + ".");
        }
    }

    /**
     * Outputs Establishments activated by the Player's dice roll to the console.
     * @param dice an integer representing the completed dice roll.
     * @param players a List of the current game state's Players.
     */

    @Override
    public void diceActivation(int dice, List<Player> players) {
        int activation;
        StringBuilder s = new StringBuilder();
        for (Player player : players) {
            Set<Establishment> keys = player.getEstOwned().keySet();
            for(Establishment est: keys) {
                String name = est.getName();
                switch (name) {
                    case "Bakery": if(dice == 2) { activation = 2; }
                                    else { activation = 3; }
                                    break;
                    case "Family Restaurant": if(dice == 9) { activation = 9; }
                                              else { activation = 10; }
                                              break;

                    case "Farmers Market": if(dice == 11) { activation = 11; }
                                            else { activation = 12; }
                                            break;

                    default: activation = Integer.parseInt(est.getActivation());
                }
                if(dice == activation){
                    if(player.isTurn()) {
                        if(!est.getColor_ab().equals(Card.Color_ab.R) && !est.getColor_ab().equals(Card.Color_ab.P)){
                            s.append(est.getName()).append(" activated for Player ").append(player.getPlayerNumber()).append("\n");
                        }
                        if (est.name.equals("Stadium")) {
                            s.append(est.getName()).append(" activated for Player ").append(player.getPlayerNumber()).append("\n");
                        }

                    } else {
                        if(!est.getColor_ab().equals(Card.Color_ab.G) && !est.getColor_ab().equals(Card.Color_ab.P)) {
                            s.append(est.getName()).append(" activated for Player ").append(player.getPlayerNumber()).append("\n");
                        }
                    }

                }
            }
        }
        System.out.print(s);
    }

//    /**
//     * Prompts the user to choose how many die to roll.
//     * @param sc a Scanner item used to take in the user's input.
//     * @param p the Player choosing the number of die to roll.
//     * @return a boolean holding true if the Player chooses to roll two die.
//     */
//
//    @Override
//    public void targetAndTake(Player p1, Player p2, int amountToTake) {
//
//    }

    /**
     * Returns a boolean representing whether or not the Player has decided to roll 1 or 2 die.
     * @param sc a Scanner object used to gather the Player's input.
     * @param p the Player rolling the die.
     * @return a boolean holding true if the Player chooses to roll two die.
     */

    public boolean rollTwo(Scanner sc, Player p) {
        int input = 0;
        while (input != 1 && input != 2) {
            System.out.println(StringUtils.center("Player " + p.getPlayerNumber() + ", would you like to roll 1 or 2 die?", 42, " "));
            input = Integer.parseInt(sc.nextLine());
        }
        return input != 1;
    }

    public Player playerChooseTarget(List<Establishment> est_order, Scanner sc, Player p, ArrayList<Player> playerArr, boolean tv) {
        if (tv) {
            System.out.println("TV Station activated for Player " + p.getPlayerNumber());
        } else {
            System.out.println("Business Complex activated for Player " + p.getPlayerNumber());
        }
        ArrayList<Player> validPlayers = new ArrayList<Player>();
        System.out.println();
        System.out.println(StringUtils.center("-------     AVAILABLE PLAYERS      -------", 42, " "));
        for (Player player : playerArr) {

//            tv station logic
            if (tv) {
                if (!player.isTurn() && player.getCoinCount() > 0) {
                    validPlayers.add(player);
                }

//                business center logic
            } else {
                if (!player.isTurn()) {
//                    est_order = [wheat, ranch, bakery ...]
                    int wheat_num = player.getEstOwned().get(est_order.get(0));
                    int bakery_num = player.getEstOwned().get(est_order.get(2));

//                    the only way to not have a player available is when they have only 1 wheat, only 1 bakery, purple cards and nothing else
                    int purpleCount = 0;
                    for (Establishment e : player.getEstOwned().keySet()) {
                        if (e.getColor_ab().equals(Card.Color_ab.P)) {purpleCount++;}
                    }
                    if (!(wheat_num == 1 && bakery_num == 1 && player.getEstOwned().size() == 2+purpleCount)) {
                        validPlayers.add(player);
                    }
                }
            }
        }
        int count = 1;
        for (Player pl : validPlayers) {
            String s = "";
            s += count + ". ";
            s += StringUtils.rightPad("Player " + pl.getPlayerNumber(), 20, " ");
            s += " (" + pl.getCoinCount() + " coins)";
            System.out.println(s);
            count++;
        }
        int input;
        do {
            System.out.println(StringUtils.center("Player " + p.getPlayerNumber() + ", who would you like to target?", 42, " "));
            input = Integer.parseInt(sc.nextLine());
        } while ((input != 1 && input > validPlayers.size()) || input < 1);
        return validPlayers.get(input - 1);
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

    public Establishment playerChooseEst(Scanner sc, Player player, ArrayList<Establishment> estToDisplay, int currPlayerNum) {
        System.out.println(StringUtils.center("-------  AVAILABLE ESTABLISHMENTS  -------", 42, " "));
        String s = "";
        s += StringUtils.center("Player " + player.getPlayerNumber(), 42, " ") + "\n";
        int count = 1;
        for (Establishment est : estToDisplay) {
            if (player.getEstOwned().containsKey(est)) {
                s += StringUtils.rightPad(count + ". ", 3, " ") + StringUtils.rightPad(est.getName(), 19, " ") +
                        est.getColor_ab() + est.getIcon_ab() + " " +
                        generateCost(est.getCost()) + " " +
                        generateActivation(est.getActivation()) + "\n";
                count++;
            }
        }
        System.out.print(s);

        int input;
        //System.out.println("size: " + validPlayers.size());
        do {
            System.out.println(StringUtils.rightPad("Player " + currPlayerNum + ", select an establishment: ", 42, " "));
            input = Integer.parseInt(sc.nextLine());
        } while (input > player.getEstOwned().size() || input < 1);
        return estToDisplay.get(input-1);
    }

    public boolean playerChooseReroll(Scanner sc, Player p) {
        String input;
        do {
            System.out.println("Player " + p.getPlayerNumber() + ", would you like to reroll the dice? (y/n): ");
            input = sc.nextLine().toLowerCase();
        } while (!input.equals("y") && !input.equals("n"));
        return input.equals("y");
    }


    public static void main(String[] args) {
        ConsoleListener c = new ConsoleListener();
        Feature7 feature7 = new Feature7(3);
        feature7.getPlayer1().setTurn(true);
//        c.playerChooseTarget(new Scanner(System.in), feature7.getCurrentPlayer(), feature7.players);
//        System.out.println("player1: " + feature7.getPlayer1().getCoinCount());
//        System.out.println("playerf2: " + feature7.getPlayer2().getCoinCount());

    }







}
