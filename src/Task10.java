/*Реализовать алгоритм сортировки слиянием*/

import java.util.Random;
import java.util.Scanner;

public class Task10 {
    static void Sort_Array(int[] arr, int index){
        if (index < 2){
            return;
        }
        int middle = index / 2;
        int[] left = new int[middle];
        int[] right = new int[index - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = arr[i];
        }
        for (int i = middle; i < index; i++) {
            right[i - middle] = arr[i];
        }
        Sort_Array(left, middle);
        Sort_Array(right, index - middle);
        int[] res = Merge_Array(arr, left, right, middle, index - middle);
    }

    static int[] Merge_Array(int[] arr, int[] left, int[] right, int l, int r){

        int i = 0, j = 0, k = 0;
        while (i < l && j < r){
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            }
            else {
                arr[k++] = right[j++];
            }
        }
        while (i < l){
            arr[k++] = left[i++];
        }
        while (j < r){
            arr[k++] = right[j++];
        }
        return arr;
    }

    static int[] Create(){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = input.nextInt();
        input.close();
        Random rnd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rnd.nextInt(-100, 100);
            System.out.print(arr[i] + " ");
        }
        return arr;
    }

    public static void main (String [] args){
        int[] array = Create();
        Sort_Array(array, array.length);
        System.out.println();
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
