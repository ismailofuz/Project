package com.example.project.entity;

import com.example.project.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "orders")
@EqualsAndHashCode(callSuper = true)
public class Order extends AbsEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    //    @CreatedDate = new Date(LocalDate.now().get(ChronoField.EPOCH_DAY))
//    @Column(nullable = false)
    private Date date ;

}
