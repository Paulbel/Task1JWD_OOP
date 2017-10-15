package by.tc.task01.service.validation.validators.CriteriaValitators;

import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.validators.CriteriaValidator;

/**
 * Created by Sinelnikov on 10.10.2017.
 */
public class RefrigeratorCriteriaValidator extends CriteriaValidator {
    public RefrigeratorCriteriaValidator() {
        super();
        putIntCriteriaFieldValidator(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString());
        putIntCriteriaFieldValidator(SearchCriteria.Refrigerator.WEIGHT.toString());
        putIntCriteriaFieldValidator(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString());
        putIntCriteriaFieldValidator(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString());
        putIntCriteriaFieldValidator(SearchCriteria.Refrigerator.HEIGHT.toString());
        putIntCriteriaFieldValidator(SearchCriteria.Refrigerator.WIDTH.toString());
    }


}
