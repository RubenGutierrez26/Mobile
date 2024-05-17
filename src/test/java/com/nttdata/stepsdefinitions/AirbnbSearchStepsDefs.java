package com.nttdata.stepsdefinitions;

import com.nttdata.steps.AirbnbSearchSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AirbnbSearchStepsDefs {

    @Steps
    AirbnbSearchSteps airbnbSearchSteps;

    @Given("que ingreso al sitio web de Airbnb y cierro cualquier ventana emergente")
    public void que_ingreso_al_sitio_web_de_Airbnb_y_cierro_cualquier_ventana_emergente() {
        airbnbSearchSteps.clickClose();
    }

    @When("ingreso {string} en el campo Where to?")
    public void ingresoEnElCampoWhereTo(String place) {
        airbnbSearchSteps.searchByText(place);
    }

    @And("seleccione SKIP en el campo When's your trip?")
    public void seleccioneSKIPEnElCampoWhenSYourTrip() {
        airbnbSearchSteps.clickSkip();
    }

    @And("haga click en Search")
    public void hagaClickEnSearch() {
        airbnbSearchSteps.clickSearch();
    }

    @Then("deberia haber resultados mayores a {int}")
    public void deberiaHaberResultadosMayoresA(int numberPlaces) {
        Pattern patron = Pattern.compile("\\d+");
        Matcher matcher = patron.matcher(airbnbSearchSteps.getResultText());
        String numeroEncontrado = "";
        while (matcher.find()) {
            numeroEncontrado += matcher.group();
        }
        System.out.println("Número encontrado: " + numeroEncontrado);
        if(numeroEncontrado.isEmpty()) { numeroEncontrado = "0";}

        Assert.assertTrue(Integer.parseInt(numeroEncontrado)>numberPlaces);
    }

    @And("debería ver el mensaje {string}")
    public void deberíaVerElMensaje(String text) {
        Assert.assertEquals(airbnbSearchSteps.getResultText(), text);
    }
}
