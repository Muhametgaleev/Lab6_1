package common.commands;

import common.supplier.Supply;

import java.io.Serializable;

public class Exit implements Command, Serializable {

    public void execute(Supply s) {
        // if (s.getPeremen().equals("")) {
        //     s.setRunning(false);
        // } else System.out.println("Команда введена некорректно");
    }

    public void declare(Supply s){
        if (s.getPeremen().equals("")) {
            s.setRunning(false);
        } else System.out.println("Команда введена некорректно");
    }

    public String getName() {
        return "exit";
    }

}
