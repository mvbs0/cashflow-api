package com.miguel.cashflow.service;
import com.miguel.cashflow.domain.entity.Sale;
import com.miguel.cashflow.domain.enums.PaymentMethod;
import com.miguel.cashflow.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    public SaleService(SaleRepository saleRepository){
        this.saleRepository = saleRepository;
    }

    public Sale createSale(BigDecimal grossAmount, PaymentMethod method) {
        PaymentMethod currentMethod = PaymentMethod.fromCodigo(method.name());
        Sale sale = new Sale();
        sale.setDate(LocalDate.now());
        sale.setMethod(currentMethod);
        sale.setGrossAmount(grossAmount);

        BigDecimal feeRate = currentMethod.GetFee();
        BigDecimal feeAmount = grossAmount.multiply(feeRate);
        BigDecimal netAmount = grossAmount.subtract(feeAmount);

        sale.setFeeRate(feeRate);
        sale.setFeeAmount(feeAmount);
        sale.setNetAmount(netAmount);

        return saleRepository.save(sale);
    }
}
