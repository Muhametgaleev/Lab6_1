package common.commands;

import common.classes.Vehicle;
import common.supplier.Supply;

import java.util.ArrayList;

public class AverageOfEnginePower implements Command {
    ArrayList<Vehicle> list;
    int average = 0, number = 0;
    String peremen;


    @Override
    public void execute(Supply s) {
        if (peremen.equals("")) {
            try {
                list = s.getCopy();
                for (Vehicle vehicle : list) {
                    average += vehicle.getEnginePower();
                    number += 1;
                }
                System.out.println(average / number);
            } catch (ArithmeticException e) {
                System.out.println("Коллекция пуста");
            }
        }
        else System.out.println("Команда введена некорректно");
    }

    @Override
    public void declare(Supply s){
        peremen=s.getPeremen();

    }

    public String getName() {
        return "average of power";
    }

}
