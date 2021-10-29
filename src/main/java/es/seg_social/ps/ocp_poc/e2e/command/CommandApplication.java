package es.seg_social.ps.ocp_poc.e2e.command;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandApplication.class, args);
    }


    /**
     * Bean usado para configurar las tags por defecto para todas las metricas de la aplicacion
     *
     * @return
     */
    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> registry.config().commonTags("environment", "int", "cd", "p&s", "gissmonitoring", "yes", "application", "gint-ps-poc-command");
    }
}

