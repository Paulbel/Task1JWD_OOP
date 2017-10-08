package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplianceDAOImpl implements ApplianceDAO {
    private String FILE_PATH = "jwd-task01-template/src/main/resources/appliances_db.txt";
    @Override
    public <E> Appliance find(Criteria<E> criteria) {
        String className = "Oven";
        BufferedReader br = null;
        FileReader fr = null;
        Pattern pattern = Pattern.compile(className + "\\s*");
        Pattern pattern1 = Pattern.compile("(\\,|\\:)\\s(\\w+)\\=(((\\d+\\.*\\d*)+\\-*(\\d+\\.*\\d*)*)|((\\w+)(\\-*(\\w*))*))");
        try {
            fr = new FileReader(FILE_PATH);
            br = new BufferedReader(fr);
            String sCurrentLine;
            boolean mayMatch = true;
            while ((sCurrentLine = br.readLine()) != null) {
                Matcher applianceMatcher = pattern.matcher(sCurrentLine);
                if (applianceMatcher.find()) {
                    applianceMatcher.usePattern(pattern1);
                    while (applianceMatcher.find() && mayMatch) {
                        for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
                            E key = entry.getKey();
                            Object value = entry.getValue();
                            if (key.toString().equals(applianceMatcher.group(2))) {
                                if (value.toString().equals(applianceMatcher.group(3))) {
                                    System.out.println("VALUE" + value);
                                } else {
                                    mayMatch = false;
                                }
                            }
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}

// you may add your own code here


//you may add your own new classes