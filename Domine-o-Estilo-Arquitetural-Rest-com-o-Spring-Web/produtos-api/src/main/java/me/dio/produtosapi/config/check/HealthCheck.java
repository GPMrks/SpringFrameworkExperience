package me.dio.produtosapi.config.check;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
public class HealthCheck implements HealthIndicator {
    @Override
    public Health health() {
        try {
            InetAddress address = InetAddress.getByName("localhost");
            if (address.isReachable(10000)){
                return Health.up().build();
            }
            } catch (Exception e) {
            return Health.down().withDetail("Motivo", e.getMessage()).build();
        }
        return Health.down().withDetail("Motivo", "Motivo desconhecido").build();
    }
}
