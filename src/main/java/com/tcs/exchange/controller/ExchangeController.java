package com.tcs.exchange.controller;

import com.tcs.exchange.dto.ExchangeRequest;
import com.tcs.exchange.dto.ExchangeResponse;
import com.tcs.exchange.model.ExchangeRate;
import com.tcs.exchange.service.ExchangeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }
    @PostMapping("prueba")
    public ResponseEntity<ExchangeResponse> postExchange(@RequestBody ExchangeRequest exchangeRequest) throws Exception {
        ExchangeRate exchangeRate = exchangeService.getExchangeRate(exchangeRequest.getMonedaOrigen(), exchangeRequest.getMonedaDestino());
        if (exchangeRate == null) {
            throw new Exception("No se encontró la tasa de cambio para las monedas " + exchangeRequest.getMonedaOrigen() + " y " + exchangeRequest.getMonedaDestino());
        }
        ExchangeResponse exchangeResponse = new ExchangeResponse(exchangeRequest.getMonto(), exchangeRequest.getMonto() * exchangeRate.getExchangeRate(),
                exchangeRequest.getMonedaOrigen(), exchangeRequest.getMonedaDestino(), exchangeRate.getExchangeRate());
        exchangeResponse.setMonedaOrigen(exchangeRate.getCurrencyFrom());
        exchangeResponse.setMonedaDestino(exchangeRate.getCurrencyTo());
        return ResponseEntity.ok(exchangeResponse);
    }

}
