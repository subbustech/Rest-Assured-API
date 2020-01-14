package pk3GooglePlaceApi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Pr2GooglePlaceAPIJSON {
	@Test
	public void googlePlaces() {
		
		RestAssured.baseURI = "https://maps.googleapis.com";

		Response res = given().
				queryParam("key","AIzaSyBz4ejBo5dEKJPlNGGYUzC95FCQcDlCF84").
				queryParam("input", "mongolian grill").
				queryParam("inputtype", "textquery").
				queryParam("fields", "photos,formatted_address,name,opening_hours,rating").
				log().all().
				when().
					get("/maps/api/place/findplacefromtext/json").
					then().
						extract().response();
		
		//Print the response
		String jsonresstr = res.asString();
		System.out.println(jsonresstr);
		
		//Convert the string into json
		JsonPath jsonBody = new JsonPath(jsonresstr);

		//Access the values from json
		//Get the size from JSON response
		int totalJson = jsonBody.getList("candidates").size();
		System.out.println("Total Restaurents Found: "+ totalJson);
		
		//Get the Name of the Restaurant
		String restaurant_name = jsonBody.get("candidates[0].name");
		System.out.println("Restaurant Name: "+restaurant_name);
		
		//Get the First Restaurant Details
		String address = jsonBody.get("candidates[0].formatted_address");
		System.out.println("Address: "+address);
	}
}
