package edu.wofford.machiwoco;

/**
 * This class uses DiceSubject to output the Player's dice roll.
 *
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */

public class DiceObserver extends Observer{

    /**
     * A constructor that creates a diceSubject instance and adds itself to DiceSubject's list of observers.
     * @param diceSubject a DiceSubject instance that will be used to access the info needed in the output.
     */

    public DiceObserver(DiceSubject diceSubject){
        this.diceSubject = diceSubject;
        this.diceSubject.attach(this);
    }

    /**
     * Prints out the Player's dice roll to the console.
     */

    @Override
    public void update() {
        if (diceSubject.getDiceNum() == 1) {
            System.out.println( "Player " + diceSubject.getActivePlayer().getPlayerNumber() +" rolled ["+diceSubject.getDice()+"] = " + diceSubject.getDice() + ".");
        } else {
            System.out.println( "Player " + diceSubject.getActivePlayer().getPlayerNumber() +" rolled ["+diceSubject.getDicePair()[0]+"]["+diceSubject.getDicePair()[1]+"] = " + diceSubject.getDice() + ".");
        }
    }
}
