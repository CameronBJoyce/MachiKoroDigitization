package edu.wofford.machiwoco;

import org.apache.commons.lang3.StringUtils;

import java.lang.*;
import java.io.*;

/** 
 * This is a class built to represent all landmark cards.
 * 
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */

public class Landmark extends Card{

    /**
     * Landmark card constructor utilizing the extension of the Card class
     * @param name is the name of the landmark card
     * @param cost is a 1-2 digit number representing the cost of the card
     * @param color is the color of the card in enumeration form
     * @param color_ab is the abbreviation of the color of the card
     * @param icon is the icon on the card in enumeration form
     * @param icon_ab is the abbreviation of the icon on the card
     * @param description is the action description of the card
     */

    public Landmark(String name, int cost, Color color, Color_ab color_ab,  Icon icon, Icon_ab icon_ab,String description) {
        super(name,cost, color, icon, description);
        this.color_ab = color_ab;
        this.icon_ab = icon_ab;
        //System.out.println("Team Beast");
    }

    /**
     * Sets the Landmark card's constructed state
     * @param is_constructed a boolean holding true if the Landmark is constructed
     */
    public void setIs_constructed(boolean is_constructed) {
        this.is_constructed = is_constructed;
    }

    /**
     * Gets the state of the Landmark's construction
     * @return a boolean holding true if the landmark is constructed
     */

    public boolean getIsConstructed() {
        return is_constructed;
    }

    //    used by landmark sub classes to determine if a landmark is constructed or not
    protected boolean is_constructed;
    protected  Color color;

    /**
      * Gets the card's color
      * @return an <code> enumeration value </code> specifying the card's color
      */

    public Color getColor() {
        return color;
    }

    /**
      * Sets the card's color
      * @param color the card's color
      */

    public void setColor(Color color) {
        this.color = color;
    }

    /**
      * Gets the landmark card's abbreviated color value
      * @return an <code> enumeration value </code> specifying the card's abbreviated color value
      */

    public Color_ab getColor_ab() {
        return color_ab;
    }

    /**
      * Sets the landmark card's color abbreviation
      * @param color_ab the card's color abbreviation
      */

    public void setColor_ab(Color_ab color_ab) {
        this.color_ab = color_ab;
    }

    /**
      * Gets the landmark card's abbreviated icon value
      * @return an <code> enumeration value </code> specifying the card's abbreviated icon value
      */

    public Icon_ab getIcon_ab() {
        return icon_ab;
    }

    /**
      * Sets the landmark card's icon abbreviation
      * @param icon_ab the card's icon abbreviation
      */

    public void setIcon_ab(Icon_ab icon_ab) {
        this.icon_ab = icon_ab;
    }

    /**
     * Generates the framework for displaying the landmark card
     * @param s a <code> string </code> that is used to generate the String[]
     * @return an <code> array of strings </code> that will be used for the toString() method
     */

    // ************ Saved for later. Do NOT delete. **************** //
    public String[] generate_blocks(String s) {
        int len = s.length();
        System.out.println("slen: " + len);
        // determines how many lines to print out
        // if s is longer than 23 char
        int new_lines = len / 23 + 1;
        String[] stringsToProcess = new String[new_lines];
        int start_index = 0;
        int end_index;

        for (int i = 0; i < new_lines; i++) {
//            this will be a multiline string
            for (int j = 20; j > 0; j--) {
                if (i == new_lines - 1) {j = len;}
                if (s.charAt(j) == ' ') {
                    end_index = j;
                    stringsToProcess[i] = s.substring(start_index, end_index);
                    s = s.substring(end_index + 1, len);
                }
            }
        }
        return stringsToProcess;
    }

    /**
     * Returns the <code> string </code> displayed on the Landmark card representing its construction
     * @param is_constructed a boolean representing whether the landmark has been constructed
     * @return a <code> string </code> that will represent the landmark's construction upon the card's display 
     */

    public String isConstructed(boolean is_constructed) {
        if (is_constructed) {return "X";}
        return " ";
    }

    /**
     * Returns the string form of the Landmark card
     * @return a string representing the current Landmark card
     */

    @Override
    public String toString() {
        // need to replace with string format method

        if (cost < 10) {
            return ".-----------------------.\n"+
                    "| <" + color_ab + ">   LANDMARK    {" + icon_ab + "} |\n" +
                    generate_single_line(name) +
                    generate_single_line(" ") +
                    description +
                    generate_single_line(" ") +
                    "| (" + cost + ")               [" + isConstructed(is_constructed) + "] |\n" +
                    "|_______________________|";
        } else {
            return ".-----------------------.\n"+
                    "| <" + color_ab + ">   LANDMARK    {" + icon_ab + "} |\n" +
                    generate_single_line(name) +
                    generate_single_line(" ") +
                    description +
                    generate_single_line(" ") +
                    "| (" + cost + ")              [" + isConstructed(is_constructed) + "] |\n" +
                    "|_______________________|";
        }
    }

    public static void main(String[] args) {
//        Landmark l = new Landmark("Test", 1, Card.Color.BLUE, Card.Icon.FRUITO, "Test");
//        System.out.println(l.toString());

//        //**********Landmark train station creation************//
//        Landmark trainStation;
//        trainStation = new Landmark("Train Station", 4, Card.Color.NONE, Card.Icon.TOWER,
//                "|  You may roll 1 or 2  |\n" +
//                        "|         dice.         |\n");
//        trainStation.color_ab = Card.Color_ab.N;
//        trainStation.icon_ab = Card.Icon_ab.T;
//        System.out.println(trainStation.toString());
//
//        //**********Landmark shopping mall creation************//
//        Landmark shoppingMall;
//        shoppingMall = new Landmark("Shopping Mall", 10, Card.Color.NONE, Card.Icon.TOWER,
//                "|   Your {U} and {B}    |\n" +
//                        "|  establishments earn  |\n" +
//                            "|     +1 coin when      |\n" +
//                                "|      activated.       |\n");
//        shoppingMall.color_ab = Card.Color_ab.N;
//        shoppingMall.icon_ab = Card.Icon_ab.T;
//        System.out.println(shoppingMall.toString());
//
//        //**********Landmark amusement park creation************//
//        Landmark amusementPark;
//        amusementPark = new Landmark("Amusement Park", 16, Card.Color.NONE, Card.Icon.TOWER,
//                "| If you roll doubles,  |\n" +
//                        "|   take another turn   |\n" +
//                            "|    after this one.    |\n");
//        amusementPark.color_ab = Card.Color_ab.N;
//        amusementPark.icon_ab = Card.Icon_ab.T;
//        System.out.println(amusementPark.toString());
//
//        //**********Landmark radio tower creation************//
//        Landmark radioTower;
//        radioTower = new Landmark("Radio Tower", 22, Card.Color.NONE, Card.Icon.TOWER,
//                "|  Once per turn, you   |\n" +
//                        "| may reroll the dice.  |\n");
//        radioTower.color_ab = Card.Color_ab.N;
//        radioTower.icon_ab = Card.Icon_ab.T;
//        System.out.println(radioTower.toString());
//
//        //**********Landmark city hall creation************//
//        Landmark cityHall;
//        cityHall = new Landmark("City Hall", 7, Card.Color.NONE, Card.Icon.TOWER,
//                "|      You have a       |\n" +
//                        "|      city hall.       |\n");
//        cityHall.color_ab = Card.Color_ab.N;
//        cityHall.icon_ab = Card.Icon_ab.T;
//        System.out.println(cityHall.toString());

    }
}