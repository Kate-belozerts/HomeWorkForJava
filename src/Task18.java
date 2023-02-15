/*
3) Реализовать алгоритм пирамидальной сортировки (HeapSort).
 */
import java.util.Arrays;

public class Task18 {
    public static void main(String []args){
        int[] array = new int[]{7, 7, 3,9, 5, 0, 77};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void heap(int[] arr, int length, int i){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < length && arr[left] > arr[max]){
            max = left;
        }
        if (right < length && arr[right] > arr[max]){
            max = right;
        }
        if (max != i){
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heap(arr, length, max);
        }
    }
    public static void heapSort(int[] array){
        if (array.length == 0)
            return;
        int length = array.length;
        for (int i = length / 2 -1; i >= 0; i--){
            heap(array,length,i);
        }
        for (int i = length -1; i >= 0; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heap(array, i, 0);
        }
    }
}
