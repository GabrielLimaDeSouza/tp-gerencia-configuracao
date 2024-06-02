Feature: Paciente Management

  Scenario: Calcular IMC para um paciente
    Given um paciente com nome "Gabriel" e peso 70.5 kg e altura 170 cm
    When eu calcular o IMC
    Then o IMC deve ser 24.39

  Scenario: Obter situação do IMC
    Given um paciente com nome "Gabriel" e peso 70.5 kg e altura 170 cm
    When eu calcular a situação do IMC
    Then a situação do IMC deve ser "Peso normal"

  Scenario: Calcular idade do paciente
    Given um paciente com nome "Gabriel" nascido em "1990-01-01"
    When eu calcular a idade
    Then a idade deve ser 34

  Scenario: Validar CPF do paciente
    Given um paciente com CPF "292.512.871-80"
    When eu validar o CPF
    Then o CPF deve ser válido

  Scenario: Obter CPF ofuscado
    Given um paciente com CPF "123.456.789-09"
    When eu obter o CPF ofuscado
    Then o CPF ofuscado deve ser "***.456.***-**"