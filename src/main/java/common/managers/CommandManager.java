package common.managers;

import common.commands.*;
import common.commands.Command;

import java.util.HashMap;

public class CommandManager {
    public static HashMap<String, Command> commandColl = new HashMap<>();


    public CommandManager() {
        commandColl.put("add",new AddCommand());
        commandColl.put("average_of_engine_power",new AverageOfEnginePower());
        commandColl.put("clear",new Clear());
        commandColl.put("execute_script",new ExecuteScript());
        commandColl.put("exit",new Exit());
        commandColl.put("help",new HelpCommand());
        commandColl.put("history",new HistoryCommand());
        commandColl.put("info",new Info());
        commandColl.put("add_if_max",new AddIfMax());
        commandColl.put("remove_by_id",new RemoveById());
        commandColl.put("remove_lower",new RemoveLower());
        commandColl.put("remove_all_by_engine_power",new RemoveAllByEnginePower());
        commandColl.put("save",new SaveCommand());
        commandColl.put("show",new ShowCommand());
        commandColl.put("print_unique_fuel_consumption",new UniqueFuelConsumption());
        commandColl.put("update",new UpdateCommand());
    }
    public Command getCommand(String s){
        return commandColl.get(s);
    }
}
