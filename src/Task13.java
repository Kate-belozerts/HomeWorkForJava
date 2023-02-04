import java.util.LinkedList;
import java.util.Queue;

/*Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди,
не удаляя.
 */
public class Task13 {
    public static void main(String[] args) {
        Queue<Integer> lst = new LinkedList<Integer>();
//        System.out.print(lst);
        enqueue(lst, 3);
        enqueue(lst, 7);
        enqueue(lst, 5);
        enqueue(lst, 9);
        System.out.print(lst);
        dequeue(lst);
        System.out.print(lst);
        System.out.println();
        int res = first(lst);
        System.out.print(res);
    }
    public static void enqueue(Queue<Integer> elements, int position){
        elements.add(position);
    }
    public static void dequeue(Queue<Integer> items){
        items.remove();
    }
    public static int first(Queue<Integer> items){
        return items.element();
    }
}
