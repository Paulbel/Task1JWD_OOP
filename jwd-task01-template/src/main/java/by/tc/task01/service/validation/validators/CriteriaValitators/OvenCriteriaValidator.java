package by.tc.task01.service.validation.validators.CriteriaValitators;

import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.validators.CriteriaValidator;

/**
 * Created by Sinelnikov on 10.10.2017.
 */
public class OvenCriteriaValidator extends CriteriaValidator {
    public OvenCriteriaValidator() {
        super();
        putIntCriteriaFieldValidator(SearchCriteria.Oven.POWER_CONSUMPTION.toString());
        putIntCriteriaFieldValidator(SearchCriteria.Oven.WEIGHT.toString());
        putIntCriteriaFieldValidator(SearchCriteria.Oven.CAPACITY.toString());
        putDoubleCriteriaFieldValidator(SearchCriteria.Oven.DEPTH.toString());
        putDoubleCriteriaFieldValidator(SearchCriteria.Oven.HEIGHT.toString());
        putDoubleCriteriaFieldValidator(SearchCriteria.Oven.WIDTH.toString());
    }
}
