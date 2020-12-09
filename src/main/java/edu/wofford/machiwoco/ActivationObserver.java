package edu.wofford.machiwoco;

import java.util.Set;
import java.util.*;

/**
 * This class uses DiceSubject to ouput any activation occurrences throughout the playthrough of Machi Koro.
 *
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */

public class ActivationObserver extends Observer {

    /**
     * A constructor that creates a diceSubject instance and adds itself to DiceSubject's list of observers.
     * @param diceSubject a DiceSubject instance that will be used to access the info needed in the output.
     */

    public ActivationObserver(DiceSubject diceSubject) {
        this.diceSubject = diceSubject;
        this.diceSubject.attach(this);
    }

    /**
     * Prints out any instances of activation throughout playthrough of the Machi Koro game.
     */

    @Override
    public void update() {
        System.out.print(checkActivation());
    }

    /**
     * Creates the string that will be displayed in the console, representing instances of activation.
     * @return a StringBuilder object that contains any instances of activation based on dice rolls.
     */

    private StringBuilder checkActivation() {
        int dice = diceSubject.getDice();
        int activation = 0;
        //Player[] players = diceSubject.getPlayers();
        ArrayList<Player> players = diceSubject.getPlayers();
        StringBuilder s = new StringBuilder();
        for (Player player : players) {
            // this changes the actual coin amounts in the player bank
            player.getActivationNumbers(dice,player.isTurn());
            //  checkRed(players);

            // this prints out the activations for user's information
            Set<Establishment> keys = player.getEstOwned().keySet();
            int x = player.getPlayerNumber();
            for(Establishment est: keys) {
                if(!est.getName().equals("Bakery")) {
                    activation = Integer.parseInt(est.getActivation());
                } else if(est.getName().equals("Bakery")) {
                    if(dice == 2) { activation = 2; }
                    else { activation = 3; }
                }

                if(est.getColor_ab().equals(Card.Color_ab.R) && !player.isTurn()) {
                    s.append(est.getName()).append(" activated for Player ").append(player.getPlayerNumber()).append("\n");
                }

                if (dice == activation && !est.getColor_ab().equals(Card.Color_ab.G)) {
                    s.append(est.getName()).append(" activated for Player ").append(player.getPlayerNumber()).append("\n");
                } else if (dice == activation && player.isTurn()) {
                    s.append(est.getName()).append(" activated for Player ").append(player.getPlayerNumber()).append("\n");
                }
            }
        }
//        if (dice == 1) {
//            return "Wheat Field Activated";
//        } else {
//            return "NOPE";
//        }
        return s;
    }


}