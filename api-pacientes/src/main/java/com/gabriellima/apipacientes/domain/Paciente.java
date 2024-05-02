package com.gabriellima.apipacientes.domain;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PACIENTE")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;

    private String sobrenome;

    private char sexo;

    private LocalDate nascimento;

    private byte idade;

    private short altura;

    private double peso;

    private String cpf;

    private double imc;

    public Paciente(PacienteDTO data){
        this.nome = data.nome();
        this.sobrenome = data.sobrenome();
        this.sexo = data.sexo();
        this.nascimento = data.nascimento();
        this.altura = data.altura();
        this.peso = data.peso();
        this.cpf = data.cpf();
        this.imc = calcularIMC();
        this.idade = calcularIdade();
    }

    public double obterPesoIdeal(){
        if(this.sexo == 'M'){
            return (72.7 * this.altura) - 58;
        } else {
            return (62.1 * this.altura) - 44.7;
        }
    }

    public String obterCpfOfuscado(){
        String cpf = this.cpf;

        String digitos = cpf.substring(3,6);

        return "***." + digitos + ".***-**";
    }

    public String obterSituacaoIMC(){
        if(this.imc < 17){
            return "Muito abaixo do peso";
        }
        if(this.imc >= 17 && this.imc <= 18.49){
            return "Abaixo do peso";
        }
        if(this.imc >= 18.50 && this.imc <= 24.99){
            return "Peso normal";
        }
        if(this.imc >= 25 && this.imc <= 29.99){
            return "Acima do peso";
        }
        if(this.imc >= 30 && this.imc <= 34.99){
            return "Obesidade I";
        }
        if(this.imc >= 35 && this.imc <= 39.99){
            return "Obesidade II (severa)";
        }

        return "Obesidade III (mórbida)";
    }

    public double calcularIMC(){
        return this.peso / (this.altura * this.altura);
    }

    public byte calcularIdade(){
        LocalDate dataAtual = LocalDate.now();

        Period periodo = Period.between(this.nascimento, dataAtual);

        return (byte) periodo.getYears();
    }

    public boolean validarCPF(){
        return true;
    }
}
