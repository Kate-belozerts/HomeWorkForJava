import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */
public class Task05 {
    static void Log(int[] arr) throws IOException {
        Logger logger = Logger.getLogger(Task05.class.getName());
        FileHandler file = new FileHandler("array.txt", true);
        logger.addHandler(file);
        SimpleFormatter sf = new SimpleFormatter();
        file.setFormatter(sf);
        logger.setUseParentHandlers(false);
        logger.info(Arrays.toString(arr));
        file.close();
    }
    static int[] Sort(int[] arr) throws IOException {
        Log(arr);
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j + 1]){
                    Log(arr);
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        Log(arr);
        return arr;
    }
    static public void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = s.nextInt();
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-30, 30);
        }

        for (int i : array) {
            System.out.print(i + "  ");
        }

        int[] result = Sort(array);
        System.out.println();

        for (int i : result) {
            System.out.print(i + "  ");
        }
    }
}
