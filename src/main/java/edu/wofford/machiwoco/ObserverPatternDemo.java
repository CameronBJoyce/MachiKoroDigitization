//package edu.wofford.machiwoco;
//
//public class ObserverPatternDemo {
//    public static void main(String[] args) {
//
//
//        // roll1
//        int dice1 = (int) (Math.random() * 6 + 1);
//        System.out.println("First Dice roll is " + dice1);
//        DiceSubject diceSubject = new DiceSubject(1, dice1);
//        new DiceObserver(diceSubject);
//        diceSubject.setDice(dice1);
//        diceSubject.notifyObservers();
//        System.out.println(" ");
//
//        // roll2
//        int dice2 = (int) (Math.random() * 6 + 1);
//        System.out.println("Second Dice roll is " + dice2);
//        diceSubject.setPlayer(42);
//        diceSubject.setDice(dice2);
//        diceSubject.notifyObservers();
//    }
//}
