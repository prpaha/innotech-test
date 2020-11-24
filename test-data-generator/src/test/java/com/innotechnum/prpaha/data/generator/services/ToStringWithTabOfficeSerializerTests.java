package com.innotechnum.prpaha.data.generator.services;

import com.innotechnum.prpaha.data.generator.TestDataProvider;
import com.innotechnum.prpaha.data.generator.dto.Office;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

@RunWith(JUnit4.class)
public class ToStringWithTabOfficeSerializerTests {

    @Test
    public void deserializeOfficeTest() throws URISyntaxException, IOException {
        File testFile = new File(getClass().getClassLoader().getResource(TestDataProvider.PREPARE_OFFICES_FILE).toURI());
        Files.lines(testFile.toPath()).forEach(this::checkOfficeDeserialize);
    }

    private void checkOfficeDeserialize(String line) {
        OfficeSerializer operationSerializer = new ToStringWithTabOfficeSerializer();
        Office office = operationSerializer.deserialize(line);
        Assert.assertNotNull(office);
        Assert.assertTrue(office.getId() > 0);
    }

}
