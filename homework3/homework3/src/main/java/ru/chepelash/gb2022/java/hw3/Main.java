package ru.chepelash.gb2022.java.hw3;

import org.javatuples.Triplet;

import java.util.*;

public class Main {
    /*
     * 1. Пусть дан произвольный список целых чисел, удалить из него четные числа
     */
    public static List<Integer> task1(List<Integer> integerList) {
        List<Integer> resultList = new ArrayList<>(List.copyOf(integerList));
        resultList.removeIf(integer -> integer % 2 == 0);
        return resultList;
    }

    /*
     * 2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
     */
    public static Triplet<Integer, Integer, Double> task2(ArrayList<Integer> integerList) {
        int maxValue = integerList.stream().mapToInt(v -> v)
                .max().orElseThrow(NoSuchElementException::new);
        int minValue = integerList.stream().mapToInt(v -> v)
                .min().orElseThrow(NoSuchElementException::new);
        double avrValue = integerList.stream().mapToInt(v -> v)
                .average().orElseThrow(NoSuchElementException::new);
        return new Triplet<>(maxValue, minValue, avrValue);
    }
}
