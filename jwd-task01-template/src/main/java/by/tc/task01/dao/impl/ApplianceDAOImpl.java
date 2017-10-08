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

    @Override
    public <E> Appliance find(Criteria<E> criteria) {
        String className = "Oven";
        E key = null;
        BufferedReader br = null;
        FileReader fr = null;
        Pattern pattern = Pattern.compile(className + "\\s*");
        Pattern pattern1 = Pattern.compile("(\\,|\\:)\\s(\\w+)\\=(((\\d+\\.*\\d*)+\\-*(\\d+\\.*\\d*)*)|((\\w+)(\\-*(\\w*))*))");
        try {
            fr = new FileReader(FILE_PATH);
            br = new BufferedReader(fr);
            String sCurrentLine;
            boolean mayMatch = true;
            boolean alreadyFound = false;
            while ((sCurrentLine = br.readLine()) != null && !alreadyFound) {//проверяем слудующую строку
                Matcher applianceMatcher = pattern.matcher(sCurrentLine);
                if (applianceMatcher.find()) {
                    applianceMatcher.usePattern(pattern1);
                    while (applianceMatcher.find() && mayMatch) {//Проверяем следующий критерий
                        for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
                            key = entry.getKey();
                            Object value = entry.getValue();
                            if (key.toString().equals(applianceMatcher.group(2))) {
                                if (value.toString().equals(applianceMatcher.group(3))) {
                                    System.out.println("VALUE" + value);
                                } else {
                                    mayMatch = false;
                                    break;
                                }
                            }
                        }
                        alreadyFound = true;
                    }
                }
            }

            if(alreadyFound){
                System.out.println(sCurrentLine);
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
/*        String s = "BATTERY_CAPACITY";
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
}

// you may add your own code here


//you may add your own new classes