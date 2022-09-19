package ru.chepelash.gb2022.java.homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    private PhoneBook phoneBook;
    @BeforeEach
    void setUp(){
        phoneBook = new PhoneBook();
    }
    @Test
    void getNumbersByName() {
        assertThrows(IllegalArgumentException.class, () ->
                phoneBook.getNumbersByName("Random"));
        phoneBook.addNumberForPerson("Oleg", "Working", "789789");
        HashMap<String, String> expected = new HashMap<>();
        expected.put("Working", "789789");
        assertEquals(expected, phoneBook.getNumbersByName("Oleg"));
    }

    @Test
    void getNumberByNameAndTag() {
        phoneBook.addNumberForPerson("Oleg", "Working", "789789");
        phoneBook.addNumberForPerson("Oleg", "Home", "123132");
        phoneBook.addNumberForPerson("Igor", "Working", "7159");
        String expected = "789789";
        assertEquals("789789", phoneBook.getNumberByNameAndTag("Oleg",
                "Working"));
        assertEquals("123132", phoneBook.getNumberByNameAndTag("Oleg",
                "Home"));
        assertEquals("7159", phoneBook.getNumberByNameAndTag("Igor",
                "Working"));
        assertThrows(IllegalArgumentException.class, () ->
                phoneBook.getNumberByNameAndTag("Igor","Home"));
        assertThrows(IllegalArgumentException.class, () ->
                phoneBook.getNumberByNameAndTag("Random","Home"));
    }

    @Test
    void addNumberForPerson() {
        phoneBook.addNumberForPerson("Igor", "Working", "7159");
        assertThrows(IllegalArgumentException.class, () ->
                phoneBook.addNumberForPerson("Igor", "Working",
                        "7156"));
    }

    @Test
    void editNumber() {
        phoneBook.addNumberForPerson("Igor", "Working", "7159");
        assertThrows(IllegalArgumentException.class, () ->
                phoneBook.editNumber("Igor", "Home", "7152"));
        assertThrows(IllegalArgumentException.class, () ->
                phoneBook.editNumber("Oleg", "Home", "7152"));
    }
}