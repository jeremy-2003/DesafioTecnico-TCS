package com.tcs.exchange;

import com.tcs.exchange.model.ExchangeRate;
import com.tcs.exchange.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ExchangeApplication {

	@Autowired
	private ExchangeRateRepository exchangeRateRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExchangeApplication.class, args);
	}

	@PostConstruct
	public void initializeExchangeRates() {
		ExchangeRate exchangeRate1 = new ExchangeRate();
		exchangeRate1.setCurrencyFrom("USD");
		exchangeRate1.setCurrencyTo("EUR");
		exchangeRate1.setExchangeRate(0.92);
		ExchangeRate exchangeRate2 = new ExchangeRate();
		exchangeRate2.setCurrencyFrom("USD");
		exchangeRate2.setCurrencyTo("PEN");
		exchangeRate2.setExchangeRate(3.74);

		ExchangeRate exchangeRate3 = new ExchangeRate();
		exchangeRate3.setCurrencyFrom("EUR");
		exchangeRate3.setCurrencyTo("PEN");
		exchangeRate3.setExchangeRate(4.08);
		ExchangeRate exchangeRate4 = new ExchangeRate();
		exchangeRate4.setCurrencyFrom("EUR");
		exchangeRate4.setCurrencyTo("USD");
		exchangeRate4.setExchangeRate(1.09);

		ExchangeRate exchangeRate5 = new ExchangeRate();
		exchangeRate5.setCurrencyFrom("PEN");
		exchangeRate5.setCurrencyTo("USD");
		exchangeRate5.setExchangeRate(0.27);
		ExchangeRate exchangeRate6 = new ExchangeRate();
		exchangeRate6.setCurrencyFrom("PEN");
		exchangeRate6.setCurrencyTo("EUR");
		exchangeRate6.setExchangeRate(0.24);

		exchangeRateRepository.save(exchangeRate1);
		exchangeRateRepository.save(exchangeRate2);
		exchangeRateRepository.save(exchangeRate3);
		exchangeRateRepository.save(exchangeRate4);
		exchangeRateRepository.save(exchangeRate5);
		exchangeRateRepository.save(exchangeRate6);
	}
}
