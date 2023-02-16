/*1) Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.*/

import java.util.*;

public class Task15 {
    public static void main(String[] args){
        HashMap<String, ArrayList<String>> telephone = new HashMap<>();
        Scanner iScanner = new Scanner(System.in);
        String[] data;

        while (true) {
            System.out.println("1 - добавить номер\n2 - просмотр контакта\n3 - просмотр телефонной книги\n4 - выход");
            String answer = iScanner.nextLine().trim();
            switch (answer) {
                case "1" -> {
                    System.out.println("Введите имя и номер телефона через пробел: ");
                    data = iScanner.nextLine().split(" ");
                    String name = data[0].toLowerCase();
                    String number = data[1];
                    List<String> items = telephone.get(name);

                    if (telephone.containsKey(name)){
                        if(!items.contains(number)) items.add(number);
                    }

                    else {
                        ArrayList<String> result = new ArrayList<>();
                        result.add(number);
                        telephone.put(name, result);
                    }
                }
                case "2" -> {
                    System.out.println("Введите имя: ");
                    String findName = iScanner.nextLine().toLowerCase();
                    if (telephone.containsKey(findName)) System.out.println(telephone.get(findName));
                }
                case "3" -> System.out.println("Все контакты: " + List.of(telephone));
                case "4" -> {
                    iScanner.close();
                    break; // Почему break не работает в данном случае? Даже если убрать закрытие сканера
                }
                default -> throw new IllegalStateException("Unexpected value: " + answer);
            }
        }
    }
}
