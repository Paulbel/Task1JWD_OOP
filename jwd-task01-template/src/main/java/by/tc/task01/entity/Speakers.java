package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

public class Speakers extends Appliance {
    private int powerConsumption;
    private int numberOfSpeakers;
    private String frequencyRange;
    private int cordLength;

    public Speakers() {
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Speakers{" +
                "powerConsumption=" + powerConsumption +
                ", numberOfSpeakers=" + numberOfSpeakers +
                ", frequencyRange='" + frequencyRange + '\'' +
                ", cordLength=" + cordLength +
                '}';
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public int getCordLength() {
        return cordLength;
    }

    public void setCordLength(int cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public void setAllFields(HashMap<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String fieldInFileName = entry.getKey();
            if (fieldInFileName.equals("POWER_CONSUMPTION")) {
                this.setPowerConsumption(Integer.valueOf(entry.getValue()));
            } else if (fieldInFileName.equals("NUMBER_OF_SPEAKERS")) {
                this.setNumberOfSpeakers(Integer.valueOf(entry.getValue()));
            } else if (fieldInFileName.equals("FREQUENCY_RANGE")) {
                this.setFrequencyRange(entry.getValue());
            } else if (fieldInFileName.equals("CORD_LENGTH")) {
                this.setCordLength(Integer.valueOf(entry.getValue()));
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
        Speakers speakers = (Speakers) obj;
        if (this.powerConsumption != speakers.powerConsumption) {
            return false;
        }
        if (this.numberOfSpeakers != speakers.numberOfSpeakers) {
            return false;
        }
        if (this.frequencyRange != speakers.frequencyRange) {
            return false;
        }
        if (this.cordLength != speakers.cordLength) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int multiplier = 37;
        return (int) (multiplier * (powerConsumption + numberOfSpeakers + cordLength) +
                ((frequencyRange == null) ? 0 : frequencyRange.hashCode()));
    }
}
