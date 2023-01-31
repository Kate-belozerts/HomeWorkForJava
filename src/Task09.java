/*Задан целочисленный список ArrayList. Найти минимальное,
максимальное и среднее ариф из этого списка.
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task09 {
    static void Find_Numbers(ArrayList<Integer> arr){
        int min = arr.get(0);
        int max = arr.get(0);
        int mid = 0;
        for (Integer number : arr) {
            if (number < min) min = number;
            if (number > max) max = number;
            mid += number;
        }
        mid = mid / arr.size();
        System.out.printf("\nМинимальное - %d\nМаксимальное - %d\nСреднее арифметическое - %d\n", min, max, mid);
    }
    static ArrayList<Integer> Create(){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = input.nextInt();
        input.close();
        Random rnd = new Random();
        ArrayList<Integer> arr = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arr.add(i, rnd.nextInt(-100, 100));
        }
        System.out.print(arr);
        return arr;
    }
    static public void main(String[] args){
        ArrayList<Integer> array = Create();
        Find_Numbers(array);
    }
}
