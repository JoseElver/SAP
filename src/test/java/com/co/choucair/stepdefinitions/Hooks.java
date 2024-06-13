package com.co.choucair.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.co.choucair.sap.userintefaces.GlobalData.MIKE;
import static net.serenitybdd.core.Serenity.getDriver;

public class Hooks {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(OnlineCast.ofStandardActors());
        OnStage.theActorCalled(MIKE);
    }

    @After
    public void tearDown(){
        getDriver().quit();
    }
}
