package common.commands;

import Server.tools.ServerAnswer;
import Server.tools.ServerSender;
import common.supplier.Supply;

import java.io.Serializable;
import java.util.ArrayList;

public class HistoryCommand implements Command, Serializable {
    String peremen;
    ArrayList<String> list;

    @Override
    public void execute(Supply s) {
        String answer="";
        if (peremen.equals("")) {
             ArrayList<String> list = s.getHistory();
            for (String history : list) answer+=history+"\n";
        } else answer="Команда введена некорректно";
        ServerAnswer serverAnswer = new ServerAnswer(answer);
        ServerSender serverSender = new ServerSender();
        serverSender.send(serverAnswer);
    }

    @Override
    public void declare(Supply s){
        peremen=s.getPeremen();
//        list = s.getHistory();
    }

    public String getName() {
        return "add if max";
    }

}
