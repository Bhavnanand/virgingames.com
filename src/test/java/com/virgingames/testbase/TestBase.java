package com.virgingames.testbase;

import com.virgingames.utils.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;

/**
 * Created by Jay
 */
public class TestBase {
    public static PropertyReader propertyReader;
    static ValidatableResponse response;
    @BeforeClass
    public static void init() {
     //   propertyReader = PropertyReader.getInstance();
      //  RestAssured.baseURI = propertyReader.getProperty("baseUrl");
    RestAssured.baseURI = "https://www.virgingames.com/api/jackpots";
            RestAssured.basePath = "/bingo";
             response = given()
                    .queryParams("currency","GBP")
                    .when()
                    .get()
                    .then().statusCode(200);
        }
}
