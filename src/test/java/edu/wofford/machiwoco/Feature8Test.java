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

public class Feature8Test {
    Feature8 feature8;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void before() {
        feature8 = new Feature8(3);
        feature8.player1.setTurn(true);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testRemoveZeroes() {
        Map<Establishment,Integer> newMarket = new HashMap<>();
        newMarket.put(feature8.getWheat(), 6);
        newMarket.put(feature8.getRanch(),6);
        newMarket.put(feature8.getForest(),6);
        newMarket.put(feature8.getStadium(),0);
        feature8.market = newMarket;
        Map<Establishment,Integer> resultmarket = new HashMap<>();
        resultmarket.put(feature8.getWheat(), 6);
        resultmarket.put(feature8.getRanch(),6);
        resultmarket.put(feature8.getForest(),6);

        assertThat(feature8.getMarket(), is(newMarket));
        feature8.removeZeroesMarket();
        assertThat(feature8.getMarket(), is(resultmarket));
    }

    @Test
    public void testRemoveZeroes2() {
        Map<Establishment,Integer> newMarket = new HashMap<>();
        newMarket.put(feature8.getWheat(), 6);
        newMarket.put(feature8.getRanch(),6);
        newMarket.put(feature8.getForest(),6);
        newMarket.put(feature8.getBakery(),0);
        feature8.market = newMarket;
        Map<Establishment,Integer> resultmarket = new HashMap<>();
        resultmarket.put(feature8.getWheat(), 6);
        resultmarket.put(feature8.getRanch(),6);
        resultmarket.put(feature8.getForest(),6);

        assertThat(feature8.getMarket(), is(newMarket));
        feature8.removeZeroesMarket();
        assertThat(feature8.getMarket(), is(resultmarket));
    }

    @Test
    public void testRemoveZeroes3() {
        Map<Establishment,Integer> newMarket = new HashMap<>();
        newMarket.put(feature8.getWheat(), 6);
        newMarket.put(feature8.getRanch(),6);
        newMarket.put(feature8.getForest(),6);
        newMarket.put(feature8.getFamilyRestaurant(),0);
        feature8.market = newMarket;
        Map<Establishment,Integer> resultmarket = new HashMap<>();
        resultmarket.put(feature8.getWheat(), 6);
        resultmarket.put(feature8.getRanch(),6);
        resultmarket.put(feature8.getForest(),6);

        assertThat(feature8.getMarket(), is(newMarket));
        feature8.removeZeroesMarket();
        assertThat(feature8.getMarket(), is(resultmarket));
    }

    @Test
    public void testRemoveZeroes4() {
        Map<Establishment,Integer> newMarket = new HashMap<>();
        newMarket.put(feature8.getWheat(), 6);
        newMarket.put(feature8.getRanch(),6);
        newMarket.put(feature8.getForest(),6);
        newMarket.put(feature8.getConvenience(),0);
        feature8.market = newMarket;
        Map<Establishment,Integer> resultmarket = new HashMap<>();
        resultmarket.put(feature8.getWheat(), 6);
        resultmarket.put(feature8.getRanch(),6);
        resultmarket.put(feature8.getForest(),6);

        assertThat(feature8.getMarket(), is(newMarket));
        feature8.removeZeroesMarket();
        assertThat(feature8.getMarket(), is(resultmarket));
    }

    @Test
    public void testRemoveZeroes5() {
        Map<Establishment,Integer> newMarket = new HashMap<>();
        newMarket.put(feature8.getWheat(), 6);
        newMarket.put(feature8.getRanch(),6);
        newMarket.put(feature8.getForest(),6);
        newMarket.put(feature8.getMine(),0);
        feature8.market = newMarket;
        Map<Establishment,Integer> resultmarket = new HashMap<>();
        resultmarket.put(feature8.getWheat(), 6);
        resultmarket.put(feature8.getRanch(),6);
        resultmarket.put(feature8.getForest(),6);

        assertThat(feature8.getMarket(), is(newMarket));
        feature8.removeZeroesMarket();
        assertThat(feature8.getMarket(), is(resultmarket));
    }

    @Test
    public void testRemoveZeroes6() {
        Map<Establishment,Integer> newMarket = new HashMap<>();
        newMarket.put(feature8.getWheat(), 6);
        newMarket.put(feature8.getRanch(),6);
        newMarket.put(feature8.getForest(),6);
        newMarket.put(feature8.getFarmersMarket(),0);
        feature8.market = newMarket;
        Map<Establishment,Integer> resultmarket = new HashMap<>();
        resultmarket.put(feature8.getWheat(), 6);
        resultmarket.put(feature8.getRanch(),6);
        resultmarket.put(feature8.getForest(),6);

        assertThat(feature8.getMarket(), is(newMarket));
        feature8.removeZeroesMarket();
        assertThat(feature8.getMarket(), is(resultmarket));
    }


//    @Test
//    public void testDeck() {
//        Feature8 feature8 = new Feature8(3);
//        assertThat(feature8.DeckA.size(), is(36));
////        assertThat(outContent.toString(), is("XD"));
////
//    }


}
