package stepsDefinitions;

import interaction.AbrirPagina;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import question.ElementoVisible;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.Assertions.assertThat;
import static userInterface.GlobalBankUI.*;

public class GlobalBankSteps {

    private Actor actor;

    @Managed
    WebDriver driver;

    @Before
    public void preparar() {
        actor = Actor.named("usuario").can(BrowseTheWeb.with(driver));
    }

    @Given("El usuario abre la página del banco")
    public void abrirBanco() {
        actor.attemptsTo(AbrirPagina.delBanco());
    }

    @When("Selecciona \"{string}\" como cliente")
    public void seleccionarCliente(String nombre) {
        actor.attemptsTo(SelectFromOptions.byVisibleText(nombre).from(SELECT_CLIENTE));
    }

    @And("Hace clic en Login")
    public void login() {
        actor.attemptsTo(Click.on(BTN_LOGIN));
    }

    @Then("Debería ver el botón Logout")
    public void verLogout() {
        actor.should(seeThat(ElementoVisible.en(BTN_LOGOUT)));
    }

    @Given("El usuario inicia sesión como \"{string}\"")
    public void iniciarSesionComo(String nombre) {
        abrirBanco();
        seleccionarCliente(nombre);
        login();
    }

    @Then("El saldo debe ser mayor a 0")
    public void validarSaldo() {
        String textoSaldo = TXT_SALDO.resolveFor(actor).getText();
        int saldo = Integer.parseInt(textoSaldo);
        assertThat(saldo).isGreaterThan(0);
    }

    @When("Va a la pestaña Deposit")
    public void irADeposit() {
        actor.attemptsTo(Click.on(TAB_DEPOSIT));
    }

    @And("Ingresa el monto \"{string}\"")
    public void ingresarMonto(String monto) {
        actor.attemptsTo(Enter.theValue(monto).into(INPUT_DEPOSIT));
    }

    @And("Confirma el depósito")
    public void confirmarDeposito() {
        actor.attemptsTo(Click.on(BTN_CONFIRM_DEPOSIT));
    }

    @Then("Debería ver el mensaje \"{string}\"")
    public void verMensaje(String mensajeEsperado) {
        String texto = TXT_DEPOSIT_SUCCESS.resolveFor(actor).getText();
        assertThat(texto).containsIgnoringCase(mensajeEsperado);
    }

    @When("Va a la pestaña Withdrawl")
    public void irAWithdrawl() {
        actor.attemptsTo(Click.on(TAB_WITHDRAWL));
    }

    @And("Confirma el retiro")
    public void confirmarRetiro() {
        actor.attemptsTo(Click.on(BTN_CONFIRM_WITHDRAWL));
    }

    @When("Accede a la pestaña Transactions")
    public void irATransacciones() {
        actor.attemptsTo(Click.on(TAB_TRANSACTIONS));
    }

    @Then("Debería ver una tabla con transacciones")
    public void validarTransacciones() {
        actor.should(seeThat(ElementoVisible.en(TABLA_TRANSACCIONES)));
    }
    @And("Ingresa el monto de retiro \"{string}\"")
    public void ingresarMontoRetiro(String monto) {
        actor.attemptsTo(Enter.theValue(monto).into(INPUT_WITHDRAWL));
    }

}
