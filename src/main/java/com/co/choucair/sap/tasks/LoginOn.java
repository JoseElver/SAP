package com.co.choucair.sap.tasks;

import com.co.choucair.sap.models.UserLoombokData;
import com.tcs.certificacion.sapgui.interactions.Click;
import com.tcs.certificacion.sapgui.interactions.Enter;
import com.tcs.certificacion.sapgui.interactions.WaitUntil;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static com.co.choucair.sap.userintefaces.SAPGUI.*;

public class LoginOn implements Task {

    protected UserLoombokData data;

    public LoginOn(UserLoombokData data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.element(TXT_USER).isVisible().maxTimeSeconds(10),
                Click.on(TXT_USER),
                Enter.theValue(data.getUser()).into(TXT_USER),
                Click.on(TXT_PASS),
                Enter.theValue(data.getUser()).into(TXT_PASS)
        );
    }

    public static LoginOn sap(UserLoombokData data){
        return Instrumented.instanceOf(LoginOn.class).withProperties(data);
    }
}
