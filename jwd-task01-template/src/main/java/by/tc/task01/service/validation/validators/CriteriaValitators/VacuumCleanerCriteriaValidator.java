package by.tc.task01.service.validation.validators.CriteriaValitators;

import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.validators.CriteriaValidator;

/**
 * Created by Sinelnikov on 10.10.2017.
 */
public class VacuumCleanerCriteriaValidator extends CriteriaValidator {
    public VacuumCleanerCriteriaValidator() {
        super();
        putIntCriteriaFieldValidator(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString());
        putStringCriteriaValidator(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString());
        putStringCriteriaValidator(SearchCriteria.VacuumCleaner.BAG_TYPE.toString());
        putStringCriteriaValidator(SearchCriteria.VacuumCleaner.WAND_TYPE.toString());
        putIntCriteriaFieldValidator(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString());
        putIntCriteriaFieldValidator(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString());
    }
}
