package com.innotechnum.prpaha.data.generator;

import com.innotechnum.prpaha.data.generator.services.DataGenerator;
import com.innotechnum.prpaha.data.generator.services.LargeDataGenerator;
import com.innotechnum.prpaha.data.generator.services.SmallDataGenerator;

/**
 * Фабрика создающая генератор тестовых данных.
 */
public class DataGeneratorFactory {

    private static final int MAX_SMALL_OPERATION_COUNT = 100;

    /**
     * Создаёт генератор соответствующий ожидаемой нагрузке на память.
     *
     * @param inputFile
     * @param operationCount
     * @param outputFile
     * @return генератор данных
     */
    public static DataGenerator getDataGenerator(final String inputFile, final int operationCount, final String outputFile) {
        if (operationCount <= MAX_SMALL_OPERATION_COUNT) {
            return new SmallDataGenerator(inputFile, operationCount, outputFile);
        } else {
            return new LargeDataGenerator(inputFile, operationCount, outputFile);
        }
    }

}
