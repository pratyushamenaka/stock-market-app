package com.crypto.currency.controller

import com.crypto.currency.model.dto.StockMarketResponse
import com.crypto.currency.service.impl.StockMarketServiceImpl
import spock.lang.Specification

import java.security.InvalidParameterException

class StockMarketControllerTest extends Specification {

    def stockMarketService = Mock(StockMarketServiceImpl)

    StockMarketController controller

    def setup() {
        controller = new StockMarketController(stockMarketService: stockMarketService)
    }

    def "verify calculateMaxProfit"() {

        given:
        def stockMarketRespList = new ArrayList<StockMarketResponse>()

        when:
        def result = controller.calculateMaxProfit();

        then:
        1 * stockMarketService.calculateMaxProfit() >> stockMarketRespList

        then:
        result == stockMarketRespList

    }

    def "verify calculateMaxProfit for specific date"() {

        given:
        def stockMarketRespList = new ArrayList<StockMarketResponse>()

        when:
        def result = controller.calculateMaxProfitOnSpecificDay("20180705");

        then:
        1 * stockMarketService.calculateMaxProfitOnSpecificDay("20180705") >> stockMarketRespList

        then:
        result == stockMarketRespList

    }

    def "verify calculateMaxProfit for specific date - Pass null value "() {

        when:
        controller.calculateMaxProfitOnSpecificDay(null);

        then:
        thrown(InvalidParameterException)

    }




}
