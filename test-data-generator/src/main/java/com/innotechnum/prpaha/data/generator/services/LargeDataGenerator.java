package com.innotechnum.prpaha.data.generator.services;

import com.google.inject.Inject;

/**
 * Генератор тестовых данных.
 * Должен использовать когда ожидается, что требуемых тестовых данных будет много.
 * Оптимизирован под минимально требуемую оперативную память.
 */
public class LargeDataGenerator implements DataGenerator {

    private final String inputFile;
    private final int operationCount;
    private final String outputFile;

    @Inject
    private OfficesFetchService officesFetchService;

    public LargeDataGenerator(final String inputFile, final int operationCount, final String outputFile) {
        this.inputFile = inputFile;
        this.operationCount = operationCount;
        this.outputFile = outputFile;
    }

    public void generate() {

    }

}
