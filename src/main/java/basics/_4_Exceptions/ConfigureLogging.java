package basics._4_Exceptions;

/*
В этой задаче вам нужно реализовать метод, настраивающий параметры логирования.
Конфигурирование в коде позволяет выполнить более тонкую и хитрую настройку, чем при помощи properties-файла.

Требуется выставить такие настройки, чтобы:
    Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
    Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
    Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java",
    независимо от серьезности сообщения печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам на уровнях "org.stepic", "org" и "".
Не упомянутые здесь настройки изменяться не должны.

(*) В реальных программах мы бы конечно печатали XML не в консоль, а в файл. Но проверяющая система не разрешает создавать файлы на диске, поэтому придется так.

Подсказки:
    Level есть не только у Logger, но и у Handler.
    Передача сообщения на обработку родительскому Handler'у регулируется свойством useParentHandlers.
 */

import java.util.logging.*;

public class ConfigureLogging {

    private static void configureLogging() {
        final Logger LOGGER_1 = Logger.getLogger("org.stepic.java.logging.ClassA.");
        final Logger LOGGER_2 = Logger.getLogger("org.stepic.java.logging.ClassB");
        final Logger LOGGER_3 = Logger.getLogger("org.stepic.java");

        LOGGER_1.setLevel(Level.ALL);
        LOGGER_2.setLevel(Level.WARNING);

        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new XMLFormatter());

        LOGGER_3.addHandler(handler);
        LOGGER_3.setUseParentHandlers(false);
    }
}
