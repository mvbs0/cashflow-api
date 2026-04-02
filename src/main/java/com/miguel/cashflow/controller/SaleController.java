package com.miguel.cashflow.controller;

import com.miguel.cashflow.domain.entity.Sale;
import com.miguel.cashflow.dto.MonthExtractDTO;
import com.miguel.cashflow.dto.SaleRequestDTO;
import com.miguel.cashflow.service.SaleService;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/month")
    public MonthExtractDTO getMonthlyReport(
            @RequestParam int year,
            @RequestParam int month
    ){
        return saleService.getMonthlyReport(year, month);
    }
}
