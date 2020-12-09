package edu.wofford.machiwoco;

import org.apache.commons.lang3.StringUtils;

/**
 * This is a class that represents the basics of a Machi Koro card - both for Establishment and Landmark.
 * 
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */

public class Card {
     /** Available card colors */
     protected enum Color {BLUE, GREEN, PURPLE, RED, NONE};
     /** Abbreviated versions of card colors */
     protected enum Color_ab { 
          /** Blue */
          B, 
          /** Green */
          G, 
          /** Purple */
          P, 
          /** Red */
          R, 
          /** None */
          N
     };
     /** Icons found on cards */
     protected enum Icon {WHEAT, COW, BREAD, GEAR, FACTORY, FRUITO, CUPU, TOWER};
     /** Abbreviated versions of card icons */
     protected enum Icon_ab{
          /** Wheat */
          W,
          /** Bread */
          B, 
          /** Cow */
          C, 
          /** Gear */
          G, 
          /** Factory */
          F, 
          /** Fruit */
          O, 
          /** Cup */
          U, 
          /** Tower */
          T
     };

     //Default Variables for Each Card
     protected String name;
     protected Color color;
     protected int cost;
     protected Icon icon;
     protected String description;
     protected Color_ab color_ab;
     protected  Icon_ab icon_ab;

     /**
      * Card constructor
      * @param name is the name of the card itself
      * @param cost is a 1-2 digit number representing the cost of the card
      * @param color is the color of the card in enumeration form
      * @param icon is the icon on the card in enumeration form
      * @param description is the action description of the card
      */

     public Card(String name, int cost, Color color, Icon icon, String description) {
          this.name = name;
          this.color = color;
          this.cost = cost;
          this.icon = icon;
          this.description = description;
     }

     /**
      * Gets the card's name
      * @return a <code> string </code> specifying the card's name
      */

     public String getName() {
          return name;
     }

     /**
      * Sets the card's name
      * @param name the card's name
      */

     public void setName(String name) {
          this.name = name;
     }

     /**
      * Gets the card's color
      * @return an <code> enumeration value </code> specifying the card's color
      */

     public Color getColor() {
          return color;
     }

     /**
      * Gets the card's cost
      * @return an <code> integer </code> specifying the card's cost
      */

     public int getCost() {
          return cost;
     }

     /**
      * Sets the card's cost
      * @param cost the card's cost
      */

     public void setCost(int cost) {
          this.cost = cost;
     }

     /**
      * Gets the card's icon
      * @return an <code> enumeration value </code> specifying the card's icon
      */

     public Icon getIcon() {
          return icon;
     }

     /**
      * Gets the card's description
      * @return a <code> string </code> specifying the card's action description
      */

     public String getDescription() {
          return description;
     }

     /**
      * Sets the card's description
      * @param description the card's action description
      */

     public void setDescription(String description) {
          this.description = description;
     }

     /**
      * Returns a string line to be used in the card's toString() method
      * @param s the string to be centered in console output
      * @return a <code> string </code> representing a line in the card's output to the console
      */

     //  return strings to be used in toString()
     public String generate_single_line(String s) {
          String str = StringUtils.center(s, 21, " ");
          return "| " + str + " |\n";
     }


}