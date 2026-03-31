package com.miguel.cashflow.dto;

import java.math.BigDecimal;

public class MonthExtractDTO {
    private BigDecimal totalGross;
    private BigDecimal totalFee;
    private BigDecimal totalNet;

    public MonthExtractDTO(BigDecimal totalGross, BigDecimal totalFee, BigDecimal totalNet) {
        this.totalGross = totalGross;
        this.totalFee = totalFee;
        this.totalNet = totalNet;
    }

    public BigDecimal getTotalGross() {
        return totalGross;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public BigDecimal getTotalNet() {
        return totalNet;
    }
}
