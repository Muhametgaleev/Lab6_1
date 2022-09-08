package common.commands;

import common.supplier.Supply;

public class Info implements Command {
    String peremen;

    @Override
    public void execute(Supply s) {
        if (s.getPeremen().equals(""))
            System.out.println("Количество элементов в коллекции на данный момент " + s.getSize() + " Остальные данные " + s.toString() + " " + s.hashCode());
        else System.out.println("Команда введена некорректно");
    }

    @Override
    public void declare(Supply s){
        peremen=s.getPeremen();
    }
    public String getName() {
        return "Info";
    }

}
