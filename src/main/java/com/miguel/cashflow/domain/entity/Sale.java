package com.miguel.cashflow.domain.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import com.miguel.cashflow.domain.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sales")
@Getter
@Setter
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod method;
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal grossAmount;
    @Column(precision = 5, scale = 2)
    private BigDecimal feeRate;
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal feeAmount;
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal netAmount;
    public Sale() {
    }

}
