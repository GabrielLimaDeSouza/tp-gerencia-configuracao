package com.gabriellima.apipacientes.configurations;

import io.cucumber.spring.CucumberContextConfiguration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = SpringBootApplication.class)
public class CucumberSpringConfiguration {
}