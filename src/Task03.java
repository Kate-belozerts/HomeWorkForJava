/*Реализовать простой калькулятор (пользователь вводит 2 числа и вводит операцию (+ - / *). int a ;
int b; String op (op!=”Stop”); (char != ’b’)
 */
import java.util.Scanner;

public class Task03 {
    static int Calculator(String a, String b){
        String[] numbers = a.split(" ");
        int numA = Integer.parseInt(numbers[0]);
        int numB = Integer.parseInt(numbers[1]);
        if (b.equals("+")) return numA + numB;
        if (b.equals("-")) return numA - numB;
        if (b.equals("/")) return numA / numB;
        if (b.equals("*")) return numA * numB;
        else return -1;
    }

    static void Endless(){
        boolean stop = true;
        while (stop) {
            Scanner num = new Scanner(System.in);
            System.out.println("Введите два числа через пробел или stop для выхода: ");
            String math = num.nextLine();
            if (math.equals("stop")) break; //Подскажите, как сделать без break? Он вообще не воспринимает изменнеие булевой переменной в теле цикла
//            System.out.println(math);
            Scanner plus = new Scanner(System.in);
            System.out.println("Введите знак (+, -, / или *), чтобы произвести математическое действие");
            String sign = plus.next();
            int res = Calculator(math, sign);
            System.out.println(res);
        }
    }

    public static void main(String[] args){
        Endless();
    }
}
