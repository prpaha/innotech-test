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

}
