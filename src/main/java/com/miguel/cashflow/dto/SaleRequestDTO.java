package com.miguel.cashflow.dto;

import com.miguel.cashflow.domain.enums.PaymentMethod;

import java.math.BigDecimal;

public class SaleRequestDTO {

    private BigDecimal grossAmount;
    private PaymentMethod method;

    public BigDecimal getGrossAmount(){
        return grossAmount;
    }

    public void setGrossAmount(BigDecimal grossAmount) {
        this.grossAmount = grossAmount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }
}
