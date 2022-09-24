package ru.chepelash.gb2022.java.homework6;

import ru.chepelash.gb2022.java.homework6.enums.ColorEnum;
import ru.chepelash.gb2022.java.homework6.enums.OsEnum;
import ru.chepelash.gb2022.java.homework6.enums.VendorEnum;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class NotebookService {
    private NotebookCollection notebookCollection;
    private final Logger LOGGER = Logger.getLogger(NotebookService.class.getName());

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
        notebookCollection.addNotebook(serialCode, notebookDTO);
    }
    public void removeNotebookBySerialCode(String serialCode) throws IllegalArgumentException{
        if(serialCode == null || serialCode.isEmpty()){
            throw new IllegalArgumentException("serialCode is empty");
        }
        notebookCollection.removeNotebook(serialCode);
    }
    public HashMap<String, NotebookDTO> getAllNotebooks(){
        return notebookCollection.getNotebooks();
    }
    private HashMap<String, NotebookDTO> getNotebookByParameter(int parameterValue, String parameterName, boolean betterThan){
        HashMap<String, NotebookDTO> result = new HashMap<>();
        if(parameterValue < 0){
            return result;
        }
        List<Map.Entry<String, NotebookDTO>> filteredEntries;
        switch (parameterName){
            case "hdd":
                if(betterThan)
                    filteredEntries = notebookCollection.getNotebooks().entrySet().stream()
                            .filter(e -> e.getValue().getHddSize() >= parameterValue)
                            .collect(Collectors.toList());
                else
                    filteredEntries = notebookCollection.getNotebooks().entrySet().stream()
                            .filter(e -> e.getValue().getHddSize() <= parameterValue)
                            .collect(Collectors.toList());
                break;
            case "ozu":
                if(betterThan)
                    filteredEntries = notebookCollection.getNotebooks().entrySet().stream()
                            .filter(e -> e.getValue().getOzu() >= parameterValue)
                            .collect(Collectors.toList());
                else
                    filteredEntries = notebookCollection.getNotebooks().entrySet().stream()
                            .filter(e -> e.getValue().getOzu() <= parameterValue)
                            .collect(Collectors.toList());
                break;
            default:
                throw new IllegalArgumentException("Wrong parameter");
        }
        for (Map.Entry<String, NotebookDTO> entry:
                filteredEntries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
    private HashMap<String, NotebookDTO> getNotebookByParameter(int parameterValue, String parameterName) {
        return getNotebookByParameter(parameterValue, parameterName, true);
    }
    private HashMap<String, NotebookDTO> collectHashMap(List<Map.Entry<String, NotebookDTO>> filteredEntries){
        HashMap<String, NotebookDTO> result = new HashMap<>();
        if(filteredEntries.isEmpty()){
            return result;
        }
        for (Map.Entry<String, NotebookDTO> entry:
             filteredEntries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
    public HashMap<String, NotebookDTO> getNotebooksByColors(List<ColorEnum> colors){
        List<Map.Entry<String, NotebookDTO>> filteredEntries = notebookCollection.getNotebooks().entrySet().stream()
                .filter(e -> colors.contains(e.getValue().getColor()))
                .collect(Collectors.toList());
        return collectHashMap(filteredEntries);
    }

    public HashMap<String, NotebookDTO> getNotebooksByOs(List<OsEnum> osEnums){
        List<Map.Entry<String, NotebookDTO>> filteredEntries = notebookCollection.getNotebooks().entrySet().stream()
                .filter(e -> osEnums.contains(e.getValue().getOs()))
                .collect(Collectors.toList());
        return collectHashMap(filteredEntries);
    }

    public HashMap<String, NotebookDTO> getNotebooksByOzu(int ozu){
        return getNotebookByParameter(ozu, "ozu");
    }

    public HashMap<String, NotebookDTO> getNotebooksByHdd(int hdd){
        return getNotebookByParameter(hdd, "hdd");
    }
}
