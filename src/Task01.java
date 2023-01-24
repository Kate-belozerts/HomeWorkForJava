/*Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)*/
import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num = input.nextInt();
        factorialSum(num);
        factorialMulti(num);
    }

    static void factorialSum(int number) {
        int count = 1;
        int sum = 0;
        if (number == 0){
            System.out.println(sum);
        }
        while (count != number + 1){
            sum += count;
            count += 1;
        }
        String result = String.format("Сумма чисел от 1 до %d = %d", number, sum);
        System.out.println(result);
    }
    static void factorialMulti(int number) {
        int count = 1;
        int res = 1;
        if (number == 0){
            System.out.println(res);
        }
        while (count != number + 1){
            res *= count;
            count += 1;
        }
        String result = String.format("Факториал %d! = %d", number, res);
        System.out.println(result);
    }
}
