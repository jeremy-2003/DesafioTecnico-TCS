package com.tcs.exchange.repository;

import com.tcs.exchange.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    ExchangeRate findByCurrencyFromAndCurrencyTo(String currencyFrom, String currencyTo);
}
