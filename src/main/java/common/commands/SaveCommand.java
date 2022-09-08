package common.commands;

import common.classes.Vehicle;
import common.supplier.Supply;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveCommand implements Command {
    String peremen;

    @Override
    public void execute(Supply s) {
        if (peremen.equals("")) {
            try {
                ArrayList<Vehicle> list = s.getCopy();
                FileWriter writer1 = new FileWriter("src/main/resources/xml_file1.xml");
                writer1.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                        "<company>\n" +
                        "    <name>IT-Heaven</name>\n" +
                        "    <offices>\n" +
                        "        <office floor=\"1\" room=\"1\">\n" +
                        "            <employees>\n");
                for (Vehicle vehicle : list) {
                    String type;
                    String id = String.valueOf(vehicle.getId());
                    String X = String.valueOf(vehicle.getCoordinateX());
                    String Y = String.valueOf(vehicle.getCoordinateY());
                    String engine = String.valueOf(vehicle.getEnginePower());
                    String cap = String.valueOf(vehicle.getCapacity());
                    if ("NULL".equals(String.valueOf(vehicle.getFuelType()))) {
                        type = "";
                    } else {
                        type = String.valueOf(vehicle.getFuelType());
                    }


                    writer1.write("                <player id=\"" + id + "\" name=\"" + vehicle.getName() + "\" coordinateX=\"" + X + "\" coordinateY=\"" + Y + "\" enginePower=\"" + engine + "\" capacity=\"" + cap + "\" FuelType=\"" + type + "\"/>\n");
                }
                writer1.write("            </employees>\n" +
                        "        </office>\n" +
                        "    </offices>\n" +
                        "</company>");
                writer1.close();
                System.out.println("Команда выполнена");
            } catch (IOException e) {
                System.out.println("Нет файла для сохранения информации");
            }
        } else System.out.println("Команда введена некорректно");
    }

    @Override
    public void declare(Supply s){
        peremen=s.getPeremen();
    }
    public String getName() {
        return "save";
    }

}
