package com.crypto.currency.service.impl;

import com.crypto.currency.model.dto.StockMarketResponse;
import com.crypto.currency.repository.StockInformationRepository;
import com.crypto.currency.service.StockMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StockMarketServiceImpl implements StockMarketService {

    @Autowired
    private StockInformationRepository stockInformationRepository;

    @Override
    public List<StockMarketResponse> calculateMaxProfit() {

        Set<StockMarketResponse> stockMarketResponseList = new HashSet<>();

        stockMarketResponseList = stockInformationRepository.findMaxProfit();

        return stockMarketResponseList.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<StockMarketResponse> calculateMaxProfitOnSpecificDay(String inputDate) {

        Set<StockMarketResponse> stockMarketResponseList = new HashSet<>();

        stockMarketResponseList = stockInformationRepository.findMaxProfitOnSpecificDay(inputDate);

        return stockMarketResponseList.stream().distinct().collect(Collectors.toList());

    }


}
