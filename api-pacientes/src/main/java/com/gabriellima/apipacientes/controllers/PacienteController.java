package com.gabriellima.apipacientes.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriellima.apipacientes.domain.Paciente;
import com.gabriellima.apipacientes.domain.PacienteDTO;
import com.gabriellima.apipacientes.services.PacienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/paciente")
public class PacienteController {
    private final PacienteService service;

    @PostMapping
    public ResponseEntity<Paciente> create(@RequestBody PacienteDTO pacienteData){
        Paciente paciente = this.service.create(pacienteData);

        return ResponseEntity.ok().body(paciente);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getAll(){
        List<Paciente> pacientes = this.service.getAll();

        return ResponseEntity.ok().body(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getById(@PathVariable("id") String id){
        Paciente paciente = this.service.getById(id);

        return ResponseEntity.ok().body(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update(@PathVariable("id") String id, @RequestBody PacienteDTO pacienteData){
        Paciente updatedPaciente = this.service.update(id, pacienteData);

        return ResponseEntity.ok().body(updatedPaciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Paciente> delete(@PathVariable("id") String id){
        this.service.delete(id);

        return ResponseEntity.noContent().build();
    }
}

