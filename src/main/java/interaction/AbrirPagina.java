package interaction;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import userInterface.GlobalBankUI;

public class AbrirPagina {

    public static Performable delBanco() {
        return Open.browserOn().the(GlobalBankUI.class);
    }
}
