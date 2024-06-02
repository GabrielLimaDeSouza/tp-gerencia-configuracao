package com.gabriellima.apipacientes.unitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gabriellima.apipacientes.domain.Paciente;
import com.gabriellima.apipacientes.domain.PacienteDTO;

public class PacienteTest {

    private Paciente paciente;

    @BeforeEach
    void setup(){
        PacienteDTO pacienteDTO = new PacienteDTO("José", "Sobrenome", 'M', LocalDate.now(), (short) 170, 70.5, "123.456.789-00");
        paciente = new Paciente(pacienteDTO);
    }
    
    @Test
    public void testShouldGetImc(){
        assertEquals(paciente.getImc(), 24.39);
    }

    @Test
    public void testShouldGetPesoIdeal(){
        assertEquals(paciente.obterPesoIdeal(), 65.59);
    }

    @Test
    public void testShouldGetCpfOfuscado(){
        assertEquals(paciente.obterCpfOfuscado(), "***.456.***-**");
    }

    @Test
    public void testShouldGetSituacaoIMC(){
        assertEquals(paciente.obterSituacaoIMC(), "Peso normal");

        paciente.setImc(33.04);

        assertEquals(paciente.obterSituacaoIMC(), "Obesidade I");

        paciente.setImc(39.99);
        assertEquals(paciente.obterSituacaoIMC(), "Obesidade II (severa)");
    }

    @Test
    public void testShouldCalcularIMC(){
        assertEquals(paciente.getImc(), 24.39);
    }

    @Test
    public void testShouldCalcularIdade(){
        LocalDate data = LocalDate.of(2002, 11, 6);

        paciente.setNascimento(data);

        assertEquals(paciente.calcularIdade(), 21);
    }

    @Test
    public void testShouldValidarCpf(){
        assertEquals(paciente.validarCPF(), false);

        paciente.setCpf("292.512.871-80");
        assertEquals(paciente.validarCPF(), true);
    }

}
