package com.miguel.cashflow.service;

import com.miguel.cashflow.domain.entity.Sale;
import com.miguel.cashflow.domain.enums.PaymentMethod;
import com.miguel.cashflow.dto.MonthExtractDTO;
import com.miguel.cashflow.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService {
    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

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
        return saleRepository.save(sale);
    }

    public MonthExtractDTO getMonthlyReport(int year, int month) {

        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

        List<Sale> sales = saleRepository.findByDateBetween(start, end);

        BigDecimal totalGross = sales.stream()
                .map(Sale::getGrossAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalFee = sales.stream()
                .map(Sale::getFeeAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalNet = sales.stream()
                .map(Sale::getNetAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new MonthExtractDTO(totalGross, totalFee, totalNet);
    }
}