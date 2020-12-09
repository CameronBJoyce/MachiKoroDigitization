package edu.wofford.machiwoco;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import org.junit.*;

import static org.hamcrest.CoreMatchers.*;

public class DiceSubjectTest {
    DiceSubject diceSubject;
    TwoPlayersPhase1 twoPlayersPhase1;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void before() {
        twoPlayersPhase1 = new TwoPlayersPhase1(false,2);
        //twoPlayersPhase1.getPlayers()[0].setTurn(true);
        twoPlayersPhase1.getPlayers().get(0).setTurn(true);
        diceSubject = new DiceSubject(twoPlayersPhase1.getCurrentPlayer(), twoPlayersPhase1.getPlayers(), 0, 1);
        new DiceObserver(diceSubject);
        new ActivationObserver(diceSubject);

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testDiceRoll2() {
        diceSubject.setDice(2);
        diceSubject.notifyObservers();
        assertThat(outContent.toString(), containsString("Player 1 rolled [2] = 2."));
    }

    @Test
    public void testDiceRollActivation() {
        // give player 2 a ranch
        Map<Establishment,Integer> map = new HashMap<>();
        map.put(twoPlayersPhase1.getRanch(), 1);
        twoPlayersPhase1.getPlayer2().setEstOwned(map);

//        set the active player to be player 2
        diceSubject.setActivePlayer(twoPlayersPhase1.getPlayer2());
        diceSubject.setPlayers(twoPlayersPhase1.getPlayers());
        diceSubject.setDice(2);
        diceSubject.notifyObservers();
        assertThat(outContent.toString(), containsString("Ranch activated for Player 2"));
    }

    @Test
    public void setDiceNum() {
        diceSubject.setDiceNum(2);
        assertThat(diceSubject.getDiceNum(), is(2));
    }

    @Test
    public void testGetSetDicePair() {
        diceSubject.setDicePair(2, 4);
        int[] test = new int[] {2, 4};
        assertThat(diceSubject.getDicePair(), is(test));
    }

    @Test
    public void testCorrectOutput2Die() {
        Feature4 f4 = new Feature4(3);
        int[] roll2Output = f4.roll2("2");
        diceSubject.setDiceNum(2);
        diceSubject.setDicePair(roll2Output[0], roll2Output[1]);
        diceSubject.setDice(roll2Output[2]);
        diceSubject.setActivePlayer(f4.getPlayer1());
        diceSubject.notifyObservers();
        assertThat(outContent.toString(), containsString("Player 1 rolled [" + roll2Output[0] + "][" + roll2Output[1] + "] = " + roll2Output[2] + "."));
    }

    @Test
    public void testCorrectOutput1Die() {
        Feature4 f4 = new Feature4(3);
        int[] roll2Output = f4.roll2("1");
        diceSubject.setDicePair(roll2Output[0], roll2Output[1]);
        diceSubject.setDice(roll2Output[2]);
        diceSubject.setActivePlayer(f4.getPlayer1());
        diceSubject.notifyObservers();
        assertThat(outContent.toString(), containsString("Player 1 rolled [" + roll2Output[0] + "] = " + roll2Output[2] + "."));
    }

    /*@Test
    public void testCheckActivationBranches() {
        Map<Establishment, Integer> test = new HashMap<>();
        Feature4 f4 = new Feature4(2);
        Player p1 = f4.getPlayer1();
        test.put(f4.getBakery(), 1);
        p1.setEstOwned(test);
        diceSubject.setDice(2);
        diceSubject.notifyObservers();
        assertThat(outContent.toString(), containsString("activated for Player"));
    }*/

    @Test
    public void testDiceRollActivationBakery() {
        // give player 2 a ranch
        Feature4 f4 = new Feature4(2);
        Map<Establishment,Integer> map = new HashMap<>();
        map.put(f4.getBakery(), 1);
        Player p2 = f4.getPlayer2();
        p2.setEstOwned(map);
        p2.setTurn(true);
        // f4.setPlayers(new Player[] {f4.getPlayer1(),p2});
        ArrayList<Player> playersAl = new ArrayList<Player>();
        playersAl.add(f4.getPlayer1());
        playersAl.add(p2);

//        set the active player to be player 2
        diceSubject.setActivePlayer(f4.getPlayer2());
        diceSubject.setPlayers(f4.getPlayers());
        diceSubject.setDice(2);
        diceSubject.notifyObservers();
        assertThat(outContent.toString(), containsString("Bakery activated for Player 2"));
    }



    @Test
    public void testDiceRollActivationBakery3() {
        // give player 2 a ranch
        Feature4 f4 = new Feature4(2);
        Map<Establishment,Integer> map = new HashMap<>();
        map.put(f4.getBakery(), 1);
        Player p2 = f4.getPlayer2();
        p2.setEstOwned(map);
        p2.setTurn(true);
        //f4.setPlayers(new Player[] {f4.getPlayer1(),p2});
        ArrayList<Player> playerAl = new ArrayList<Player>();
        playerAl.add(f4.getPlayer1());
        playerAl.add(p2);
//        set the active player to be player 2
        diceSubject.setActivePlayer(f4.getPlayer2());
        diceSubject.setPlayers(f4.getPlayers());
        diceSubject.setDice(3);
        diceSubject.notifyObservers();
        assertThat(outContent.toString(), containsString("Bakery activated for Player 2"));
    }


    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
