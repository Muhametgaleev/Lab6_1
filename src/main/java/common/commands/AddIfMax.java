package common.commands;

import common.classes.Coordinates;
import common.classes.FuelType;
import common.classes.Vehicle;
import common.scanner.MyScanner;
import common.supplier.Supply;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AddIfMax extends AddParent implements Command, Serializable {
    ArrayList<Vehicle> list;
    int maxEllement = 0;
    Integer id;
    String name;
    Coordinates coordinates;
    Integer capacity;
    Integer enginePower;
    LocalDateTime creationDate;
    FuelType type;
    String peremen;

    @Override
    public void execute(Supply s) {
        if (peremen.equals("")) {
            list = s.getCopy();
            for (Vehicle vehicle : list) {
                if (maxEllement < vehicle.getCapacity()) {
                    maxEllement = vehicle.getCapacity();
                }
            }

            if (maxEllement < capacity) {
                list.add(new Vehicle(id, name, coordinates, creationDate, enginePower, capacity, type));
                System.out.println("Элемент успешно добавлен");
                s.setCopy(list);
            } else {
                System.out.println("К сожалению, ваш элемент не подходит по значениям");
            }
        }
        else System.out.println("Команда введена некорректно");
    }
    @Override
    public void declare(Supply s){
        MyScanner scanner = new MyScanner();

            id = this.findMaxIdFile() + 1;
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
            peremen=s.getPeremen();
    }

    public int findMaxIdFile() {
        int maxx = 0;
        for (Vehicle vehicle : list) {
            if (vehicle.getId() > maxx) {
                maxx = vehicle.getId();
            }
        }
        return maxx;
    }

    public String getName() {
        return "add if max";
    }
}
