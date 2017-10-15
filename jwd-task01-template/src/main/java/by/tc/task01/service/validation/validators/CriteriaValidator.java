package by.tc.task01.service.validation.validators;

import by.tc.task01.entity.criteria.Criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sinelnikov on 10.10.2017.
 */
public abstract class CriteriaValidator {

    protected HashMap<String, Pattern> patterns;

    protected CriteriaValidator() {
        this.patterns = new HashMap<String, Pattern>();
    }

    public <E> boolean validateAppliance(Criteria<E> criteria) {
        try {
            for (Map.Entry entry : criteria.getCriteria().entrySet()) {
                Pattern pattern = patterns.get(entry.getKey().toString());
                Matcher matcher = pattern.matcher(String.valueOf(entry.getValue()));
                if (!matcher.matches()) {
                    return false;
                }
            }
        } catch (NullPointerException ex) {
            return false;
        }
        return true;
    }

    protected void putIntCriteriaFieldValidator(String fieldName) {
        patterns.put(fieldName, ValidatorConstants.validateIntPattern);
    }

    protected void putDoubleCriteriaFieldValidator(String fieldName) {
        patterns.put(fieldName, ValidatorConstants.validateDoublePattern);
    }

    protected void putStringCriteriaValidator(String fieldName) {
        patterns.put(fieldName, ValidatorConstants.validateStringPattern);
    }

}
