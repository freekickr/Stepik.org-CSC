package basics._6_GensCollsStreams;

/*
Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами,
затем удалит из них все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность в обратном порядке в System.out.

Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.

В этом задании надо написать программу целиком, включая import'ы, декларацию класса Main и метода main.

Sample Input: 1 2 3 4 5 6 7
Sample Output: 6 4 2
 */

import java.util.LinkedList;
import java.util.Scanner;

public class ParseNumsReverse {
    public static void main(String[] args) {
        doMagic();
    }

    private static void doMagic() {
        try {
            LinkedList<Integer> list = new LinkedList<>();
            Scanner sc = new Scanner(System.in);
            int n = 0;
            while (sc.hasNextInt()) {
                int elem = sc.nextInt();
                if (n % 2 == 1)
                    list.addFirst(elem);
                n++;
            }
            list.forEach(s -> System.out.print(s + " "));
        } catch (NullPointerException e) {
            System.out.println("Oops! NPE");
        }
    }
}
