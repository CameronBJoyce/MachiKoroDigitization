package edu.wofford.machiwoco;

import org.apache.commons.lang3.StringUtils;

/** 
 * This is a class built to represent all establishment cards.
 * 
 * @author Eric Craft
 * @author Ivan Gu
 * @author Bennett Joyce
 */

public class Establishment extends Card {

    private Color_ab color_ab;

    /**
      * Gets the establishment card's abbreviated color value
      * @return an <code> enumeration value </code> specifying the card's abbreviated color value
      */

    public Color_ab getColor_ab() {
        return color_ab;
    }

    /**
      * Sets the establishment card's color abbreviation
      * @param color_ab the card's color abbreviation
      */

    public void setColor_ab(Color_ab color_ab) {
        this.color_ab = color_ab;
    }

    /**
      * Gets the establishment card's abbreviated icon value
      * @return an <code> enumeration value </code> specifying the card's abbreviated icon value
      */

    public Icon_ab getIcon_ab() {
        return icon_ab;
    }

    /**
      * Sets the establishment card's icon abbreviation
      * @param icon_ab the card's icon abbreviation
      */

    public void setIcon_ab(Icon_ab icon_ab) {
        this.icon_ab = icon_ab;
    }

    private Icon_ab icon_ab;
    private String activation;
    private String type;
    private String target;
    private int amount;
    private String modifierType;
    private String modifier;

    /**
     * Establishment card constructor utilizing the extension of the Card class
     * @param name is the name of the establishment card itself
     * @param cost is a 1-2 digit number representing the cost of the card
     * @param color is the color of the card in enumeration form
     * @param icon is the icon on the card in enumeration form
     * @param description is the action description of the card
     * @param activation is the activtion range of the card
     */

    public Establishment(String name,
                         int cost,
                         Color color,
                         Icon icon,
                         String description,
                         String activation) {
        super(name, cost, color, icon, description);
        this.activation = activation;
    }

    /** 
     * Establishment card constructor
     * @param name is the name of the establishment card itself
     * @param cost is a 1-2 digit number representing the cost of the card
     * @param color is the color of the card in enumeration form
     * @param color_ab is the abbreviated version of the card's color in enumeration form
     * @param icon is the icon on the card in enumeration form
     * @param icon_ab is the abbreviated version of the card's icon in enumeration form
     * @param description is the action description of the card
     * @param activation is the activtion range of the card
     * @param type is the action performed by the card
     * @param target is the target of the action being performed
     * @param amount is the number of coins being given or received
     * @param modifierType is what's being modified
     * @param modifier is the icon that represents the ability to modify
     */

    //Robust Constructor (all Variable must be passed in)
    public Establishment(String name,
                         int cost,
                         Color color,
                         Color_ab color_ab,
                         Icon icon,
                         Icon_ab icon_ab,
                         String description,
                         String activation,
                         String type,
                         String target,
                         int amount,
                         String modifierType,
                         String modifier) {
        super(name,cost,color,icon,description);
        this.color_ab = color_ab;
        this.icon_ab = icon_ab;
        this.activation = activation;
        this.type = type;
        this.target = target;
        this.amount = amount;
        this.modifierType = modifierType;
        this.modifier = modifier;
    }

    /**
      * Gets the card's activation range
      * @return a <code> string </code> specifying the card's activation range
      */

    public String getActivation() {
        return activation;
    }

    /**
      * Sets the card's activation range
      * @param activation the card's activation range
      */

    public void setActivation(String activation) {
        this.activation = activation;
    }

    /**
      * Gets the card's type
      * @return a <code> string </code> specifying the card's type
      */

    public String getType() {
        return type;
    }

    /**
      * Sets the card's type
      * @param type the card's type
      */

    public void setType(String type) {
        this.type = type;
    }

    /**
      * Gets the card's target
      * @return a <code> string </code> specifying the card's target
      */

    public String getTarget() {
        return target;
    }

    /**
      * Sets the card's target
      * @param target the card's target
      */

    public void setTarget(String target) {
        this.target = target;
    }

    /**
      * Gets the amount of coins being given or received
      * @return an <code> integer </code> specifying the number of coins at play
      */

    public int getAmount() {
        return amount;
    }

    /**
      * Sets the amount of coins being given or received
      * @param amount the amount of coins being given or received
      */

    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
      * Gets the modifier type of the card
      * @return a <code> string </code> specifying the modifier type
      */

    public String getModifierType() {
        return modifierType;
    }

    /**
      * Sets the modifier type of the card
      * @param modifierType the modifier type being applied
      */

    public void setModifierType(String modifierType) {
        this.modifierType = modifierType;
    }

    /**
      * Gets the modifier of the card
      * @return a <code> string </code> specifying the modifier
      */

    public String getModifier() {
        return modifier;
    }

    /**
      * Sets the modifier of the card
      * @param modifier the modifier being applied
      */

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }


    protected boolean is_constructed;

    /**
     * Generates the activation string to be displayed as part of the card
     * @return a <code> string </code> that displays the activation range of the card
     */

    public String generateActivationString() {
            String act = "[" + activation + "]";
            return StringUtils.center(act, 15, " ");
    }

    /**
     * Generates the cost string to be displayed as part of the card
     * @return a <code> string </code> that displays the cost of the card
     */

    public String generateCostString() {
        String act = "(" + Integer.toString(cost) + ")";
        return StringUtils.rightPad(act, 22, " ");
    }

    /**
     * Generates the current establishment card as a <code> string </code>
     * @return a <code> string </code> that displays the establishment card
     */

    @Override
    public String toString() {
       return ".-----------------------.\n"+
        "| <" + color_ab + ">" + generateActivationString() + "{" + icon_ab + "} |\n" +
        generate_single_line(name) +
        generate_single_line(" ") +
        description +
        generate_single_line(" ") +
        "| " + generateCostString() + "|\n" +
               "|_______________________|";
    }



    public static void main(String[] args) {
        //**********Establishment wheat field creation************//
        Establishment wheat = new Establishment("Wheat Field", 1, Color.BLUE, Color_ab.B,Icon.WHEAT, Icon_ab.W,
                "|  Get 1 coin from the  |\n" +
                          "|         bank.         |\n" +
                          "|    (anyone's turn)    |\n",
                "1", "receive", "bank", 1, "none", "none");

        //**********Establishment ranch creation************//
        Establishment ranch = new Establishment("Ranch", 1, Color.BLUE, Color_ab.B, Icon.COW, Icon_ab.C,
                "|  Get 1 coin from the  |\n" +
                          "|         bank.         |\n" +
                          "|    (anyone's turn)    |\n",
                "2", "receive", "bank", 1, "none", "none");

        //**********Establishment bakery creation************//
        Establishment bakery = new Establishment("Bakery", 1, Color.GREEN, Color_ab.G, Icon.BREAD,Icon_ab.B,
                "|  Get 1 coin from the  |\n" +
                          "|         bank.         |\n" +
                          "|   (your turn only)    |\n",
                "2-3", "receive", "bank", 1, "none", "none");

        //**********Establishment cafe creation************//
        Establishment cafe = new Establishment("Cafe", 2, Color.RED,Color_ab.R, Icon.CUPU,Icon_ab.U,
                "| Take 1 coin from the  |\n" +
                          "|    active player.     |\n" +
                          "|   (opponent's turn)   |\n",
                "3", "receive", "active", 1, "none", "none");

        //**********Establishment convenience store creation************//
        Establishment convenience = new Establishment("Convenience Store", 2, Color.GREEN,Color_ab.G, Icon.BREAD, Icon_ab.B,
                "| Get 3 coins from the  |\n" +
                          "|         bank.         |\n" +
                          "|   (your turn only)    |\n",
                "4", "receive", "bank", 3, "none", "none");

        //**********Establishment forest creation************//
        Establishment forest = new Establishment("Forest",
                3, Color.BLUE,Color_ab.B, Icon.GEAR,Icon_ab.G,
                "|  Get 1 coin from the  |\n" +
                          "|         bank.         |\n" +
                          "|    (anyone's turn)    |\n",
                "5", "receive", "bank", 1, "none", "none");

        //**********Establishment stadium creation************//
        Establishment stadium = new Establishment("Stadium",
                6, Color.PURPLE, Color_ab.P,Icon.TOWER,Icon_ab.T,
                "|   Take 2 coins from   |\n" +
                          "|    each opponent.     |\n" +
                          "|   (your turn only)    |\n",
                "6", "receive", "others", 2, "none", "none");

        //**********Establishment TV Station creation************//
        Establishment tv = new Establishment("TV Station",
                7, Color.PURPLE,Color_ab.P, Icon.TOWER,Icon_ab.T,
                "| Take 5 coins from an  |\n" +
                          "|       opponent.       |\n" +
                          "|   (your turn only)    |\n",
                "6", "receive", "choice", 5, "none", "none");

        //**********Establishment Business Complex creation************//
        Establishment business = new Establishment("Business Complex", 8, Color.PURPLE,Color_ab.P, Icon.TOWER,Icon_ab.T,
                "| Exchange one of your  |\n" +
                          "|       non-tower       |\n" +
                          "| establishments for 1  |\n" +
                          "|   an opponent owns.   |\n" +
                          "|   (your turn only)    |\n",
                "6", "exchange", "choice", 0, "none", "none");

        //**********Establishment Cheese Factory creation************//
        Establishment cheese = new Establishment("Cheese Factory", 5, Color.GREEN,Color_ab.G, Icon.FACTORY,Icon_ab.F,
                "| Get 3 coins from the  |\n" +
                          "|   bank for each {C}   |\n" +
                          "|   establishment you   |\n" +
                          "|         own.          |\n" +
                          "|   (your turn only)    |\n",
                "7", "receive", "bank", 3, "icon", "cow");

        //**********Establishment Furniture Factory creation************//
        Establishment furniture = new Establishment("Furniture Factory", 3, Color.GREEN,Color_ab.G, Icon.FACTORY,Icon_ab.F,
                "| Get 3 coins from the  |\n" +
                          "|   bank for each {G}   |\n" +
                          "|   establishment you   |\n" +
                          "|         own.          |\n" +
                          "|   (your turn only)    |\n",
                "8", "receive", "bank", 3, "icon", "gear");

        //**********Establishment mine creation************//
        Establishment mine = new Establishment("Mine", 6, Color.BLUE,Color_ab.B, Icon.GEAR,Icon_ab.G,
                "| Get 5 coins from the  |\n" +
                          "|         bank.         |\n" +
                          "|    (anyone's turn)    |\n",
                "9", "receive", "bank", 5, "none", "none");

        //**********Establishment restaurant creation************//
        Establishment restaurant = new Establishment("Family Restaurant", 3, Color.RED,Color_ab.R, Icon.CUPU,Icon_ab.U,
                "| Take 2 coins from the |\n" +
                          "|    active player.     |\n" +
                          "|   (opponent's turn)   |\n",
                "9-10", "receive", "active", 2, "none", "none");

        //**********Establishment orchard creation************//
        Establishment orchard = new Establishment("Apple Orchard", 3, Color.BLUE,Color_ab.B, Icon.WHEAT,Icon_ab.W,
                "| Get 3 coins from the  |\n" +
                          "|         bank.         |\n" +
                          "|    (anyone's turn)    |\n",
                "10", "receive", "bank", 3, "none", "none");

        //**********Establishment market creation************//
        Establishment market = new Establishment("Farmers Market", 2, Color.GREEN,Color_ab.G, Icon.FRUITO,Icon_ab.O,
                "| Get 2 coins from the  |\n" +
                          "|   bank for each {W}   |\n" +
                          "|   establishment you   |\n" +
                          "|         own.          |\n" +
                          "|   (your turn only)    |\n",
                "11-12", "receive", "bank", 2, "icon", "wheat");


        System.out.println(wheat.toString() + "\n");
        System.out.println(ranch.toString()+ "\n");
        System.out.println(bakery.toString()+ "\n");
        System.out.println(cafe.toString()+ "\n");
        System.out.println(convenience.toString()+ "\n");
        System.out.println(forest.toString()+ "\n");
        System.out.println(stadium.toString()+ "\n");
        System.out.println(tv.toString()+ "\n");
        System.out.println(business.toString()+ "\n");
        System.out.println(cheese.toString()+ "\n");
        System.out.println(furniture.toString()+ "\n");
        System.out.println(mine.toString()+ "\n");
        System.out.println(restaurant.toString()+ "\n");
        System.out.println(orchard.toString()+ "\n");
        System.out.println(market.toString()+ "\n");

    }
}