package resources;

public class demo {

    public String getAddPlaceAPI() {
        return addPlaceAPI;
    }

    public void setAddPlaceAPI(String addPlaceAPI) {
        this.addPlaceAPI = addPlaceAPI;
    }

    public String getGetPlaceAPI() {
        return getPlaceAPI;
    }

    public void setGetPlaceAPI(String getPlaceAPI) {
        this.getPlaceAPI = getPlaceAPI;
    }

    public String getDeletePlaceAPI() {
        return deletePlaceAPI;
    }

    public void setDeletePlaceAPI(String deletePlaceAPI) {
        this.deletePlaceAPI = deletePlaceAPI;
    }

    String addPlaceAPI = "/maps/api/place/add/json";
    String getPlaceAPI = "/maps/api/place/get/json";
    String deletePlaceAPI = "/maps/api/place/delete/json";





}
