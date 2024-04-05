package io.by.lt.pl.controller;

import io.by.lt.pl.service.dto.Vehicle;
import io.by.lt.pl.service.dto.VehicleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> getAll() {
        return vehicleService.getAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Vehicle get(Long id) {
        return vehicleService.getById(id);
    }
}
