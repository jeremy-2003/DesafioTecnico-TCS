package com.tcs.exchange.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ExchangeRequest {
    private double monto;
    private String monedaOrigen;
    private String monedaDestino;
}
