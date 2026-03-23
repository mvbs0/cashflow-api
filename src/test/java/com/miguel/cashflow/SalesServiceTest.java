//package com.miguel.cashflow;
//
//import com.miguel.cashflow.domain.entity.Sale;
//import com.miguel.cashflow.domain.enums.PaymentMethod;
//import com.miguel.cashflow.service.SaleService;
//import org.junit.jupiter.api.Test;
//
//import java.math.BigDecimal;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class SaleServiceTest {
//
//    private final SaleService saleService = new SaleService();
//
//    @Test
//    void shouldCreateSaleWithCorrectCalculation() {
//
//        BigDecimal grossAmount = new BigDecimal("200.00");
//        PaymentMethod method = PaymentMethod.PIX;
//
//        Sale sale = saleService.createSale(grossAmount, method);
//
//        assertEquals(method, sale.getMethod());
//
//        assertEquals(0,
//                sale.getFeeRate().compareTo(new BigDecimal("0.15")));
//
//        assertEquals(0,
//                sale.getFeeAmount().compareTo(new BigDecimal("30.00")));
//
//        assertEquals(0,
//                sale.getNetAmount().compareTo(new BigDecimal("170.00")));
//
//        assertNotNull(sale.getDate());
//    }
//}