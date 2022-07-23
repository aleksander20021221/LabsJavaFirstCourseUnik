package com.company;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @org.junit.jupiter.api.Test
    void testMain() {
        String s= "1/4 + 3/-5 * 5 - -3/-8 / 5/3 + 1";
        assertEquals(s,-79/40);
    }
}