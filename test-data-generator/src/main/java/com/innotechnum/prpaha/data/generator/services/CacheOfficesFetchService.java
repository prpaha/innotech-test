package com.innotechnum.prpaha.data.generator.services;

import com.google.inject.Inject;
import com.innotechnum.prpaha.data.generator.dto.Office;
import com.innotechnum.prpaha.data.generator.repository.OfficeRepository;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис работы с офисами.
 */
public class CacheOfficesFetchService implements OfficesFetchService {

    private OfficeRepository officeRepository;

    @Inject
    public CacheOfficesFetchService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    private List<Office> offices;

    @Override
    public Office getRandomOffice() {
        if (offices == null || offices.isEmpty()) {
            throw new RuntimeException("Classfier 'offices' is empty");
        }
        return offices.get(RandomUtils.nextInt(0, offices.size()));
    }

    @Override
    public void fetchOffices(String inputFile) {
        officeRepository.init(inputFile);
        offices = new ArrayList<>(officeRepository.getAllOffices());
    }
}
