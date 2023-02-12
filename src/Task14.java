///*Реализовать простой калькулятор (пользователь вводит 2 числа и вводит операцию (+ - / *). int a ;
//int b; String op (op!=”Stop”); (char != ’b’)
//Добавить систему логирования!
//* В калькулятор добавьте возможность отменить последнюю операцию.
// */
//import java.io.IOException;
//import java.util.Scanner;
//import java.util.Stack;
//import java.util.logging.*;
//
//public class Task14 {
//    static void  Log(String text) throws IOException {
//        Logger logger = Logger.getLogger(Task03.class.getName());
//        FileHandler file = new FileHandler("logger#2.log", true);
//        logger.addHandler(file);
//        SimpleFormatter form = new SimpleFormatter();
//        file.setFormatter(form);
//        logger.setUseParentHandlers(false); //чтобы не выводил логи в консоль
//        logger.info(text);
//        file.close();
//    }
//
//
//    static public double Calculator(Stack<String> math){
//        double second = Double.parseDouble(math.pop());
//        String sign = math.pop();
//        double first = Double.parseDouble(math.pop());
//        if (sign.equals("+")) return first + second;
//        if (sign.equals("-")) return first - second;
//        if (sign.equals("/")) return first / second;
//        if (sign.equals("*")) return first * second;
//
//        return -111111111;
//    }
//
//
//    static public void Start() throws IOException {
//        Stack<String> remember = new Stack<String>();
//        while (true) {
//            Scanner math = new Scanner(System.in);
//            String text = input(math, 1, remember);
//            if (text.equals("stop")) break;
//            double result = Calculator(remember);
//            Log(String.valueOf(result));
//            System.out.println("Результат - " + result);
//
////        System.out.println(remember);
//        }
//    }
//
//    public static String input(Scanner math, int step, Stack<String> store) throws IOException {
//        String inputText = null;
//        if (step == 1) {
//            System.out.println("""
//                    Введите первое число:\s
//                    Или:
//                    stop - для выхода
//                    back - назад""");
//            inputText = math.nextLine().toLowerCase();
//            Log(inputText);
//            if (inputText.equals("stop")) return "stop";
//            else if (inputText.equals("back")) {
//                store.pop();
//                return input(math, 3, store);
//            }
//            else {
//                store.add(inputText);
//                return inputText += input(math, 2, store);
//            }
//        }
//        else if (step == 2) {
//            System.out.println("Введите знак: ");
//            inputText = math.nextLine().toLowerCase();
//            Log(inputText);
//            if (inputText.equals("stop")) return "stop";
//            else if (inputText.equals("back")) {
//                store.pop();
//                return input(math, 1, store);
//            }
//            else {
//                store.add(inputText);
//                return inputText += input(math, 3, store);
//            }
//        }
//        else if (step == 3) {
//            System.out.println("Введите второе значение: ");
//            inputText = math.nextLine().toLowerCase();
//            Log(inputText);
//            if (inputText.equals("stop")) return "stop";
//            else if (inputText.equals("back")) {
//                store.pop();
//                return input(math, 2, store);
//            }
//            else {
//                store.add(inputText);
//                return inputText;
//            }
//        }
//        return "error";
//    }
//
//    public static void main(String[] args) throws IOException {
//        Start();
//    }
//}

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
    //стор, в котором мы храним текущие числа
    public static Stack<Double> numbersStore = new Stack<Double>();
    //стор для результата
    public static Stack<Double> resStore = new Stack<Double>();
    //стор для операций
    public static Stack<String> operStore = new Stack<String>();
    // просто для удобства
    public static Double resultat = 0.0;
    public static Integer step = 1;

    static void  Log(String text) throws IOException {
        Logger logger = Logger.getLogger(Task14.class.getName());
        FileHandler file = new FileHandler("logger#2.log", true);
        logger.addHandler(file);
        SimpleFormatter form = new SimpleFormatter();
        file.setFormatter(form);
        logger.setUseParentHandlers(false); //чтобы не выводил логи в консоль
        logger.info(text);
        file.close();
    }


    static public double Calculator(){
        double second = numbersStore.pop();
        String sign = operStore.pop();
        double first = numbersStore.pop();
        if (sign.equals("+")) resultat=first + second;
        else if (sign.equals("-")) resultat=first - second;
        else if (sign.equals("/")) resultat=first / second;
        else if (sign.equals("*")) resultat=first * second;
        resStore.push(resultat);
        return -111111111;
    }


    static public void Start() throws IOException {

        while (true) {
            Scanner math = new Scanner(System.in);
            String text = input(math, step);
            if (text.equals("stop")) break;
            else if (text.equals("noup")) continue;
            Calculator();
            Log(String.valueOf(resultat));
            System.out.println("Результат - " + resultat);
            step = 4;
//        System.out.println(remember);
        }
    }

    public static String input(Scanner math, int step) throws IOException {
        String inputText = null;
        if (step == 1) {
            System.out.println("""
                    Введите первое число:\s""");
            inputText = math.nextLine().toLowerCase();
            Log(inputText);
            numbersStore.push(Double.parseDouble(inputText));
            resultat = Double.parseDouble(inputText);
            resStore.push(resultat);
            return input(math,2);
        }
        else if (step == 2) {
            System.out.println("Введите знак: ");
            inputText = math.nextLine().toLowerCase();
            Log(inputText);
            if (inputText.equals("stop")) return "stop";
            else {
                operStore.push(inputText);
                return input(math, 3);
            }
        }
        else if (step == 3) {
            System.out.println("Введите второе значение: ");
            inputText = math.nextLine().toLowerCase();
            Log(inputText);
            if (inputText.equals("stop")) return "stop";
            else {
                numbersStore.push(Double.parseDouble(inputText));
                return "";
            }
        }
        else if (step == 4) {
            System.out.println("""
                    Введите enter, чтобы продолжить вычисления:\s
                    Или:
                    stop - для выхода
                    back, чтобы вернуться к предыдущему результату""");
            inputText = math.nextLine().toLowerCase();
            Log(inputText);
            if (inputText.equals("stop")) return "stop";
            else if (inputText.equals("back")) {
                if (resStore.isEmpty()) {
                    System.out.println("Предыдущего числа нет");
                    return "noup";
                }
                else if (resStore.size()==1) resultat = resStore.pop(); //если длина равна 1, то мы не сможем сделать 2 раза pop, это нужно на 1 шаге
                else {
                    resStore.pop();
                    resultat = resStore.pop(); //достаем предыдущий результат
                }
                System.out.println("Теперь ваш результат: "+ resultat);
                numbersStore.push(resultat);
                return input(math, 2);
            }
            else {
                numbersStore.push(resultat);
                return input(math,2);
            }
        }
        return "error";
    }

    public static void main(String[] args) throws IOException {
        Start();
    }
}
