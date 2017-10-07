package by.tc.task01.entity;

public class Laptop extends Appliance{
	private int batteryCapacity;
	private String os;
	private int memoryCapacity;
	private int systemMemoryCapacity;
	private double cpuFrequence;
	private double displaySize;

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getMemoryCapacity() {
        return memoryCapacity;
    }

    public void setMemoryCapacity(int memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    public int getSystemMemoryCapacity() {
        return systemMemoryCapacity;
    }

    public void setSystemMemoryCapacity(int systemMemoryCapacity) {
        this.systemMemoryCapacity = systemMemoryCapacity;
    }

    public double getCpuFrequence() {
        return cpuFrequence;
    }

    public void setCpuFrequence(double cpuFrequence) {
        this.cpuFrequence = cpuFrequence;
    }

    public double getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(double displaySize) {
        this.displaySize = displaySize;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Laptop{" +
                "batteryCapacity=" + batteryCapacity +
                ", os='" + os + '\'' +
                ", memoryCapacity=" + memoryCapacity +
                ", systemMemoryCapacity=" + systemMemoryCapacity +
                ", cpuFrequence=" + cpuFrequence +
                ", displaySize=" + displaySize +
                '}';
    }
}

