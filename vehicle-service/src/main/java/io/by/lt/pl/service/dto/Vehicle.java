package io.by.lt.pl.service.dto;

import java.time.Year;

public record Vehicle(
        Long id,
        String brand,
        String model,
        Year year
) {
}
