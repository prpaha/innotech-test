package com.innotechnum.prpaha.data.generator;

import com.innotechnum.prpaha.data.generator.dto.Office;
import com.innotechnum.prpaha.data.generator.dto.Operation;
import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Утилитный класс обеспециавющий генерацию тестовых данных.
 */
public class TestDataProvider {

    public static final String PREPARE_OFFICES_FILE = "office.txt";

    public static Operation getOperation() {
        return new Operation(RandomUtils.nextInt(), getOffice(),
                new Date(RandomUtils.nextLong()), BigDecimal.valueOf(RandomUtils.nextDouble()));
    }

    public static Office getOffice() {
        return new Office(RandomUtils.nextInt());
    }

}
