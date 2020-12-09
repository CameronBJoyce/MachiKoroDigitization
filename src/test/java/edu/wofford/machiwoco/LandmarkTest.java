package edu.wofford.machiwoco;

import io.cucumber.java.jv.Lan;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;


public class LandmarkTest {

    Landmark l;
    Landmark trainStation;
    @Test
    public void testSomething() {
        assertThat(1, is(1));
    }

    @Before
    public void before() {
        l = new Landmark("Test", 1, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T, "Test");

        // trainStation creation
        trainStation = new Landmark("Train Station", 4, Card.Color.NONE, Card.Color_ab.N, Card.Icon.TOWER, Card.Icon_ab.T,
                "|  You may roll 1 or 2  |\n" +
                "|         dice.         |\n");
        trainStation.color_ab = Card.Color_ab.N;
        trainStation.icon_ab = Card.Icon_ab.T;
    }

    @Test
    public void testGenerateSignleline() {
        assertThat(l.generate_single_line("Train Station"),
                is("|     Train Station     |\n"));
    }

    @Test
    public void testTrainStationToString() {
        assertThat(trainStation.toString(), is(".-----------------------.\n" +
                "| <N>   LANDMARK    {T} |\n" +
                "|     Train Station     |\n" +
                "|                       |\n" +
                "|  You may roll 1 or 2  |\n" +
                "|         dice.         |\n" +
                "|                       |\n" +
                "| (4)               [ ] |\n" +
                "|_______________________|"));
    }

//    @Test
//    public void testSetIs_constructed(boolean is_constructed) {
//        //assertThat()
//    }




//    @Test
//    public void testGenerateBlocks() {
//        String[] s = new String[2];
//        s[0] = "You may roll 1 or 2";
//        s[1] = "dice.";
//        assertThat(l.generate_blocks("You may roll 1 or 2 "),
//                is(s));
//    }
}