package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

public class VacuumCleaner extends Appliance {
    private int powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private int motorSpeedRegulation;
    private int cleaningWidth;


    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public int getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(int motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public int getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(int cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "VacuumCleaner{" +
                "powerConsumption=" + powerConsumption +
                ", filterType='" + filterType + '\'' +
                ", bagType='" + bagType + '\'' +
                ", wandType='" + wandType + '\'' +
                ", motorSpeedRegulation=" + motorSpeedRegulation +
                ", cleaningWidth=" + cleaningWidth +
                '}';
    }

    @Override
    public void setAllFields(HashMap<String, String> map) {
        for (Map.Entry <String,String>entry:map.entrySet()){
            String fieldInFileName =entry.getKey();
            if (fieldInFileName.equals("POWER_CONSUMPTION")){
                this.setPowerConsumption(Integer.valueOf(entry.getValue()));
            }else if(fieldInFileName.equals("FILTER_TYPE")){
                this.setFilterType(entry.getValue());
            }else if(fieldInFileName.equals("BAG_TYPE")){
                this.setBagType(entry.getValue());
            }else if(fieldInFileName.equals("WAND_TYPE")){
                this.setWandType(entry.getValue());
            }else if(fieldInFileName.equals("MOTOR_SPEED_REGULATION")){
                this.setMotorSpeedRegulation(Integer.valueOf(entry.getValue()));
            }else if(fieldInFileName.equals("CLEANING_WIDTH")){
                this.setCleaningWidth(Integer.valueOf(entry.getValue()));
            }
        }
    }
}
