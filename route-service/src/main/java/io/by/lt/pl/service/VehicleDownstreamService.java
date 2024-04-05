package io.by.lt.pl.service;

import io.by.lt.pl.service.dto.Vehicle;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

// FIXME - doesn't work.
public interface VehicleDownstreamService {

    @GetExchange("/vehicle")
    List<Vehicle> findAll();

    @GetExchange("/vehicle/{id}")
    Vehicle findById(@PathVariable Long id);
}
