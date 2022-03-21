package com.example.project.entity;

import com.example.project.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Invoice extends AbsEntity {

    @OneToOne(fetch = FetchType.LAZY)
    private Order order;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 8, fraction = 2)
    @Column(nullable = false)
    private BigDecimal amount;

    //    @CreatedDate
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(nullable = false)
    private Date issued;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(nullable = false)
    private Date due;

}
