package com.miguel.cashflow.domain.enums;


import java.math.BigDecimal;
import java.util.Set;

// com o enum consigo deixar o codigo aberto para extenção mas fechado para modificação. isso me da a possibilidade de adicionar instancias EX BOLETO sem precisar modificar o construtor.
public enum PaymentMethod{
    //instancias do enum(cada uma delas vira um objeto)
    CASH("CASH"),
    DEBIT("DEBIT"),
    CREDIT("CREDIT"),
    PIX("PIX");

    //variavel pertecente ao enum
    private String fees;

    //Construtor
    PaymentMethod (String feeRate){
        this.fees = feeRate;
    }

    public BigDecimal GetFee(){
       if(fromCodigo(fees) == CASH){
            return BigDecimal.ZERO;
        } else{
            return new BigDecimal("0.15");
        }
    }
    public static PaymentMethod fromCodigo(String feeRate) {
        for (PaymentMethod status : values()) {
            if (status.fees.equals(feeRate)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + feeRate);
    }
}


