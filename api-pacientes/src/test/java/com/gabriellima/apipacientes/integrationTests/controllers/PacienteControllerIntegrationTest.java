package com.gabriellima.apipacientes.integrationTests.controllers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gabriellima.apipacientes.domain.Paciente;
import com.gabriellima.apipacientes.domain.PacienteDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PacienteControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private PacienteDTO pacienteDTO;

    @BeforeEach
    public void setup(){
        pacienteDTO = new PacienteDTO("José", "Sobrenome", 'M', LocalDate.now(), (short) 170, 70.5, "123.456.789-00");
    }

    @Test
    public void testCreatePaciente() {

        ResponseEntity<Paciente> response = testRestTemplate.postForEntity("/api/v1/paciente", pacienteDTO, Paciente.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetAllPacientes() {
        ResponseEntity<List<Paciente>> response = testRestTemplate.exchange(
                "/api/v1/paciente",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Paciente>>() {});

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testUpdatePaciente() {
        ResponseEntity<Paciente> responseCreate = testRestTemplate.postForEntity("/api/v1/paciente", pacienteDTO, Paciente.class);
        assertEquals(HttpStatus.OK, responseCreate.getStatusCode());
    
        Paciente paciente = responseCreate.getBody();
    
        paciente.setNome("Novo Nome");
    
        ResponseEntity<Paciente> responseUpdate = testRestTemplate.exchange(
                "/api/v1/paciente/{id}", 
                HttpMethod.PUT, 
                new HttpEntity<>(paciente), 
                Paciente.class, 
                paciente.getId());
    
        assertEquals(HttpStatus.OK, responseUpdate.getStatusCode());
        assertNotNull(responseUpdate.getBody());
        assertEquals("Novo Nome", responseUpdate.getBody().getNome());
    }
}
