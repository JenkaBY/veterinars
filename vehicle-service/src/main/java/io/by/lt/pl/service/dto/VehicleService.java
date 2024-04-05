package io.by.lt.pl.service.dto;

import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    private static final List<Vehicle> ALL = List.of(
            new Vehicle(1L, "BMW", "x3", Year.parse("2012")),
            new Vehicle(2L, "Ford", "S-Max", Year.parse("2024"))
    );
    private Map<Long, Vehicle> vehicleContext = ALL.stream()
            .collect(Collectors.toMap(Vehicle::id,Function.identity()));


    public Vehicle getById(Long id) {
        return Optional.ofNullable(vehicleContext.get(id)).orElseThrow(() -> new RuntimeException("NOT found vehicle by id " + id + "."));
    }

    public List<Vehicle> getAll() {
        return ALL;
    }
}
