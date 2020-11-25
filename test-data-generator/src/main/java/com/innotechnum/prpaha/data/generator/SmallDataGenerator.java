package com.innotechnum.prpaha.data.generator;

import com.google.inject.Inject;
import com.innotechnum.prpaha.data.generator.dto.Operation;
import com.innotechnum.prpaha.data.generator.services.OfficesFetchService;
import com.innotechnum.prpaha.data.generator.services.OperationSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Генератор тестовых данных.
 * Должен использовать когда ожидается, что требуемых тестовых данных будет не много.
 * Оптимизирован под скорость работы.
 */
public class SmallDataGenerator extends AbstractDataGenerator implements DataGenerator {

    private String inputFilePath;
    private int operationCount;
    private String outputFilePath;

    private final OfficesFetchService officesFetchService;
    private final OperationSerializer operationSerializer;

    @Inject
    public SmallDataGenerator(OfficesFetchService officesFetchService, OperationSerializer operationSerializer) {
        this.officesFetchService = officesFetchService;
        this.operationSerializer = operationSerializer;
    }

    public void init(final String inputFilePath, final int operationCount, final String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.operationCount = operationCount;
        this.outputFilePath = outputFilePath;
    }

    public void generate() {
        officesFetchService.fetchOffices(inputFilePath);

        Collection<Operation> generatedOperations = generateOperations();
        File outputFile = getOutputFile();
        try (FileWriter writer = new FileWriter(outputFile, false)) {
            generatedOperations.forEach(operation -> writeLineToFile(writer, operationSerializer.serialize(operation)));
            writer.flush();
        } catch (IOException ex) {

        }
    }

    private File getOutputFile() {
        File file = new File(outputFilePath);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    private void writeLineToFile(FileWriter writer, String line) {
        try {
            writer.write(line);
            writer.write(System.getProperty("line.separator"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Collection<Operation> generateOperations() {
        return IntStream.range(0, operationCount).mapToObj(this::generateOperation).collect(Collectors.toList());
    }

    private Operation generateOperation(int index) {
        return new Operation(index + 1, officesFetchService.getRandomOffice(),
                getRandomDate(), getRandomAmount());
    }

}
