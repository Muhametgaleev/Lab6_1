package common.commands;

import Client.tools.ClientReceiver;
import Client.tools.ClientSender;
import common.managers.CommandManager;
import common.scanner.MyScanner;
import common.supplier.Supply;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Objects;


public class ExecuteScript implements Command {
    ClientReceiver receiver = new ClientReceiver();
    ClientSender packetsSender = new ClientSender();
    String nameFile;
    @Override
    public void declare(Supply supply) throws SocketException {
        Command commandd = null;
        DatagramSocket clientSocket = new DatagramSocket();
        if (!supply.getPeremen().equals("")) {
            try {
                nameFile = supply.getPeremen();
//                String nameFile = supply.getPeremen();
                CommandManager command = new CommandManager();
                MyScanner myScanner = new MyScanner(nameFile);
                while (myScanner.hasNext()) {
                    String[] s = myScanner.readNextLine().split(" ");
                    try {
                        if (s.length == 2) {
                            supply.setPeremen(s[1]);
                            if (!Objects.equals(s[0], "execute_script") & !Objects.equals(s[1], nameFile)) {
                                commandd=command.getCommand(s[0]);
                                command.getCommand(s[0]).declare(supply);

//                                supply.setHistory(s[0]);
                            }
                        } else {
                            commandd=command.getCommand(s[0]);
                            command.getCommand(s[0]).declare(supply);
//                            supply.setHistory(s[0]);
                        }
                        packetsSender.send(clientSocket, commandd);
                    } catch (NullPointerException e) {

                        System.out.println("такой команды не существует");
                    } catch (IOException e) {
//                        e.printStackTrace();
                    }
                    supply.setPeremen("");
                    try{receiver.receive(clientSocket);}
                    catch (IOException e){
                        System.out.println("Server is not available now.");
                        break;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Введите название файла корректно");
            }
        } else {
            System.out.println("Команда введена не корректно");
        }
    }

    @Override
    public void execute(Supply s){
//        nameFile = s.getPeremen();
    }

    public String getName() {
        return "execute script";
    }

}
