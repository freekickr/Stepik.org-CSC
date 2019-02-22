package basics._2_Syntax;

/*
Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
Допустимая погрешность – 0.0001 (1E-4)

Можно использовать класс Math и его методы. Класс Math доступен всегда, импортировать его не надо.

В качестве примера написано заведомо неправильное выражение. Исправьте его.

Sample Input: 0.1 0.2 0.3
Sample Output: true
 */

public class DoubleExpression {
    public static boolean doubleExpression(double a, double b, double c) {
        double delta = 0.0001;
        return Math.abs((a + b) - c) <= delta;
    }
}
