/*Реализовать простой калькулятор (пользователь вводит 2 числа и вводит операцию (+ - / *). int a ;
int b; String op (op!=”Stop”); (char != ’b’)
Добавить систему логирования!
 */
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Task03 {
    static void  Log(String text) throws IOException {
        Logger logger = Logger.getLogger(Task03.class.getName());
        FileHandler file = new FileHandler("log.log", true);
        logger.addHandler(file);
        SimpleFormatter form = new SimpleFormatter();
        file.setFormatter(form);
        logger.setUseParentHandlers(false); //чтобы не выводил логи в консоль
        logger.info(text);
        file.close();
    }


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

    static void Endless() throws IOException {
        boolean stop = true;
        while (stop) {
            Scanner num = new Scanner(System.in);
            System.out.println("Введите два числа через пробел или stop для выхода: ");
            String math = num.nextLine();
            Log(math);
            if (math.equals("stop")) {
                num.close();
                break;
            }
//            System.out.println(math);
            Scanner plus = new Scanner(System.in);
            System.out.println("Введите знак (+, -, / или *), чтобы произвести математическое действие");
            String sign = plus.next();
            Log(sign);
            int res = Calculator(math, sign);
            String result = "" + res;
            Log(result);
            System.out.println(res);
        }
    }

    public static void main(String[] args) throws IOException {
        Endless();
    }
}
