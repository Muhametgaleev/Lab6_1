package common.commands;

import common.classes.FuelType;
import common.scanner.MyScanner;

public class AddParent {
    /**
     * Реализация методов постоянного ввода при неправильно введенных данных
     * @param c
     * @param name
     * @return
     */
    public Float analizeFloat(MyScanner c, String name){
        System.out.println("Введите значение CoordX");
        boolean run=true;
        Float ans=null;
        while (run) {
            try {
                ans=Float.parseFloat(c.readNextLine());
                if(ans>-342) run=false;
                else System.out.println("Введите правильный диапазон");
            } catch (NumberFormatException e) {
                System.out.println("Введите информацию переменной "+ name+ " корректно");
            }
        }
        return ans;
    }
    public Long analizeLong(MyScanner c, String name){
        System.out.println("введите значение CoordY");
        boolean run=true;
        Long ans=null;
        while (run) {
            try {
                ans=Long.parseLong(c.readNextLine());
                if (ans<809) run=false;
                else System.out.println("Введите правильный диапазон");
            } catch (NumberFormatException e) {
                System.out.println("Введите информацию переменной "+ name+ " корректно");
            }
        }
        return ans;
    }
    public Integer analizeInteger(MyScanner c, String name){
        boolean run=true;
        Integer ans=null;
        while (run) {
            try {
                ans=Integer.parseInt(c.readNextLine());
                if (ans>0) run=false;
                else System.out.println("Введите правильный диапазон");
            } catch (NumberFormatException e) {
                System.out.println("Введите информацию переменной "+ name+ " корректно");

            }
        }
        return ans;
    }
    public FuelType analizeFuel(MyScanner c, String name){
        FuelType ans = null;
        boolean run=true;
        while (run) {
            try {
                System.out.println("Доступные значения: GASOLINE\n" +
                        "    ALCOHOL\n" +
                        "    MANPOWER\n" +
                        "    NUCLEAR\n" +
                        "    NULL (через enter)\n" +
                        "    ANTIMATTER");
                String lineValue = c.readNextLine();
                if ("".equals(lineValue)) {
                    ans=FuelType.valueOf("NULL");
                } else {
                    ans=FuelType.valueOf(lineValue);
                }
                run=false;

            } catch (IllegalArgumentException e) {
                System.out.println("Введите информацию переменной "+ name+ " корректно");
            }
        }
        return ans;
    }

}
