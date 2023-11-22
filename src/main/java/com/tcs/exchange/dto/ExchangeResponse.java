package com.tcs.exchange.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ExchangeResponse {
    private double monto;
    private double montoConTipoDeCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private double tipoDeCambio;
}
