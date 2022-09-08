package common.commands;

import common.classes.Vehicle;
import common.supplier.Supply;

import java.util.ArrayList;

public class RemoveAllByEnginePower implements Command{
    Integer enginePower;

    @Override
    public void execute(Supply s) {
        try{
            ArrayList<Vehicle> list=s.getCopy();
            ArrayList<Vehicle> listZnach=new ArrayList<>();
            for (Vehicle vehicle:list){
                if(vehicle.getEnginePower().equals(enginePower)){listZnach.add(vehicle);}
            }
            for (Vehicle znach : listZnach) {
                list.remove(znach);
            }
            s.setCopy(list);
            System.out.println("Команда выполнена");
        }
        catch (NumberFormatException e){
            System.out.println("К сожалению, данные введены неправильно");
        }
    }

    @Override
    public void declare(Supply s){
        enginePower=Integer.parseInt(s.getPeremen());
    }

    public String getName() {
        return "remove by";
    }

}
