package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

public class Laptop extends Appliance {
    private int batteryCapacity;
    private String os;
    private int memoryRom;
    private int systemMemory;
    private double cpu;
    private int displayInchs;

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

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public double getdisplayInchs() {
        return displayInchs;
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

    @Override
    public void setAllFields(HashMap<String,String> map) {
        for (Map.Entry <String,String>entry:map.entrySet()){
            String fieldInFileName =entry.getKey();
            if (fieldInFileName.equals("BATTERY_CAPACITY")){
                this.setBatteryCapacity(Integer.valueOf(entry.getValue()));
            }else if(fieldInFileName.equals("OS")){
                this.setOs(entry.getValue());
            }else if(fieldInFileName.equals("MEMORY_ROM")){
                this.setMemoryRom(Integer.valueOf(entry.getValue()));
            }else if(fieldInFileName.equals("SYSTEM_MEMORY")){
                this.setSystemMemoryCapacity(Integer.valueOf(entry.getValue()));
            }else if(fieldInFileName.equals("CPU")){
                this.setCpu(Double.valueOf(entry.getValue()));
            }else if(fieldInFileName.equals("DISPLAY_INCHS")){
                this.setDisplayInchs(Integer.valueOf(entry.getValue()));
            }
        }
    }
}

