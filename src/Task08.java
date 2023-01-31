import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/*Пусть дан произвольный список целых чисел,
удалить из него четные числа
 */
public class Task08 {
    static void Random_List(){
        Random rnd = new Random();
        int size = 10;
        ArrayList<Integer> lst = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            lst.add(i, rnd.nextInt( 30));
        }
        System.out.print(lst); // Произвольный список чисел

//        for (Iterator<Integer> count = lst.iterator(); count.hasNext();){
//            Integer num = count.next();
//            if (num % 2 == 0){
//                count.remove();
//            }
//        } // Было так. IDE предложил заменить на одну строчку. Оставлю версию для себя, чтобы не забыть :)

        lst.removeIf(num -> num % 2 == 0);

        System.out.print(lst);
    }
    static public void main(String[] args){
        Random_List();
    }
}
