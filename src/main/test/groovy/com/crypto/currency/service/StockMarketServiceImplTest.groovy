package com.crypto.currency.service

import com.crypto.currency.model.StockInformation
import com.crypto.currency.model.StockType
import com.crypto.currency.model.dto.StockMarketResponse
import com.crypto.currency.repository.StockInformationRepository
import com.crypto.currency.service.impl.StockMarketServiceImpl
import spock.lang.Specification

class StockMarketServiceImplTest extends Specification {

    static def generateStockMarketDB() {
        def c = new StockInformation()
        def stockId = 1
        c.setStockId(stockId)
        c.setCurrency('BTC')
        c.setStockPrice(34.70)
        c.setStockTime('0900')
        c.setStockDate('20180507')
        c.setStockType(generateStockTypeDB())
        return c
    }

    static def generateStockTypeDB() {
        def d = new StockType()
        d.setStockTypeDesc('Bit Coin')
        d.stockTypeId = 100
        d.stockTypeName = 'BTC'
        d.stockInformationList = null
        return d
    }

    def stockRepo = Mock(StockInformationRepository) {
        findAll() >> { _ ->
            return Arrays.asList(generateStockMarketDB(), generateStockMarketDB())
        }

        findMaxProfit() >> { _ ->
            return Arrays.asList(generateStockMarketDB(), generateStockMarketDB())
        }

        findMaxProfitOnSpecificDay(_) >> { String inputDate ->
            if ("xxx".equals(inputDate)) {
                return null
            }
            def stockDb = generateStockMarketDB()
            stockDb.setStockDate(inputDate)
            return stockDb
        }
    }


    def stockMarketService = new StockMarketServiceImpl(stockInformationRepository: stockRepo)


    def stockInformation
    def stockInput
    def stockInput2
    def stockResult


    def setup() {
        stockInformation = Mock(StockInformation)

        stockInput = new StockInformation()
        stockInput.getStockId() >> 1
        stockInput.getCurrency() >> 'BTC'
        stockInput.getStockDate() >> '20170508'
        stockInput.getStockPrice() >> 39.35
        stockInput.getStockTime() >> '1200'
        stockInput.getStockType() >> Mock(StockType)


        stockInput2 = new StockInformation()
        stockInput2.getStockId() >> 1
        stockInput2.getCurrency() >> 'BTC'
        stockInput2.getStockDate() >> '20170508'
        stockInput2.getStockPrice() >> 19.00
        stockInput2.getStockTime() >> '1400'
        stockInput2.getStockType() >> Mock(StockType)
        List<StockInformation> stockList = [stockInput, stockInput2]


        stockResult = new StockMarketResponse()
        stockResult.setStockDate('20170508')
        stockResult.setSellTime('1200')
        stockResult.setBuyTime('1400')
        stockResult.setSellPrice(39.35)
        stockResult.setBuyPrice(19.00)
        stockResult.setProfit(20.35)
        stockResult.setCurrency('BTC')

    }


    def "Calculate max profit for all the currency categories"() {
        given:
        stockInformation = Mock(StockInformation)

        List<StockInformation> stockResultList = [stockResult]

        when: "get the profits"
        stockResultList = stockMarketService.calculateMaxProfit()

        then:
        1 * stockRepo.findMaxProfit(*_) >> stockResultList

        then:
        assert stockResultList.get(0).getProfit() == 20.35
    }

    def "Calculate max profit for all the currency categories -- speicific day"() {
        given:
        stockInformation = Mock(StockInformation)

        List<StockInformation> stockResultList = [stockResult]

        when: "get the profits"
        stockResultList = stockMarketService.calculateMaxProfitOnSpecificDay('20170508')

        then:
        1 * stockRepo.findMaxProfitOnSpecificDay(*_) >> stockResultList

        then:
        assert stockResultList.get(0).getProfit() == 20.35
    }


}
