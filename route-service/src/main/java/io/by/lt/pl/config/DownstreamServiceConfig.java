package io.by.lt.pl.config;

import io.by.lt.pl.service.VehicleDownstreamService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class DownstreamServiceConfig {

    @Bean
    public VehicleDownstreamService vehicleService(@Value("${downstream.service.vehicle-url}") String vehicleUrl) {
        var restClient = RestClient.builder().baseUrl(vehicleUrl).build();
        var adapter = RestClientAdapter.create(restClient);
        var factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(VehicleDownstreamService.class);
    }
}
