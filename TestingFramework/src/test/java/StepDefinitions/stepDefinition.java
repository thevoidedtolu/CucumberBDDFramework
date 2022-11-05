package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.runner.RunWith;
import resources.APIResources;
import resources.TestData;
import resources.Utils;


import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

@RunWith(Cucumber.class)
public class stepDefinition extends Utils {
        RequestSpecification resp;
        ResponseSpecification respecc;
        Response response;
        static String place_id;

        TestData data=new TestData();


    @Given("Add Place payload with {string} {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address, String phoneNumber) throws IOException {

        respecc = new ResponseSpecBuilder().expectStatusCode(200).
                expectContentType(ContentType.JSON).build();

        resp= given().spec(RquestSpec()).body(data.addPlacePayload(name,language,address,phoneNumber));

    }
    @When("User calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {

        APIResources resourceAPI =  APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());

        respecc = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).
                build();
        if(method.equalsIgnoreCase("POST")){
            response = resp.when().post(resourceAPI.getResource());       }
        else if (method.equalsIgnoreCase("GET")) {
            response = resp.when().get(resourceAPI.getResource());
        }
    }
    @Then("Verify that the API call is successful with status code {int}")
    public void verify_that_the_api_call_is_successful_with_status_code(Integer int1) {

        assertEquals(response.getStatusCode(),200);


    }
    @Then("{string} in response is {string}")
    public void in_response_is(String key, String value) {

        assertEquals(getJsonPath(response,key),value);
    }
    @Then("Verify place-id created to {string} using {string}")
    public void in_response_body_is(String expectedName, String resource) throws IOException {

        place_id = getJsonPath(response,"place_id");
        resp = given().spec(RquestSpec()).queryParam("place_id",place_id);
        user_calls_with_http_request(resource,"GET");
        String ActualName = getJsonPath(response,"name");
        assertEquals(ActualName,expectedName);
    }
    @Given("DeletePlace Payload")
    public void delete_place_payload() throws IOException {

        resp = given().spec(RquestSpec()).body(data.deletePlacePayload(place_id));
    }
}
