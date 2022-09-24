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
        notebookService.addNotebook("1", VendorEnum.HP, "model1",
                1024, 1024, OsEnum.NO_OS, ColorEnum.BLACK, 24.4);
        assertThrows(IllegalArgumentException.class, () ->
                notebookService.addNotebook("1", VendorEnum.HP, "model1",
                        1024, 1024, OsEnum.NO_OS, ColorEnum.BLACK, 24.4));
    }

    @Test
    void removeNotebookBySerialCode() {
        assertThrows(IllegalArgumentException.class, () ->
                notebookService.removeNotebookBySerialCode("1"));
        notebookService.addNotebook("1", VendorEnum.HP, "model1",
                1024, 1024, OsEnum.NO_OS, ColorEnum.BLACK, 24.4);
        notebookService.removeNotebookBySerialCode("1");
    }

    @Test
    void getNotebooksByColors() {
        notebookService.addNotebook("1", VendorEnum.HP, "model1",
                1024, 1024, OsEnum.NO_OS, ColorEnum.BLACK, 24.4);
        assertEquals(new HashMap<String, NotebookDTO>(), notebookService.getNotebooksByColors(List.of(ColorEnum.RED)));
        HashMap<String, NotebookDTO> expected = new HashMap<>(Map.of("1",
                new NotebookDTO(VendorEnum.HP, "model1",
                        1024, 1024, OsEnum.NO_OS, ColorEnum.BLACK, 24.4)));
        assertEquals(expected, notebookService.getNotebooksByColors(List.of(ColorEnum.BLACK)));
        notebookService.addNotebook("2", VendorEnum.HUAWEI, "model1",
                2048, 16000, OsEnum.LINUX, ColorEnum.SILVER, 18.8);
        notebookService.addNotebook("3", VendorEnum.APPLE, "model1",
                2048, 16000, OsEnum.MAC, ColorEnum.RED, 16.);
        expected.put("2", new NotebookDTO(VendorEnum.HUAWEI, "model1",
                2048, 16000, OsEnum.LINUX, ColorEnum.SILVER, 18.8));
        assertEquals(expected, notebookService.getNotebooksByColors(List.of(ColorEnum.BLACK, ColorEnum.SILVER)));
    }

    @Test
    void getNotebooksByOzu() {
        notebookService.addNotebook("1", VendorEnum.HP, "model1",
                1024, 1024, OsEnum.NO_OS, ColorEnum.BLACK, 24.4);
        notebookService.addNotebook("2", VendorEnum.HUAWEI, "model1",
                1048, 16000, OsEnum.LINUX, ColorEnum.SILVER, 18.8);
        notebookService.addNotebook("3", VendorEnum.APPLE, "model1",
                2048, 16000, OsEnum.MAC, ColorEnum.RED, 16.);
        HashMap<String, NotebookDTO> expected = new HashMap<>(Map.of("3",
                new NotebookDTO(VendorEnum.APPLE, "model1",
                        2048, 16000, OsEnum.MAC, ColorEnum.RED, 16.)));
        assertEquals(expected, notebookService.getNotebooksByOzuMoreThan(2000));
        assertEquals(expected, notebookService.getNotebooksByOzuMoreThan(2048));
    }

    @Test
    void getAllNotebooks() {
        notebookService.addNotebook("1", VendorEnum.HP, "model1",
                1024, 1024, OsEnum.NO_OS, ColorEnum.BLACK, 24.4);
        notebookService.addNotebook("2", VendorEnum.HUAWEI, "model1",
                1048, 16000, OsEnum.LINUX, ColorEnum.SILVER, 18.8);
        notebookService.addNotebook("3", VendorEnum.APPLE, "model1",
                2048, 16000, OsEnum.MAC, ColorEnum.RED, 16.);
        HashMap<String, NotebookDTO> expected = new HashMap<>(Map.of("3",
                new NotebookDTO(VendorEnum.APPLE, "model1",
                        2048, 16000, OsEnum.MAC, ColorEnum.RED, 16.),
                "1", new NotebookDTO(VendorEnum.HP, "model1",
                        1024, 1024, OsEnum.NO_OS, ColorEnum.BLACK, 24.4),
                "2", new NotebookDTO(VendorEnum.HUAWEI, "model1",
                        1048, 16000, OsEnum.LINUX, ColorEnum.SILVER, 18.8)));
        assertEquals(expected, notebookService.getAllNotebooks());
    }

    @Test
    void getNotebooksByOs() {
        notebookService.addNotebook("1", VendorEnum.HP, "model1",
                1024, 1024, OsEnum.NO_OS, ColorEnum.BLACK, 24.4);
        notebookService.addNotebook("2", VendorEnum.HUAWEI, "model1",
                1048, 16000, OsEnum.LINUX, ColorEnum.SILVER, 18.8);
        notebookService.addNotebook("3", VendorEnum.APPLE, "model1",
                2048, 16000, OsEnum.MAC, ColorEnum.RED, 16.);
        HashMap<String, NotebookDTO> expected = new HashMap<>(Map.of("3",
                new NotebookDTO(VendorEnum.APPLE, "model1",
                        2048, 16000, OsEnum.MAC, ColorEnum.RED, 16.)));
        assertEquals(expected, notebookService.getNotebooksByOs(List.of(OsEnum.MAC)));
        expected.put("2", new NotebookDTO(VendorEnum.HUAWEI, "model1",
                1048, 16000, OsEnum.LINUX, ColorEnum.SILVER, 18.8));
        assertEquals(expected, notebookService.getNotebooksByOs(List.of(OsEnum.MAC, OsEnum.LINUX)));
    }

    @Test
    void getNotebooksByHdd() {
        notebookService.addNotebook("1", VendorEnum.HP, "model1",
                1024, 1024, OsEnum.NO_OS, ColorEnum.BLACK, 24.4);
        notebookService.addNotebook("2", VendorEnum.HUAWEI, "model1",
                1048, 12000, OsEnum.LINUX, ColorEnum.SILVER, 18.8);
        notebookService.addNotebook("3", VendorEnum.APPLE, "model1",
                2048, 16000, OsEnum.MAC, ColorEnum.RED, 16.);
        HashMap<String, NotebookDTO> expected = new HashMap<>(Map.of("3",
                new NotebookDTO(VendorEnum.APPLE, "model1",
                        2048, 16000, OsEnum.MAC, ColorEnum.RED, 16.)));

        assertEquals(expected, notebookService.getNotebooksByHddMoreThan(16000));
        expected.put("2", new NotebookDTO(VendorEnum.HUAWEI, "model1",
                1048, 12000, OsEnum.LINUX, ColorEnum.SILVER, 18.8));
        assertEquals(expected, notebookService.getNotebooksByHddMoreThan(12000));
    }

    @Test
    void getNotebooksByOzuLessThan() {
        notebookService.addNotebook("1", VendorEnum.HP, "model1",
                1024, 1024, OsEnum.NO_OS, ColorEnum.BLACK, 24.4);
        notebookService.addNotebook("2", VendorEnum.HUAWEI, "model1",
                1048, 16000, OsEnum.LINUX, ColorEnum.SILVER, 18.8);
        notebookService.addNotebook("3", VendorEnum.APPLE, "model1",
                2048, 16000, OsEnum.MAC, ColorEnum.RED, 16.);
        HashMap<String, NotebookDTO> expected = new HashMap<>(Map.of("1",
                new NotebookDTO(VendorEnum.HP, "model1",
                        1024, 1024, OsEnum.NO_OS, ColorEnum.BLACK, 24.4)));
        assertEquals(expected, notebookService.getNotebooksByOzuLessThan(1030));
        expected.put("2", new NotebookDTO(VendorEnum.HUAWEI, "model1",
                1048, 16000, OsEnum.LINUX, ColorEnum.SILVER, 18.8));
        assertEquals(expected, notebookService.getNotebooksByOzuLessThan(2000));
    }
}