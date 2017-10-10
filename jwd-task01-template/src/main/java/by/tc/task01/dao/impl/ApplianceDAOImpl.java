package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.applianceCreateCommand.ApplianceCreateDirector;
import by.tc.task01.dao.applianceCreateCommand.CreateCommand;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplianceDAOImpl implements ApplianceDAO {
    private String FILE_PATH = "jwd-task01-template/src/main/resources/appliances_db.txt";
    private Pattern fieldNameValuePattern;
    private Pattern typeNamePattern;
    private int fieldNameInPatternIndex;
    private int valueInPatternIndex;

    public ApplianceDAOImpl() {
        fieldNameValuePattern = Pattern.compile("(\\w+)=(\\w+(\\-\\w+)*(\\.\\d+)*)");
        fieldNameInPatternIndex = 1;
        valueInPatternIndex = 2;
    }

    @Override
    public <E> Appliance find(Criteria<E> criteria) {
        String entry = findEntryInFile(criteria);
        if (entry != null) {
            return createApplianceByEntry(entry, criteria.getApplianceType());
        }
        return null;
    }

    private Appliance createApplianceByEntry(String entry, String applianceType) {
        ApplianceCreateDirector createDirector = new ApplianceCreateDirector();
        CreateCommand command = createDirector.getCommand(applianceType);
        Appliance appliance = command.createAppliance();
        HashMap<String, String> fieldAndValueMap = new HashMap<String, String>();
        Matcher fieldMatcher = typeNamePattern.matcher(entry);
        if (fieldMatcher.find()) {
            fieldMatcher.usePattern(fieldNameValuePattern);
            while (fieldMatcher.find()) {
                String fieldName = fieldMatcher.group(fieldNameInPatternIndex);
                String value = fieldMatcher.group(valueInPatternIndex);
                fieldAndValueMap.put(fieldName, value);
            }
        }
        appliance.setAllFields(fieldAndValueMap);
        return appliance;
    }

    private <E> String findEntryInFile(Criteria<E> criteria) {
        String entryFromFile = null;
        BufferedReader br = null;
        FileReader fr = null;
        typeNamePattern = Pattern.compile(criteria.getApplianceType() + "\\s*\\:");
        try {
            fr = new FileReader(FILE_PATH);
            br = new BufferedReader(fr);
            boolean mayMatch;
            boolean alreadyFound = false;
            while (!alreadyFound && ((entryFromFile = br.readLine()) != null)) {//проверяем слудующую строку
                Matcher applianceMatcher = typeNamePattern.matcher(entryFromFile);
                mayMatch = true;
                if (applianceMatcher.find()) {
                    applianceMatcher.usePattern(fieldNameValuePattern);
                    while (mayMatch && applianceMatcher.find()) {//Проверяем следующий критерий
                        for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
                            E key = entry.getKey();
                            Object value = entry.getValue();
                            if (key.toString().equals(applianceMatcher.group(fieldNameInPatternIndex))) {
                                if (value.toString().equals(applianceMatcher.group(valueInPatternIndex))) {
                                    alreadyFound = true;
                                } else {
                                    mayMatch = false;
                                    alreadyFound = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            return null;
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
        }
        return entryFromFile;
    }
}
