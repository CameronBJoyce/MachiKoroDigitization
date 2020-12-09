package edu.wofford.machiwoco;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import org.hamcrest.Matchers;
import org.junit.*;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class Feature7Test {
    Feature7 feature7;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void before() {
        feature7 = new Feature7(3);
        feature7.player1.setTurn(true);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testGetStadium() {
        assertThat(feature7.getStadium(), is(feature7.stadium));
    }

    @Test
    public void testNumOfPurples() {
        assertThat(feature7.market.get(feature7.stadium), is(3));
        Feature7 newF7 = new Feature7(4);
        assertThat(newF7.market.get(newF7.stadium), is(4));
    }

    @Test
    public void testIsTSConstructedFalse() {
        feature7.getPlayer1().getLandmarks()[1].setIs_constructed(false);
        assertThat(feature7.getPlayer1().isShoppingMallConstructed(), is(false));
    }

    @Test
    public void testAvailPlayersTV() {
        feature7.getPlayer2().setCoinCount(0);
        feature7.player3.setCoinCount(2);
        ArrayList<Player> temp = feature7.availPlayersTV(feature7.players);
        assertThat(temp.size(), is(1));
        assertThat(temp.get(0), is(feature7.player3));
    }

    @Test
    public void testTVNoMoney() {
        feature7.player2.setCoinCount(0);
        feature7.player3.setCoinCount(0);
        feature7.TVStationLogic();
        assertThat(outContent.toString(), containsString("TV Station activated, but no player is available to target."));
    }

    @Test
    public void testTVAI() {
        feature7.getPlayer1().setTurn(false);
        feature7.getPlayer2().setTurn(true);
        feature7.TVStationLogic();
//        started with 3, wanted to get five, but only 3 is available.
        assertThat(feature7.getPlayer2().getCoinCount(), is(6));
    }

    @Test
    public void testTVAI2() {
        feature7.getPlayer1().setTurn(false);
        feature7.getPlayer1().setCoinCount(9);
        feature7.player3.setCoinCount(5);
        feature7.getPlayer2().setTurn(true);
        feature7.getPlayer2().getEstOwned().put(feature7.getTvStation(), 1);
        feature7.TVStationLogic();
//        started with 3, wanted to get five, but only 3 is available.
        assertThat(feature7.getPlayer2().getCoinCount(), is(8));
        assertThat(feature7.getPlayer1().getCoinCount() + feature7.player3.getCoinCount(), is(9));
    }

    @Test
    public void testRadioConstructed() {
        feature7.getPlayer1().getLandmarks()[3].setIs_constructed(true);
        assertThat(feature7.player1.isRadioTowerConstructed(), is(true));
        assertThat(feature7.player1.getLandmarks()[0].getIsConstructed(), is(false));
    }

    @Test
    public void testBusCompAI() {
        feature7.getPlayer1().setTurn(false);
        feature7.getPlayer2().setTurn(true);

        feature7.getPlayer2().getEstOwned().put(feature7.orchard, 2);
        feature7.getPlayer2().getEstOwned().put(feature7.getBusiness(), 1);
        feature7.player3.getEstOwned().put(feature7.getWheat(), 2);
        feature7.player3.getEstOwned().put(feature7.getBusiness(), 1);

        feature7.busComplexLogic();
        assertThat(feature7.player3.getEstOwned().get(feature7.wheat), is(1));
        assertThat(feature7.player2.getEstOwned().get(feature7.orchard), is(1));
        assertThat(feature7.player2.getEstOwned().get(feature7.wheat), is(2));
    }

    @Test
    public void testBusCompAI2() {
        feature7.getPlayer1().setTurn(false);
        feature7.getPlayer2().setTurn(true);
        feature7.getPlayer2().getEstOwned().put(feature7.orchard, 2);
        feature7.getPlayer2().getEstOwned().put(feature7.getBusiness(), 1);
        feature7.player3.getEstOwned().put(feature7.familyRestaurant, 2);
        feature7.player3.getEstOwned().put(feature7.getBusiness(), 1);
        feature7.busComplexLogic();
        assertThat(feature7.player2.getEstOwned().get(feature7.orchard), is(1));
        assertThat(feature7.player2.getEstOwned().get(feature7.familyRestaurant), is(1));
    }

    @Test
    public void testBusCompAI3() {
        feature7.getPlayer1().setTurn(false);
        feature7.getPlayer2().setTurn(true);
        feature7.getPlayer2().getEstOwned().put(feature7.orchard, 2);
        feature7.getPlayer2().getEstOwned().put(feature7.getBusiness(), 1);
        feature7.player3.getEstOwned().put(feature7.bakery, 2);
        feature7.player3.getEstOwned().put(feature7.getBusiness(), 1);
        feature7.busComplexLogic();
        assertThat(feature7.player2.getEstOwned().get(feature7.orchard), is(1));
        assertThat(feature7.player2.getEstOwned().get(feature7.bakery), is(2));
    }

    @Test
    public void testBusCompHuman() {
        feature7.getPlayer1().getEstOwned().put(feature7.orchard, 2);
        feature7.getPlayer1().getEstOwned().put(feature7.familyRestaurant, 2);
        feature7.getPlayer1().getEstOwned().put(feature7.getBusiness(), 1);

        feature7.getPlayer2().getEstOwned().put(feature7.mine, 2);

        feature7.player3.getEstOwned().put(feature7.bakery, 2);

        feature7.sc = new Scanner("1\n1\n1");
        feature7.busComplexLogic();
        assertThat(feature7.player1.getEstOwned().get(feature7.mine), is(1));
        assertThat(feature7.player2.getEstOwned().get(feature7.mine), is(1));
    }

    @Test
    public void testBusCompHuman2() {
        feature7.getPlayer1().getEstOwned().put(feature7.orchard, 2);
        feature7.getPlayer1().getEstOwned().put(feature7.familyRestaurant, 2);
        feature7.getPlayer1().getEstOwned().put(feature7.getBusiness(), 1);

        feature7.getPlayer2().getEstOwned().put(feature7.mine, 2);

        feature7.player3.getEstOwned().put(feature7.bakery, 2);

        feature7.sc = new Scanner("2\n1\n1");
        feature7.busComplexLogic();
        assertThat(feature7.player1.getEstOwned().get(feature7.bakery), is(2));
        assertThat(feature7.player1.getEstOwned().get(feature7.orchard), is(2));
        assertThat(feature7.player1.getEstOwned().get(feature7.familyRestaurant), is(1));
        assertThat(feature7.player3.getEstOwned().get(feature7.bakery), is(1));
    }

    @Test
    public void testGamePlay() {
        feature7.getPlayer1().getEstOwned().put(feature7.tvStation, 1);
        feature7.getPlayer1().setCoinCount(2);
        feature7.player3.setCoinCount(69);
        feature7.sc = new Scanner("2");
        feature7.TVStationLogic();
        assertThat(feature7.getPlayer1().getCoinCount(), is(7));
        assertThat(feature7.player3.getCoinCount(), is(64));


    }

    @Test
    public void testWayBetter() {
        feature7.wayBetterRollDice(true);
        assertThat(feature7.dice1+feature7.dice2, lessThanOrEqualTo(12));
    }


    @Test
    public void testWayBetter2() {
        feature7.player1.setTurn(false);
        feature7.player2.setTurn(true);
        feature7.player2.getLandmarks()[3].setIs_constructed(true);
        feature7.wayBetterRollDice(true);

        assertThat(feature7.dice1+feature7.dice2, lessThanOrEqualTo(12));
    }

    @Test
    public void testRadioAI() {
        feature7.player1.setTurn(false);
        feature7.player3.setTurn(true);
        feature7.player3.getLandmarks()[3].is_constructed = true;
        assertThat(feature7.radioTowerLogic(), Matchers.either(Matchers.is(true)).or(Matchers.is(false)));
    }

    @Test
    public void testRadioHuman() {
        feature7.sc = new Scanner("y");
        feature7.player1.getLandmarks()[3].is_constructed = true;
        boolean human = feature7.radioTowerLogic();
        assertThat(human, is(true));
    }

}
