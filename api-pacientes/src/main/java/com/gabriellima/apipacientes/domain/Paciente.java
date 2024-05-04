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
        double altura = this.altura / 100.0;
        if(this.sexo == 'M'){
            return (72.7 * altura) - 58.0;
        } else {
            return (62.1 * altura) - 44.7;
        }
    }

    public String obterCpfOfuscado(){
        String cpf = this.cpf;

        String digitos = cpf.substring(4,7);

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
        double alturaEmMetros = this.altura / 100.0;
        double imc = this.peso / (alturaEmMetros * alturaEmMetros);
        
        // Arredonda para duas casas decimais
        imc = Math.round(imc * 100.0) / 100.0;
        
        return imc;
    }

    public byte calcularIdade(){
        LocalDate dataAtual = LocalDate.now();

        Period periodo = Period.between(this.nascimento, dataAtual);

        return (byte) periodo.getYears();
    }

    public boolean validarCPF(){
        String cpf = this.cpf;

        cpf = cpf.replaceAll("[.-]", "");

        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")) {
            return false;
        }
    
        int[] cpfDigits = new int[11];
        for (int i = 0; i < 11; i++) {
            cpfDigits[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
        }
    
        int v1 = 0;
        int v2 = 0;
        for (int i = 0; i < 9; i++) {
            v1 += cpfDigits[i] * (10 - i);
            v2 += cpfDigits[i] * (11 - i);
        }
    
        v1 = (v1 % 11) < 2 ? 0 : 11 - (v1 % 11);
        v2 += v1 * 2;
        v2 = (v2 % 11) < 2 ? 0 : 11 - (v2 % 11);
    
        return cpfDigits[9] == v1 && cpfDigits[10] == v2;
    }
}
