package com.co.choucair.stepdefinitions;

import com.tcs.certificacion.sapgui.interactions.OpenConnection;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class TestStepDefinitions {

    private static final String MIKE = "Mike";

    @Given("Mike is ready to open the connection")
    public void mikeIsReadyToOpenTheConnection() {
        OnStage.theActorCalled(MIKE).wasAbleTo(OpenConnection.withServer("srvsapconexion.dyndns-server.com").andPort(3200));
    }
    @When("attemps to connect to SAPLogon")
    public void attempsToConnectToSAPLogon() {

    }
    @Then("will success the connection")
    public void willSuccessTheConnection() {

    }

}
