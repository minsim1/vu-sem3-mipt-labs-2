package com.example.mipt_lab_2;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void testAddition(){
        Calculator calc = new Calculator("TEST1", "TEST2");
        calc.inputNumber(4);
        calc.inputOperand('+');
        calc.inputNumber(2);
        calc.equals();
        assertEquals("6.0",calc.currentOutput);
    }

    @Test
    public void testSubtraction(){
        Calculator calc = new Calculator("TEST1", "TEST2");
        calc.inputNumber(4);
        calc.inputNumber(0);
        calc.inputOperand('-');
        calc.inputNumber(2);
        calc.inputNumber(1);
        calc.equals();
        assertEquals("19.0",calc.currentOutput);
    }

    @Test
    public void testMultiplication(){
        Calculator calc = new Calculator("TEST1", "TEST2");
        calc.inputNumber(6);
        calc.inputNumber(7);
        calc.inputOperand('*');
        calc.inputNumber(6);
        calc.inputNumber(7);
        calc.equals();
        assertEquals("4489.0",calc.currentOutput);
    }

    @Test
    public void testDivision(){
        Calculator calc = new Calculator("TEST1", "TEST2");
        calc.inputNumber(3);
        calc.inputNumber(3);
        calc.inputOperand('/');
        calc.inputNumber(4);
        calc.inputNumber(4);
        calc.equals();
        assertEquals("0.75",calc.currentOutput);
    }

    @Test
    public void testSquareRoot(){
        Calculator calc = new Calculator("TEST1", "TEST2");
        calc.inputNumber(6);
        calc.inputNumber(4);
        calc.inputSquareRoot();
        assertEquals("8.0",calc.currentOutput);
    }


    @Test
    public void testSquareRootError(){
        Calculator calc = new Calculator("div0Err", "sqrtErr");
        calc.inputNumber(6);
        calc.inputNumber(4);
        calc.switchPolarity();
        calc.inputSquareRoot();
        assertEquals("sqrtErr",calc.currentOutput);
    }

    @Test
    public void testDiv0Err(){
        Calculator calc = new Calculator("div0Err", "sqrtErr");
        calc.inputNumber(6);
        calc.inputNumber(4);
        calc.inputOperand('/');
        calc.inputNumber(0);
        calc.equals();
        assertEquals("div0Err",calc.currentOutput);
    }
}

