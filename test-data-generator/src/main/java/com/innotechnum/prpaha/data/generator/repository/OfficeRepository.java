package com.innotechnum.prpaha.data.generator.repository;

import com.innotechnum.prpaha.data.generator.dto.Office;

import java.util.Collection;

/**
 * Репозиторий для офисов.
 */
public interface OfficeRepository {

    /**
     * Получает все офисы.
     *
     * @return коллекция офисов
     */
    Collection<Office> getAllOffices();

    /**
     * Инициализация репозитория офисов.
     *
     * @param inputFile путь до файла с офисами
     */
    void init(String inputFile);
}
