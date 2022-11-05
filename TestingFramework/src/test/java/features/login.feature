Feature: Application Login
  @AddPlace
   Scenario Outline: Verify AddPlace functionality
     Given Add Place payload with "<name>" "<language>" "<address>" "<phoneNumber>"
     When User calls "AddPlaceAPI" with "POST" http request
     Then Verify that the API call is successful with status code 200
     And "status" in response is "OK"
     And "scope" in response is "APP"
     And Verify place-id created to "<name>" using "GetPlaceAPI"

     Examples:
       |name|language|address|phoneNumber|
       |AAhousse|English|43, Lane 3, Wallcross Estate|+234 823  445 3234|

     @DeletePlace
     Scenario: Verify DeletePlace API functionality
       Given DeletePlace Payload
       When User calls "DeletePlaceAPI" with "POST" http request
       Then Verify that the API call is successful with status code 200
       And "status" in response is "OK"