package ru.chepelash.gb2022.java.homework4;

import org.junit.jupiter.api.BeforeEach;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    private MyStack<Integer> myStack;
    private int maxLength = 10;
    @BeforeEach
    void createStack(){
        myStack = new MyStack<Integer>(maxLength);
    }
    @org.junit.jupiter.api.Test
    void empty() {
        assertTrue(myStack.empty());
        myStack.push(1);
        assertFalse(myStack.empty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(0, myStack.size());
        for (int i = 0; i < maxLength; i++) {
            myStack.push(i);
        }
        assertEquals(maxLength, myStack.size());
    }

    @org.junit.jupiter.api.Test
    void peek() {
        myStack.push(1);
        assertEquals(1, myStack.peek());
        myStack.push(3);
        assertEquals(3, myStack.peek());
    }

    @org.junit.jupiter.api.Test
    void pop() {
        myStack.push(1);
        myStack.push(3);
        assertEquals(3, myStack.pop());
        assertEquals(1, myStack.pop());
    }

    @org.junit.jupiter.api.Test
    void pushError() {
        for (int i = 0; i < maxLength; i++) {
            myStack.push(i);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> myStack.push(11));
    }

    @org.junit.jupiter.api.Test
    void popError() {
        assertThrows(EmptyStackException.class, () -> myStack.pop());
    }

    @org.junit.jupiter.api.Test
    void maxLengthError() {
        assertThrows(IllegalArgumentException.class, () -> {MyStack<Integer> errorStack = new MyStack<>(-1);});
    }
}