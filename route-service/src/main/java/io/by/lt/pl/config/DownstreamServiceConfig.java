package io.by.lt.pl.config;

import io.by.lt.pl.service.VehicleDownstreamService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class DownstreamServiceConfig {

    @Bean
    public VehicleDownstreamService vehicleService() {
        RestClient restClient = RestClient.builder().baseUrl("http:\\localhost:8091").build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        VehicleDownstreamService service = factory.createClient(VehicleDownstreamService.class);
        return service;
    }
}
