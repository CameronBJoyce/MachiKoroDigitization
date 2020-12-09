package edu.wofford.machiwoco;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class GameStateSubjectTest {
    GameStateSubject gameSubject;
    TwoPlayersPhase1 twoPlayersPhase1;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void before() {
        twoPlayersPhase1 = new TwoPlayersPhase1(false,2);
        // twoPlayersPhase1.getPlayers()[0].setTurn(true);
        twoPlayersPhase1.getPlayers().get(0).setTurn(true);
        gameSubject = new GameStateSubject(twoPlayersPhase1.EST_ORDER, twoPlayersPhase1.getPlayers(), twoPlayersPhase1.getMarket());
        new GameStateObserver(gameSubject);

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    // test set players
    @Test
    public void testSetPlayers() {
        // Player[] players = twoPlayersPhase1.getPlayers();
        ArrayList<Player> players = twoPlayersPhase1.getPlayers();
        gameSubject.setPlayers(players);
        assertThat(gameSubject.getPlayers(), is(players));
    }

    // test set market
    @Test
    public void testSetMarket() {
        Map<Establishment, Integer> market = twoPlayersPhase1.getMarket();
        gameSubject.setMarket(market);
        assertThat(gameSubject.getMarket(), is(market));
    }

    // test set EST_ORDER
    @Test
    public void testSetEstOrder() {
        ArrayList<Establishment> est = twoPlayersPhase1.EST_ORDER;
        gameSubject.setEstOrder(est);
        assertThat(gameSubject.getEstOrder(), is(est));
    }

    @Test
    public void testNotifyObservers() {
        // Player[] players = twoPlayersPhase1.getPlayers();
        ArrayList<Player> players = twoPlayersPhase1.getPlayers();
        gameSubject.setPlayers(players);
        Map<Establishment, Integer> market = twoPlayersPhase1.getMarket();
        gameSubject.setMarket(market);
        ArrayList<Establishment> est = twoPlayersPhase1.EST_ORDER;
        gameSubject.setEstOrder(est);
        gameSubject.notifyObservers();
        assertThat(outContent.toString(), containsString("******************************************\n" +
        "                  MARKET                  \n" +
        "------------------------------------------\n" +
        "Wheat Field        BW (1)  [1]      #6\n" +
        "Ranch              BC (1)  [2]      #6\n" +
        "Forest             BG (3)  [5]      #6\n\n" +
        "             Player 1* [YOU]              \n" +
        "------------------------------------------\n" +
        "                (3 coins)                 \n" +
        "Wheat Field        BW (1)  [1]      #1\n"    +
        "..........................................\n" +
        "City Hall          NT (7)  [ ]\n\n" +
        "                 Player 2                 \n" +
        "------------------------------------------\n" +
        "                (3 coins)                 \n" +
        "Wheat Field        BW (1)  [1]      #1\n"    +
        "..........................................\n" +
        "City Hall          NT (7)  [ ]\n\n" +
        "******************************************"));
    }

    @Test
    public void testPrintTurnBranches() {
        // Player p1 = gameSubject.getPlayers()[0];
        // Player p2 = gameSubject.getPlayers()[1];
        Player p1 = gameSubject.getPlayers().get(0);
        Player p2 = gameSubject.getPlayers().get(1);
        p1.setTurn(false);
        p2.setTurn(false);
        // gameSubject.setPlayers(new Player[] {p1, p2});
        ArrayList<Player> playerAl = new ArrayList<Player>();
        playerAl.add(p1);
        playerAl.add(p2);
        gameSubject.notifyObservers();
        assertThat(outContent.toString(), not(containsString("Turn started for player")));
        
    }


    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}