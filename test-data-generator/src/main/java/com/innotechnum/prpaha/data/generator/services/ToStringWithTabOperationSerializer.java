package com.innotechnum.prpaha.data.generator.services;

import com.innotechnum.prpaha.data.generator.dto.Operation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;

/**
 * Сериализатор данных.
 */
public class ToStringWithTabOperationSerializer implements OperationSerializer {

    protected static final String DELIMITER = "\t\t";

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    @Override
    public String serialize(final Operation operation) {
        return new StringBuilder()
                .append(dateFormat.format(operation.getDate())).append(DELIMITER)
                .append(timeFormat.format(operation.getDate())).append(DELIMITER)
                .append(operation.getOffice().getId()).append(DELIMITER)
                .append(operation.getIndex()).append(DELIMITER)
                .append(getAmount(operation.getAmount()))
                .toString();
    }

    private String getAmount(final BigDecimal amount) {
        return amount.setScale(2, RoundingMode.UP).toPlainString();
    }

}
