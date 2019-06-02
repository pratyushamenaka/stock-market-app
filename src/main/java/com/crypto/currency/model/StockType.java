package com.crypto.currency.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@Table(
        name = "stock_type",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"stock_type_id"})}
)
public class StockType implements Serializable {
    @Id
    @Column(name = "stock_type_id", unique = true, updatable = false)
    @SequenceGenerator(name = "stock_type_primary_key_seq", sequenceName = "stock_type_primary_key_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_type_primary_key_seq")
    private Integer stockTypeId;

    @Column(name = "stock_type_name", nullable = false, length = 36)
    private String stockTypeName;

    @Column(name = "stock_type_desc", nullable = false, length = 36)
    private String stockTypeDesc;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "stockType")
    private List<StockInformation> stockInformationList;

}
