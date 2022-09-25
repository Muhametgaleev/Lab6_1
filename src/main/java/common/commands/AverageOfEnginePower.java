package common.commands;

import Server.tools.ServerAnswer;
import Server.tools.ServerSender;
import common.classes.Vehicle;
import common.supplier.Supply;

import java.io.Serializable;
import java.util.ArrayList;

public class AverageOfEnginePower implements Command, Serializable {
    ArrayList<Vehicle> list;
    int average = 0, number = 0;
    String peremen;


    @Override
    public void execute(Supply s) {
        String answer;
        if (peremen.equals("")) {
            try {
                list = s.getCopy();
                for (Vehicle vehicle : list) {
                    average += vehicle.getEnginePower();
                    number += 1;
                }
                System.out.println(average / number);
                answer=String.valueOf(average / number);
            } catch (ArithmeticException e) {
                answer="is empty";
            }
        }
        else answer="Incorrect command";
        ServerAnswer serverAnswer = new ServerAnswer(answer);
        ServerSender serverSender = new ServerSender();
        serverSender.send(serverAnswer);
    }

    @Override
    public void declare(Supply s){
        peremen=s.getPeremen();

    }

    public String getName() {
        return "average of power";
    }

}
