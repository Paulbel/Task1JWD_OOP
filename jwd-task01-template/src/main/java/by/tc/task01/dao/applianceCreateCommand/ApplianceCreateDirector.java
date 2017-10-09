package by.tc.task01.dao.applianceCreateCommand;

import by.tc.task01.dao.applianceCreateCommand.applianceCreateCommandImpl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sinelnikov on 09.10.2017.
 */
public class ApplianceCreateDirector
{
    private Map<String,CreateCommand> creatorsMap;

    public ApplianceCreateDirector() {
        creatorsMap = new HashMap<String, CreateCommand>();
        creatorsMap.put("Oven",new OvenCreator());
        creatorsMap.put("Laptop", new LaptopCreator());
        creatorsMap.put("Refrigerator", new RefrigeratorCreator());
        creatorsMap.put("TabletPC",new TabletPCCreator());
        creatorsMap.put("VacuumCleaner", new VacuumCleanerCreator());
        creatorsMap.put("Speakers",new SpeakersCreator());
    }

    public CreateCommand getCommand(String commandName){
        return creatorsMap.get(commandName);
    }


}
