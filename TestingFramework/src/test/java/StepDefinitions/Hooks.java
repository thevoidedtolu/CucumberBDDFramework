package StepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {
    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
        //execute when place_id is null
        stepDefinition m= new stepDefinition();

        if(stepDefinition.place_id==null) {
            m.add_place_payload_with("Shetty","French","Asia", "+234 332 5543 454");
            m.user_calls_with_http_request("AddPlaceAPI","POST");
            m.in_response_is("Shetty", "GetPlaceAPI");

        }


    }
}
