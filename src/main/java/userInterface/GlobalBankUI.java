package userInterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login")
public class GlobalBankUI extends PageObject {

    public static final Target SELECT_CLIENTE = Target.the("Selector de cliente")
            .locatedBy("select#userSelect");

    public static final Target BTN_LOGIN = Target.the("Botón Login")
            .locatedBy("button[type='submit']");

    public static final Target BTN_LOGOUT = Target.the("Botón Logout")
            .locatedBy("button[ng-click='byebye()']");

    public static final Target TAB_DEPOSIT = Target.the("Pestaña Deposit")
            .locatedBy("button[ng-click='deposit()']");

    public static final Target INPUT_DEPOSIT = Target.the("Input de depósito")
            .locatedBy("input[ng-model='amount']");

    public static final Target BTN_CONFIRM_DEPOSIT = Target.the("Botón confirmar depósito")
            .locatedBy("button[type='submit']");

    public static final Target TXT_DEPOSIT_SUCCESS = Target.the("Mensaje de éxito")
            .locatedBy("span[ng-show='message']");

    public static final Target TAB_WITHDRAWL = Target.the("Pestaña Withdrawl")
            .locatedBy("button[ng-click='withdrawl()']");

    public static final Target INPUT_WITHDRAWL = Target.the("Input de retiro")
            .locatedBy("input[ng-model='amount']");

    public static final Target BTN_CONFIRM_WITHDRAWL = Target.the("Botón confirmar retiro")
            .locatedBy("button[type='submit']");

    public static final Target TAB_TRANSACTIONS = Target.the("Pestaña Transactions")
            .locatedBy("button[ng-click='transactions()']");

    public static final Target TABLA_TRANSACCIONES = Target.the("Tabla de transacciones")
            .locatedBy("table.table.table-bordered.table-striped");

    public static final Target TXT_SALDO = Target.the("Texto de saldo")
            .locatedBy("div.center strong:nth-child(2)");
}
