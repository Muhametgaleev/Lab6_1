package common.scanner;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.DatagramSocket;
import java.util.NoSuchElementException;
import java.util.Scanner;
import Client.tools.*;
import common.commands.*;

/**
 * Класс ввода данных через консоль
 *
 */
public class MyScanner {
    private String[] arraysOfParams;
    Scanner read;
    public String[] getArrayOfParams(){
        return this.arraysOfParams;
    }

    public MyScanner(){
        read = new Scanner(System.in);
    }
    public MyScanner(String nameOfFile) throws FileNotFoundException {

        InputStream myFile = getFileFromResourceAsStream(nameOfFile);
        read= new Scanner(myFile);
    }
    public String readNextLine(){
        try {
            return read.nextLine();
        } catch (NoSuchElementException e){
            return "";
        }

    }
    public boolean hasNext(){
        return read.hasNext();
    }

    /**
     * Открытие файла не по URL-сслыке
     * @param fileName
     * @return
     */
    private InputStream getFileFromResourceAsStream(String fileName) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(fileName);

            if (inputStream == null) {
                throw new IllegalArgumentException("file not found! " + fileName);
            } else {
                return inputStream;
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("Файл не найден");
            return null;
        }
    }


//    public void run(DatagramSocket clientSocket) throws Exception {
//        client.tools.ClientSender packetsSender = new client.tools.ClientSender();
//        Scanner scanner = new Scanner(System.in);
//        if(scanner.hasNext()){
//            String consoleLine = scanner.nextLine();
//            arraysOfParams = consoleLine.split(" +");
//            String[] params = {""};
//            if (arraysOfParams.length > 1) {
//                params = new String[arraysOfParams.length - 1];
//                System.arraycopy(arraysOfParams,1,params,0,arraysOfParams.length - 1);
//            }
//            if (params.length<=1) {
//                try {
//                    switch (arraysOfParams[0]){
//                        case ("show"):
//                            ShowCommand showCommand = new ShowCommand(arraysOfParams[0], params[0]);
//                            packetsSender.send(clientSocket, showCommand);
//                            break;
//                        case ("clear"):
//                            Clear clearCommand = new Clear(arraysOfParams[0], params[0]);
//                            packetsSender.send(clientSocket,clearCommand);
//                            break;
//                        case ("group_counting_by_id"):
//                            GroupCountingIdCommand groupCountingIdCommand = new GroupCountingIdCommand(arraysOfParams[0], params[0]);
//                            packetsSender.send(clientSocket,groupCountingIdCommand);
//                            break;
//                        case ("help"):
//                            HelpCommand helpCommand = new HelpCommand(arraysOfParams[0], params[0]);
//                            packetsSender.send(clientSocket,helpCommand);
//                            break;
//                        case ("info"):
//                            Info infoCommand = new Info(arraysOfParams[0], params[0]);
//                            packetsSender.send(clientSocket,infoCommand);
//                            break;
//                        case ("print_descending"):
//                            PrintDescendingCommand printDescendingCommand = new PrintDescendingCommand(arraysOfParams[0], params[0]);
//                            packetsSender.send(clientSocket,printDescendingCommand);
//                            break;
//                        case ("history"):
//                            HistoryCommand historyCommand= new HistoryCommand(arraysOfParams[0], params[0]);
//                            packetsSender.send(clientSocket,historyCommand);
//                            break;
//                        case ("exit"):
//                            toExit = true;
//                            break;
//                        case ("execute_script"):
//                            if (!FilesSafe.getFilesList().contains(params[0])) {
//                                Scripter scripter = new Scripter();
//                                scripter.read(params[0]);
//                                scripter.executeScript(clientSocket);
//                            }
//                            else{
//                                System.out.println("Recursion found");
//                            }
//                            break;
//                        case ("filter_less_than_mpaa_rating"):
//                            MpaaFilterCommand mpaaFilterCommand = new MpaaFilterCommand(arraysOfParams[0], params[0]);
//                            packetsSender.send(clientSocket,mpaaFilterCommand);
//                            break;
//                        case ("remove_by_id"):
//                            RemoveByIdCommand removeByIdCommand = new RemoveByIdCommand(arraysOfParams[0], params[0]);
//                            packetsSender.send(clientSocket,removeByIdCommand);
//                            break;
//                        case ("add"):
//                            AddCommand addCommand = new AddCommand(arraysOfParams[0], params[0]);
//                            packetsSender.send(clientSocket,addCommand);
//                            break;
//                        case ("remove_greater"):
//                            RemoveGreaterCommand removeGreaterCommand = new RemoveGreaterCommand(arraysOfParams[0], params[0]);
//                            packetsSender.send(clientSocket,removeGreaterCommand);
//                            break;
//                        case ("insert_at"):
//                            InsertAtCommand insertAtCommand = new InsertAtCommand(arraysOfParams[0], params[0]);
//                            packetsSender.send(clientSocket,insertAtCommand);
//                            break;
//                        case ("update"):
//                            UpdateCommand updateCommand = new UpdateCommand(arraysOfParams[0], params[0]);
//                            packetsSender.send(clientSocket,updateCommand);
//                            break;
//                        default:
//                            throw new InvalidNameException();
//                    }
//                } catch (InvalidNameException | NonArgsExeption | TooManyArgsException | IllegalArgumentException | IOException e) {
//                    System.out.println(e.getMessage());
//                    throw new Exception();
//                }
//                if (arraysOfParams[0].equals("execute_script")) throw new Exception();
//            }
//            else{
//                System.out.println("Too many parameters. Use \"help\" to get a list of available commands.");
//                throw new Exception();
//            }
//        }}


}
