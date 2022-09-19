package ru.chepelash.gb2022.java.homework4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfixToPostfixTest {

    @Test
    void convert() {
        String testEquation = "A+B*(C^D-E)";
        String expectedEquation = "ABCD^E-*+";
        assertEquals(expectedEquation, InfixToPostfix.convert(testEquation));
    }
}