package ru.chepelash.gb2022.java.hw2;

import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.naming.directory.InvalidAttributesException;

public class App 
{
    /*
     * 1. Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
     *  1 Расширение файла: txt
     *  2 Расширение файла: pdf
     *  3 Расширение файла:
     *  4 Расширение файла: jpg
     */
    public static List<String> task1(String strDirPath) throws InvalidAttributesException, IOException{
        Path dirPath = Paths.get(strDirPath);
        if(!Files.isDirectory(dirPath)){
            throw new InvalidAttributesException("Path is not directory");
        }
        AtomicInteger indx = new AtomicInteger(1);
        List<String> result;
        try(Stream<Path> pathStream = Files.list(dirPath)) {
            result = pathStream.map(e -> String.format("%d Расширение файла: %s", indx.getAndIncrement(),
                    FilenameUtils.getExtension(e.getFileName().toString())))
                    .collect(Collectors.toList());
        }
        return result;
    }
    
    /*
     * 2. Дана строка sql-запроса "select * from students where ". 
     * Сформируйте часть WHERE этого запроса, используя StringBuilder. 
     * Данные для фильтрации приведены ниже в виде json строки. 
     * Если значение null, то параметр не должен попадать в запрос. 
     * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
     *  Ответ: "select * from students where name = 'Ivanov' and country = 'Russia' and city = 'Moscow'" для приведенного примера
     */
    public String task2(String fpath){
        String result = null;

        return result;
    }
    
    /*
     * 3**** Дана json строка (можно сохранить в файл и читать из файла)
     *   [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
     * {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
     *
     *   Написать метод(ы), который распарсит json и, используя StringBuilder, 
     * создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
     *
     * Пример вывода:
     *   Студент Иванов получил 5 по предмету Математика.
     *   Студент Петрова получил 4 по предмету Информатика.
     *   Студент Краснов получил 5 по предмету Физика.
     *
     */
    public String task3(String fpath){
        String result = null;

        return result;
    }    
}
