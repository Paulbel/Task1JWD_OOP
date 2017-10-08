package by.tc.task01.entity;

public class Laptop extends Appliance{
	private int batteryCapacity;
	private String os;
	private int memoryRomCapacity;
	private int systemMemoryCapacity;
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
        return memoryRomCapacity;
    }

    public void setMemoryCapacity(int memoryRomCapacity) {
        this.memoryRomCapacity = memoryRomCapacity;
    }

    public int getSystemMemoryCapacity() {
        return systemMemoryCapacity;
    }

    public void setSystemMemoryCapacity(int systemMemoryCapacity) {
        this.systemMemoryCapacity = systemMemoryCapacity;
    }

    public double getcpu() {
        return cpu;
    }

    public void setcpu(double cpu) {
        this.cpu = cpu;
    }

    public double getdisplayInchs() {
        return displayInchs;
    }

    public void setdisplayInchs(double displayInchs) {
        this.displayInchs = displayInchs;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "batteryCapacity=" + batteryCapacity +
                ", os='" + os + '\'' +
                ", memoryCapacity=" + memoryRomCapacity +
                ", systemMemoryCapacity=" + systemMemoryCapacity +
                ", cpu=" + cpu +
                ", displayInchs=" + displayInchs +
                '}';
    }
}

