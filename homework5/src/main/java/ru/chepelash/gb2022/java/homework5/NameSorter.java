package ru.chepelash.gb2022.java.homework5;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Пусть дан список сотрудников
 * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
 * Отсортировать по убыванию популярности.
 */
public class NameSorter {
    public static LinkedHashMap<String, Long> countAndSortNames(List<String> nameList){
        Map<String, Long> result = nameList.stream()
                .map(el -> el.split(" ")[0])
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        List<Map.Entry<String, Long>> entries = new ArrayList<>(result.entrySet());
        entries.sort((o1, o2) -> o2.getValue().intValue() - o1.getValue().intValue());
        LinkedHashMap<String, Long> sortedResult = new LinkedHashMap<>();

        for (Map.Entry<String, Long>entry:
             entries) {
            sortedResult.put(entry.getKey(), entry.getValue());
        }
        sortedResult.forEach((k, v) -> System.out.printf("%d %s\n", v, k));
        return sortedResult;
    }
}
