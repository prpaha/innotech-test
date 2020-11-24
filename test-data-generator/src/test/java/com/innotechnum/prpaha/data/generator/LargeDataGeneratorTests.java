package com.innotechnum.prpaha.data.generator;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.UUID;

@RunWith(JUnit4.class)
public class LargeDataGeneratorTests {

    @Test
    public void generateFail() {
        DataGenerator dataGenerator = new LargeDataGenerator(UUID.randomUUID().toString(),
                RandomUtils.nextInt(), UUID.randomUUID().toString());
        try {
            dataGenerator.generate();
            Assert.fail();
        } catch (RuntimeException e) {

        }
    }

}
