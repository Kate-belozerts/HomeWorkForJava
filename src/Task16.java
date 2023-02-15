import java.util.*;

/*2) Пусть дан список сотрудников:Иван Иванов и т.д.
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности.
 */
public class Task16 {
    public static void inputList() {
        String[] stuff = new String[5];
        int size = stuff.length;
        Scanner iScanner = new Scanner(System.in);
        PriorityQueue<String> lst = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Введите имя и фамилию сотрудника: ");
            stuff[i] = iScanner.nextLine().toLowerCase();
        }
        int count = 1;
        int name = 0;
        for (int i = 0; i < stuff.length; i++) {
            String[] compare = stuff[i].split(" ");
            for (int j = 0; j < stuff.length; j++) {
                String[] comparable = stuff[j].split(" ");
                if(i == j) continue;
                if (comparable[name].contains(compare[name])){
                count++;
                }
            }
            lst.add(Integer.toString(count).concat(" - (количество) ").concat(stuff[i]));

            count = 1;
        }
        System.out.println("Все имена с количествами повторений: ".concat(Arrays.toString(lst.toArray())));

        Stack<String> result = new Stack<>();
        while (!lst.isEmpty()) {
            result.add(lst.poll());
        }

        System.out.println("По убыванию популярности: ");

        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }
    }
    public static void main(String[] args) {
        inputList();
    }
}
