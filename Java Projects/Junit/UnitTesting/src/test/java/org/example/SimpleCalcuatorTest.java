package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleCalcuatorTest {
    @Test
   public void twoPlusTwoEqualsFour(){
        SimpleCalcuator calcuator = new SimpleCalcuator();
        assertEquals(4, calcuator.add(2,2));
    }
    @Test
    public void threePlusSevenEqualsTen(){
        SimpleCalcuator calcuator = new SimpleCalcuator();
        assertEquals(10, calcuator.add(3,7));
    }
}