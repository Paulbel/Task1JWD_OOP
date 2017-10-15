package by.tc.task01.service.validation.validators.CriteriaValitators;

import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.validators.CriteriaValidator;

/**
 * Created by Sinelnikov on 10.10.2017.
 */
public class LaptopCriteriaValidator extends CriteriaValidator {
    public LaptopCriteriaValidator() {
        super();
        putIntCriteriaFieldValidator(SearchCriteria.Laptop.BATTERY_CAPACITY.toString());
        putStringCriteriaValidator(SearchCriteria.Laptop.OS.toString());
        putIntCriteriaFieldValidator(SearchCriteria.Laptop.MEMORY_ROM.toString());
        putIntCriteriaFieldValidator(SearchCriteria.Laptop.SYSTEM_MEMORY.toString());
        putDoubleCriteriaFieldValidator(SearchCriteria.Laptop.CPU.toString());
        putDoubleCriteriaFieldValidator(SearchCriteria.Laptop.DISPLAY_INCHS.toString());
    }

}
