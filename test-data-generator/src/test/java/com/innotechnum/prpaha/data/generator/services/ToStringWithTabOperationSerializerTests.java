package com.innotechnum.prpaha.data.generator.services;

import com.innotechnum.prpaha.data.generator.TestDataProvider;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ToStringWithTabOperationSerializerTests {

    @Test
    public void serializeTest() {
        OperationSerializer operationSerializer = new ToStringWithTabOperationSerializer();
        String serializedOperation = operationSerializer.serialize(TestDataProvider.getOperation());

        Assert.assertTrue(StringUtils.isNotBlank(serializedOperation));

        String[] datas = serializedOperation.split(ToStringWithTabOperationSerializer.DELIMITER);
        Assert.assertEquals(datas.length, 5);
    }

}
