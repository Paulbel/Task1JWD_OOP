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

    public Oven() {
    }

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
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String fieldInFileName = entry.getKey();
            if (fieldInFileName.equals("POWER_CONSUMPTION")) {
                this.setPowerConsumption(Integer.valueOf(entry.getValue()));
            } else if (fieldInFileName.equals("WEIGHT")) {
                this.setWeight(Integer.valueOf(entry.getValue()));
            } else if (fieldInFileName.equals("CAPACITY")) {
                this.setCapacity(Integer.valueOf(entry.getValue()));
            } else if (fieldInFileName.equals("DEPTH")) {
                this.setDepth(Double.valueOf(entry.getValue()));
            } else if (fieldInFileName.equals("HEIGHT")) {
                this.setHeight(Double.valueOf(entry.getValue()));
            } else if (fieldInFileName.equals("WIDTH")) {
                this.setWidth(Double.valueOf(entry.getValue()));
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
        Oven oven = (Oven) obj;
        if (this.powerConsumption != oven.powerConsumption) {
            return false;
        }
        if (this.weight != oven.weight) {
            return false;
        }
        if (this.capacity != oven.capacity) {
            return false;
        }
        if (this.depth != oven.depth) {
            return false;
        }
        if (this.height != oven.height) {
            return false;
        }
        if (this.width != oven.width) {
            return false;
        }
        return true;
    }


    @Override
    public int hashCode() {
        int multiplier = 37;
        return (int) (multiplier * (powerConsumption + weight + capacity + depth + height + width));
    }
}



