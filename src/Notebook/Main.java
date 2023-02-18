package Notebook;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Notebooks samsung = new Notebooks("Samsung", 16, 512,
                "White", "Windows11", 2, 2023, "yes", "yes" );
        Notebooks apple = new Notebooks("Macbook", 8, 512,
                "Grey", "MacOS", 1, 2023, "yes", "yes" );
        Notebooks lg = new Notebooks("LG", 5, 264,
                "Black", "WindowsXP", 5, 2020, "no", "no" );
        Notebooks asus = new Notebooks("Asus", 8, 512,
                "Green", "Windows10", 2, 2022, "yes", "no" );
        Notebooks honor = new Notebooks("Honor", 4, 128,
                "Red", "Windows9", 2, 2018, "no", "yes" );

//        System.out.println(samsung);
        List<Notebooks> shop = new ArrayList<>();
        shop.add(samsung);
        shop.add(apple);
        shop.add(lg);
        shop.add(asus);
        shop.add(honor);
        menu(shop);
    }

    static public void menu(List<Notebooks> shop){
        Scanner iScanner = new Scanner(System.in);
        System.out.println("""
                Выберите способ фильтрации:\s
                1 - Оперативная система
                2 - Цвет
                3 - Объем оперативной памяти RAM
                4 - Наличие подсветки клавиатуры
                5 - Наличие тачпада
                """);
        int choice = iScanner.nextInt();
        sortedByChoice(choice, shop);
    }

    static public void sortedByChoice(int number, List<Notebooks> shop){
        Map<String, String> result = new HashMap<>();
        Notebooks temp = null;

        for (Notebooks notebooks : shop) {
            temp = notebooks;
            switch (number) {
                case 1 -> result.put(temp.getName(), temp.getOs());
                case 2 -> result.put(temp.getName(), temp.getColor());
                case 3 -> result.put(temp.getName(), String.valueOf(temp.getMemoryRAM()));
                case 4 -> result.put(temp.getName(), temp.getBacklightKeyboard());
                case 5 -> result.put(temp.getName(), temp.getTouchpad());
            }
        }
//        System.out.println(result);
        showTable(result);
        System.out.println("""
                Хотите выбрать другой критерий фильтрации?\s
                1 - Да
                2 - Нет""");
        Scanner iScanner = new Scanner(System.in);
        int repeat = iScanner.nextInt();
        if (repeat == 1) menu(shop);
    }

    static public void showTable(Map<String, String> lst){
        int size = 12;
        int subtract = 12;
        System.out.println("""
                | Name:      |   Parameter:|\s
                |------------|-------------|""");
        for (Map.Entry<String, String> i: lst.entrySet()){
            int temp = size - i.getKey().length();
            int tempSub = subtract - i.getValue().length();
            System.out.printf("|%s%s|%s%s|", i.getKey(), " ".repeat(temp),
                    i.getValue(), " ".repeat(tempSub));
            System.out.println();
        }
        System.out.println();
    }
}
