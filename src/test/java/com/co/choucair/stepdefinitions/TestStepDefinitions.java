package com.co.choucair.stepdefinitions;

import com.co.choucair.sap.models.UserLoombokData;
import com.co.choucair.sap.tasks.CloseSAP;
import com.co.choucair.sap.tasks.LoginOn;
import com.co.choucair.sap.tasks.OpenSAP;
import com.tcs.certificacion.sapgui.interactions.Control;
import com.tcs.certificacion.sapgui.interactions.OpenConnection;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.choucair.sap.userintefaces.GlobalData.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TestStepDefinitions {


    @Given("Mike is ready to open the connection")
    public void mikeIsReadyToOpenTheConnection(DataTable data) {
        theActorInTheSpotlight().wasAbleTo(
                OpenSAP.on(UserLoombokData.setData(data).get(0))
        );
    }

    @When("attemps to connect to SAPLogon with")
    public void attempsToConnectToSAPLogonWith(DataTable data) {
       /* theActorInTheSpotlight().attemptsTo(
                LoginOn.sap(UserLoombokData.setData(data).get(0))
        );*/
    }

    @Then("will success the connection")
    public void willSuccessTheConnection() {
        theActorInTheSpotlight().attemptsTo(
                CloseSAP.on()
        );
    }

}
