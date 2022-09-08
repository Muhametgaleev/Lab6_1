package common.commands;

import common.supplier.Supply;

import java.util.ArrayList;

public class HistoryCommand implements Command {
    String peremen;
    ArrayList<String> list;

    @Override
    public void execute(Supply s) {
        if (peremen.equals("")) {
             ArrayList<String> list = s.getHistory();
            for (String history : list) System.out.println(history);
        } else System.out.println("Команда введена некорректно");
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
