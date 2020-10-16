package com.desafio.conexa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.desafio.conexa.dto.PacienteDTO;
import com.desafio.conexa.entity.Paciente;
import com.desafio.conexa.exception.NotFoundErrorException;
import com.desafio.conexa.repository.PacienteRepository;
import com.desafio.conexa.service.PacienteService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class PacienteTest {

	@Autowired
	private PacienteService pacienteService;

	@Autowired
	private PacienteRepository pacienteRepository;
	
	

	@Test
	void testFindAll() {
		List<PacienteDTO> listapacientesService = pacienteService.findAll();
		List<Paciente> listaPacientesDatabase = new ArrayList<>();
		pacienteRepository.findAll().iterator().forEachRemaining(listaPacientesDatabase::add);

		PacienteDTO pacienteDTO = listapacientesService.stream()
				.filter(paciente -> paciente.getNome().equals("Carla Elaine Sônia Ramos")).findFirst().get();

		Paciente paciente = listaPacientesDatabase.stream()
				.filter(pacienteData -> pacienteData.getNome().equals("Carla Elaine Sônia Ramos")).findFirst().get();

		assertNotNull(Objects.nonNull(listapacientesService));
		assertEquals(pacienteDTO.getNome(), paciente.getNome());
		assertEquals(pacienteDTO.getCpf(), paciente.getCpf());
		assertEquals(pacienteDTO.getTelefone(), paciente.getTelefone());
		assertEquals(pacienteDTO.getIdade(), paciente.getIdade());
		assertEquals(listapacientesService.size(), listaPacientesDatabase.size());
	}

	@Test
	void testAdd() {
		PacienteDTO paciente = new PacienteDTO();
		paciente.setNome("Emanuelly Débora Mariane Melo");
		paciente.setCpf("423.189.215-63");
		paciente.setIdade(25);
		paciente.setTelefone("+55 (98) 98245-7614");
		
		pacienteService.add(paciente);

		Paciente pacienteData = ((Collection<Paciente>) pacienteRepository.findAll()).stream()
		    .filter(nutri -> nutri.getNome().equals("Emanuelly Débora Mariane Melo")).findFirst().get();
		
		assertEquals("Emanuelly Débora Mariane Melo", pacienteData.getNome());
		assertEquals("423.189.215-63", pacienteData.getCpf());
		assertEquals("25", String.valueOf(pacienteData.getIdade()));
		assertEquals("+55 (98) 98245-7614", pacienteData.getTelefone());
	}

	@Test
	void testFindById() throws NumberFormatException, NotFoundErrorException {
		Paciente paciente = pacienteService.findById("1");

		assertEquals("1", String.valueOf(paciente.getIdPaciente()));
		assertEquals("Carla Elaine Sônia Ramos", paciente.getNome());
		assertEquals("408.895.034-86", paciente.getCpf());
	}

}
