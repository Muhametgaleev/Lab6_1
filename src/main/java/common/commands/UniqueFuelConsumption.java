package common.commands;

import common.classes.FuelType;
import common.classes.Vehicle;
import common.supplier.Supply;

import java.util.ArrayList;
import java.util.HashSet;


public class UniqueFuelConsumption implements Command {
    String peremen;

    @Override
    public void execute(Supply s) {
        if (peremen.equals("")) {
            ArrayList<Vehicle> list = s.getCopy();
            HashSet<FuelType> listForFuel = new HashSet<>();
            for (Vehicle vehicle : list) {
                listForFuel.add(vehicle.getFuelType());
            }
            for (FuelType unique_fuel : listForFuel) {
                System.out.println(unique_fuel);
            }
        } else System.out.println("Команда введена некорректно");
    }

    @Override
    public void declare(Supply s){
        peremen=s.getPeremen();
    }
    public String getName() {
        return "unique";
    }

}