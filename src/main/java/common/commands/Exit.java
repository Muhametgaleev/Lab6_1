package common.commands;

import common.supplier.Supply;

public class Exit implements Command {

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
