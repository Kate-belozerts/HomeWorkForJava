/*Вывести все простые числа от 1 до 1000*/
import java.util.Scanner;
public class Task02 {
    static void SimpleNumbers(int number) {
        if (number == 0 || number < 0) System.out.println("Это не является натуральным числом");
        System.out.print("2 ");
        int num = 3;
            for (int i = 2; i < number; i++) {
                if (num % i == 0){
                    num++;
                    i = 2;
                }
                if (i == num -1 && num % i != 0){
                    System.out.print(num + " ");
                    num++;
                    i = 2;
                } else if (i == num -1 && num % i == 0){
                    num++;
                    i = 2;
                }
            }
}
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        System.out.println("Введите число, до которого указать все простые числа: ");
        int n = ask.nextInt();
        SimpleNumbers(n);
    }
}
