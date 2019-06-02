package com.crypto.currency.service;

import com.crypto.currency.model.dto.StockMarketResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Interface
 */
@Service
public interface StockMarketService {

    /**
     * calculateMaxProfit : method to each currency category calculate profit from database
     * @return List of Stocks for currency catageroies
     */
    List<StockMarketResponse> calculateMaxProfit();

    /**
     * calculateMaxProfit : method to each currency category calculate profit from db for specified date
     * @return List of Stocks for currency catageroies
     * @param inputDate
     */
    List<StockMarketResponse> calculateMaxProfitOnSpecificDay(String inputDate);
}
