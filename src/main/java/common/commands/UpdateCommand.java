package common.commands;

import Server.tools.ServerAnswer;
import Server.tools.ServerSender;
import common.classes.Coordinates;
import common.classes.FuelType;
import common.classes.Vehicle;
import common.scanner.MyScanner;
import common.supplier.Supply;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class UpdateCommand extends AddParent implements Command, Serializable {
    ArrayList<Vehicle> list;
    Integer id;
    String name;
    Coordinates coordinates;
    Integer capacity;
    Integer enginePower;
    LocalDateTime creationDate;
    FuelType type;

    @Override
    public void execute(Supply s) {
//        try {
            list=s.getCopy();
            list.removeIf(vehicle -> vehicle.getId().equals(id));
            list.add(new Vehicle(id, name, coordinates, creationDate, enginePower, capacity, type));
//            System.out.println("Элемент добавлен");
            s.setCopy(list);
            ServerAnswer serverAnswer = new ServerAnswer("Success");
            ServerSender serverSender = new ServerSender();
            serverSender.send(serverAnswer);

//        }
//        catch (NumberFormatException e){
//            ServerAnswer serverAnswer = new ServerAnswer("Неправильно введенная команда");
//            ServerSender serverSender = new ServerSender();
//            serverSender.send(serverAnswer);
//        }
    }

    public void declare(Supply s){
        MyScanner scanner = new MyScanner();
            System.out.println("If the item is not found, it will be automatically added to the collection.");
            id=Integer.parseInt(s.getPeremen());
            if(id<=0){
                id=analizeInteger(scanner, "id");
            }
            System.out.println("Enter name");
            name = scanner.readNextLine();

            coordinates = new Coordinates(analizeFloat(scanner, "cordx"), analizeLong(scanner, "cordy"));
            System.out.println("Enter Capacity");
            capacity = analizeInteger(scanner, "capacity");
            System.out.println("Enter Engine power");
            enginePower = analizeInteger(scanner, "Engine Power");
            creationDate = LocalDateTime.now();
            System.out.println("Enter FuelType");
            type = analizeFuel(scanner, "FuelType");
    }

    public String getName() {
        return "update";
    }

}
