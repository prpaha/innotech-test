package com.innotechnum.prpaha.data.generator;

import com.google.inject.Injector;
import com.innotechnum.prpaha.data.generator.services.OfficesFetchService;
import com.innotechnum.prpaha.data.generator.services.OperationSerializer;

/**
 * Фабрика создающая генератор тестовых данных.
 */
public class DataGeneratorFactory {

    protected static final int MAX_SMALL_OPERATION_COUNT = 100;

    /**
     * Создаёт генератор соответствующий ожидаемой нагрузке на память.
     *
     * @param inputFile
     * @param operationCount
     * @param outputFile
     * @return генератор данных
     */
    public static DataGenerator getDataGenerator(final String inputFile, final int operationCount,
                                                 final String outputFile, final Injector injector) {
        if (operationCount <= MAX_SMALL_OPERATION_COUNT) {
            OfficesFetchService officesFetchService = injector.getInstance(OfficesFetchService.class);
            OperationSerializer operationSerializer = injector.getInstance(OperationSerializer.class);
            SmallDataGenerator dataGenerator = new SmallDataGenerator(officesFetchService, operationSerializer);
            dataGenerator.init(inputFile, operationCount, outputFile);
            return dataGenerator;
        } else {
            return new LargeDataGenerator(inputFile, operationCount, outputFile);
        }
    }

}
