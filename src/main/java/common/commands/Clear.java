package common.commands;

import Server.tools.ServerAnswer;
import Server.tools.ServerSender;
import common.classes.Vehicle;
import common.supplier.Supply;

import java.io.Serializable;
import java.util.ArrayList;

public class Clear implements Command, Serializable {
    ArrayList<Vehicle> list;
    String peremen;

    @Override
    public void execute(Supply s) {
        String answer;
        if (peremen.equals("")) {
            list = new ArrayList<Vehicle>();
            s.setCopy(list);
            answer="Команда выполнена";

        } else answer="Команда введена некорректно";
        ServerAnswer serverAnswer = new ServerAnswer(answer);
        ServerSender serverSender = new ServerSender();
        serverSender.send(serverAnswer);
    }

    @Override
    public void declare(Supply s){
        peremen=s.getPeremen();
    }

    public String getName() {
        return "clear";
    }

}