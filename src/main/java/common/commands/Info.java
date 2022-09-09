package common.commands;

import Server.tools.ServerAnswer;
import Server.tools.ServerSender;
import common.supplier.Supply;

import java.io.Serializable;

public class Info implements Command, Serializable {
    String peremen;
    String answer;

    @Override
    public void execute(Supply s) {
        if (s.getPeremen().equals(""))
            answer="Количество элементов в коллекции на данный момент " + s.getSize() + " Остальные данные " + s.toString() + " " + s.hashCode();
        else answer="Команда введена некорректно";
        ServerAnswer serverAnswer = new ServerAnswer(answer);
        ServerSender serverSender = new ServerSender();
        serverSender.send(serverAnswer);
    }

    @Override
    public void declare(Supply s){
        peremen=s.getPeremen();
    }
    public String getName() {
        return "Info";
    }

}
