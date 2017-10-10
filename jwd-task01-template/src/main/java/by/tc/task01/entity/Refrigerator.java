package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

public class Refrigerator extends Appliance {
    private int powerConsumption;
    private int weight;
    private int freezerCapacity;
    private double overallCapacity;
    private double height;
    private double width;

    public Refrigerator() {
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

    public int getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(int freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
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
        return "Refrigerator{" +
                "powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", freezerCapacity=" + freezerCapacity +
                ", overallCapacity=" + overallCapacity +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    @Override
    public void setAllFields(HashMap<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String fieldInFileName = entry.getKey();
            if (fieldInFileName.equals("POWER_CONSUMPTION")) {
                this.setPowerConsumption(Integer.valueOf(entry.getValue()));
            } else if (fieldInFileName.equals("WEIGHT")) {
                this.setWeight(Integer.valueOf(entry.getValue()));
            } else if (fieldInFileName.equals("FREEZER_CAPACITY")) {
                this.setFreezerCapacity(Integer.valueOf(entry.getValue()));
            } else if (fieldInFileName.equals("OVERALL_CAPACITY")) {
                this.setOverallCapacity(Integer.valueOf(entry.getValue()));
            } else if (fieldInFileName.equals("HEIGHT")) {
                this.setHeight(Integer.valueOf(entry.getValue()));
            } else if (fieldInFileName.equals("WIDTH")) {
                this.setWidth(Double.valueOf(entry.getValue()));
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if (null == obj){
            return false;
        }
        if(this.getClass()!=obj.getClass()){
            return false;
        }
        Refrigerator refrigerator = (Refrigerator) obj;
        if(this.powerConsumption!=refrigerator.powerConsumption){
            return false;
        }
        if(this.weight!=refrigerator.weight){
            return false;
        }
        if(this.freezerCapacity!=refrigerator.freezerCapacity){
            return false;
        }
        if(this.overallCapacity!=refrigerator.overallCapacity){
            return false;
        }
        if(this.height!=refrigerator.height){
            return false;
        }
        if(this.width!=refrigerator.width){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int multiplier = 37;
        return (int) (multiplier * (powerConsumption + weight + freezerCapacity + overallCapacity + height + width));
    }
}

