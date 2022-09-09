package common.commands;

import Server.tools.ServerAnswer;
import Server.tools.ServerSender;
import common.classes.Vehicle;
import common.supplier.Supply;

import java.io.Serializable;
import java.util.ArrayList;


public class RemoveById implements Command, Serializable {
    ArrayList<Vehicle> list;
    int id;

    @Override
    public void execute(Supply s) {

            // id = Integer.parseInt(s.getPeremen());
            list = s.getCopy();
            for (Vehicle vehicle : list) {
                if (vehicle.getId().equals(id)) {
                    list.remove(vehicle);
                }
            }
            s.setCopy(list);
//            System.out.println("Команда выполнена");
            ServerAnswer serverAnswer = new ServerAnswer("Команда выполнена");
            ServerSender serverSender = new ServerSender();
            serverSender.send(serverAnswer);

    }

    @Override
    public void declare(Supply s){
        try{
            id = Integer.parseInt(s.getPeremen());
        }catch (NumberFormatException e){
            System.out.println("Возникла ошибка");
        }
    }

    public String getName() {
        return "remove";
    }

}
