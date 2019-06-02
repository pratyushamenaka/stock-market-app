package com.crypto.currency.repository;

import com.crypto.currency.model.StockInformation;
import com.crypto.currency.model.dto.StockMarketResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


/**
 * Repository class for Stock Information table.
 * Used native queries
 */
@Repository
public interface StockInformationRepository extends JpaRepository<StockInformation,Integer> {
    
    List<StockInformation> findAll();

    @Query("select new com.crypto.currency.model.dto.StockMarketResponse( stk.stockId, stk.currency as currency, stk.stockTime as buytime, stk.stockDate as stockdate, stk.stockPrice as buyprice, " +
            "sellstk.stockTime as selltime, sellstk.stockPrice as sellprice, (sellstk.stockPrice - stk.stockPrice) as profit) from StockInformation stk, StockInformation sellstk"
            + " where stk.stockPrice = (select min(stkinfo.stockPrice) from StockInformation stkinfo where stkinfo.currency = stk.currency and stkinfo.stockDate = stk.stockDate)"
            + "and sellstk.stockPrice = (select max(stkinfo.stockPrice) from StockInformation stkinfo where stkinfo.currency = stk.currency and stkinfo.stockDate = stk.stockDate)")
    Set<StockMarketResponse> findMaxProfit();

    @Query("select new com.crypto.currency.model.dto.StockMarketResponse(stk.stockId, stk.currency as currency, stk.stockTime as buytime, stk.stockDate as stockdate, stk.stockPrice as buyprice, " +
            "sellstk.stockTime as selltime, sellstk.stockPrice as sellprice, (sellstk.stockPrice - stk.stockPrice) as profit) from StockInformation stk, StockInformation sellstk"
            + " where stk.stockPrice = (select min(stkinfo.stockPrice) from StockInformation stkinfo where stkinfo.currency = stk.currency and stkinfo.stockDate = :inputDate)"
            + "and sellstk.stockPrice = (select max(stkinfo.stockPrice) from StockInformation stkinfo where stkinfo.currency = stk.currency and stkinfo.stockDate = :inputDate)")
    Set<StockMarketResponse> findMaxProfitOnSpecificDay(@Param("inputDate") String inputDate);

}
