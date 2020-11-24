package com.innotechnum.prpaha.data.generator;

import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

@RunWith(JUnit4.class)
public class DataGeneratorFactoryTests {

    @Test
    public void getSmallDataGeneratorTest() {
        DataGenerator dataGenerator = DataGeneratorFactory.getDataGenerator(null,
                DataGeneratorFactory.MAX_SMALL_OPERATION_COUNT, null,
                Mockito.mock(Injector.class));
        Assert.assertTrue(dataGenerator instanceof SmallDataGenerator);
    }

    @Test
    public void getLargeDataGeneratorTest() {
        DataGenerator dataGenerator = DataGeneratorFactory.getDataGenerator(null,
                DataGeneratorFactory.MAX_SMALL_OPERATION_COUNT + 1, null,
                Mockito.mock(Injector.class));
        Assert.assertTrue(dataGenerator instanceof LargeDataGenerator);
    }

}
