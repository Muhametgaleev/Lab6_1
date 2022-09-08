package common.commands;

import common.managers.CommandManager;
import common.scanner.MyScanner;
import common.supplier.Supply;

import java.io.FileNotFoundException;
import java.util.Objects;


public class ExecuteScript implements Command {
    String nameFile;
    @Override
    public void execute(Supply supply) {
        if (!supply.getPeremen().equals("")) {
            try {
                String nameFile = supply.getPeremen();
                CommandManager command = new CommandManager();
                MyScanner myScanner = new MyScanner(nameFile);
                while (myScanner.hasNext()) {
                    String[] s = myScanner.readNextLine().split(" ");
                    try {
                        if (s.length == 2) {
                            supply.setPeremen(s[1]);
                            if (!Objects.equals(s[0], "execute_script") & !Objects.equals(s[1], nameFile)) {
                                command.getCommand(s[0]).execute(supply);
                                supply.setHistory(s[0]);
                            }
                        } else {
                            command.getCommand(s[0]).execute(supply);
                            supply.setHistory(s[0]);
                        }
                    } catch (NullPointerException e) {

                        System.out.println("такой команды не существует");
                    }
                    supply.setPeremen("");

                }
            } catch (FileNotFoundException e) {
                System.out.println("Введите название файла корректно");
            }
        } else {
            System.out.println("Команда введена не корректно");
        }
    }

    @Override
    public void declare(Supply s){
        nameFile = s.getPeremen();
    }

    public String getName() {
        return "add if max";
    }

}
