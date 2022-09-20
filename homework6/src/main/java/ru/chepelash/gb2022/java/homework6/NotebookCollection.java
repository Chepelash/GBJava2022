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

    public void addNotebook(Map<String, NotebookDTO> notebook){
        notebooks.putAll(notebook);
    }
    public NotebookDTO removeNotebook(String serialCode){
        return notebooks.remove(serialCode);
    }
    public boolean isEmpty(){
        return notebooks.isEmpty();
    }
}
