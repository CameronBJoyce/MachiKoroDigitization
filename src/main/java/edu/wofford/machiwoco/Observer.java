package edu.wofford.machiwoco;

/**
 * An Observer class that contains all Subject classes to be observed.
 * 
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */

public abstract class Observer {
    protected DiceSubject diceSubject;
    protected InputSubject inputSubject;
    public abstract void update();
}
