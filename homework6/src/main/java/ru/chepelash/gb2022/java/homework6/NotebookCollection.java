package ru.chepelash.gb2022.java.homework6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotebookCollection {
    private HashMap<String, NotebookDTO> notebooks;

    public NotebookCollection(){
        notebooks = new HashMap<>();
    }

    public HashMap<String, NotebookDTO> getNotebooks() {
        return notebooks;
    }

    public void addNotebook(String serialCode, NotebookDTO notebook)
            throws IllegalArgumentException{
        if(notebooks.containsKey(serialCode)){
            throw new IllegalArgumentException("This serial code exists");
        }
        notebooks.put(serialCode, notebook);
    }
    public void removeNotebook(String serialCode) throws IllegalArgumentException {
        if(notebooks.isEmpty()){
            throw new IllegalArgumentException("Notebook collection is empty");
        }
        if(!notebooks.containsKey(serialCode)){
            throw new IllegalArgumentException("There is no such serial code");
        }
        notebooks.remove(serialCode);
    }
    public boolean isEmpty(){
        return notebooks.isEmpty();
    }
}
