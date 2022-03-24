package co.com.sofka.stepdefinitions.list;

import co.com.sofka.stepdefinition.setup.services.ServiceSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.internal.matcher.xml.XmlDtdMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class ListStepDefinitions  extends ServiceSetUp {

    public static final Logger LOGGER = Logger.getLogger(ListStepDefinitions.class);
    private Response response;
    private RequestSpecification resquest;

    @Given("Envio el request a la URL definida")
    public void envioElRequestALaUrlDefinida(){
        try{
            generalSetUp();
            resquest = given()
                    .log()
                    .all()
                    .body("");
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @When("Hago la peticion del servicio")
    public void hagoLaPeticionDelServicio(){
        try{
            response = resquest.when()
                    .get();
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Then("Espero la respuesta HTTP 200")
    public void esperoLaRespuestaHttp200(){
        try{
            response.then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_OK)
                    .body("page", notNullValue());
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }


}
