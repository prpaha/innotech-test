package com.innotechnum.prpaha.data.generator;

import com.innotechnum.prpaha.data.generator.services.DataGenerator;
import com.innotechnum.prpaha.data.generator.services.LargeDataGenerator;
import com.innotechnum.prpaha.data.generator.services.SmallDataGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DataGeneratorFactoryTests {

    @Test
    public void getSmallDataGeneratorTest() {
        DataGenerator dataGenerator = DataGeneratorFactory.getDataGenerator(null, 100, null);
        Assert.assertTrue(dataGenerator instanceof SmallDataGenerator);
    }

    @Test
    public void getLargeDataGeneratorTest() {
        DataGenerator dataGenerator = DataGeneratorFactory.getDataGenerator(null, 101, null);
        Assert.assertTrue(dataGenerator instanceof LargeDataGenerator);
    }

}
