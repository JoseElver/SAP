package com.co.choucair.sap.tasks;

import com.tcs.certificacion.sapgui.interactions.Click;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

public class CloseSAP implements Task {
    private static final Target BTN_EXIT = Target.the("button to close the SAP client")
            .locatedBy("wnd[0]/tbar[0]/btn[15]");

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_EXIT)
        );
    }

    public static CloseSAP on(){
        return Instrumented.instanceOf(CloseSAP.class).withProperties();
    }
}
