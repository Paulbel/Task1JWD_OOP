package by.tc.task01.service.validation.validators.CriteriaValitators;

import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.validators.CriteriaValidator;

/**
 * Created by Sinelnikov on 10.10.2017.
 */
public class SpeakersCriteriaValidator extends CriteriaValidator {
    public SpeakersCriteriaValidator() {
        super();
        putIntCriteriaFieldValidator(SearchCriteria.Speakers.POWER_CONSUMPTION.toString());
        putIntCriteriaFieldValidator(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString());
        putStringCriteriaValidator(SearchCriteria.Speakers.FREQUENCY_RANGE.toString());
        putIntCriteriaFieldValidator(SearchCriteria.Speakers.CORD_LENGTH.toString());
    }
}
