package com.innotechnum.prpaha.data.generator;

import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Абстрактный генератор данных.
 */
public class AbstractDataGenerator {

    private final long minTime;
    private final long maxTime;

    public AbstractDataGenerator() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),
                0, 1, 0, 0, 0);
        maxTime = calendar.getTimeInMillis();
        calendar.set(calendar.get(Calendar.YEAR) - 1,
                0, 1, 0, 0, 0);
        minTime = calendar.getTimeInMillis();
    }

    protected BigDecimal getRandomAmount() {
        return BigDecimal.valueOf(RandomUtils.nextDouble(10000.00, 100000.00));
    }

    protected Date getRandomDate() {
        return new Date(RandomUtils.nextLong(minTime, maxTime));
    }

}
