package com.innotechnum.prpaha.data.generator.services;

import com.innotechnum.prpaha.data.generator.dto.Office;

/**
 * Сериализатор данных.
 */
public interface OfficeSerializer {

    /**
     * Десериализует офис.
     *
     * @param line строка
     * @return офис
     */
    Office deserialize(String line);

}
