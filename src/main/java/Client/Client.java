package Client;

import Client.tools.ClientReceiver;
import Client.tools.ClientSender;
import common.commands.Command;
import common.managers.CommandManager;
import common.scanner.MyScanner;
import common.supplier.Supply;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        int isRight=0;
        MyScanner reader = new MyScanner();
        DatagramSocket clientSocket = new DatagramSocket();
        ClientReceiver receiver = new ClientReceiver();
        ClientSender packetsSender = new ClientSender();
        CommandManager command=new CommandManager();
        Supply supply=new Supply();
//        System.out.println("hwthhwth");

        while (supply.getRunning()){
            try {
                System.out.println("Enter command");
                String[] s = reader.readNextLine().split(" ");
                if (s.length < 3) {
                    isRight=1;
                    if (s.length == 2) supply.setPeremen(s[1]);
                    Command commandd = command.getCommand(s[0]);
                    commandd.declare(supply);
                    supply.setPeremen("");
                    if (!s[0].equals("execute_script")) packetsSender.send(clientSocket, commandd);

                    try{
                        if(isRight==1) receiver.receive(clientSocket);
                    }
                    catch (SocketTimeoutException e){
                        System.out.println("Server is not available now.");
                        break;
                    }

                }else{
                    System.out.println("Лишние данные");
                }
            }catch (NullPointerException e){
                System.out.println("такой команды не существует");
            } catch (Exception e){
                continue;
            }

        }

    }
}
