package basics._6_GensCollsStreams;

/*
Реализуйте метод, вычисляющий симметрическую разность двух множеств.

Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.

Пример:
    Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.
 */

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set1copy = new HashSet<>(set1);
        Set<T> set2copy = new HashSet<>(set2);

        set1copy.removeAll(set2);
        set2copy.removeAll(set1);

        set1copy.addAll(set2copy);
        return set1copy;
    }
}
