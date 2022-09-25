package common.commands;

import Server.tools.ServerAnswer;
import Server.tools.ServerSender;
import common.classes.Vehicle;
import common.supplier.Supply;

import java.io.Serializable;
import java.util.ArrayList;

public class ShowCommand implements Command, Serializable {
    ArrayList<Vehicle> list;
    String peremen;
    String answer="";

    @Override
    public void execute(Supply s) {
        if (peremen.equals("")) {
            list = s.getCopy();
            for (Vehicle vehicle : list) {
                answer+=vehicle.getName() + " " + vehicle.getId() + " " + vehicle.getCapacity() + " " + vehicle.getEnginePower() + " " + vehicle.getCoordinateX() + " " + vehicle.getCoordinateY() + " " + vehicle.getCreationDate() + "\n";
            }
            System.out.println(answer);
            ServerAnswer serverAnswer = new ServerAnswer(answer);
            ServerSender serverSender = new ServerSender();
            serverSender.send(serverAnswer);
        } else {
            ServerAnswer serverAnswer = new ServerAnswer("Incorrect command");
            ServerSender serverSender = new ServerSender();
            serverSender.send(serverAnswer);
        };
    }

    @Override
    public void declare(Supply s){
        peremen=s.getPeremen();
    }

    public String getName() {
        return "show";
    }

}
