package com.innotechnum.prpaha.data.generator.repository;

import com.innotechnum.prpaha.data.generator.TestDataProvider;
import com.innotechnum.prpaha.data.generator.dto.Office;
import com.innotechnum.prpaha.data.generator.services.OfficeSerializer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class ToStringWithTabOfficeRepositoryTest {

    @Mock
    private OfficeSerializer officeSerializer;

    @Test
    public void getAllOffices() throws URISyntaxException {
        Mockito.when(officeSerializer.deserialize(Mockito.anyString())).thenReturn(TestDataProvider.getOffice());
        OfficeRepository officeRepository = new ToStringWithTabOfficeRepository(officeSerializer);
        File file = new File(getClass().getClassLoader().getResource(TestDataProvider.PREPARE_OFFICES_FILE).toURI());
        officeRepository.init(file.getPath());
        Collection<Office> offices = officeRepository.getAllOffices();
        Assert.assertNotNull(offices);
        Assert.assertEquals(offices.size(), 10);
    }

    @Test
    public void initFail() {
        OfficeRepository officeRepository = new ToStringWithTabOfficeRepository(officeSerializer);
        try {
            officeRepository.init(UUID.randomUUID().toString());
            Assert.fail();
        } catch (RuntimeException e) {

        }
    }

}
