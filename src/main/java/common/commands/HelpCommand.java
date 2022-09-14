package common.commands;

import Server.tools.ServerAnswer;
import Server.tools.ServerSender;
import common.supplier.Supply;

import java.io.Serializable;

public class HelpCommand implements Command, Serializable {
    String peremen;

    @Override
    public void execute(Supply s) {
         if(peremen.equals("")){
         String strokeHelp= """
                 help : вывести справку по доступным командам
                 info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                 show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                 add {element} : добавить новый элемент в коллекцию
                 update id {element} : обновить значение элемента коллекции, id которого равен заданному
                 remove_by_id id : удалить элемент из коллекции по его id
                 clear : очистить коллекцию
                 save : сохранить коллекцию в файл
                 execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
                 exit : завершить программу (без сохранения в файл)
                 add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
                 remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный
                 history : вывести последние 5 команд (без их аргументов)
                 remove_all_by_engine_power enginePower : удалить из коллекции все элементы, значение поля enginePower которого эквивалентно заданному
                 average_of_engine_power : вывести среднее значение поля enginePower для всех элементов коллекции
                 print_unique_fuel_consumption : вывести уникальные значения поля fuelConsumption всех элементов в коллекции""";
             ServerAnswer serverAnswer = new ServerAnswer(strokeHelp);
             ServerSender serverSender = new ServerSender();
             serverSender.send(serverAnswer);
         }
         else {
             System.out.println("Команда введена некорректно");
             ServerAnswer serverAnswer = new ServerAnswer("Команда введена некорректно");
             ServerSender serverSender = new ServerSender();
             serverSender.send(serverAnswer);
         }
    }

    @Override
    public void declare(Supply s){
        peremen=s.getPeremen();
//        if(s.getPeremen().equals(""))
//        System.out.println("help : вывести справку по доступным командам\n" +
//                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
//                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
//                "add {element} : добавить новый элемент в коллекцию\n" +
//                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
//                "remove_by_id id : удалить элемент из коллекции по его id\n" +
//                "clear : очистить коллекцию\n" +
//                "save : сохранить коллекцию в файл\n" +
//                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
//                "exit : завершить программу (без сохранения в файл)\n" +
//                "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
//                "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
//                "history : вывести последние 5 команд (без их аргументов)\n" +
//                "remove_all_by_engine_power enginePower : удалить из коллекции все элементы, значение поля enginePower которого эквивалентно заданному\n" +
//                "average_of_engine_power : вывести среднее значение поля enginePower для всех элементов коллекции\n" +
//                "print_unique_fuel_consumption : вывести уникальные значения поля fuelConsumption всех элементов в коллекции");
//        else System.out.println("Команда введена некорректно");
    }
    public String getName() {
        return "help";
    }

}
