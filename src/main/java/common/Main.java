package common;

import common.managers.CommandManager;
import common.parser.SaxPars;
import common.scanner.MyScanner;
import common.supplier.Supply;
import common.commands.*;

public class Main {
    public static  void main(String[] args) {
        MyScanner myScanner=new MyScanner();
        SaxPars saxPars=new SaxPars();
        Supply supply=new Supply(saxPars);
        CommandManager command=new CommandManager();

        while (supply.getRunning()) {
            String[] s = myScanner.readNextLine().split(" ");
            try{
                    if(s.length==2) supply.setPeremen(s[1]);
                    command.getCommand(s[0]).declare(supply);
                    supply.setHistory(s[0]);
            }
            catch (NullPointerException e){

                System.out.println("такой команды не существует");
            }
            supply.setPeremen("");
        }
    }
}
