package com.rachmatwahid.resto.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void add() {
        int resultAdd = calculator.add(1, 2);
        assertEquals(resultAdd, 3);
    }
}