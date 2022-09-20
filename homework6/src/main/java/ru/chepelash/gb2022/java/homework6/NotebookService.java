package ru.chepelash.gb2022.java.homework6;

import ru.chepelash.gb2022.java.homework6.enums.ColorEnum;
import ru.chepelash.gb2022.java.homework6.enums.OsEnum;
import ru.chepelash.gb2022.java.homework6.enums.VendorEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NotebookService {
    private NotebookCollection notebookCollection;

    public NotebookService(NotebookCollection notebookCollection) {
        this.notebookCollection = notebookCollection;
    }

    public void addNotebook(String serialCode, VendorEnum vendor, String model, int ozu, int hddSize,
                            OsEnum os, ColorEnum color, double screenSize) throws IllegalArgumentException{
        if(model == null || model.isEmpty()){
            throw new IllegalArgumentException("Model is empty");
        }
        if(serialCode == null || serialCode.isEmpty()){
            throw new IllegalArgumentException("serialCode is empty");
        }
        if(ozu < 0 || hddSize < 0 || screenSize < 0){
            throw new IllegalArgumentException(String.format("Parameters are wrong: OZU: %d; HddSize: %d; ScreenSize: %f",
                    ozu, hddSize, screenSize));
        }
        NotebookDTO notebookDTO = new NotebookDTO(vendor, model, ozu, hddSize, os, color, screenSize);
        notebookCollection.addNotebook(Map.of(serialCode, notebookDTO));
    }
    public boolean removeNotebookBySerialCode(String serialCode) throws IllegalArgumentException{
        if(serialCode == null || serialCode.isEmpty()){
            throw new IllegalArgumentException("serialCode is empty");
        }
        return notebookCollection.removeNotebook(serialCode) != null;
    }
    public HashMap<String, NotebookDTO> getNotebooksByColors(List<ColorEnum> colors){
        if(notebookCollection.isEmpty()){
            return null;
        }
        List<Map.Entry<String, NotebookDTO>> filteredEntries = notebookCollection.getNotebooks().entrySet().stream()
                .filter(e -> colors.contains(e.getValue().getColor()))
                .collect(Collectors.toList());
        if(filteredEntries.isEmpty()){
            return null;
        }
        HashMap<String, NotebookDTO> result = new HashMap<>();
        for (Map.Entry<String, NotebookDTO> entry:
             filteredEntries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public HashMap<String, NotebookDTO> getNotebooksByOzu(int ozu){
        if(ozu < 0){
            return null;
        }
        List<Map.Entry<String, NotebookDTO>> filteredEntries = notebookCollection.getNotebooks().entrySet().stream()
                .filter(e -> e.getValue().getOzu() >= ozu)
                .collect(Collectors.toList());
        if(filteredEntries.isEmpty()){
            return null;
        }
        HashMap<String, NotebookDTO> result = new HashMap<>();
        for (Map.Entry<String, NotebookDTO> entry:
                filteredEntries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
