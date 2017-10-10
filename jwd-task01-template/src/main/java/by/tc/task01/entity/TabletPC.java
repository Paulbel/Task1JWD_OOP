package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

public class TabletPC extends Appliance {
    private int batteryCapacity;
    private int displayInches;
    private int memoryRom;
    private int flashMemoryCapacity;
    private String color;

    public TabletPC() {
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(int flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "TabletPC{" +
                "batteryCapacity=" + batteryCapacity +
                ", displayInches=" + displayInches +
                ", memoryRom=" + memoryRom +
                ", flashMemoryCapacity=" + flashMemoryCapacity +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public void setAllFields(HashMap<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String fieldInFileName = entry.getKey();
            if (fieldInFileName.equals("BATTERY_CAPACITY")) {
                this.setBatteryCapacity(Integer.valueOf(entry.getValue()));
            } else if (fieldInFileName.equals("DISPLAY_INCHES")) {
                this.setDisplayInches(Integer.valueOf(entry.getValue()));
            } else if (fieldInFileName.equals("MEMORY_ROM")) {
                this.setMemoryRom(Integer.valueOf(entry.getValue()));
            } else if (fieldInFileName.equals("FLASH_MEMORY_CAPACITY")) {
                this.setFlashMemoryCapacity(Integer.valueOf(entry.getValue()));
            } else if (fieldInFileName.equals("COLOR")) {
                this.setColor(entry.getValue());
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        TabletPC tabletPC = (TabletPC) obj;
        if (this.batteryCapacity != tabletPC.batteryCapacity) {
            return false;
        }
        if (this.displayInches != tabletPC.displayInches) {
            return false;
        }
        if (this.memoryRom != tabletPC.memoryRom) {
            return false;
        }
        if (this.flashMemoryCapacity != tabletPC.flashMemoryCapacity) {
            return false;
        }
        if (this.color != tabletPC.color) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int multiplier = 37;
        return multiplier * (batteryCapacity + displayInches + memoryRom + flashMemoryCapacity) +
                ((color == null) ? 0 : color.hashCode());
    }
}
