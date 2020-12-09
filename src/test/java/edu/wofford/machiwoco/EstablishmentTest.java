package edu.wofford.machiwoco;

import io.cucumber.java.jv.Lan;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EstablishmentTest {

    Establishment bakery;
    Establishment stadium;

    @Test
    public void testSomething() {
        assertThat(1, is(1));
    }

    @Before
    public void before() {

        // bakery creation
         bakery = new Establishment("Bakery", 1, Card.Color.GREEN,Card.Color_ab.G, Card.Icon.BREAD,Card.Icon_ab.B,
                "|  Get 1 coin from the  |\n" +
                        "|         bank.         |\n" +
                        "|   (your turn only)    |\n",
                "2-3", "receive", "bank", 1, "none", "none");

        // stadium creation
         stadium = new Establishment("Stadium",
                6, Card.Color.PURPLE, Card.Color_ab.P, Card.Icon.TOWER, Card.Icon_ab.T,
                "|   Take 2 coins from   |\n" +
                        "|    each opponent.     |\n" +
                        "|   (your turn only)    |\n",
                "6", "receive", "others", 2, "none", "none");
    }

    @Test
    public void testRangedActionToString() {
        assertThat(bakery.toString(), is( ".-----------------------.\n| <G>     [2-3]     {B} |\n|        Bakery         |\n|                       |\n|  Get 1 coin from the  |\n|         bank.         |\n|   (your turn only)    |\n|                       |\n| (1)                   |\n|_______________________|"));
    }

    @Test
    public void testToString() {
        assertThat(stadium.toString(), is(".-----------------------.\n| <P>      [6]      {T} |\n|        Stadium        |\n|                       |\n|   Take 2 coins from   |\n|    each opponent.     |\n|   (your turn only)    |\n|                       |\n| (6)                   |\n|_______________________|"));
    }
}
