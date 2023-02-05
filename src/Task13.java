import java.util.Arrays;
import java.util.LinkedList;

/*Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди,
не удаляя.
 */
public class Task13 {

    public static void main(String[] args) {
        Queue arr = new Queue(5); // Реализовала очередь по праивлам FIFO
        arr.enqueue(1);
        arr.enqueue(2);
        arr.enqueue(3);
        arr.enqueue(4);
        arr.dequeue();
        arr.first();

        //С помощью встроенных методов:
        LinkedList<Integer> lst = new LinkedList<>();
        Eenqueue(lst, 5);
        Eenqueue(lst, 4);
        Eenqueue(lst, 3);
        System.out.println(lst);
        Ddequeue(lst);
        System.out.println(lst);
        int res = Ffirst(lst);
        System.out.println(res);
        System.out.println("The element is still in the list: " + lst);
    }


    static void Eenqueue(LinkedList<Integer> ls, int element){
        ls.add(element);
    }
    static void Ddequeue(LinkedList<Integer> ls){
        ls.remove();
    }
    static int Ffirst(LinkedList<Integer> ls){
        return ls.peek();
    }



    // Методы для массива:_________________________________________________________________________
static class Queue{
        int capacity;
        int[] items;
        int last;
        int back;
        Queue(int size){
            items = new int[size];
            last = size -1;
            back = 0;
            capacity = size;
        }
        boolean isFull(){
            if (back == last){ //return back == last;
                return true;
            }
            else return false;
        }
        public void enqueue(int element){
            if (isFull()){
                System.out.println("Queue is full");
            }
            items[back] = element;
            System.out.println(Arrays.toString(items));
            back++;
        }
        void dequeue() {
            if (back == 0) System.out.println("Queue is empty");
            else {
                System.out.println("Deleted: " + items[0]);
                for (int i = 1; i < back; i++) {
                    items[i-1] = items[i];
                    if(i == back-1) items[i] = 0;
                }

            }
            System.out.println(Arrays.toString(items));
        }

        void first(){
            if (back == 0) System.out.println("Queue is empty");
            else {
                System.out.println("First element is: " + items[0]);
            }
        }
    }
}

