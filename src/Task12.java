import java.util.LinkedList;
import java.util.Stack;

/*Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.*/

public class Task12 {
    static public void main(String [] args){
        LinkedList<Integer> lst = new LinkedList<Integer>();
        for (int i = 0; i < 7; i++) {
            lst.add(i);
        }
        System.out.print(lst);
        System.out.println();
        lst = Reverse(lst);
        System.out.print(lst);
    }
    static public LinkedList<Integer> Reverse(LinkedList<Integer> arr){
        Stack<Integer> res = new Stack<Integer>();
        for (int i = 0; i < arr.size(); i++) {
            res.add(arr.get(i));
        }

        int size = res.size();
        arr.clear();
        for (int j = 0; j < size; j++) {
            arr.add(j, res.pop());
        }
        return arr;
    }
}
