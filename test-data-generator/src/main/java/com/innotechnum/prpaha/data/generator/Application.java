package com.innotechnum.prpaha.data.generator;

import com.google.inject.Guice;
import com.innotechnum.prpaha.data.generator.validator.InputParametersValidator;

/**
 * Точка запуска приложения-утилиты
 * <p>
 * Аргументы для запуска:
 * 1. Полный путь до файла с точками продаж (String).
 * 2. Количество операций (Integer).
 * 3. Полный путь до файла, в который необходимо записать результат (String).
 */
public class Application {

    private final String[] args;

    public Application(String[] args) {
        validateInputParameters(args);

        this.args = args;
    }

    public static void main(String[] args) {
        Application application = new Application(args);
        application.generateTestData();
    }

    /**
     * Валидируем входные параметры на соответствие протоколу.
     *
     * @param args массив параметров
     */
    private void validateInputParameters(String[] args) {
        new InputParametersValidator(args).validate();
    }

    /**
     * Запускаем генерацию тестовых данных.
     */
    private void generateTestData() {
        String inputFile = args[0];
        int operationCount = Integer.parseInt(args[1]);
        String outputFile = args[2];

        DataGenerator generator = DataGeneratorFactory.getDataGenerator(inputFile, operationCount, outputFile,
                Guice.createInjector(new ServicesModule()));
        generator.generate();
    }

}
