package common.commands;

import common.classes.Vehicle;
import common.supplier.Supply;

import java.util.ArrayList;

public class Clear implements Command {
    ArrayList<Vehicle> list;
    String peremen;

    @Override
    public void execute(Supply s) {
        if (peremen.equals("")) {
            list = new ArrayList<Vehicle>();
            s.setCopy(list);
            System.out.println("Команда выполнена");
        } else System.out.println("Команда введена некорректно");
    }

    @Override
    public void declare(Supply s){
        peremen=s.getPeremen();
    }

    public String getName() {
        return "clear";
    }

}