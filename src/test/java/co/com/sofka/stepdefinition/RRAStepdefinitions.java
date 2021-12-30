package co.com.sofka.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.apache.log4j.Logger;

import static io.restassured.RestAssured.given;

public class RRAStepdefinitions extends ReqresStup{
    private static final Logger LOGGER = Logger.getLogger(RRAStepdefinitions.class);
    private RequestSpecification requestNotFound_Register;
    private Response responseNotFound_Register;

    //Scenario 1
    @Given("el Cliente está en la Url https:\\/\\/reqres.in\\/ y Busca el usuario Veintitres.")
    public void elClienteEstáEnLaUrlHttpsReqresInYBuscaElUsuarioVeintitres() {
        try {
            generalSetup();
            requestNotFound_Register = given();
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }
    @When("cuando el cliente realiza la peticion de busqueda  de usuario")
    public void cuandoElClienteRealizaLaPeticionDeBusquedaDeUsuario() {
        try {
            responseNotFound_Register = requestNotFound_Register.get(RESOURCE_SINGE_USER);

        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }
    @Then("el cliente deberá ver un codigo de respuesta de usuario no encontrado")
    public void elClienteDeberáVerUnCodigoDeRespuestaDeUsuarioNoEncontrado() {
        try {
            String mensaje = responseNotFound_Register
                    .then()
                    .extract()
                    .asString();

            Assertions.assertEquals("{}", mensaje);
            LOGGER.info("Verificacion Exitosa Scenario1");

        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }

    //Scenario 2
    @Given("el Cliente está en la Url https:\\/\\/reqres.in\\/ y digita su usuario {string} y contraseña {string}")
    public void elClienteEstáEnLaUrlHttpsReqresInYDigitaSuUsuarioYContraseña(String usuario, String contrasena) {
        try {
            generalSetup();
            requestNotFound_Register = given().body("{\n" +
                    "    \"email\": \""+usuario+"\",\n" +
                    "    \"password\": \""+contrasena+"\"\n" +
                    "}");
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }
    @When("cuando el cliente realiza la peticion de creacion de usuario")
    public void cuandoElClienteRealizaLaPeticionDeCreacionDeUsuario() {
        try {
            responseNotFound_Register = requestNotFound_Register.post(RESOURCE_REGISTER);
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }

    }
    @Then("el cliente deberá ver un codigo de respuesta éxitoso y los datos creados")
    public void elClienteDeberáVerUnCodigoDeRespuestaÉxitosoYLosDatosCreados() {
        try {
            String mensaje = responseNotFound_Register
                    .then()
                    .extract()
                    .asString();

            Assertions.assertEquals("{\"id\":4,\"token\":\"QpwL5tke4Pnpja7X4\"}", mensaje);
            LOGGER.info("Verificacion Exitosa");
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }
}
