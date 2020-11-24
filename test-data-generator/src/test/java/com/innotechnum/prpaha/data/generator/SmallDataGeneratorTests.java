package com.innotechnum.prpaha.data.generator;

import com.innotechnum.prpaha.data.generator.services.OfficesFetchService;
import com.innotechnum.prpaha.data.generator.services.OperationSerializer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.net.URISyntaxException;
import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class SmallDataGeneratorTests {

    @Mock
    private OfficesFetchService officesFetchService;

    @Mock
    private OperationSerializer operationSerializer;

    @Test
    public void generate() throws URISyntaxException {
        File officeFile = getOfficeFile();

        Mockito.when(officesFetchService.getRandomOffice()).thenReturn(TestDataProvider.getOffice());
        Mockito.when(operationSerializer.serialize(Mockito.any())).thenReturn(UUID.randomUUID().toString());

        String outputFilePath = "operationsResult.txt";
        SmallDataGenerator dataGenerator = new SmallDataGenerator(officesFetchService, operationSerializer);
        dataGenerator.init(officeFile.getPath(), 99, outputFilePath);
        dataGenerator.generate();

        File resultFile = new File(outputFilePath);
        Assert.assertTrue(resultFile.exists());
        analyzeFile(resultFile);
    }

    private void analyzeFile(File resultFile) {
        // TODO Проанализировать формат файла на соответствие протоколу
    }

    private File getOfficeFile() throws URISyntaxException {
        return new File(getClass().getClassLoader().getResource(TestDataProvider.PREPARE_OFFICES_FILE).toURI());
    }

}
