package com.gabriellima.apipacientes.integrationTests.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.gabriellima.apipacientes.domain.Paciente;
import com.gabriellima.apipacientes.domain.PacienteDTO;
import com.gabriellima.apipacientes.repositories.PacienteRepository;
import com.gabriellima.apipacientes.services.PacienteService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase
public class PacienteServiceIntegrationTest {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Test
    public void testCreatePaciente() {
        PacienteDTO pacienteDTO = new PacienteDTO("José", "Sobrenome", 'M', LocalDate.now(), (short) 170, 70.5, "123.456.789-00");
        Paciente paciente = pacienteService.create(pacienteDTO);
        
        assertNotNull(paciente.getId());
        assertEquals("José", paciente.getNome());

        Paciente pacienteSalvo = pacienteRepository.findById(paciente.getId()).orElse(null);
        assertNotNull(pacienteSalvo);
        assertEquals("José", pacienteSalvo.getNome());
    }

    @Test
    public void testUpdatePaciente() {
        // Criar um paciente inicialmente
        PacienteDTO pacienteDTO = new PacienteDTO("José", "Sobrenome", 'M', LocalDate.now(), (short) 170, 70.5, "123.456.789-00");
        Paciente pacienteCriado = pacienteService.create(pacienteDTO);
        
        PacienteDTO pacienteDTOUpdated = new PacienteDTO("Novo Nome", "Sobrenome", 'M', LocalDate.now(), (short) 170, 70.5, "123.456.789-00");

        Paciente pacienteAtualizado = pacienteService.update(pacienteCriado.getId(), pacienteDTOUpdated);

        assertNotNull(pacienteAtualizado);
        assertEquals("Novo Nome", pacienteAtualizado.getNome());

        Paciente pacienteAtualizadoNoBanco = pacienteRepository.findById(pacienteCriado.getId()).orElse(null);
        assertNotNull(pacienteAtualizadoNoBanco);
        assertEquals("Novo Nome", pacienteAtualizadoNoBanco.getNome());
    }

    @Test
    public void testGetPacienteById() {
        PacienteDTO pacienteDTO = new PacienteDTO("José", "Sobrenome", 'M', LocalDate.now(), (short) 170, 70.5, "123.456.789-00");
        Paciente pacienteCriado = pacienteService.create(pacienteDTO);
        
        Optional<Paciente> optionalPacienteEncontrado = pacienteRepository.findById(pacienteCriado.getId());
        assertTrue(optionalPacienteEncontrado.isPresent());
        
        Paciente pacienteEncontrado = optionalPacienteEncontrado.get();
        
        assertNotNull(pacienteEncontrado);
        assertEquals(pacienteCriado.getId(), pacienteEncontrado.getId());
        assertEquals(pacienteCriado.getNome(), pacienteEncontrado.getNome());
    }
}