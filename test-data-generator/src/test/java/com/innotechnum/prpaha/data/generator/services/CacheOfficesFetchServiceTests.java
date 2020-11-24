package com.innotechnum.prpaha.data.generator.services;

import com.innotechnum.prpaha.data.generator.TestDataProvider;
import com.innotechnum.prpaha.data.generator.dto.Office;
import com.innotechnum.prpaha.data.generator.repository.OfficeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class CacheOfficesFetchServiceTests {

    @Mock
    private OfficeRepository officeRepository;

    @Test
    public void getRandomOfficeWhenEmptyOffices() {
        OfficesFetchService officesFetchService = new CacheOfficesFetchService(officeRepository);
        try {
            officesFetchService.getRandomOffice();
            Assert.fail("Offices is empty");
        } catch (RuntimeException e) {

        }
    }

    @Test
    public void getRandomOfficeSuccess() {
        List<Office> testOffices = Arrays.asList(TestDataProvider.getOffice(),
                TestDataProvider.getOffice(),
                TestDataProvider.getOffice());
        Mockito.when(officeRepository.getAllOffices()).thenReturn(testOffices);
        OfficesFetchService officesFetchService = new CacheOfficesFetchService(officeRepository);
        officesFetchService.fetchOffices(UUID.randomUUID().toString());
        Office office = officesFetchService.getRandomOffice();
        Assert.assertNotNull(office);
        Assert.assertTrue(testOffices.contains(office));
    }

}
