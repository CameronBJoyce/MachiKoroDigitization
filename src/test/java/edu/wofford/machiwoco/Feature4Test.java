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

public class Feature4Test {
    Feature4 feature4;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void before() {
        feature4 = new Feature4(3);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testPlayerNum() {
        // assertThat(feature4.getPlayers().length, is(3));
        assertThat(feature4.getPlayers().size(), is(3));
    }

    @Test
    public void testTrainStationConstructed() {
        Player player = feature4.getPlayer1();
        player.setCoinCount(10);
        player.buyLandmark(player.getLandmarks()[1]);
        assertThat(feature4.isTrainStationConstructed(player), is(true));

        Player player2 = feature4.getPlayer2();
        //assertThat(feature4.isTrainStationConstructed(player2), is(false));
    }

    @Test
    public void testCityHallInit() {
        // Player[] players = feature4.getPlayers();
        ArrayList<Player> players = feature4.getPlayers();
        for (Player p : players) {
            Landmark[] l = p.getLandmarks();
            assertThat(l[0].is_constructed, is(false));
        }
    }
        /************************************************/


//    /**************TRAIN STATION TEST ERRORS************/
        @Test
    public void testTrainStationInit() {
        //Player[] players = feature4.getPlayers();
        ArrayList<Player> players = feature4.getPlayers();
        for (Player p : players) {
            assertThat(p.getLandmarks()[1].is_constructed, is(false));
        }
    }
//        /************************************************/


    @Test
    public void testNoOneTurn() {
        assertThat(feature4.getTurn(), is(0));
    }

    @Test
    public void testNoPlayer() {
        assertThat(feature4.getCurrentPlayer(), is(nullValue()));
    }

    @Test
    public void testEstInput() {
        // feature4.getPlayers()[0].setTurn(true);
        feature4.getPlayers().get(0).setTurn(true);
        assertThat(feature4.getBuyInput(1), is(true));
    }

    @Test
    public void testBuyInput() {
        //feature4.getPlayers()[0].setTurn(true);
        feature4.getPlayers().get(0).setTurn(true);
        assertThat(feature4.handleInput("1"), is(true));
    }

    @Test
    public void testTurnPlayer1() {
        //feature4.getPlayers()[0].setTurn(true);
        feature4.getPlayers().get(0).setTurn(true);
        feature4.endTurn(3);
        //assertThat(feature4.getPlayers()[0].isTurn(), is(false));
        assertThat(feature4.getPlayers().get(0).isTurn(), is(false));
    }

    @Test
    public void testTurnPlayer2() {
        // feature4.getPlayers()[1].setTurn(true);
        feature4.getPlayers().get(1).setTurn(true);
        feature4.endTurn(3);
        //assertThat(feature4.getPlayers()[1].isTurn(), is(false));
        assertThat(feature4.getPlayers().get(1).isTurn(), is(false));
    }
    @Test
    public void testTurnPlayer3() {
        // feature4.getPlayers()[2].setTurn(true);
        feature4.getPlayers().get(2).setTurn(true);
        feature4.endTurn(3);
        // assertThat(feature4.getPlayers()[2].isTurn(), is(false));
        assertThat(feature4.getPlayers().get(2).isTurn(), is(false));
        // assertThat(feature4.getPlayers()[0].isTurn(), is(true));
        assertThat(feature4.getPlayers().get(0).isTurn(), is(true));

    }

    @Test
    public void testMakeMoveAI() {
        // feature4.getPlayers()[1].setAi(true);
        feature4.getPlayers().get(1).setAi(true);
        // feature4.getPlayers()[1].setTurn(true);
        feature4.getPlayers().get(1).setTurn(true);
        feature4.makeMove();
        //String menu = twoPlayersPhase1.getMenu();
        assertThat(outContent.toString(), containsString("Player "+feature4.getPlayer2().getPlayerNumber()));
    }

    @Test
    public void testInitialMarket() {
        Establishment wheat = feature4.getWheat();
        assertThat(feature4.getMarketP2().get(wheat), is(6));

        Establishment ranch = feature4.getRanch();
        assertThat(feature4.getMarketP2().get(ranch), is(6));

        Establishment forest = feature4.getForest();
        assertThat(feature4.getMarketP2().get(forest), is(6));

        Establishment bakery = feature4.getBakery();
        assertThat(feature4.getMarketP2().get(bakery), is(6));

        Establishment convenience = feature4.getConvenience();
        assertThat(feature4.getMarketP2().get(convenience), is(6));

        Establishment mine = feature4.getMine();
        assertThat(feature4.getMarketP2().get(mine), is(6));

        Establishment orchard = feature4.getOrchard();
        assertThat(feature4.getMarketP2().get(orchard), is(6));
    }


    @Test
    public void testInitPlayerCoinCount() {
        // Player[] players = feature4.getPlayers();
        ArrayList<Player> players = feature4.getPlayers();
        int count = 0;
        for (Player p : players) {
            count += p.getCoinCount();
        }
        // assertThat(count, is(3*players.length));
        assertThat(count, is(3*players.size()));
    }


       /***********PLAYER ESTABLISHMENT ERROR*************/
   @Test
   public void testInitPlayerEst() {
    //    Player[] players = feature4.getPlayers();
    ArrayList<Player> players = feature4.getPlayers();
       //players[2].printEstOwned();
       //assertThat(outContent.toString(), containsString("dsigsbighwsb"));
       for (Player p : players) {
           //assertThat(players[0].getEstOwned().get(feature4.getWheat()), is(1));
           assertThat(p.getEstOwned().get(feature4.getWheat()), is(1));
           assertThat(p.getEstOwned().get(feature4.getBakery()), is(1));
           //assertThat(p.getEstOwned().get(p.getEstOwned().keySet().toArray()[0]), is(feature4.getWheat()));  -- is 1
           //assertThat(players[0].getEstOwned().get(players[0].getEstOwned().keySet().toArray()[0]), is(feature4.getWheat()));
           //assertThat(players[1].getEstOwned().get(feature4.getWheat()), is("x"));
            //p.printEstOwned();
        }
   }

   @Test
   public void testMakeMove() {
       feature4.getPlayer1().setTurn(true);
       feature4.sc = new Scanner("1");
       feature4.makeMove();
       assertThat(outContent.toString(), containsString("would you like to purchase"));
   }

   @Test
   public void testHumanInputNoMoney() {
       feature4.getPlayer1().setTurn(true);
       feature4.getPlayer1().setCoinCount(0);
       //feature4.sc = new Scanner("1");
       feature4.makeMove();
       assertThat(outContent.toString(), containsString("did not have enough money"));
   }

   @Test
   public void testAILogicDoNothing() {
       feature4.getPlayer2().setTurn(true);
       feature4.getPlayer2().setCoinCount(0);
       feature4.makeMove();
       assertThat(outContent.toString(), containsString("did not have enough money"));
   }

   @Test
   public void testAILogic99() {
       feature4.getPlayer2().setTurn(true);
       feature4.getPlayer2().setCoinCount(1);
       Map<Establishment, Integer> newMarket = new HashMap<>();
       newMarket.put(feature4.getWheat(), 0);
       feature4.market = newMarket;
       feature4.EST_ORDER = new ArrayList<Establishment>();
       feature4.EST_ORDER.add(feature4.getWheat());
       feature4.makeMove();
       assertThat(outContent.toString(), containsString("chose not to make"));

   }

   @Test
   public void testRollTwo() {
       feature4.getPlayer1().getLandmarks()[0].setIs_constructed(true);
       feature4.getPlayer1().setTurn(true);
       feature4.sc = new Scanner("1");
       assertThat(feature4.rollTwo(), is(false));
   }

    @Test
    public void testRollTwoAI() {
        feature4.getPlayer2().getLandmarks()[0].setIs_constructed(true);
        feature4.getPlayer2().setTurn(true);
        assertThat(feature4.rollTwo(), Matchers.either(Matchers.is(true)).or(Matchers.is(false)));
    }

   @Test
   public void testRollTwoNotConstructed() {
       feature4.getPlayer1().setTurn(true);
       assertThat(feature4.rollTwo(), is(false));
   }

   

//    @Test
//    public void testOneLandmark() {
//        Player p = feature4.getCurrentPlayer();
//        p.setCoinCount(20);
//        ArrayList<Landmark> lmk = feature4.getAffordableLandmarks(p);
//        Landmark l = lmk.get(0);
//        Landmark l2 = lmk.get(1);
//        p.buyLandmark(l);
//       // p.buyLandmark();
//        assertThat(feature4.allLandmarksConstructed(),is(false));
//
//        // active player should not lose their turn since game ended
//       // assertThat(feature4.getCurrentPlayer().isTurn(), is(true));
//    }
//
//    @Test
//    public void testTwoLandmarks() {
//        Player p = feature4.getCurrentPlayer();
//        p.setCoinCount(20);
//        ArrayList<Landmark> lmk = feature4.getAffordableLandmarks(p);
//        Landmark l = lmk.get(0);
//        Landmark l2 = lmk.get(1);
//        p.buyLandmark(l);
//        p.buyLandmark(l2);
//        assertThat(feature4.allLandmarksConstructed(),is(true));
//    }

    //

    @Test
    public void testEstOrder() {
       ArrayList<Establishment> estTest = new ArrayList<>();
        estTest.add(feature4.wheat);
        estTest.add(feature4.ranch);
        estTest.add(feature4.bakery);
        estTest.add(feature4.convenience);
        estTest.add(feature4.forest);
        estTest.add(feature4.mine);
        estTest.add(feature4.orchard);
        assertThat(feature4.EST_ORDER.size(), is(7));
        for (int i = 0; i < feature4.EST_ORDER.size(); i++) {
           assertThat(feature4.EST_ORDER.get(i), is(estTest.get(i)));
       }
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

}
