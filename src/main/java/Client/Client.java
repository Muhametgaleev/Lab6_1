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

        MyScanner reader = new MyScanner();
        DatagramSocket clientSocket = new DatagramSocket();
        ClientReceiver receiver = new ClientReceiver();
        ClientSender packetsSender = new ClientSender();
        CommandManager command=new CommandManager();
        Supply supply=new Supply();
//        System.out.println("hwthhwth");

        while (supply.getRunning()){
            try {
                System.out.println("hwthhwth");
                String[] s = reader.readNextLine().split(" ");
                if(s.length==2) supply.setPeremen(s[1]);

                Command commandd=command.getCommand(s[0]);
                commandd.declare(supply);
                if(!s[0].equals("execute_script")) packetsSender.send(clientSocket, commandd);
            }
            catch (Exception e){
                continue;
            }
            try{receiver.receive(clientSocket);}
            catch (SocketTimeoutException e){
                System.out.println("Server is not available now.");
                break;
            }
        }

    }
}
