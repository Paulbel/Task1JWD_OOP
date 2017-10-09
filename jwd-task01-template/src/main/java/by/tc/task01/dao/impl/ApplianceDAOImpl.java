package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
        Object obj = null;
        try {
            obj = Class.forName("by.tc.task01.entity." + applianceType).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class c = obj.getClass();
        Matcher fieldMatcher = typeNamePattern.matcher(entry);
        if (fieldMatcher.find()) {
            fieldMatcher.usePattern(fieldNameValuePattern);
            while (fieldMatcher.find()) {//Проверяем следующий критерий
                String s = fieldMatcher.group(fieldNameInPatternIndex);
                s = s.toLowerCase();
                StringBuilder str = new StringBuilder(s);
                int index = 0;
                while (true) {
                    if (index != -1) {
                        if (index != 0) {
                            str.deleteCharAt(index);
                        }
                        String sp = new String(str.substring(index, index + 1));
                        str.deleteCharAt(index);
                        sp = sp.toUpperCase();
                        str.insert(index, sp);
                        str.trimToSize();
                        index = str.indexOf("_");
                    } else {
                        break;
                    }
                }
                str.insert(0, "set");
                String name = str.toString();
                try {
                    String value = fieldMatcher.group(valueInPatternIndex);
                    Pattern doubleTypePattern = Pattern.compile("\\d+\\.+\\d+");
                    Pattern stringTypePattern = Pattern.compile("((\\d+\\.*\\d*)\\-+(\\d+\\.*\\d*))|([a-zA-Z]+(\\-*[a-zA-Z])*)");
                    Matcher matcher = doubleTypePattern.matcher(value);
                    Class[] paramTypes;
                    Method method;
                    Object[] object;
                    if (matcher.matches()) {
                        paramTypes = new Class[]{double.class};
                        method = c.getMethod(name, paramTypes);
                        object = new Object[]{Double.valueOf(value)};
                        method.invoke(obj, object);
                        continue;
                    }
                    matcher.usePattern(stringTypePattern);
                    if (matcher.matches()) {
                        paramTypes = new Class[]{String.class};
                        method = c.getMethod(name, paramTypes);
                        object = new Object[]{value};
                        method.invoke(obj, object);
                        continue;
                    }
                    paramTypes = new Class[]{int.class};
                    method = c.getMethod(name, paramTypes);
                    object = new Object[]{Integer.valueOf(value)};
                    method.invoke(obj, object);
                } catch (NoSuchMethodException e) {

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return (Appliance) obj;
    }

    private <E> String findEntryInFile(Criteria<E> criteria) {
        String entryFromFile = null;
        BufferedReader br = null;
        FileReader fr = null;
        typeNamePattern = Pattern.compile(criteria.getApplianceType() + "\\s*\\:");
        try {
            fr = new FileReader(FILE_PATH);
            br = new BufferedReader(fr);
            boolean mayMatch = true;
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
        return entryFromFile;
    }
}

// you may add your own code here


//you may add your own new classes