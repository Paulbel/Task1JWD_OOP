package by.tc.task01.service.validation.validators.CriteriaValitators;

import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.validators.CriteriaValidator;

/**
 * Created by Sinelnikov on 10.10.2017.
 */
public class TabletPCCriteriaValidator extends CriteriaValidator {
    public TabletPCCriteriaValidator() {
        super();
        putIntCriteriaFieldValidator(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString());
        putIntCriteriaFieldValidator(SearchCriteria.TabletPC.DISPLAY_INCHES.toString());
        putIntCriteriaFieldValidator(SearchCriteria.TabletPC.MEMORY_ROM.toString());
        putIntCriteriaFieldValidator(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString());
        putStringCriteriaValidator(SearchCriteria.TabletPC.COLOR.toString());
    }
}
