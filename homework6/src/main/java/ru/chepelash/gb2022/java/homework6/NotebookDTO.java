package ru.chepelash.gb2022.java.homework6;

import ru.chepelash.gb2022.java.homework6.enums.ColorEnum;
import ru.chepelash.gb2022.java.homework6.enums.OsEnum;
import ru.chepelash.gb2022.java.homework6.enums.VendorEnum;

import java.util.Objects;

public class NotebookDTO {
    private final VendorEnum vendor;
    private final String model;
    private final int ozu;
    private final int hddSize;
    private final OsEnum os;
    private final ColorEnum color;
    private final double screenSize;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotebookDTO that = (NotebookDTO) o;
        return ozu == that.ozu && hddSize == that.hddSize && Double.compare(that.screenSize, screenSize) == 0 && vendor == that.vendor && model.equals(that.model) && os == that.os && color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendor, model, ozu, hddSize, os, color, screenSize);
    }

    public NotebookDTO(VendorEnum vendor, String model, int ozu, int hddSize, OsEnum os, ColorEnum color, double screenSize) {
        this.vendor = vendor;
        this.model = model;
        this.ozu = ozu;
        this.hddSize = hddSize;
        this.os = os;
        this.color = color;
        this.screenSize = screenSize;
    }

    public VendorEnum getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public int getOzu() {
        return ozu;
    }

    public int getHddSize() {
        return hddSize;
    }

    public OsEnum getOs() {
        return os;
    }

    public ColorEnum getColor() {
        return color;
    }

    public double getScreenSize() {
        return screenSize;
    }
}
