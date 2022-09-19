package ru.chepelash.gb2022.java.homework5;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NameSorterTest {

    @Test
    void countAndSortNames() throws IOException {
        HashMap<String, Long> expected = new HashMap<>(Map.of("Иван", (long) 4,
                "Мария", (long)3,"Анна", (long)3, "Петр", (long)3,
                "Марина", (long)2, "Светлана", (long)1,
                "Кристина", (long)1, "Павел", (long)1));
        String testFile = Files.readString(Paths.get("src/test/java/resources/namesFiles"));

        List<String> inputData = List.of(testFile.split("\n"));

        assertEquals(expected, NameSorter.countAndSortNames(inputData));
    }
}