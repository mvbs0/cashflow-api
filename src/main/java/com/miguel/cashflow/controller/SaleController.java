package com.miguel.cashflow.controller;

import com.miguel.cashflow.domain.entity.Sale;
import com.miguel.cashflow.dto.SaleRequestDTO;
import com.miguel.cashflow.service.SaleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SaleController {
    private final SaleService saleService;

    public SaleController(SaleService saleService){
        this.saleService = saleService;
    }

    @PostMapping
    public Sale createSale(@RequestBody SaleRequestDTO request){

        return saleService.createSale(
                request.getGrossAmount(),
                request.getMethod()
        );
    }
}
