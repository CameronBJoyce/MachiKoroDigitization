package edu.wofford.machiwoco;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.aMapWithSize;
import static org.hamcrest.Matchers.is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import org.junit.*;

import static org.hamcrest.CoreMatchers.*;

public class ConsoleListenerTest {
    ConsoleListener c;
    TwoPlayersPhase1 t;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    Establishment farmersMarket;
    Establishment bakery;
    Establishment cheeseFactory;
    Establishment furniture;
    Map<Establishment, Integer> est;


    @Before
    public void before() {
        c = new ConsoleListener();
        t = new TwoPlayersPhase1(false,2);
         farmersMarket = new Establishment("Farmers Market", 2, Card.Color.GREEN, Card.Color_ab.G, Card.Icon.FRUITO, Card.Icon_ab.O,
                "| Get 2 coins from the  |\n" +
                        "|   bank for each {W}   |\n" +
                        "|   establishment you   |\n" +
                        "|         own.          |\n" +
                        "|   (your turn only)    |\n",
                "11-12", "receive", "bank", 2, "icon", "wheat");

         bakery = new Establishment("Bakery", 1, Card.Color.GREEN, Card.Color_ab.G, Card.Icon.BREAD, Card.Icon_ab.B,
                "|  Get 1 coin from the  |\n" +
                        "|         bank.         |\n" +
                        "|   (your turn only)    |\n",
                "2-3", "receive", "bank", 1, "none", "none");

         cheeseFactory = new Establishment("Cheese Factory", 5, Card.Color.GREEN, Card.Color_ab.G, Card.Icon.FACTORY, Card.Icon_ab.F,
                "| Get 3 coins from the  |\n" +
                        "|   bank for each {C}   |\n" +
                        "|   establishment you   |\n" +
                        "|         own.          |\n" +
                        "|   (your turn only)    |\n",
                "7", "receive", "bank", 3, "icon", "cow");

         furniture = new Establishment("Furniture Factory", 3, Card.Color.GREEN, Card.Color_ab.G, Card.Icon.FACTORY, Card.Icon_ab.F,
                "| Get 3 coins from the  |\n" +
                        "|   bank for each {G}   |\n" +
                        "|   establishment you   |\n" +
                        "|         own.          |\n" +
                        "|   (your turn only)    |\n",
                "8", "receive", "bank", 3, "icon", "gear");


        est = new HashMap<>();

        // capturing system outputs
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testOneDiceRoll() {
        c.diceRolled(2, 0, t.getPlayer1());
        assertThat(outContent.toString(), containsString("Player 1 rolled [2] = 2."));
    }

    @Test
    public void testTwoDiceRoll() {
        c.diceRolled(2, 3, t.getPlayer2());
        assertThat(outContent.toString(), containsString("Player 2 rolled [2][3] = 5."));
    }

    @Test
    public void testRanchActivation() {
        est.put(t.getRanch(), 1);
        t.player2.setEstOwned(est);
        c.diceActivation(2,  t.getPlayers());
        assertThat(outContent.toString(), containsString("Ranch activated for Player 2"));
    }

    @Test
    public void testRanchAndBakeryActivation() {
        est.put(t.getRanch(), 1);
        est.put(bakery, 1);
        t.player2.setEstOwned(est);
        t.player2.setTurn(true);
        c.diceActivation(2,  t.getPlayers());
        assertThat(outContent.toString(), containsString("Ranch activated for Player 2"));
        assertThat(outContent.toString(), containsString("Bakery activated for Player 2"));
    }

    @Test
    public void testFarmersMarket11() {
        est.put(farmersMarket, 1);
        t.player2.setEstOwned(est);
        t.player2.setTurn(true);
        c.diceActivation(11,  t.getPlayers());
        assertThat(outContent.toString(), containsString("Farmers Market activated for Player 2"));
        c.diceActivation(12,  t.getPlayers());
        assertThat(outContent.toString(), containsString("Farmers Market activated for Player 2"));
    }

    @Test
    public void testFarmersMarket12() {
        est.put(farmersMarket, 1);
        t.player2.setEstOwned(est);
        t.player2.setTurn(true);
        c.diceActivation(12,  t.getPlayers());
        assertThat(outContent.toString(), containsString("Farmers Market activated for Player 2"));
    }

    @Test
    public void testCheeseFactory() {
        est.put(cheeseFactory, 1);
        t.player2.setEstOwned(est);
        t.player2.setTurn(true);
        c.diceActivation(7,  t.getPlayers());
        assertThat(outContent.toString(), containsString("Cheese Factory activated for Player 2"));
    }

    @Test
    public void testFurniture() {
        est.put(furniture, 1);
        t.player2.setEstOwned(est);
        t.player2.setTurn(true);
        c.diceActivation(8,  t.getPlayers());
        assertThat(outContent.toString(), containsString("Furniture Factory activated for Player 2"));
    }


    @Test
    public void testBakery() {
        est.put(bakery, 1);
        t.player2.setEstOwned(est);
        t.player2.setTurn(true);
        c.diceActivation(3,  t.getPlayers());
        assertThat(outContent.toString(), containsString("Bakery activated for Player 2"));
    }

    @Test
    public void testNotTurn() {
        est.put(bakery, 1);
        t.player2.setEstOwned(est);
        t.player2.setTurn(false);
        c.diceActivation(3,  t.getPlayers());
        assertThat(outContent.toString(), not(containsString("Bakery activated for Player 2")));
    }

    @Test
    public void testRollTwo2() {
        Scanner sc = new Scanner("2");
        assertThat(c.rollTwo(sc, t.player2), is(true));
    }

    @Test
    public void testRollTwo1() {
        Scanner sc = new Scanner("1");
        assertThat(c.rollTwo(sc, t.player2), is(false));
    }

    @Test
    public void testTargetPlayer() {
        Feature7 feature7 = new Feature7(3);
        Scanner sc = new Scanner("2");
        feature7.getPlayer1().setTurn(true);
        c.playerChooseTarget(feature7.EST_ORDER, sc, feature7.player1, feature7.getPlayers(), true);
        assertThat(outContent.toString(), containsString("2. Player 3"));
        //assertThat(outContent.toString(), containsString("size: 3"));
        
    }

    @Test
    public void testStadiumActivationOutput() {
        Feature7 feature7 = new Feature7(3);
        est.put(feature7.stadium, 1);
        feature7.getPlayer1().setEstOwned(est);
        feature7.getPlayer1().setTurn(true);
        c.diceActivation(6, feature7.getPlayers());
        assertThat(outContent.toString(), containsString("Stadium activated for Player 1"));
    }

    @Test
    public void testRestaurantActivationOutput() {
        Feature6 feature6 = new Feature6(3);
        est.put(feature6.familyRestaurant, 1);
        feature6.getPlayer1().setEstOwned(est);
        feature6.getPlayer1().setTurn(false);
        c.diceActivation(9, feature6.getPlayers());
        assertThat(outContent.toString(), containsString("Family Restaurant activated for Player 1"));
    }

    @Test
    public void testRestaurantActivationOutput10() {
        Feature6 feature6 = new Feature6(3);
        est.put(feature6.familyRestaurant, 1);
        feature6.getPlayer1().setEstOwned(est);
        feature6.getPlayer1().setTurn(false);
        c.diceActivation(10, feature6.getPlayers());
        assertThat(outContent.toString(), containsString("Family Restaurant activated for Player 1"));
    }

//    @Test
//    public void testBusinessActivation() {
//        Feature7 feature7 = new Feature7(3);
//        Scanner sc = new Scanner("1");
//        feature7.getPlayer1().setTurn(true);
////        assertThat(feature7.EST_ORDER.size(), is (15));
////        assertThat(feature7.player1.getEstOwned().size(), is (2));
//
//        c.playerChooseTarget(feature7.EST_ORDER, sc, feature7.player1, feature7.getPlayers(), false);
//        assertThat(outContent.toString(), containsString("Business Complex activated for Player 1"));
//    }

    @Test
    public void testBusinessActivation() {
        Feature7 feature7 = new Feature7(3);
        Scanner sc = new Scanner("1");
        feature7.getPlayer1().setTurn(true);
//        assertThat(feature7.EST_ORDER.size(), is (15));
//        assertThat(feature7.player1.getEstOwned().size(), is (2));
        feature7.getPlayer2().getEstOwned().put(feature7.wheat, 2);
        feature7.player3.getEstOwned().put(feature7.orchard, 1);

        c.playerChooseTarget(feature7.EST_ORDER, sc, feature7.player1, feature7.getPlayers(), false);
        assertThat(outContent.toString(), containsString("1. Player 2"));
        assertThat(outContent.toString(), containsString("2. Player 3"));
    }

    @Test
    public void testBusinessActivationOnlyStartNPurple() {
        Feature7 feature7 = new Feature7(3);
        Scanner sc = new Scanner("1");
        feature7.getPlayer1().setTurn(true);
        feature7.player2.getEstOwned().put(feature7.orchard, 1);
        feature7.getPlayer2().getEstOwned().put(feature7.businessComplex,1);
        feature7.player3.getEstOwned().put(feature7.stadium, 1);

        c.playerChooseTarget(feature7.EST_ORDER, sc, feature7.player1, feature7.getPlayers(), false);
        assertThat(outContent.toString(), containsString("1. Player 2"));
        assertThat(outContent.toString(), not(containsString("Player 3")));
    }

    @Test
    public void testBusinessCenterEstPrint() {
        Feature7 feature7 = new Feature7(3);
        feature7.getPlayer1().setTurn(false);
        feature7.getPlayer2().getEstOwned().put(feature7.forest, 2);
        feature7.getPlayer2().setTurn(true);
        c.playerChooseEst(new Scanner("1"), feature7.getPlayer2(), feature7.availEstBusComplex(feature7.player2), feature7.getCurrentPlayer().getPlayerNumber());
//        assertThat(feature7.EST_ORDER.size(), is(15));
//        c.playerChooseEst(new Scanner("1"), feature7.getPlayer1(), feature7.availEstBusComplex()(feature7.player1), feature7.getCurrentPlayer().getPlayerNumber());

        assertThat(outContent.toString(), not(containsString("1. Wheat Field")));
        assertThat(outContent.toString(), not(containsString("2. Bakery")));
        assertThat(outContent.toString(), containsString("1. Forest"));
    }

    @Test
    public void testBusinessCenterPurple() {
        Feature7 feature7 = new Feature7(3);
        feature7.getPlayer1().setTurn(false);
        feature7.getPlayer1().getEstOwned().put(feature7.forest, 2);
        feature7.getPlayer1().getEstOwned().put(feature7.wheat, 3);
        feature7.getPlayer1().getEstOwned().put(feature7.tvStation, 1);
        feature7.getPlayer1().getEstOwned().put(feature7.farmersMarket, 1);
        feature7.getPlayer2().setTurn(true);
        c.playerChooseEst(new Scanner("1"), feature7.getPlayer1(), feature7.availEstBusComplex(feature7.player1), feature7.getCurrentPlayer().getPlayerNumber());
        assertThat(outContent.toString(), containsString("1. Wheat Field"));
        assertThat(outContent.toString(), containsString("2. Forest"));
        assertThat(outContent.toString(), not(containsString("TV Station")));
        assertThat(outContent.toString(), not(containsString("Bakery")));
    }

    @Test
    public void testPlayerChooseReroll() {
        Feature7 feature7 = new Feature7(3);
        boolean temp = c.playerChooseReroll(new Scanner("Y"), feature7.player1);
        assertThat(outContent.toString(), containsString("would you like to reroll the dice? (y/n):"));
        assertThat(temp, is(true));

    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
