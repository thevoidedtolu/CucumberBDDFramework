package resources;

import pojo.LocationSpecifics;
import pojo.getLocations;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public getLocations addPlacePayload(String name, String language, String address, String phoneNumber)
    {
        getLocations p = new getLocations();
        p.setAccuracy(50);
        p.setAddress(address);
        p.setLanguage(language);
        p.setPhoneNumber(phoneNumber);
        p.setName(name);
        p.setWebsite("https://rahulshettyacademy.com  ");

        List<String> myList = new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        p.setType(myList);

        LocationSpecifics l = new LocationSpecifics();
        l.setLat (33.22123);
        l.setLng (-22.33243);
        p.setLocation(l);
        return p;
    }

    public String deletePlacePayload(String place_id) {

        return "{\r\n \"place_id\":\""+place_id+"\"\r\n}";


    }
}
