package edu.wofford.machiwoco;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import org.junit.*;

import static org.hamcrest.CoreMatchers.*;

public class ActivationListenerTest {
    ActivationListener a;
    TwoPlayersPhase1 t;
    Establishment bakery;
    Feature5 f5;
    Feature6 f6;
    Feature6 fourPlayers;
    Feature7 f7;


    @Before
    public void before() {
        a = new ActivationListener();
        t = new TwoPlayersPhase1(false,2);
         bakery = new Establishment("Bakery", 1, Card.Color.GREEN, Card.Color_ab.G, Card.Icon.BREAD, Card.Icon_ab.B,
                "|  Get 1 coin from the  |\n" +
                        "|         bank.         |\n" +
                        "|   (your turn only)    |\n",
                "2-3", "receive", "bank", 1, "none", "none");
        f5 = new Feature5(3);
        f6 = new Feature6(3);
        fourPlayers = new Feature6(4);
        f7 = new Feature7(3);
    }

    @Test
    public void testWheatAct() {
        a.diceActivation(1, t.getPlayers());
        assertThat(t.player1.getCoinCount(), is(4));
        assertThat(t.player2.getCoinCount(), is(4));
    }

    @Test
    public void testRanchAct() {
        t.player2.getEstOwned().put(t.ranch, 1);
        a.diceActivation(2, t.getPlayers());
        assertThat(t.player1.getCoinCount(), is(3));
        assertThat(t.player2.getCoinCount(), is(4));
    }

    @Test
    public void testBakeryRanchAct() {
        t.player1.setTurn(false);
        t.player2.getEstOwned().put(t.ranch, 1);
        t.player2.getEstOwned().put(bakery, 1);
        t.player1.getEstOwned().put(bakery, 1);
        t.player2.setTurn(true);
        a.diceActivation(2, t.getPlayers());
        assertThat(t.player1.getCoinCount(), is(3));
        assertThat(t.player2.getCoinCount(), is(5));
    }

    @Test
    public void testTakeMoneySufficient() {
        t.player1.setCoinCount(10);
        t.player2.setCoinCount(1);
        a.takeMoney(t.player1, t.player2, 4);
        assertThat(t.player1.getCoinCount(), is(6));
        assertThat(t.player2.getCoinCount(), is(5));
    }

    @Test
    public void testTakeMoneyNotSufficient() {
        t.player1.setCoinCount(10);
        t.player2.setCoinCount(1);
        a.takeMoney(t.player2, t.player1, 4);
        assertThat(t.player1.getCoinCount(), is(11));
        assertThat(t.player2.getCoinCount(), is(0));
    }

    @Test
    public void testNonActivePlayers() {
        t.player1.setTurn(false);
        t.player2.setTurn(true);
        assertThat(a.nonActivePlayers(t.players).size(), is(1));
        assertThat(a.nonActivePlayers(t.players).get(0), is(t.player1));
    }

    @Test
    public void testTwoNonActivePlayers() {
        f5.player1.setTurn(false);
        f5.player2.setTurn(true);
        assertThat(a.nonActivePlayers(f5.players).size(), is(2));
        assertThat(a.nonActivePlayers(f5.players).get(1), is(f5.player3));
        assertThat(a.nonActivePlayers(f5.players).get(0), is(f5.player1));
    }


    @Test
    public void testTwoNonActivePlayers3() {
        f5.player1.setTurn(false);
        f5.player3.setTurn(true);
        assertThat(a.nonActivePlayers(f5.players).size(), is(2));
        assertThat(a.nonActivePlayers(f5.players).get(1), is(f5.player1));
        assertThat(a.nonActivePlayers(f5.players).get(0), is(f5.player2));
    }

    @Test
    public void testTakeMoney() {
        f6.player1.setTurn(false);
        f6.player2.setTurn(true);
        f6.player1.getEstOwned().put(f6.getCafe(), 1);
        a.diceActivation(3, f6.players);
        assertThat(f6.player1.getCoinCount(), is(4));
    }

    @Test
    public void testTakeMoneyNotEnough() {
        f6.player1.setTurn(false);
        f6.player2.setTurn(true);
        f6.player2.setCoinCount(2);
        f6.player1.getEstOwned().put(f6.getCafe(), 3);
        a.diceActivation(3, f6.players);
        assertThat(f6.player1.getCoinCount(), is(5));
        assertThat(f6.player2.getCoinCount(), is(1));
    }

    @Test
    public void testTakeMoney3Player() {
        f6.player1.setTurn(false);
        f6.player2.setTurn(true);
        f6.player2.setCoinCount(5);
        f6.player1.getEstOwned().put(f6.getCafe(), 3);
        f6.player3.getEstOwned().put(f6.getCafe(), 4);
        a.diceActivation(3, f6.players);
        assertThat(f6.player1.getCoinCount(), is(6));
        assertThat(f6.player3.getCoinCount(), is(5));
        assertThat(f6.player2.getCoinCount(), is(1));
    }

    @Test
    public void testTakeMoneyFamRest() {
        f6.player1.setTurn(false);
        f6.player2.setTurn(true);
        f6.player2.setCoinCount(5);
        f6.player1.getEstOwned().put(f6.getFamilyRestaurant(), 2);
        a.diceActivation(9, f6.players);
        assertThat(f6.player1.getCoinCount(), is(7));
    }

    @Test
    public void testTakeMoneyFamRestNoMoney() {
        f6.player1.setTurn(false);
        f6.player2.setTurn(true);
        f6.player2.setCoinCount(3);
        f6.player1.getEstOwned().put(f6.getFamilyRestaurant(), 2);
        a.diceActivation(10, f6.players);
        assertThat(f6.player1.getCoinCount(), is(6));
    }

    @Test
    public void testTakeMoneyFamRestShopMall() {
        f6.player1.setTurn(false);
        f6.player2.setTurn(true);
        f6.player2.setCoinCount(10);
        f6.player1.getEstOwned().put(f6.getFamilyRestaurant(), 2);
        f6.player1.getLandmarks()[1].is_constructed = true;
        a.diceActivation(9, f6.players);
        assertThat(f6.player1.getCoinCount(), is(9));
    }

    @Test
    public void testTakeMoneyFamRestShopMallNoMoney() {
        f6.player1.setTurn(false);
        f6.player2.setTurn(true);
        f6.player2.setCoinCount(5);
        f6.player1.getEstOwned().put(f6.getFamilyRestaurant(), 2);
        f6.player1.getLandmarks()[1].is_constructed = true;
        a.diceActivation(9, f6.players);
        assertThat(f6.player1.getCoinCount(), is(8));
        assertThat(f6.player2.getCoinCount(), is(0));
    }

    @Test
    public void testTakeMoneyFamRestShopMallMine() {
        f6.player1.setTurn(false);
        f6.player2.setTurn(true);
        f6.player2.setCoinCount(5);
        f6.player1.getEstOwned().put(f6.getFamilyRestaurant(), 2);
        f6.player2.getEstOwned().put(f6.getMine(), 3);
        f6.player1.getLandmarks()[1].is_constructed = true;
        a.diceActivation(9, f6.players);
        assertThat(f6.player1.getCoinCount(), is(8));
        assertThat(f6.player2.getCoinCount(), is(15));
    }

    @Test
    public void testCoinCountError() {
        fourPlayers.player1.setTurn(false);
        fourPlayers.player3.setTurn(true);

//        fourPlayers.player1.setCoinCount(10);
        fourPlayers.player2.setCoinCount(11);
        fourPlayers.player3.setCoinCount(14);
        fourPlayers.player4.setCoinCount(11);

//        fourPlayers.player3.getLandmarks()[0].is_constructed = true;
//        fourPlayers.player3.getLandmarks()[2].is_constructed = true;

        fourPlayers.player2.getEstOwned().put(fourPlayers.getCafe(), 1);
        fourPlayers.player4.getEstOwned().put(fourPlayers.getCafe(), 1);
        fourPlayers.player3.getEstOwned().put(fourPlayers.getBakery(), 3);
        a.diceActivation(3, fourPlayers.players);
        fourPlayers.player3.buyCard(fourPlayers.cheeseFactory);
        assertThat(fourPlayers.player3.getCoinCount(), is(10));
       // assertThat(f6.player2.getCoinCount(), is(15));

    }

    @Test
    public void testStadiumLogic() {
        f7.player1.setTurn(false);
        ArrayList<Player> p = new ArrayList<>();
        p.add(f7.player1);
        p.add(f7.player2);

        f7.player1.setCoinCount(3);
        f7.player2.setCoinCount(3);
        f7.player3.setCoinCount(3);

        f7.player3.setTurn(true);

        f7.player1.getEstOwned().put(f7.getStadium(), 1);
        a.stadiumLogic(f7.player3,p);

        assertThat(f7.player3.getCoinCount(), is(7));
        // assertThat(f6.player2.getCoinCount(), is(15));
    }

    @Test
    public void testStadiumOverflow() {
        f7.player1.setTurn(false);
        ArrayList<Player> p = new ArrayList<>();
        p.add(f7.player1);
        p.add(f7.player2);

        f7.player1.setCoinCount(1);
        f7.player2.setCoinCount(3);
        f7.player3.setCoinCount(3);

        f7.player3.setTurn(true);

        f7.player1.getEstOwned().put(f7.getStadium(), 1);
        a.stadiumLogic(f7.player3,p);
        assertThat(f7.player3.getCoinCount(), is(6));
        // assertThat(f6.player2.getCoinCount(), is(15));
    }
}
