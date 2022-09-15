package ru.chepelash.gb2022.java.homework4;


import java.util.EmptyStackException;

/*
 * Взять за основу реализацию стека, написанную в конце семенара. Добавить проверку граничных условий
 * и выводить сообщения об ошибках, если мы пытаемся извлечь элемент из пустого стека,
 * добавить элемент в полностью заполненный стек и тд
 */
public class MyStack <T>
{
    private final int maxLength;
    private int index;
    private T[] array;

    public MyStack(int maxLength){
        if(maxLength < 1)
            throw new IllegalArgumentException();
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

    public int getMaxLength() {
        return maxLength;
    }
}
