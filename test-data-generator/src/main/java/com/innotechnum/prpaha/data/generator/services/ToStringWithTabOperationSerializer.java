package com.innotechnum.prpaha.data.generator.services;

import com.innotechnum.prpaha.data.generator.dto.Operation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

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
                .append(formatDate(operation.getDate())).append(DELIMITER)
                .append(formatTime(operation.getDate())).append(DELIMITER)
                .append(operation.getOffice().getId()).append(DELIMITER)
                .append(operation.getIndex()).append(DELIMITER)
                .append(getAmount(operation.getAmount()))
                .toString();
    }

    private synchronized String formatTime(final Date date) {
        return timeFormat.format(date);
    }

    private synchronized String formatDate(final Date date) {
        return dateFormat.format(date);
    }

    private String getAmount(final BigDecimal amount) {
        return amount.setScale(2, RoundingMode.UP).toPlainString();
    }

}
