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
    public HashMap<String, String> getNumbersByName(String name)
            throws IllegalArgumentException {
        if(!phoneBook.containsKey(name)){
            throw new IllegalArgumentException("Person does not exists");
        }
        return phoneBook.get(name);
    }
    /*
     * returns specific number for a person
     */
    public String getNumberByNameAndTag(String name, String tag)
            throws IllegalArgumentException{
        HashMap<String, String> phones = getNumbersByName(name);
        if(!phones.containsKey(tag)){
            throw new IllegalArgumentException("Tag does not exists");
        }
        return phones.get(tag);
    }

    /*
     * adds number with tag.
     * if person does not exist, adds person
     * if person exists and tag does not - adds new phone number with this tag
     * if person and tag exist - throws an exception
     */
    public void addNumberForPerson(String name, String tag, String phoneNumber)
            throws IllegalArgumentException {
        if(phoneBook.containsKey(name)){
            HashMap<String, String> phones = getNumbersByName(name);
            if(phones.containsKey(tag)){
                throw new IllegalArgumentException("Person and tag exist");
            }
            phones.put(tag, phoneNumber);
        } else {
            HashMap<String, String> phone = new HashMap<>();
            phone.put(tag, phoneNumber);
            phoneBook.put(name, phone);
        }
    }
    /*
     * edits existing phone number
     * if person or tag does not exist - throws an exception
     */
    public void editNumber(String name, String tag, String phoneNumber){
        if(!phoneBook.containsKey(name)){
            throw new IllegalArgumentException("Person does not exist");
        }
        HashMap<String, String> phones = getNumbersByName(name);
        if(!phones.containsKey(tag)){
            throw new IllegalArgumentException("Tag does not exist");
        }
        phones.put(tag, phoneNumber);
    }
}
