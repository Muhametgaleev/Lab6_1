package common.commands;

import common.classes.Vehicle;
import common.supplier.Supply;

import java.util.ArrayList;

public class ShowCommand implements Command {
    ArrayList<Vehicle> list;
    String peremen;

    @Override
    public void execute(Supply s) {
        if (peremen.equals("")) {
            list = s.getCopy();
            for (Vehicle vehicle : list) {
                System.out.println(vehicle.getName() + " " + vehicle.getId() + " " + vehicle.getCapacity() + " " + vehicle.getEnginePower() + " " + vehicle.getCoordinateX() + " " + vehicle.getCoordinateY() + " " + vehicle.getCreationDate());
            }
        } else System.out.println("Команда введена некорректно");
    }

    @Override
    public void declare(Supply s){
        peremen=s.getPeremen();
    }

    public String getName() {
        return "show";
    }

}
