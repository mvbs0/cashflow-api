package com.miguel.cashflow.service;
import com.miguel.cashflow.domain.entity.Sale;
import com.miguel.cashflow.domain.enums.PaymentMethod;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class SaleService {
    public Sale createSale(BigDecimal grossAmount, PaymentMethod method) {
        Sale sale = new Sale();
        sale.setDate(LocalDate.now());
        sale.setMethod(method);
        sale.setGrossAmount(grossAmount);

        BigDecimal feeRate = method.getFeeRate();
        BigDecimal feeAmount = grossAmount.multiply(feeRate);
        BigDecimal netAmount = grossAmount.subtract(feeAmount);

        sale.setFeeRate(feeRate);
        sale.setFeeAmount(feeAmount);
        sale.setNetAmount(netAmount);

        return sale;
    }
}
