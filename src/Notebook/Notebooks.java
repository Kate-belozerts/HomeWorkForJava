/*Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
1. Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет выборку: имя ноутбука и выбранный критерий .
Критерии фильтрации можно хранить в Map.
Сделать выборку.
Например:
Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …

2. Отфильтровать ноутбуки первоначального множества. По имени ноутбука в алфавитном порядке, по цене по убыванию
Например, по алфавиту
 */

package Notebook;

public class Notebooks {
    protected String name;
    protected int memoryRAM;
    protected int volumeSSD;
    protected String color;
    protected String os;
    protected int guarantee;
    protected int year;
    protected String touchpad;
    protected String backlightKeyboard;


    public Notebooks(String name, int memoryRAM, int volumeSSD, String color,
                     String os, int guarantee, int year, String touchpad, String backlightKeyboard){
        this.name = name;
        this.memoryRAM = memoryRAM;
        this.volumeSSD = volumeSSD;
        this.color = color;
        this.os = os;
        this.guarantee = guarantee;
        this.year = year;
        this.touchpad = touchpad;
        this.backlightKeyboard = backlightKeyboard;
    }
    public String getName(){
        return  name;
    }
    public int getMemoryRAM(){
        return memoryRAM;
    }
    public int getVolumeSSD() {
        return volumeSSD;
    }

    public String getColor() {
        return color;
    }
    public String getOs(){
        return os;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public int getYear() {
        return year;
    }
    public String getTouchpad(){
        return touchpad;
    }
    public String getBacklightKeyboard(){
        return backlightKeyboard;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", memoryRAM=" + memoryRAM +
                ", volumeSSD=" + volumeSSD +
                ", color='" + color + '\'' +
                ", os='" + os + '\'' +
                ", guarantee=" + guarantee +
                ", year=" + year +
                ", touchpad='" + touchpad + '\'' +
                ", backlightKeyboard='" + backlightKeyboard + '\'';
    }
}
