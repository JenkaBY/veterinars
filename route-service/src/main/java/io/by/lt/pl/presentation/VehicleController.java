package io.by.lt.pl.presentation;

import io.by.lt.pl.service.VehicleDownstreamService;
import io.by.lt.pl.service.dto.Vehicle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/external/vehicle")
public class VehicleController {

    private final VehicleDownstreamService downstreamService;

    public VehicleController(VehicleDownstreamService downstreamService) {
        this.downstreamService = downstreamService;
    }

    @GetMapping
    public List<Vehicle> findAll() {
        return downstreamService.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle find(Long id) {
        return downstreamService.findById(id);
    }
}
