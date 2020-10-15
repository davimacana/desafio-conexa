package com.desafio.conexa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.desafio.conexa.entity.Agendamento;
import com.desafio.conexa.entity.Medico;
import com.desafio.conexa.entity.Paciente;
import com.desafio.conexa.entity.Usuario;
import com.desafio.conexa.repository.AgendamentoRepository;
import com.desafio.conexa.repository.PacienteRepository;
import com.desafio.conexa.repository.UsuarioRepository;

@SpringBootApplication
public class DesafioConexaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioConexaApplication.class, args);
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.addBasenames("messages");
	    return messageSource;
	}
	
	@Bean
	public CommandLineRunner demo(PacienteRepository pacienteRepository, 
			UsuarioRepository usuarioRepository, PasswordEncoder encoder, AgendamentoRepository agendamentoRepository) {
		return (args) -> {
			
			Paciente paciente = new Paciente();
			paciente.setCpf("142.939.697-05");
			paciente.setIdade(25);
			paciente.setNome("Martha Maçana");
			paciente.setTelefone("+55 (21) 98655-0659");
			pacienteRepository.save(paciente);
			
			Usuario usuario = new Usuario();
			usuario.setUsuario("Davi");
			usuario.setSenha(encoder.encode("123"));
			
			Medico medico = new Medico();
			medico.setNome("Davi Maçana");
			medico.setEspecialidade("Psiquiatria");
			
			List<Agendamento> agendamentos = new ArrayList<>();
			Agendamento agendamento = new Agendamento();
			agendamento.setDataHora(Calendar.getInstance());
			agendamento.setMedico(medico);
			agendamento.setPaciente(paciente);
			agendamentos.add(agendamento);
			
			medico.setAgendamentos(agendamentos);
			usuario.setMedico(medico);
			usuarioRepository.save(usuario);
			
		};
	}
}
