package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private static Pattern validateStringPattern;
	private static Pattern validateDoublePattern;
	private static Pattern validateIntPattern;
	private static HashMap<String,HashMap> patterns;


	static {
		validateStringPattern = Pattern.compile(".+");
		validateIntPattern = Pattern.compile("\\d+");
		validateDoublePattern = Pattern.compile("\\d+(\\.\\d+)?");
		patterns = new HashMap<String, HashMap>();
		HashMap<SearchCriteria.Oven,Pattern> ovenPatternHashMap = new HashMap<SearchCriteria.Oven, Pattern>();
		ovenPatternHashMap.put(SearchCriteria.Oven.POWER_CONSUMPTION,validateIntPattern);
		ovenPatternHashMap.put(SearchCriteria.Oven.WEIGHT, validateIntPattern);
		ovenPatternHashMap.put(SearchCriteria.Oven.CAPACITY, validateIntPattern);
		ovenPatternHashMap.put(SearchCriteria.Oven.DEPTH, validateDoublePattern);
		ovenPatternHashMap.put(SearchCriteria.Oven.HEIGHT, validateDoublePattern);
		ovenPatternHashMap.put(SearchCriteria.Oven.WIDTH, validateDoublePattern);
		HashMap<SearchCriteria.Laptop,Pattern> laptopPatternHashMap = new HashMap<SearchCriteria.Laptop, Pattern>();
		laptopPatternHashMap.put(SearchCriteria.Laptop.BATTERY_CAPACITY, validateIntPattern);
		laptopPatternHashMap.put(SearchCriteria.Laptop.OS, validateStringPattern);
		laptopPatternHashMap.put(SearchCriteria.Laptop.MEMORY_ROM, validateIntPattern);
		laptopPatternHashMap.put(SearchCriteria.Laptop.SYSTEM_MEMORY, validateIntPattern);
		laptopPatternHashMap.put(SearchCriteria.Laptop.CPU, validateDoublePattern);
		laptopPatternHashMap.put(SearchCriteria.Laptop.DISPLAY_INCHS, validateDoublePattern);
		HashMap<SearchCriteria.Refrigerator,Pattern> refrigeratorPatternHashMap = new HashMap<SearchCriteria.Refrigerator, Pattern>();
		refrigeratorPatternHashMap.put(SearchCriteria.Refrigerator.POWER_CONSUMPTION, validateIntPattern);
		refrigeratorPatternHashMap.put(SearchCriteria.Refrigerator.WEIGHT, validateIntPattern);
		refrigeratorPatternHashMap.put(SearchCriteria.Refrigerator.FREEZER_CAPACITY, validateIntPattern);
		refrigeratorPatternHashMap.put(SearchCriteria.Refrigerator.OVERALL_CAPACITY, validateIntPattern);
		refrigeratorPatternHashMap.put(SearchCriteria.Refrigerator.HEIGHT, validateIntPattern);
		refrigeratorPatternHashMap.put(SearchCriteria.Refrigerator.WIDTH, validateIntPattern);
		HashMap<SearchCriteria.Speakers,Pattern> speakersPatternHashMap = new HashMap<SearchCriteria.Speakers, Pattern>();
		speakersPatternHashMap.put(SearchCriteria.Speakers.POWER_CONSUMPTION, validateIntPattern);
		speakersPatternHashMap.put(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS, validateIntPattern);
		speakersPatternHashMap.put(SearchCriteria.Speakers.FREQUENCY_RANGE, validateStringPattern);
		speakersPatternHashMap.put(SearchCriteria.Speakers.CORD_LENGTH, validateIntPattern);
		HashMap<SearchCriteria.TabletPC,Pattern> tabletPCPatternHashMap = new HashMap<SearchCriteria.TabletPC, Pattern>();
		tabletPCPatternHashMap.put(SearchCriteria.TabletPC.BATTERY_CAPACITY, validateIntPattern);
		tabletPCPatternHashMap.put(SearchCriteria.TabletPC.DISPLAY_INCHES, validateIntPattern);
		tabletPCPatternHashMap.put(SearchCriteria.TabletPC.MEMORY_ROM, validateIntPattern);
		tabletPCPatternHashMap.put(SearchCriteria.TabletPC.BATTERY_CAPACITY, validateIntPattern);
		tabletPCPatternHashMap.put(SearchCriteria.TabletPC.COLOR, validateStringPattern);
		HashMap<SearchCriteria.VacuumCleaner,Pattern> vacuumCleanerPatternHashMap = new HashMap<SearchCriteria.VacuumCleaner, Pattern>();
		vacuumCleanerPatternHashMap.put(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION, validateIntPattern);
		vacuumCleanerPatternHashMap.put(SearchCriteria.VacuumCleaner.FILTER_TYPE, validateStringPattern);
		vacuumCleanerPatternHashMap.put(SearchCriteria.VacuumCleaner.BAG_TYPE, validateStringPattern);
		vacuumCleanerPatternHashMap.put(SearchCriteria.VacuumCleaner.WAND_TYPE, validateStringPattern);
		vacuumCleanerPatternHashMap.put(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION, validateIntPattern);
		vacuumCleanerPatternHashMap.put(SearchCriteria.VacuumCleaner.CLEANING_WIDTH, validateIntPattern);
		patterns.put("Oven",ovenPatternHashMap);
		patterns.put("Laptop",laptopPatternHashMap);
		patterns.put("Refrigerator",refrigeratorPatternHashMap);
		patterns.put("Speakers",speakersPatternHashMap);
		patterns.put("TabletPC",tabletPCPatternHashMap);
		patterns.put("VacuumCleaner",vacuumCleanerPatternHashMap);

	}

	public static <E> boolean criteriaValidator(Criteria<E> criteria) {
		String applianceType = criteria.getApplianceType();
		HashMap <Criteria, Pattern> patternMap = patterns.get(applianceType);
		for (Map.Entry entry:criteria.getCriteria().entrySet()){
			Pattern pattern = patternMap.get(entry.getKey());
			Matcher matcher = pattern.matcher(String.valueOf(entry.getValue()));
			if(!matcher.matches()){
				System.out.println("BAD PARAMETER!");
				return false;
			}
		}
		// you may add your own code here
		
		return true;
	}

}

//you may add your own new classes