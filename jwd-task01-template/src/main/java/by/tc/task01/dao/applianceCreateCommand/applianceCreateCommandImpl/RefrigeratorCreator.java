package by.tc.task01.dao.applianceCreateCommand.applianceCreateCommandImpl;

import by.tc.task01.dao.applianceCreateCommand.CreateCommand;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;

/**
 * Created by Sinelnikov on 09.10.2017.
 */
public class RefrigeratorCreator implements CreateCommand{
    @Override
    public Appliance createAppliance() {
        return new Refrigerator();
    }
}
