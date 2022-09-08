package common.commands;

import common.classes.Coordinates;
import common.classes.FuelType;
import common.classes.Vehicle;
import common.scanner.MyScanner;
import common.supplier.Supply;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UpdateCommand extends AddParent implements Command{
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
        try {
            list=s.getCopy();
            int id=Integer.parseInt(s.getPeremen());
            list.removeIf(vehicle -> vehicle.getId().equals(id));

            MyScanner scanner=new MyScanner();
            System.out.println("Введите имя");
            String name= scanner.readNextLine();
            Coordinates coordinates=new Coordinates(analizeFloat(scanner,"cordx"), analizeLong(scanner,"cordy"));
            Integer  capacity= analizeInteger(scanner, "capacity");
            Integer  enginePower= analizeInteger(scanner, "Engine Power");
            LocalDateTime creationDate = LocalDateTime.now();
            FuelType type=analizeFuel(scanner, "FuelType");

            list.add(new Vehicle(id, name, coordinates, creationDate, enginePower, capacity, type));
            System.out.println("Элемент добавлен");
            s.setCopy(list);

        }
        catch (NumberFormatException e){execute(s);}
    }

    public void declare(Supply s){
        MyScanner scanner = new MyScanner();

            id=Integer.parseInt(s.getPeremen());
            System.out.println("Введите имя");
            name = scanner.readNextLine();

            coordinates = new Coordinates(analizeFloat(scanner, "cordx"), analizeLong(scanner, "cordy"));
            System.out.println("Введите значение Capacity");
            capacity = analizeInteger(scanner, "capacity");
            System.out.println("Введите значание Engine power");
            enginePower = analizeInteger(scanner, "Engine Power");
            creationDate = LocalDateTime.now();
            System.out.println("Введите значение FuelType");
            type = analizeFuel(scanner, "FuelType");
    }

    public String getName() {
        return "update";
    }

}
