package com.gabriellima.apipacientes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gabriellima.apipacientes.domain.Paciente;
import com.gabriellima.apipacientes.domain.PacienteDTO;
import com.gabriellima.apipacientes.repositories.PacienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteService {
    public final PacienteRepository repository;

    public Paciente create(PacienteDTO pacienteData){
        Paciente paciente = new Paciente(pacienteData);

        this.repository.save(paciente);

        return paciente;
    }

    public Paciente update(String id, PacienteDTO pacienteData){
        Paciente paciente = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado!"));

        if(pacienteData.altura() != 0) paciente.setAltura(pacienteData.altura());
        if(!pacienteData.cpf().isEmpty()) paciente.setCpf(pacienteData.cpf());
        if(!pacienteData.nome().isEmpty()) paciente.setNome(pacienteData.nome());
        if(pacienteData.peso() != 0) paciente.setPeso(pacienteData.peso());
        if(pacienteData.sexo() != '\0') paciente.setSexo(pacienteData.sexo());
        if(!pacienteData.sobrenome().isEmpty()) paciente.setSobrenome(pacienteData.sobrenome());
        if(pacienteData.nascimento() != null) paciente.setNascimento(pacienteData.nascimento());

        this.repository.save(paciente);

        return paciente;
    }

    public void delete(String id){
        Paciente paciente = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado!"));

        this.repository.delete(paciente);
    }

    public List<Paciente> getAll(){
        return this.repository.findAll();
    }
}
