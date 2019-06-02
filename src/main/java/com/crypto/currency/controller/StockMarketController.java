package com.crypto.currency.controller;

import com.crypto.currency.model.dto.StockMarketResponse;
import com.crypto.currency.service.impl.StockMarketServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;
import java.util.List;

/**
 * Controller file to retrieve the Max Profit for
 * each currency type for a specific day
 */
@RestController
@Api(tags = {"stock-market-controller"}, description = "Retrieve the currencies max profit")
@RequestMapping(value = "api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
public class StockMarketController {

    @Autowired
    private StockMarketServiceImpl stockMarketService;


    @RequestMapping(method = RequestMethod.GET, value = "/calculate-profit",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value= HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Retrieving Max Profit")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public List<StockMarketResponse> calculateMaxProfit() {
        return stockMarketService.calculateMaxProfit();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/calculate-profit-for-day/{inputDate}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value= HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Retrieving Max Profit for particular day")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public List<StockMarketResponse> calculateMaxProfitOnSpecificDay(@Param("inputDate") @PathVariable("inputDate") String inputDate) {
        if(StringUtils.isEmpty(inputDate)) {
            throw new InvalidParameterException("inputDate parameter is missing or invalid");
        }
        return stockMarketService.calculateMaxProfitOnSpecificDay(inputDate);
    }

}
