package Server.tools;

import common.commands.Command;
import common.parser.SaxPars;
import common.supplier.Supply;
import lombok.Getter;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerReceiver {
    SaxPars saxPars=new SaxPars();
    Supply supply=new Supply(saxPars);
    @Getter
    private static DatagramPacket datagramPacket;

    public static DatagramPacket getDatagramPacket() {
        return datagramPacket;
    }

    @Getter
    private static DatagramSocket datagramSocket;

    public static DatagramSocket getDatagramSocket() {
        return datagramSocket;
    }

    public void receive(DatagramSocket serverSocket) throws IOException {
        byte[] receiveData = new byte[8096];

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        datagramPacket = receivePacket;
        datagramSocket = serverSocket;
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(receiveData))) {
            Command command = (Command) ois.readObject();
            System.out.println("Command "+ command.getName()+" received.");
            command.execute(supply);
            supply.setHistory(command.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
