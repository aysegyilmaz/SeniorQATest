package Bases;

import io.restassured.RestAssured;

public class BaseTest extends Data {

    public void BeforeTest(){

        RestAssured.baseURI = URL;

    }

}
