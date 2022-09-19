package ru.chepelash.gb2022.java.homework5;

import java.util.HashMap;
import java.util.List;

/*
 * 1. Реализуйте структуру телефонной книги с помощью HashMap,
 * учитывая, что 1 человек может иметь несколько телефонов.
 */
public class PhoneBook {
    private HashMap<String, HashMap<String, String>> phoneBook;
    public PhoneBook(){
        phoneBook = new HashMap<>();
    }

    /*
     * returns list of phone numbers for a person
     */
    public List<String> getNumbersByName(String name){
        return null;
    }
    /*
     * returns specific number for a person
     */
    public String getNumberByNameAndTag(String name, String tag){
        return null;
    }

    /*
     * adds number with tag.
     * if person does not exist, adds person
     * if person exists and tag does not - adds new phone number with this tag
     * if person and tag exist - throws an exception
     */
    public void addNumberForPerson(String name, String tag, String phoneNumber) {

    }
    /*
     * edits existing phone number
     * if person or tag does not exist - throws an exception
     */
    public void editNumber(String name, String tag, String phoneNumber){

    }
}
