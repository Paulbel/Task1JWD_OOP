package by.tc.task01.entity;

public class Laptop extends Appliance{
	private int batteryCapacity;
	private String os;
	private int memoryRom;
	private int systemMemory;
	private double cpu;
	private double displayInchs;

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
        return memoryRom;
    }

    public void setMemoryCapacity(int memoryRomCapacity) {
        this.memoryRom = memoryRomCapacity;
    }

    public int getSystemMemoryCapacity() {
        return systemMemory;
    }

    public void setSystemMemoryCapacity(int systemMemoryCapacity) {
        this.systemMemory = systemMemoryCapacity;
    }

    public double getcpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public void setCpu(int cpu){
        this.cpu = cpu;
    }

    public double getdisplayInchs() {
        return displayInchs;
    }

    public void setdisplayInchs(double displayInchs) {
        this.displayInchs = displayInchs;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public double getCpu() {
        return cpu;
    }

    public double getDisplayInchs() {
        return displayInchs;
    }

    public void setDisplayInchs(int displayInchs) {
        this.displayInchs = displayInchs;
    }

    public void setDisplayInchs(double displayInchs) {
        this.displayInchs = displayInchs;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "batteryCapacity=" + batteryCapacity +
                ", os='" + os + '\'' +
                ", memoryCapacity=" + memoryRom +
                ", systemMemoryCapacity=" + systemMemory +
                ", cpu=" + cpu +
                ", displayInchs=" + displayInchs +
                '}';
    }
}

