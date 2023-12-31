package com.digitalnomads.api.ui;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        testLog();
    }

    public static void testLog() {
        log.info("Тестирует логи"); // логи-это средства записи всех дейстий приложения.
        /*Логирование позволяет записывать информацию о происходящих в приложении
        событиях, действиях и состояниях. Это может быть крайне полезно при отладке и выявлении ошибок.
        Основные уровни логирования:
ERROR - в программе произошла ошибка
WARN - предупреждение перед критической ошибкой
INFO - общая информация о выполнении программы
DEBUG - детальная информация для отладки
TRACE - наиболее полная информация.
         */
    }
}