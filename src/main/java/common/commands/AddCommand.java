package common.commands;

import Server.tools.ServerAnswer;
import Server.tools.ServerSender;
import common.classes.Coordinates;
import common.classes.FuelType;
import common.classes.Vehicle;

import common.scanner.MyScanner;
import common.supplier.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AddCommand extends AddParent implements Command, Serializable {
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
            String answer = null;
            id = this.findMaxIdFile() + 1;

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
                answer="Элемент успешно добавлен";
                s.setCopy(list);
            }catch(Exception e){
                answer="Что-то пошло не так";
            }finally {
                ServerAnswer serverAnswer = new ServerAnswer(answer);
                ServerSender serverSender = new ServerSender();
                serverSender.send(serverAnswer);
            }

        }
        else {
//            System.out.println("Команда введена некорректно");
            ServerAnswer serverAnswer = new ServerAnswer("Команда введена некорректно");
            ServerSender serverSender = new ServerSender();
            serverSender.send(serverAnswer);
        }


    }

    @Override
    public void declare(Supply s){
        MyScanner scanner = new MyScanner();
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
