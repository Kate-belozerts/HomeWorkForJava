/*1) Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.*/

import java.util.*;

public class Task15 {
    public static void main(String[] args){
        HashMap<String, StringBuilder> telephone = new HashMap<>();
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

                    if (telephone.containsKey(name)){
                        StringBuilder temp = new StringBuilder(telephone.get(name) + " ");
                        for (int i = 1; i < data.length; i++) {
                            temp.append(data[i]);
                        }
                        telephone.remove(name);
                        telephone.put(name.toLowerCase(), new StringBuilder(temp));
                    }
                    else {
                        telephone.putIfAbsent(name.toLowerCase(), new StringBuilder(data[1]));
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
