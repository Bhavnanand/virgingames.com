package com.virgingames.testSuites;

import com.virgingames.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ExtractResponseData extends TestBase {
    static ValidatableResponse response;

    @BeforeClass
    public static void init() {
        //   propertyReader = PropertyReader.getInstance();
        //  RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.baseURI = "https://www.virgingames.com/api/jackpots";
        RestAssured.basePath = "/bingo";
        response = given()
                .queryParams("currency", "GBP")
                .when()
                .get()
                .then().statusCode(200);
    }

    @Test
    public void test001() {
        String jack = response.extract().path("data.jackpotId");
        System.out.println("jackPotId  : " + jack);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test002() {
        //Extract first pots id =309
        int Id = response.extract().path("data.pots[0].id");
        System.out.println("For Bingo jackpotId first pot is : " + Id);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test003() {
        // Extract first Pot name
        String potname = response.extract().path("data.pots.name");
        System.out.println("First pot name  : " + potname);
        System.out.println("------------------End of Test---------------------------");
    }

    //Extract currency Type
    @Test
    public void test004() {
        String PotCurrency = response.extract().path("data.pots.currency");
        System.out.println("Pots currency  : " + PotCurrency);
        System.out.println("------------------End of Test---------------------------");

    }
}
