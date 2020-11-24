package com.innotechnum.prpaha.data.generator.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO для операции.
 */
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Operation {

    private int index;
    private Office office;
    private Date date;
    private BigDecimal amount;

}
