package ru.chepelash.gb2022.java.homework4;

/*
 * Написать реализацию очереди на основе массива;
 * Реализовать методы size(), empty(), offer(), poll(), peek()
 */

public class MyQueue <T> {
    private final int maxLength;
    private int headIndx;
    private int tailIndx;
    private boolean overlap;
    private T[] queue;
    public MyQueue(int maxLength) {
        if(maxLength < 1)
            throw new IllegalArgumentException();
        this.maxLength = maxLength;
        headIndx = 0;
        tailIndx = 0;
        overlap = false;
        queue = (T[]) new Object[maxLength];
    }
    public int size(){
        if(overlap) {
            if(headIndx == tailIndx)
                return maxLength;
            return maxLength - tailIndx + headIndx;
        }
        return headIndx - tailIndx;
    }
    public boolean empty(){
        return headIndx == tailIndx && !overlap;
    }
    public boolean full(){
        return headIndx == tailIndx && overlap;
    }
    /*
     * возвращает элемент из головы очереди. Возвращает null, если очередь пуста. Элемент не удаляется.
     */
    public T peek(){
        if(!empty())
            return queue[tailIndx];
        return null;
    }

    /*
     * пытается добавить оbj в очередь. Возвращает true, если оbj добавлен, и false в противном случае.
     */
    public boolean offer(T newValue){
        if(full())
            return false;
        queue[headIndx] = newValue;
        headIndx++;
        if(headIndx == maxLength){
            headIndx = 0;
            overlap = true;
        }
        return true;
    }
    /*
     * возвращает элемент из головы очереди и удаляет его. Возвращает null, если очередь пуста.
     */
    public T poll(){
        if(empty())
            return null;
        T element = queue[tailIndx];
        tailIndx++;
        if(tailIndx == maxLength){
            tailIndx = 0;
            overlap = false;
        }
        return element;
    }
}
