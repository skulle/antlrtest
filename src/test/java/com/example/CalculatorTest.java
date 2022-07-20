package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    public void additionAndMultiplication() {
        // given
        String expression = "2*(3+4)";

        // when
        int result = new Calculator().compute(expression);

        // then
        assertEquals(14, result);
    }
}