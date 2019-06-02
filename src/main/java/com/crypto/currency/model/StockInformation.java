package com.crypto.currency.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.io.Serializable;

@Data
@Entity
@Table(
        name = "stock_information",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"stock_id"})}
)
public class StockInformation implements Serializable {
    @Id
    @Column(name = "stock_id", unique = true, updatable = false)
    @SequenceGenerator(name = "stock_primary_key_seq", sequenceName = "stock_primary_key_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_primary_key_seq")
    private Integer stockId;

    @Column(name = "currency", nullable = false, length = 36)
    private String currency;

    @Column(name = "stock_date", nullable = false, length = 36)
    private String stockDate;

    @Column(name = "stock_time", nullable = false, length = 36)
    private String stockTime;

    @Column(precision = 10, scale = 2)
    private Double stockPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_type_id", nullable = false)
    private StockType stockType;
}
