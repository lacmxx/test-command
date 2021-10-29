package es.seg_social.ps.ocp_poc.e2e.command.presentation.controllers;

import es.seg_social.ps.ocp_poc.e2e.command.integration.model.Afiliado;
import es.seg_social.ps.ocp_poc.e2e.command.integration.repositories.AfiliadoRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Tag(name = "afiliado", description = "API afiliados (funciones command del patron CQRS)")
@RestController
public class CommandController {

    private static final Logger logger = LoggerFactory.getLogger(CommandController.class);

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    private final Counter createCounter;
    private final Counter updateCounter;
    private final Counter deleteCounter;

    public CommandController(MeterRegistry meterRegistry) {
        createCounter = meterRegistry.counter("gint-ps-poc.command.counter.create", "mytagname", "mytagvalue");
        updateCounter = meterRegistry.counter("gint-ps-poc.command.counter.update", "mytagname", "mytagvalue");
        deleteCounter = meterRegistry.counter("gint-ps-poc.command.counter.delete", "mytagname", "mytagvalue");
    }

    @Operation(summary = "Alta afiliado", description = "Alta de afiliado con los datos proporcionados", tags = {"afiliado"})
    @PostMapping("/afiliados")
    public Afiliado nuevoAfiliado(@RequestBody Afiliado nuevoAfiliado) {
        logger.info("Entering to nuevoAfiliado");
        Afiliado nuevoAfi = new Afiliado(nuevoAfiliado.getCodAfiliado(),
                nuevoAfiliado.getNombre(),
                nuevoAfiliado.getApellido1(),
                nuevoAfiliado.getApellido2(),
                nuevoAfiliado.getDni(),
                nuevoAfiliado.getDireccion(),
                nuevoAfiliado.getTelefono(),
                nuevoAfiliado.getEmail(),
                nuevoAfiliado.getIdProvincia(),
                nuevoAfiliado.getProvincia());
        logger.info("Incrememting create counter");
        createCounter.increment();
        Afiliado afiliado = afiliadoRepository.save(nuevoAfi);
        logger.info("Response from nuevoAfiliado");
        return afiliado;
    }

    @Operation(summary = "Actualización datos afiliado por código de afiliado", description = "Actualización de afiliado con los datos proporcionados", tags = {"afiliado"})
    @PutMapping("/afiliados/{codAfiliado}")
    public Afiliado actualizarAfiliado(@PathVariable Integer codAfiliado, @RequestBody Afiliado nuevosDatosAfiliado) {
        logger.info("Entering to actualizarAfiliado");
        Afiliado afiliadoActualizado = new Afiliado(codAfiliado,
                nuevosDatosAfiliado.getNombre(),
                nuevosDatosAfiliado.getApellido1(),
                nuevosDatosAfiliado.getApellido2(),
                nuevosDatosAfiliado.getDni(),
                nuevosDatosAfiliado.getDireccion(),
                nuevosDatosAfiliado.getTelefono(),
                nuevosDatosAfiliado.getEmail(),
                nuevosDatosAfiliado.getIdProvincia(),
                nuevosDatosAfiliado.getProvincia());
        logger.info("Incrememting update counter");
        updateCounter.increment();
        Afiliado afiliado = afiliadoRepository.save(afiliadoActualizado);
        logger.info("Response from actualizarAfiliado");
        return afiliado;
    }


    @Operation(summary = "Baja afiliado", description = "Baja de afiliado por código de afiliación", tags = {"afiliado"})
    @DeleteMapping("/afiliados/{codAfiliado}")
    public void eliminarAfiliado(@PathVariable Integer codAfiliado) {
        logger.info("Entering to eliminarAfiliado");
        afiliadoRepository.deleteById(codAfiliado);
        logger.info("Incrememting delete counter");
        deleteCounter.increment();
        logger.info("Response from eliminarAfiliado");
        return;
    }
}


