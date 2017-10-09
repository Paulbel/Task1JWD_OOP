package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

public class Oven extends Appliance {
    private int powerConsumption;
    private int weight;
    private int capacity;
    private double depth;
    private double height;
    private double width;

    public double getDepth() {
        return depth;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }



    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Oven{" +
                "powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", capacity=" + capacity +
                ", depth=" + depth +
                ", height=" + height +
                ", width=" + width +
                '}';
    }



    @Override
    public void setAllFields(HashMap<String, String> map) {
        for (Map.Entry <String,String>entry:map.entrySet()){
            String fieldInFileName =entry.getKey();
            if (fieldInFileName.equals("POWER_CONSUMPTION")){
                this.setPowerConsumption(Integer.valueOf(entry.getValue()));
            }else if(fieldInFileName.equals("WEIGHT")){
                this.setWeight(Integer.valueOf(entry.getValue()));
            }else if(fieldInFileName.equals("CAPACITY")){
                this.setCapacity(Integer.valueOf(entry.getValue()));
            }else if(fieldInFileName.equals("DEPTH")){
                this.setDepth(Double.valueOf(entry.getValue()));
            }else if(fieldInFileName.equals("HEIGHT")){
                this.setHeight(Double.valueOf(entry.getValue()));
            }else if(fieldInFileName.equals("WIDTH")){
                this.setWidth(Double.valueOf(entry.getValue()));
            }
        }
    }
}



