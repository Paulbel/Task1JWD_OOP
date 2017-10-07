package by.tc.task01.entity;

public class TabletPC extends Appliance{
	private int batteryCapacity;
	private int displaySize;
	private int memoryRomCapacity;
	private int flashMemoryCapacity;
	private String color;

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(int displaySize) {
        this.displaySize = displaySize;
    }

    public int getMemoryRomCapacity() {
        return memoryRomCapacity;
    }

    public void setMemoryRomCapacity(int memoryRomCapacity) {
        this.memoryRomCapacity = memoryRomCapacity;
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
                ", displaySize=" + displaySize +
                ", memoryRomCapacity=" + memoryRomCapacity +
                ", flashMemoryCapacity=" + flashMemoryCapacity +
                ", color='" + color + '\'' +
                '}';
    }
}
