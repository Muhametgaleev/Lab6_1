package common.supplier;
import common.classes.Vehicle;
import common.parser.SaxPars;


import java.util.ArrayList;
import java.util.Collection;

public class Supply {
    /**
     * класс доставщик информации, также хранит в себе коллекцию, с которой работают команды
     */
    boolean running=true;
    public static ArrayList<String> historyCollectrion = new ArrayList<>();
    private ArrayList<Vehicle> listOfVehicle= new ArrayList<>();

    private String peremen="";
    public Supply(){}
    public Supply(SaxPars s){
            listOfVehicle.addAll((Collection<? extends Vehicle>) s.getVehicle());
    }

    public ArrayList<Vehicle> getCopy(){return listOfVehicle;}
    public void setCopy(ArrayList<Vehicle> s) {this.listOfVehicle=s;}
    public void setRunning(boolean s){this.running=s;}
    public boolean getRunning(){return running;}
    public void setPeremen(String s){this.peremen=s;}
    public String getPeremen(){return peremen;}
    public int getSize(){return listOfVehicle.size();}
    public void setHistory(String history)  {
        if(historyCollectrion.size()==5){
            historyCollectrion.remove(0);
            historyCollectrion.add(history);
        }
        else historyCollectrion.add(history);
    }
    public ArrayList<String> getHistory(){return historyCollectrion;}
}
