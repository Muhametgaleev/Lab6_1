package common.commands;

import Server.tools.ServerAnswer;
import Server.tools.ServerSender;
import common.classes.Vehicle;
import common.supplier.Supply;

import java.io.Serializable;
import java.util.ArrayList;

public class RemoveAllByEnginePower implements Command, Serializable {
    Integer enginePower;

    @Override
    public void execute(Supply s) {
        String answer = null;
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
            answer="Succes";
        }
        catch (NumberFormatException e){
            answer="Incorrect data of command";
        }finally {
            ServerAnswer serverAnswer = new ServerAnswer(answer);
            ServerSender serverSender = new ServerSender();
            serverSender.send(serverAnswer);
        }
    }

    @Override
    public void declare(Supply s){
        enginePower=Integer.parseInt(s.getPeremen());
    }

    public String getName() {
        return "remove all by power";
    }

}
