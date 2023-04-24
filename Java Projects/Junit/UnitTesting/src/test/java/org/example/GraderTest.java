package org.example;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraderTest {

    @Test
   public void fiftyNineShouldReturnF(){
        Grader grade = new Grader();
        assertEquals('F',grade.determineLetterGrade(59));
    }
    @Test
    public void sixtyNineShouldReturnD(){
        Grader grade = new Grader();
        assertEquals('D',grade.determineLetterGrade(69));
    }
    @Test
    public void seventyNineShouldReturnC(){
        Grader grade = new Grader();
        assertEquals('C',grade.determineLetterGrade(79));
    }
    @Test
    public void eightyNineShouldReturnB(){
        Grader grade = new Grader();
        assertEquals('B',grade.determineLetterGrade(89));
    }
    @Test
    public void nintyNineShouldReturnA(){
        Grader grade = new Grader();
        assertEquals('A',grade.determineLetterGrade(99));
    }
    @Test(expected = IllegalArgumentException.class)
    public void negativeShouldReturnException(){
        Grader grade = new Grader();
       assertEquals("Number Grade Can not be less than 0", grade.determineLetterGrade(-1));
    }
}