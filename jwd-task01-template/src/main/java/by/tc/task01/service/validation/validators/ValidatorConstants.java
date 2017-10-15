package by.tc.task01.service.validation.validators;

import java.util.regex.Pattern;

/**
 * Created by Sinelnikov on 10.10.2017.
 */
public final class ValidatorConstants {
    protected static Pattern validateStringPattern;
    protected static Pattern validateDoublePattern;
    protected static Pattern validateIntPattern;
    static {
        validateStringPattern = Pattern.compile(".+");
        validateIntPattern = Pattern.compile("\\d+(\\.0)?");
        validateDoublePattern = Pattern.compile("\\d+(\\.\\d+)?");
    }
    private ValidatorConstants(){}
}
