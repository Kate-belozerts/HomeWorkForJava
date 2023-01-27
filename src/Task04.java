/**+Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса,
 * например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или
 * сообщить, что его нет. 24 45 //24 + 45 = 69 (n=2)
 */
import java.util.Scanner;

public class Task04 {
    static int Expression(String str) {
        String[] math = str.split("\\+");
        String numA = math[0].trim().replace("?", "0");
        String[] numbers = math[1].split("=");
        String numB = numbers[0].trim().replace("?", "0");
        String sum = numbers[1].trim();
        int result = -1;
        int answer = Integer.parseInt(sum);
//        System.out.printf("%s%s%d", numA, numB, answer);
        int a = Integer.parseInt(numA);
        int b = Integer.parseInt(numB);
//        System.out.printf("%d %d", a, b);

        int first = 1;
        int second = 1;
        int one = 1;
        int ten = 1;

        if (a < 10){
            first = 10;
            one = first;
        }

        if (b < 10){
            second = 10;
            ten = second;
        }

        for (int i = 0; i < 10; i++) {
            int temp = (a + first) + (b + second);
//            System.out.println(temp);
            if (temp == answer){
                if (a < 10) result = (a + first) / 10;
                else result = (a + first) % 10;
            } else {
                first += one;
                second += ten;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите уравнение: ");
        String text = input.nextLine();
        int res = Expression(text);
        System.out.printf("n = %d", res);
    }
}
