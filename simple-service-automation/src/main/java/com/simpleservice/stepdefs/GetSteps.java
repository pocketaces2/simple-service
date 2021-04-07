package com.simpleservice.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.Youseknowlikewhen;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

import java.net.HttpURLConnection;
import java.util.Locale;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetSteps {

    Response response;

    @Given("this is test case {string}")
    public void givenTestCase(String testCase){
        System.out.println("This is test case: " + testCase);
    }

    @When("I submit a request to get the country for the country code {string}")
    public void whenSubmitCountryCodeGet(String countryCode){
        response = given().port(8085).log().all()
                    .when().get("/getCountry")
                    .then().extract().response();
    }

    //TOOD: Change response.getBody().print to something else - map it on a pojo?
    @Then("I validate the appropriate {string} is returned in the response")
    public void thenAssertCountryResponse(String country) {
        assertThat("Response code is not 200", response.getStatusCode(), is(HttpStatus.SC_OK));
        assertThat("Returned country code is not expected value,", response.getBody().print(), equalTo(country));
    }
}
