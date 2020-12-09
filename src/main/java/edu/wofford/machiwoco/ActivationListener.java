package edu.wofford.machiwoco;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * A class that pulls from the current game state to perform activation actions based on a Player's dice roll.
 *
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */

public class ActivationListener implements GameListener {

    /**
     * Checks what activations will be activated based on a Player's given dice roll.
     * @param dice an integer representing the Player's dice roll.
     * @param players a List of the current game state's Players.
     */

    @Override
    public void diceActivation(int dice, List<Player> players) {
       ArrayList<Player> inactivePlayers = nonActivePlayers(players);
       Player active= players.get(0);
       for(Player p : players) {
           if(p.isTurn()) {
               active = p;
           }
       }
       int moneyOwed;
       for(Player p : inactivePlayers) {
           moneyOwed = 0;
           if (dice == 3) {
               if(p.numOfCafe(p.getEstOwned()) > 0) {
                   if (p.isShoppingMallConstructed()) {
                       moneyOwed = p.numOfCafe(p.getEstOwned()) * 2;
                   } else {
                       moneyOwed = p.numOfCafe(p.getEstOwned());
                   }
               }

           } else if (dice == 9 || dice == 10) {
               if(p.numOfRestaurant(p.getEstOwned()) > 0)  {
                   if(p.isShoppingMallConstructed()) {
                       moneyOwed =  p.numOfRestaurant(p.getEstOwned()) *3;
                   } else {
                       moneyOwed =  p.numOfRestaurant(p.getEstOwned()) *2;
                   }

               }
           }
           takeMoney(active,p,moneyOwed);
       }
       if(dice ==6) {
           if(active.isStadiumOwned()) {
               stadiumLogic(active,inactivePlayers);
           }
           // Business Center and TV Station logic is handled elsewhere

       }
        for (Player player : players) {
            //  changes the coin amounts in the player bank
            player.getActivationNumbers(dice, player.isTurn());
        }
    }

    /**
     * Logic for handling stadium card
     * @param active currently active player
     * @param inactivePlayers Arraylist of inactive players
     */
    protected void stadiumLogic(Player active, ArrayList<Player> inactivePlayers) {
        for(Player p : inactivePlayers) {
            takeMoney(p,active,2);
        }
    }

    /**
     * Provides a list of non-active Players.
     * @param players a List of Players involved in the current game.
     * @return an ArrayList of Players that are not currently active.
     */

    public ArrayList<Player> nonActivePlayers(List<Player> players) {
        ArrayList<Player> temp = new ArrayList<>();
        ArrayList<Player> nonActive = new ArrayList<>();

        int currentPlayerIndex = 0;
        for (Player p : players) {
            if (p.isTurn()) {currentPlayerIndex = players.indexOf(p);}
        }

        for (int i = 1; i < players.size(); i++) {
            temp.add(players.get((currentPlayerIndex + i)%players.size()));
        }

        for (int i = temp.size()-1; i > -1; i--) {
            nonActive.add(temp.get(i));
        }
        return nonActive;
    }

    /**
     * Takes money from a given Player.
     * @param playerToTake the Player taking/receiving coins.
     * @param playerToGive the Player losing/giving coins.
     * @param amount an integer representing the number of coins that are being given/being taken away.
     */

    public void takeMoney(Player playerToTake, Player playerToGive, int amount) {
        playerToGive.addCoins(playerToTake.takeCoin(amount));
    }

    /**
     * Swaps establishment from one player to another
     * @param playerToTake the Player getting one of their cards swapped.
     * @param playerToGive the Player swapping the establishment
     * @param estToGive establishment given to player to take
     * @param estToTake establishmentt taken from the player
     */
    public void swap(Player playerToTake, Player playerToGive, Establishment estToTake, Establishment estToGive) {
        playerToGive.removeCard(estToGive);
        playerToGive.addCard(estToTake);
        playerToTake.removeCard(estToTake);
        playerToTake.addCard(estToGive);
    }


    @Override
    public void diceRolled(int dice1, int dice2, Player p) {

    }
}