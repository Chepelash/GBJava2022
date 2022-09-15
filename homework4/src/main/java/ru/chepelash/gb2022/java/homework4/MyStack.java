package ru.chepelash.gb2022.java.homework4;


import java.util.EmptyStackException;

public class MyStack <T>
{
    private final int maxLength;
    private int index;
    private T[] array;

    public MyStack(int maxLength){
        this.maxLength = maxLength;
        index = 0;
        array = (T[]) new Object[maxLength];
    }

    public boolean empty(){
        return size() == 0;
    }
    public int size(){
        return index;
    }

    public T peek(){
        return array[index-1];
    }

    public T pop(){
        if(index == 0)
            throw new EmptyStackException();
        index--;
        return array[index];
    }

    public void push(T value){
        if(index == maxLength)
            throw new IndexOutOfBoundsException("Max Stack length ");
        array[index] = value;
        index++;
    }
}
