package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

/**
 * Created by Sinelnikov on 08.10.2017.
 */
public final class ApplianceFactory {
    private static final ApplianceFactory instance = new ApplianceFactory();

    private ApplianceFactory() {}

    public Appliance getAppliance(Object object) {
        if (object instanceof SearchCriteria.Oven){
            return new Oven();
        }
        return null;
    }

    public static ApplianceFactory getInstance() {
        return instance;
    }
}




