package com.co.choucair.sap.tasks;

import com.co.choucair.sap.models.UserLoombokData;
import com.tcs.certificacion.sapgui.interactions.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static com.co.choucair.sap.userintefaces.SAPGUI.TXT_PASS;
import static com.co.choucair.sap.userintefaces.SAPGUI.TXT_USER;

public class OpenSAP implements Task {

    protected UserLoombokData data;

    public OpenSAP(UserLoombokData data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OpenConnection.withServer(data.getServer()).andPort(3200));
        actor.attemptsTo(
                TimeDead.inlong(5000));
        actor.attemptsTo(
                WaitUntil.element(TXT_USER).isVisible().maxTimeSeconds(10),
                Click.on(TXT_USER),
                Enter.theValue(data.getUser()).into(TXT_USER),
                Click.on(TXT_PASS),
                Enter.theValue(data.getUser()).into(TXT_PASS)
        );
    }

    public static OpenSAP on(UserLoombokData data){
        return Instrumented.instanceOf(OpenSAP.class).withProperties(data);
    }
}
