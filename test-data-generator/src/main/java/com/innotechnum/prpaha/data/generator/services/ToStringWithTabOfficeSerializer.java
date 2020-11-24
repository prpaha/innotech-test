package com.innotechnum.prpaha.data.generator.services;

import com.innotechnum.prpaha.data.generator.dto.Office;

/**
 * Сериализатор данных.
 */
public class ToStringWithTabOfficeSerializer implements OfficeSerializer {

    @Override
    public Office deserialize(String line) {
        return new Office(Integer.parseInt(line));
    }

}
