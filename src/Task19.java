import java.util.*;

/*2) Пусть дан список сотрудников:Иван Иванов и т.д.
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.

 */
public class Task19 {
    public static void listOfWorkers(){
        HashMap<String, Integer> stuff = new HashMap<>();
        Scanner iScanner = new Scanner(System.in);
//        System.out.println("Введите количество сотрудников: ");
//        int size = iScanner.nextInt(); // Очередной вопрос... Подскажите, почему он пропускает ввод первого имени, при вводе size?
        int size = 7;
        for (int i = 0; i < size; i++) {
            System.out.println("Введите имя и фамилию сотрудника: ");
            String name = iScanner.nextLine().toLowerCase();
            stuff.put(name, 0);
        }
        sortPopular(stuff);
    }


    public static void sortPopular(HashMap<String, Integer> arr){
        int size = arr.size();
        String[] allNames = arr.keySet().toArray(new String[0]);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String[] divide = allNames[i].split(" ");
                String name = divide[0];
                String[] divideCompare = allNames[j].split(" ");
                String nameFind = divideCompare[0];

                if (name.equals(nameFind)){
                    arr.put(allNames[i], arr.get(allNames[i]) + 1);
                }
            }
        }
        
        System.out.println(arr);
        SortedList(arr);
//        System.out.println(arr);
    }

    public static void SortedList(HashMap<String, Integer> lst){
        int size = lst.size();
        int max = 1;
        String[] allNames = lst.keySet().toArray(new String[0]);
        Map<String, Integer> result = new LinkedHashMap<>();

        for (int i = 0; i < size; i++) {
            int frequency = lst.get(allNames[i]);
            if (frequency > max){
                max = frequency;
            }
        }

        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                int frequency = lst.get(allNames[i]);
                if (frequency == max) result.put(allNames[i], lst.get(allNames[i]));
                if (i == size-1) max--;
                if (max == 0) break;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        listOfWorkers();
    }
}
