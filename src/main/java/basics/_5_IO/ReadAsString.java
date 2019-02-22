package basics._5_IO;

/*
Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.

Пример:
    InputStream последовательно возвращает четыре байта: 48 49 50 51.
    Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку "0123".
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class ReadAsString {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        // your implementation here
        Reader reader = new InputStreamReader(inputStream, charset);
        StringBuilder sb = new StringBuilder();
        for (int val = reader.read(); val != -1; val = reader.read())
            sb.append((char)val);
        return sb.toString();
    }
}
