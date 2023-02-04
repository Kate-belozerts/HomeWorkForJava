import java.util.*;

public class Task11 {
//    static  public void main(String[] args){
//        ArrayList<Integer> arr = new ArrayList<>();
//        LinkedList<Integer> lin = new LinkedList<>();
//        long start = System.nanoTime();
//        for (int i = 0; i < 10000; i++) {
//            arr.add(i);
//        }
//        long end = System.nanoTime();
//        System.out.println(end - start);
//
//        start = System.nanoTime();
//        for (int i = 0; i < 10000; i++) {
//            lin.add(i);
//        }
//        end = System.nanoTime();
//        System.out.println(end - start);
//    }
    static public void main(String[] args){
        ArrayList<Integer> a = new ArrayList<>();
        Scanner b = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            a.add(b.nextInt());
        }
        Stack<Integer> test = new Stack<>();
        for (Integer integer : a) { //(int i = 0; i < a.size(); i++)
            test.add(integer);
        }
//        test.addAll(a); - Добавит весь массив
//        System.out.println(test);

        Queue<Integer> f = new LinkedList<>();
        f.addAll(a);
//        System.out.println(f);


        PrintStack(test); // 0987654321
        System.out.println();
        PrintQu(f); // 1234567890

    }

    static void PrintStack(Stack<Integer> gfd){
        while (!gfd.isEmpty()){
            System.out.print(gfd.pop());
        }
    }
    static void PrintQu(Queue<Integer> gfd){
        while (!gfd.isEmpty()){
            System.out.print(gfd.remove());
        }
    }
}
//В стеке реализовать
//size()
//empty()
//push()
//pop()
//peak()
