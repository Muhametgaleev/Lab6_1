package Server;

import Server.tools.ServerReceiver;
import common.*;
import common.managers.CommandManager;
import common.parser.SaxPars;
import common.supplier.Supply;


import java.io.IOException;
import java.net.DatagramSocket;

public class Server {
    private static int SERVER_PORT=5475;
    public static void main(String[] args) throws IOException {
        ServerReceiver receiver = new ServerReceiver();
        DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT);

        while(true) {
            receiver.receive(serverSocket);
        }
    }
}
