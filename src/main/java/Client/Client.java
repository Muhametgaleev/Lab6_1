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
                System.out.println("Введите команду");
                String[] s = reader.readNextLine().split(" ");
//                for(int i=0; i<s.length; i++)System.out.println(s[i]);
                if(s.length==2) supply.setPeremen(s[1]);

                Command commandd=command.getCommand(s[0]);
                commandd.declare(supply);
                supply.setPeremen("");
                if(!s[0].equals("execute_script")) packetsSender.send(clientSocket, commandd);

            }catch (NullPointerException e){
                System.out.println("такой команды не существует");
            }
            catch (Exception e){
                continue;
            }
            try{
                receiver.receive(clientSocket);
            }
            catch (SocketTimeoutException e){
                System.out.println("Server is not available now.");
                break;
            }

        }

    }
}
