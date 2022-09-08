package common.commands;

import common.classes.Coordinates;
import common.classes.FuelType;
import common.classes.Vehicle;

import common.scanner.MyScanner;
import common.supplier.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class AddCommand extends AddParent implements Command {
    ArrayList<Vehicle> list;

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
        if(peremen.equals("")) {
            list = s.getCopy();


            // MyScanner scanner = new MyScanner();

            // Integer id = this.findMaxIdFile() + 1;
            // System.out.println("Введите имя");
            // String name = scanner.readNextLine();

            // Coordinates coordinates = new Coordinates(analizeFloat(scanner, "cordx"), analizeLong(scanner, "cordy"));
            // System.out.println("Введите значение Capacity");
            // Integer capacity = analizeInteger(scanner, "capacity");
            // System.out.println("Введите значание Engine power");
            // Integer enginePower = analizeInteger(scanner, "Engine Power");
            // LocalDateTime creationDate = LocalDateTime.now();
            // System.out.println("Введите значение FuelType");
            // FuelType type = analizeFuel(scanner, "FuelType");
            try{
                list.add(new Vehicle(id, name, coordinates, creationDate, enginePower, capacity, type));
                System.out.println("Элемент успешно добавлен");
                s.setCopy(list);
            }catch(Exception e){
                System.out.println("Что-то пошло не так");
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
    public int findMaxIdFile(){
        int maxx=0;
        for (Vehicle vehicle: list){
            if(vehicle.getId()>maxx){maxx=vehicle.getId();}
        }
        return maxx;
    }

    public String getName() {
        return "add";
    }
}
