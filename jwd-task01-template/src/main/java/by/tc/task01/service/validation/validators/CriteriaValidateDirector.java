package by.tc.task01.service.validation.validators;

import by.tc.task01.service.validation.validators.CriteriaValitators.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sinelnikov on 10.10.2017.
 */
public class CriteriaValidateDirector {
    private Map<String, CriteriaValidator> creatorsMap;

    public CriteriaValidateDirector() {
        creatorsMap = new HashMap<String, CriteriaValidator>();
        creatorsMap.put("Oven", new OvenCriteriaValidator());
        creatorsMap.put("Laptop", new LaptopCriteriaValidator());
        creatorsMap.put("Refrigerator", new RefrigeratorCriteriaValidator());
        creatorsMap.put("TabletPC", new TabletPCCriteriaValidator());
        creatorsMap.put("VacuumCleaner", new VacuumCleanerCriteriaValidator());
        creatorsMap.put("Speakers", new SpeakersCriteriaValidator());
    }

    public CriteriaValidator getValidator(String validatorType) {
        return creatorsMap.get(validatorType);
    }
}
