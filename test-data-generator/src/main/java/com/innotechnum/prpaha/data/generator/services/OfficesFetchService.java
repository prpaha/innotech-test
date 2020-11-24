package com.innotechnum.prpaha.data.generator.services;

import com.innotechnum.prpaha.data.generator.dto.Office;

/**
 * Сервис осуществляющий доступ к данным точек продаж.
 */
public interface OfficesFetchService {

    /**
     * Получает случайный отдел продаж.
     *
     * @return отдел продаж
     */
    Office getRandomOffice();

    /**
     * Выборка коллекции офисов.
     *
     * @param inputFile файл с офисами
     */
    void fetchOffices(String inputFile);
}
