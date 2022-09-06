package ru.chepelash.gb2022.java.hw2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import javax.naming.directory.InvalidAttributesException;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void testTask1() throws InvalidAttributesException, IOException {
        String dirPath = "/home/virtboy/Documents";
        for(String extension : App.task1(dirPath)){
            System.out.println(extension);
        }
    }

    @Test
    public void testTask2() {
        System.out.println(App.task2("{'name':'Ivanov', 'country':'Russia', 'city':'Moscow', 'age':'null'}"));
    }

    @Test
    public void testTask3() throws IOException {
        System.out.println(App.task3("src/test/resources/task3Data"));
    }

}
