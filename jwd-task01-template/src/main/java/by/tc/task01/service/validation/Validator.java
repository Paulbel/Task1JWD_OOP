package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.validation.validators.CriteriaValidator;
import by.tc.task01.service.validation.validators.CriteriaValitators.CriteriaValidateDirector;

public class Validator {
    public static <E> boolean criteriaValidator(Criteria<E> criteria) {
        CriteriaValidateDirector criteriaValidateDirector = new CriteriaValidateDirector();
        CriteriaValidator criteriaValidator = criteriaValidateDirector.getValidator(criteria.getApplianceType());
        return criteriaValidator.validateAppliance(criteria);
    }
}
