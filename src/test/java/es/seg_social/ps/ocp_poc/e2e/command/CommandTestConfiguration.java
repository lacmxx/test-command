package es.seg_social.ps.ocp_poc.e2e.command;

import es.seg_social.ps.ocp_poc.e2e.command.integration.repositories.AfiliadoRepository;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.noop.NoopCounter;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@TestConfiguration
public class CommandTestConfiguration {

    @Bean
    public DataSource dataSource() {
        return Mockito.mock(DataSource.class);
    }

    @Bean
    public MeterRegistry meterRegistry() {
        MeterRegistry registry = Mockito.mock(MeterRegistry.class);
        when(registry.counter(anyString(), anyString(), anyString())).thenReturn(new NoopCounter(new Meter.Id("",null,null,null,Meter.Type.COUNTER)));
        return registry;
    }


    @Bean
    @Primary
    public AfiliadoRepository afiliadoRepository() {
        return Mockito.mock(AfiliadoRepository.class);
    }
}
