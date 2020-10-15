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
			
			Paciente pacienteUm = new Paciente();
			pacienteUm.setCpf("408.895.034-86");
			pacienteUm.setIdade(55);
			pacienteUm.setNome("Carla Elaine Sônia Ramos");
			pacienteUm.setTelefone("+55 (96) 99558-8378");
			pacienteRepository.save(pacienteUm);
			
			Paciente pacienteDois = new Paciente();
			pacienteDois.setCpf("587.999.624-70");
			pacienteDois.setIdade(28);
			pacienteDois.setNome("Mariana Luciana Benedita da Costa");
			pacienteDois.setTelefone("+55 (89) 98724-5942");
			pacienteRepository.save(pacienteDois);
			
			Usuario usuario = new Usuario();
			usuario.setUsuario("medico@email.com");
			usuario.setSenha(encoder.encode("senhamedico"));
			
			Medico medico = new Medico();
			medico.setNome("Davi Maçana");
			medico.setEspecialidade("Cirurgia Geral");
			
			List<Agendamento> agendamentos = new ArrayList<>();
			Agendamento agendamento = new Agendamento();
			agendamento.setDataHora(Calendar.getInstance());
			agendamento.setMedico(medico);
			agendamento.setPaciente(pacienteDois);
			agendamentos.add(agendamento);
			
			medico.setAgendamentos(agendamentos);
			usuario.setMedico(medico);
			usuarioRepository.save(usuario);
			
		};
	}
}
