package common.commands;


import Server.tools.ServerAnswer;
import Server.tools.ServerSender;
import common.classes.Vehicle;
import common.scanner.MyScanner;
import common.supplier.Supply;

import java.util.ArrayList;

public class RemoveLower extends AddParent implements Command {
    Integer capacity;
    String peremen;

    @Override
    public void execute(Supply s) {
        String answer;
        if (peremen.equals("")) {
            ArrayList<Vehicle> list = s.getCopy();
            ArrayList<Vehicle> listZnach = new ArrayList<>();
            
            for (Vehicle vehicle : list) {
                if (vehicle.getCapacity() < capacity) {
                    listZnach.add(vehicle);
                }
            }

            for (Vehicle znach : listZnach) {
                list.remove(znach);
            }
            s.setCopy(list);
            answer="Команда выполнена";
        } else answer="Команда введена некорректно";

        ServerAnswer serverAnswer = new ServerAnswer(answer);
        ServerSender serverSender = new ServerSender();
        serverSender.send(serverAnswer);
    }

    @Override
    public void declare(Supply s){
        MyScanner scanner = new MyScanner();
        System.out.println("Введите значение Capacity");
        capacity = analizeInteger(scanner, "capacity");
        peremen=s.getPeremen();
    }
    public String getName() {
        return "remove lower";
    }

}
