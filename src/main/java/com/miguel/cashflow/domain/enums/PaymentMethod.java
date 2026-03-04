package com.miguel.cashflow.domain.enums;


import java.math.BigDecimal;
// com o enum consigo deixar o codigo aberto para extenção mas fechado para modificação. isso me da a possibilidade de adicionar instancias EX BOLETO sem precisar modificar o construtor.
public enum PaymentMethod{
    //instancias do enum(cada uma delas vira um objeto)
    CASH(BigDecimal.ZERO),
    DEBIT(new BigDecimal("0.15")),
    CREDIT(new BigDecimal("0.15")),
    PIX(new BigDecimal("0.15"));

    //variavel pertecente ao enum
    private final BigDecimal feeRate;

    //aqui o feeRate pertence ao construtor
    PaymentMethod(BigDecimal feeRate){
        // O Atritubuto da classe recebe o valor do parametro
        this.feeRate = feeRate;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }
    public boolean hasFee(){
        return feeRate.compareTo(BigDecimal.ZERO) > 0;
    }
}


