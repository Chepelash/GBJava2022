package ru.chepelash.gb2022.java.homework6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.chepelash.gb2022.java.homework6.enums.ColorEnum;
import ru.chepelash.gb2022.java.homework6.enums.OsEnum;
import ru.chepelash.gb2022.java.homework6.enums.VendorEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class NotebookServiceTest {
    private NotebookService notebookService;
    @BeforeEach
    void setUp(){
        NotebookCollection notebookCollection = new NotebookCollection();
        notebookService = new NotebookService(notebookCollection);
    }
    @Test
    void addNotebook() {
    }

    @Test
    void removeNotebookBySerialCode() {
    }

    @Test
    void getNotebooksByColors() {
        notebookService.addNotebook("1", VendorEnum.HP, "model1",
                1024, 1024, OsEnum.NO_OS, ColorEnum.BLACK, 24.4);
        assertNull(notebookService.getNotebooksByColors(List.of(ColorEnum.RED)));
        HashMap<String, NotebookDTO> expected = new HashMap<>(Map.of("1",
                new NotebookDTO(VendorEnum.HP, "model1",
                        1024, 1024, OsEnum.NO_OS, ColorEnum.BLACK, 24.4)));
        assertEquals(expected, notebookService.getNotebooksByColors(List.of(ColorEnum.BLACK)));
    }

    @Test
    void getNotebooksByOzu() {
    }
}