package com.virgingames.testSuites;

import com.virgingames.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;

public class GetDataAndAssertresponse extends TestBase {
    static ValidatableResponse response;

    //Get all data for bingo game
    @Test
    public void getData() {
        response = given()
                .queryParams("currency", "GBP")
                .when()
                .get()
                .then().statusCode(200);
    }
    @Test
    public void isJackpotIdEqualsBingo(){
response.body("data.jackpots",equalTo("Bingo") );
    }
    //Get name of game for first pot
    @Test
    public void NameofFirstPot(){
      response.body("data.pots[0].name",hasItem("virgingamessession"));
    }
    @Test
    public void amountofFirstData(){
        response.body("data.pots[0].amount",equalTo(4259))
        .body("data.pot[1]",hasKey("amount"));
    }
    @Test
    public void checkEntry(){
        response.body("data.pots[2]",hasItem("GBP"))
                .body("data.pots[2]",hasKey("currency"));
    }
    @Test
    public void NameAssociatedWithPots(){
        response.body("data.findAll{it.id==309}",hasItem(hasEntry("name","virgingamessession")));
    }


}


