package com.gabriellima.apipacientes.steps;

import com.gabriellima.apipacientes.domain.Paciente;
import com.gabriellima.apipacientes.domain.PacienteDTO;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class PacienteSteps {

    private Paciente paciente;
    private double imc;
    private String situacaoIMC;
    private byte idade;
    private boolean cpfValido;
    private String cpfOfuscado;

    @Given("um paciente com nome {string} e peso {double} kg e altura {int} cm")
    public void umPacienteComNomeEPesoEAltura(String nome, double peso, int altura) {
        PacienteDTO pacienteDTO = new PacienteDTO(nome, "Lima", 'M', LocalDate.now().minusYears(30), (short) altura, peso, "123.456.789-00");
        paciente = new Paciente(pacienteDTO);
    }

    @Given("um paciente com nome {string} nascido em {string}")
    public void umPacienteComNomeNascidoEm(String nome, String nascimento) {
        paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setNascimento(LocalDate.parse(nascimento));
    }

    @Given("um paciente com CPF {string}")
    public void umPacienteComCPF(String cpf) {
        paciente = new Paciente();
        paciente.setCpf(cpf);
    }

    @When("eu calcular o IMC")
    public void euCalcularOIMC() {
        imc = paciente.calcularIMC();
    }

    @When("eu calcular a situação do IMC")
    public void euCalcularASituacaoDoIMC() {
        situacaoIMC = paciente.obterSituacaoIMC();
    }

    @When("eu calcular a idade")
    public void euCalcularAIdade() {
        idade = paciente.calcularIdade();
    }

    @When("eu validar o CPF")
    public void euValidarOCPF() {
        cpfValido = paciente.validarCPF();
    }

    @When("eu obter o CPF ofuscado")
    public void euObterOCPFOfuscado() {
        cpfOfuscado = paciente.obterCpfOfuscado();
    }

    @Then("o IMC deve ser {double}")
    public void oIMCDeveSer(double esperado) {
        Assertions.assertEquals(esperado, imc);
    }

    @Then("a situação do IMC deve ser {string}")
    public void aSituacaoDoIMCDeveSer(String esperado) {
        Assertions.assertEquals(esperado, situacaoIMC);
    }

    @Then("a idade deve ser {int}")
    public void aIdadeDeveSer(int esperado) {
        Assertions.assertEquals(esperado, idade);
    }

    @Then("o CPF deve ser {string}")
    public void oCPFDeveSer(String validoOuInvalido) {
        boolean esperado = "válido".equals(validoOuInvalido);
        Assertions.assertEquals(esperado, cpfValido);
    }

    @Then("o CPF ofuscado deve ser {string}")
    public void oCPFOfuscadoDeveSer(String esperado) {
        Assertions.assertEquals(esperado, cpfOfuscado);
    }

    @Then("o CPF deve ser válido")
    public void oCPFDeveSerValido() {
        Assertions.assertTrue(cpfValido);
    }
}
