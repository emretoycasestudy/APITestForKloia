package com.petstore.base;

import com.petstore.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Cases {
    public void beforeclass(){
        baseURI= ConfigurationReader.get("uri");
    }
    public void postMethod(){
        Map<String,Object> requestMap=new HashMap<>();
        requestMap.put("id", 182);
        requestMap.put("category.id", 1);
        requestMap.put("category.name","Pets");
        requestMap.put("name","Karabas");
        requestMap.put("tags.id",0);
        requestMap.put("tags.name","pet-dog");
        requestMap.put("status","available");

        given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(requestMap)
                .when()
                .post("/pet")
                .then().log().all()
                .and().assertThat()
                .statusCode(200)
                .body("id",notNullValue(),"name",equalTo("Karabas"))
                .and().contentType(equalTo("application/json"))
                .and().header("Date",notNullValue());


    }
    public void getMethod(){
        int id= 182;

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", id)
                .when().get("/pet/{id}");
        response.prettyPrint();

        //verify status code
        assertEquals(response.statusCode(),200);

        //verify response body
        Map<String,Object> pets=response.body().as(Map.class);

        assertEquals(pets.get("name"),"Karabas");
        assertEquals(pets.get("status"),"available");

        //verify content type
        assertEquals(response.contentType(),"application/json");

        //verify has date value
        assertTrue(response.header("Date").contains("GMT"));


    }
    public void deleteMethod(){
        int id= 182;
        given().log().all()
                .and()
                .contentType(ContentType.JSON)
                .pathParam("id",id)
                .when()
                .delete("/pet/{id}")
                .then()
                .assertThat().log().all()
                .statusCode(200)
                .and().contentType(equalTo("application/json"))
                .body("message",equalTo("182"),"type",equalTo("unknown"));
    }


}

