package ru.chepelash.gb2022.java.homework4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    MyQueue<Integer> myQueue;
    int maxLength = 10;
    @BeforeEach
    void setUp() {
        myQueue = new MyQueue<>(maxLength);
    }

    @Test
    void size() {
        assertEquals(0, myQueue.size());
        myQueue.offer(1);
        assertEquals(1, myQueue.size());
    }

    @Test
    void empty() {
        assertTrue(myQueue.empty());
        myQueue.offer(1);
        assertFalse(myQueue.empty());
    }

    @Test
    void full() {
        assertFalse(myQueue.full());
        for (int i = 0; i < maxLength; i++) {
            assertTrue(myQueue.offer(i));
        }
        assertTrue(myQueue.full());
    }

    @Test
    void peek() {
        assertNull(myQueue.peek());
        myQueue.offer(1);
        assertEquals(1, myQueue.peek());
    }

    @Test
    void offer() {
        for (int i = 0; i < maxLength; i++) {
            assertTrue(myQueue.offer(i));
        }
        assertFalse(myQueue.offer(11));
    }

    @Test
    void poll() {
        myQueue.offer(1);
        myQueue.offer(3);
        assertEquals(1, myQueue.poll());
        assertEquals(3, myQueue.poll());
        assertNull(myQueue.poll());
    }

    @Test
    void overlaps(){
        for (int i = 0; i < 10; i++) {
            assertTrue(myQueue.offer(i));
        }
        for (int i = 0; i < maxLength/2; i++) {
            assertEquals(i, myQueue.poll());
        }
        for (int i = 0; i < maxLength/2; i++) {
            assertTrue(myQueue.offer(i+20));
        }
        assertTrue(myQueue.full());
        assertFalse(myQueue.empty());
        for (int i = 0; i < maxLength; i++) {
            assertNotNull(myQueue.poll());
        }
        assertFalse(myQueue.full());
        assertTrue(myQueue.empty());
    }
}