package ru.chepelash.gb2022.java.hw3;

import org.javatuples.Triplet;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @Test
    public void task1() {
        // 1. Пусть дан произвольный список целых чисел, удалить из него четные числа
        List<Integer> testList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expectedList = List.of(1, 3, 5, 7, 9);
        List<Integer> resultList = Main.task1(testList);
        Assert.assertEquals(expectedList, resultList);
    }

    @Test
    public void task2() {
        // 2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
        ArrayList<Integer> testArrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Triplet<Integer, Integer, Double> expectedTriplet = new Triplet<>(10, 1, 5.5);
        Triplet<Integer, Integer, Double> resultTriplet = Main.task2(testArrayList);
        Assert.assertEquals(expectedTriplet, resultTriplet);
    }
}