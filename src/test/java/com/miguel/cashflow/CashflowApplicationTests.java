package com.miguel.cashflow;

import com.miguel.cashflow.domain.entity.Sale;
import com.miguel.cashflow.domain.enums.PaymentMethod;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CashflowApplicationTests {

    @Test
    void testPaymentMethod() {

        assertEquals(0, PaymentMethod.CASH.getFeeRate().compareTo(new BigDecimal("0.00")));
        assertEquals(0, PaymentMethod.PIX.getFeeRate().compareTo(new BigDecimal("0.15")));
        assertFalse(PaymentMethod.CASH.hasFee());
        assertTrue(PaymentMethod.PIX.hasFee());
    }

    @Test
    void testSaleCalculation() {

        Sale sale = new Sale();
        sale.setDate(LocalDate.now());
        sale.setMethod(PaymentMethod.PIX);
        sale.setGrossAmount(new BigDecimal("100.00"));

        BigDecimal fee = sale.getGrossAmount()
                .multiply(sale.getMethod().getFeeRate());

        BigDecimal net = sale.getGrossAmount()
                .subtract(fee);

        sale.setFeeRate(sale.getMethod().getFeeRate());
        sale.setFeeAmount(fee);
        sale.setNetAmount(net);

        assertEquals(0, fee.compareTo(new BigDecimal("15.00")));
        assertEquals(0, net.compareTo(new BigDecimal("85.00")));
        assertEquals(PaymentMethod.PIX, sale.getMethod());
    }
}