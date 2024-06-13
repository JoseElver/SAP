package com.co.choucair.sap.userintefaces;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import net.serenitybdd.screenplay.targets.Target;
import org.testng.annotations.Test;

public class SAPGUI {

    public static final Target TXT_USER = Target.the("field for user")
            .locatedBy("wnd[0]/usr/txtRSYST-BNAME");
    public static final Target TXT_PASS = Target.the("field for user")
            .locatedBy("wnd[0]/usr/pwdRSYST-BCODE");

}
