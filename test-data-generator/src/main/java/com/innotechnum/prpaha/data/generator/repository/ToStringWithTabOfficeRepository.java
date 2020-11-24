package com.innotechnum.prpaha.data.generator.repository;

import com.google.inject.Inject;
import com.innotechnum.prpaha.data.generator.dto.Office;
import com.innotechnum.prpaha.data.generator.services.OfficeSerializer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Репозиторий с оффисами.
 */
public class ToStringWithTabOfficeRepository implements OfficeRepository {

    private final OfficeSerializer officeSerializer;

    private File file;

    @Inject
    public ToStringWithTabOfficeRepository(OfficeSerializer officeSerializer) {
        this.officeSerializer = officeSerializer;
    }

    @Override
    public Collection<Office> getAllOffices() {
        try {
            return Files.lines(file.toPath()).map(this::deserialize).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Office deserialize(String line) {
        return officeSerializer.deserialize(line);
    }

    @Override
    public void init(String inputFile) {
        file = new File(inputFile);
        if (!file.exists()) {
            throw new RuntimeException("File with offices not exists");
        }
    }

}
