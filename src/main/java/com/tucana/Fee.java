package com.tucana;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class Fee {

    private Long id;

    private BigDecimal feeAmt;

    private Date feeDate;
}
