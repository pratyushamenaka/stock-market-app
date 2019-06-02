package com.crypto.currency.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockMarketResponse {

    private Integer stockId;

    private String currency;

    private String buyTime;

    private String stockDate;

    private Double buyPrice;

    private String sellTime;

    private Double sellPrice;

    private Double profit;

}
