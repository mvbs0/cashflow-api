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

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private PaymentMethod method;

        @Column(nullable = false)
        private BigDecimal grossAmount;

        @Column(nullable = false)
        private BigDecimal feeRate;

        @Column(nullable = false)
        private BigDecimal feeAmount;

        @Column(nullable = false)
        private BigDecimal netAmount;

}
