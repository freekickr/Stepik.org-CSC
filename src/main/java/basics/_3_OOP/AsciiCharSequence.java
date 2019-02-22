package basics._3_OOP;

/*
Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов (их коды влезают в один байт) в массиве байт.
По сравнению с классом String, хранящим каждый символ как char, AsciiCharSequence будет занимать в два раза меньше памяти.

Класс AsciiCharSequence должен:
  - реализовывать интерфейс java.lang.CharSequence;
  - иметь конструктор, принимающий массив байт;
  - определять методы length(), charAt(), subSequence() и toString()

Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).

В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры,
поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.

P.S. В Java 9 ожидается подобная оптимизация в самом классе String: http://openjdk.java.net/jeps/254
 */

public class AsciiCharSequence implements java.lang.CharSequence {
    byte[] array;

    public AsciiCharSequence(byte[] array) {
        this.array = array;
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int index) {
        return (char)array[index];
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        int length = end - start;
        byte[] temp = new byte[length];
        System.arraycopy(array, start, temp, 0, length);
        return new AsciiCharSequence(temp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (byte val : array)
            sb.append((char) val);
        return sb.toString();
    }
}
