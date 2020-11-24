package com.innotechnum.prpaha.data.generator.services;

import com.innotechnum.prpaha.data.generator.dto.Operation;

/**
 * Сериализатор данных.
 */
public interface OperationSerializer {

    /**
     * Сериализует операцию.
     *
     * @param operation операция
     * @return сериализованное представление операции
     */
    String serialize(Operation operation);

}
