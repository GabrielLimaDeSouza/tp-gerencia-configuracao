package com.gabriellima.apipacientes.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue={"com.gabriellima.apipacientes.steps", "com.gabriellima.apipacientes.configurations"}, monochrome = true)
public class CucumberRunner {
}