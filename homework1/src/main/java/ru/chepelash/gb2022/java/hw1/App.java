package ru.chepelash.gb2022.java.hw1;

import java.util.Arrays;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Homework1");
        System.out.println("task1");
        task1();
        System.out.println("Done");
        System.out.println("task2");
        task2();
        System.out.println("Done");
    }


    /*
     * 1. Задан массив, например, nums = [1,7,3,6,5,6]. 
     * Написать программу, которая найдет индекс i для этого массива такой, 
     * что сумма элементов с индексами < i равна сумме элементов с индексами > i.
     */
    private static void task1(){
        int[] nums = {1,2,3,5,3,2,1};
        int sumLeft;
        int sumRight;
        int answer = 0;
        for(int i = 1; i < nums.length-1; i++){
            sumLeft = Arrays.stream(Arrays.copyOfRange(nums, 0, i)).sum();
            sumRight = Arrays.stream(Arrays.copyOfRange(nums, i+1, nums.length)).sum();
            if(sumLeft == sumRight){
                answer = i;
                System.out.printf("Left array = %s, right array = %s, sumLeft = %d, sumRight = %d, i = %d\n", Arrays.toString(Arrays.copyOfRange(nums, 0, i)),
                Arrays.toString(Arrays.copyOfRange(nums, i+1, nums.length)), sumLeft, sumRight, i);
                break;
            }            
        }    
        if(answer == 0){
            System.out.println("No answer");
        } else {
            System.out.printf("Answer = %d\n", answer);
        }
    }
    /*
     * 2. Напишите функцию, для поиска наиболее длинного общего префикса, среди массива строк. 
     * Если общего префикса нет, то возвращать пустую строку. Пример ["aabb", "aabbb", "aaabb"] - ответ "aa"
     */
    private static void task2(){

    }

     
}
