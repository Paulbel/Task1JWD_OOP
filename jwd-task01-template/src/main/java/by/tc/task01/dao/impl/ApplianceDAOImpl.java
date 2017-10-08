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
    private final String patternForFields = "(\\,|\\:)\\s(\\w+)\\=" +
            "(((\\d+\\.*\\d*)+\\-*(\\d+\\.*\\d*)*)|((\\w+)(\\-*(\\w*))*))";

    @Override
    public <E> Appliance find(Criteria<E> criteria) {
        String entry = findEntryInFile(criteria);
        if (entry != null) {
            return createApplianceByEntry(entry);
        }
        return null;
    }

    private Appliance createApplianceByEntry(String entry) {
        /*String s = "BATTERY_CAPACITY";
        s = s.toLowerCase();
        StringBuilder str = new StringBuilder(s);
        int index = 0;
        while (true){
            if(index!=-1){
                if (index!=0) {
                    str.deleteCharAt(index);
                }
                String sp = new String(str.substring(index,index+1));
                str.deleteCharAt(index);
                sp = sp.toUpperCase();
                str.insert(index,sp);
                str.trimToSize();
                index = str.indexOf("_");
            }else {
                break;
            }

        }

        str.insert(0,"set");
        String name = str.toString();
        System.out.println(str);
        try {

            Object obj = new Laptop();
            Class c = obj.getClass();
            Class[] paramTypes = new Class[]{int.class};
            Method method = c.getMethod(name, paramTypes);

            method.invoke(obj, 2);
            System.out.println(obj.toString());
        }
        catch (NoSuchMethodException e){

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/


        return null;
    }

    private <E> String findEntryInFile(Criteria<E> criteria) {
        String entryFromFile = null;
        String className = "Oven";
        E key = null;
        BufferedReader br = null;
        FileReader fr = null;
        Pattern pattern = Pattern.compile(className + "\\s*");
        Pattern pattern1 = Pattern.compile(patternForFields);
        try {
            fr = new FileReader(FILE_PATH);
            br = new BufferedReader(fr);

            boolean mayMatch = true;
            boolean alreadyFound = false;
            while (!alreadyFound && ((entryFromFile = br.readLine()) != null)) {//проверяем слудующую строку
                Matcher applianceMatcher = pattern.matcher(entryFromFile);
                if (applianceMatcher.find()) {
                    applianceMatcher.usePattern(pattern1);
                    while (mayMatch && applianceMatcher.find()) {//Проверяем следующий критерий
                        for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
                            key = entry.getKey();
                            Object value = entry.getValue();
                            if (key.toString().equals(applianceMatcher.group(2))) {
                                if (value.toString().equals(applianceMatcher.group(3))) {
                                    alreadyFound = true;
                                    System.out.println("VALUE" + value);
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
        System.out.println(entryFromFile);
        return entryFromFile;
    }
}

// you may add your own code here


//you may add your own new classes