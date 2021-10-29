package es.seg_social.ps.ocp_poc.e2e.command.presentation.controllers;

import es.seg_social.ps.ocp_poc.e2e.command.CommandTestConfiguration;
import es.seg_social.ps.ocp_poc.e2e.command.integration.model.Afiliado;
import es.seg_social.ps.ocp_poc.e2e.command.integration.repositories.AfiliadoRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@Import( CommandTestConfiguration.class)
class CommandControllerApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private AfiliadoRepository afiliadoRepository;

	@Test
	public void nuevoAfiliado() throws Exception {
		when(afiliadoRepository.save(any())).thenReturn(new Afiliado(1,"Jose","Lopez","Lopez","00000000Z","Calle Mayor S/N","654567387","a@mail.es",1,"Álava"));
		mockMvc.perform(post("/afiliados").contentType(MediaType.APPLICATION_JSON).content("{\"codAfiliado\":1,\"nombre\":\"Jose\",\"apellido1\":\"Garc\\u00eda\",\"apellido2\":\"Lopsez\",\"dni\":\"00000000Y\",\"direccion\":\"Calle Mayor\",\"telefono\":\"987654321\",\"email\":\"mail@dominio.es\",\"idProvincia\":12}"))
				.andExpect(jsonPath("$.provincia", Matchers.equalTo("Álava")));
	}

	@Test
	public void actualizarAfiliado() throws Exception {
		when(afiliadoRepository.save(any())).thenReturn(new Afiliado(1,"Jose","Lopez","Lopez","00000000Z","Calle Mayor S/N","654567387","a@mail.es",1,"Álava"));
		mockMvc.perform(put("/afiliados/1").contentType(MediaType.APPLICATION_JSON).content("{\"codAfiliado\":1,\"nombre\":\"Jose\",\"apellido1\":\"Garc\\u00eda\",\"apellido2\":\"Lopsez\",\"dni\":\"00000000Y\",\"direccion\":\"Calle Mayor\",\"telefono\":\"987654321\",\"email\":\"mail@dominio.es\",\"idProvincia\":12}"))
				.andExpect(jsonPath("$.provincia", Matchers.equalTo("Álava")));
	}

	@Test
	public void eliminarAfiliado() throws Exception {
		doNothing().when(afiliadoRepository).deleteById(any());
		mockMvc.perform(delete("/afiliados/1")).andExpect(status().isOk());
	}

}
