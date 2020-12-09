package edu.wofford.machiwoco;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import org.junit.*;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class Feature6Test {
    Feature6 feature6;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void before() {
        feature6 = new Feature6(3);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test 
    public void testGetCafe() {
        assertThat(feature6.getCafe(), is(feature6.cafe));
    }

    @Test
    public void testGetFamilyRest() {
        Feature6 newF6 = new Feature6(4);
        assertThat(newF6.getFamilyRestaurant(), is(newF6.familyRestaurant));
    }

    @Test
    public void testIsTSConstructed() {
        feature6.getPlayer1().getLandmarks()[1].setIs_constructed(true);
        assertThat(feature6.getPlayer1().isShoppingMallConstructed(), is(true));
    }

    @Test
    public void testIsTSConstructedFalse() {
        feature6.getPlayer1().getLandmarks()[1].setIs_constructed(false);
        assertThat(feature6.getPlayer1().isShoppingMallConstructed(), is(false));
    }


}
