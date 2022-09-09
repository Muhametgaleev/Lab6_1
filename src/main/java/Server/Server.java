package Server;

import Server.tools.ServerReceiver;
import common.*;
import common.managers.CommandManager;
import common.parser.SaxPars;
import common.supplier.Supply;


import java.io.IOException;
import java.net.DatagramSocket;

public class Server {
    private static int SERVER_PORT=8000;

    public static void main(String[] args) throws IOException {
//        CollectionLoader loader = new CollectionLoader();
//        loader.load();
//        CollectionManager collectionManager = new CollectionManager(loader);
//        CommandManager commandManager = new CommandManager(collectionManager);

//        SaxPars saxPars=new SaxPars();
//        Supply supply=new Supply(saxPars);
//        CommandManager command=new CommandManager();
        ServerReceiver receiver = new ServerReceiver();
        DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT);

        while(true) {
            receiver.receive(serverSocket);
        }
    }
}
