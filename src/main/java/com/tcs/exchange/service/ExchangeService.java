package com.tcs.exchange.service;

import com.tcs.exchange.model.ExchangeRate;
import com.tcs.exchange.repository.ExchangeRateRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class ExchangeService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    public ExchangeService(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public ExchangeRate getExchangeRate(String currencyFrom, String currencyTo) {
        return exchangeRateRepository.findByCurrencyFromAndCurrencyTo(currencyFrom, currencyTo);
    }

    public void updateExchangeRate(String currencyFrom, String currencyTo, double exchangeRateAux) {
        ExchangeRate exchangeRate = exchangeRateRepository.findByCurrencyFromAndCurrencyTo(currencyFrom, currencyTo);
        if (exchangeRate == null) {
            exchangeRate = new ExchangeRate();
            exchangeRate.setCurrencyFrom(currencyFrom);
            exchangeRate.setCurrencyTo(currencyTo);
        }
        exchangeRate.setExchangeRate(exchangeRateAux);
        exchangeRateRepository.save(exchangeRate);
    }
}
