/*Реализовать простой калькулятор (пользователь вводит 2 числа и вводит операцию (+ - / *). int a ;
int b; String op (op!=”Stop”); (char != ’b’)
Добавить систему логирования!
* В калькулятор добавьте возможность отменить последнюю операцию.
 */
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.*;

public class Task14 {
    static void  Log(String text) throws IOException {
        Logger logger = Logger.getLogger(Task03.class.getName());
        FileHandler file = new FileHandler("logger#2.log", true);
        logger.addHandler(file);
        SimpleFormatter form = new SimpleFormatter();
        file.setFormatter(form);
        logger.setUseParentHandlers(false); //чтобы не выводил логи в консоль
        logger.info(text);
        file.close();
    }


    static public double Calculator(Stack<String> math){
        double second = Double.parseDouble(math.pop());
        String sign = math.pop();
        double first = Double.parseDouble(math.pop());
        if (sign.equals("+")) return first + second;
        if (sign.equals("-")) return first - second;
        if (sign.equals("/")) return first / second;
        if (sign.equals("*")) return first * second;

        return -111111111;
    }


    static public void Start() throws IOException {
        Stack<String> remember = new Stack<String>();
        while (true) {
            Scanner math = new Scanner(System.in);
            String text = input(math, 1, remember);
            if (text.equals("stop")) break;
            double result = Calculator(remember);
            Log(String.valueOf(result));
            System.out.println("Результат - " + result);

//        System.out.println(remember);
        }
    }

    public static String input(Scanner math, int step, Stack<String> store) throws IOException {
        String inputText = null;
        if (step == 1) {
            System.out.println("""
                    Введите первое число:\s
                    Или:
                    stop - для выхода
                    back - назад""");
            inputText = math.nextLine().toLowerCase();
            Log(inputText);
            if (inputText.equals("stop")) return "stop";
            else if (inputText.equals("back")) {
                store.pop();
                return input(math, 3, store);
            }
            else {
                store.add(inputText);
                return inputText += input(math, 2, store);
            }
        }
        else if (step == 2) {
            System.out.println("Введите знак: ");
            inputText = math.nextLine().toLowerCase();
            Log(inputText);
            if (inputText.equals("stop")) return "stop";
            else if (inputText.equals("back")) {
                store.pop();
                return input(math, 1, store);
            }
            else {
                store.add(inputText);
                return inputText += input(math, 3, store);
            }
        }
        else if (step == 3) {
            System.out.println("Введите второе значение: ");
            inputText = math.nextLine().toLowerCase();
            Log(inputText);
            if (inputText.equals("stop")) return "stop";
            else if (inputText.equals("back")) {
                store.pop();
                return input(math, 2, store);
            }
            else {
                store.add(inputText);
                return inputText;
            }
        }
        return "error";
    }

    public static void main(String[] args) throws IOException {
        Start();
    }
}
