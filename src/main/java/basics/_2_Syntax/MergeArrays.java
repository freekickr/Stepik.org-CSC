package basics._2_Syntax;

/*
Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один отсортированный в том же порядке массив.
Массивы могут быть любой длины, в том числе нулевой.

Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность:
    он будет идти по двум исходным массивам и сразу формировать отсортированный результирующий массив.
    Так, чтобы сортировка полученного массива при помощи Arrays.sort() уже не требовалась.
    К сожалению, автоматически это не проверить, так что это остается на вашей совести :)

Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.

Пример:
Если на вход подаются массивы {0, 2, 2} и {1, 3}, то на выходе должен получиться массив {0, 1, 2, 2, 3}
 */

public class MergeArrays {
    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int a1indice = 0;
        int a2indice = 0;
        for (int i = 0; i < result.length; i++) {
            if (a1indice < a1.length && a2indice < a2.length) {
                if (a1[a1indice] < a2[a2indice]) {
                    result[i] = a1[a1indice];
                    a1indice++;
                } else {
                    result[i] = a2[a2indice];
                    a2indice++;
                }
            } else {
                if (a1indice == a1.length && a2indice < a2.length) {
                    result[i] = a2[a2indice];
                    a2indice++;
                } else if (a2indice == a2.length && a1indice < a1.length) {
                    result[i] = a1[a1indice];
                    a1indice++;
                }
            }
        }
        return result;
    }
}
