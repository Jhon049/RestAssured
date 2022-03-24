package co.com.sofka.stepdefinition.setup.services;

import io.restassured.RestAssured;
import org.apache.log4j.PropertyConfigurator;

import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;

public class ServiceSetUp {
    private static final String BASE_URI = "https://reqres.in";
    private static final String BASE_PATH = "/api/users?page=2";
    private static final String BASE_PATH2 = "/api/login";

    protected void generalSetUp(String request){
        setUpLog4j2();
        if(request == "get"){
            setUpBases(BASE_PATH);
        }else {
            setUpBases(BASE_PATH2);
        }
    }

    private void setUpLog4j2(){
        PropertyConfigurator.configure(System.getProperty("user.dir")  + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    private void setUpBases(String PATH_URL){
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = PATH_URL;
    }
}