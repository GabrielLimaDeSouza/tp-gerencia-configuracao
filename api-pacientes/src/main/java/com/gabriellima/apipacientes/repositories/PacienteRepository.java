package com.gabriellima.apipacientes.repositories;

import com.gabriellima.apipacientes.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String> {

}
