package pk3GooglePlaceApi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Pr1GooglePlaceAPIRAW {
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
		System.out.println(res.asString());
		
		//Get the size of the array in response
		int total = res.body().path("candidates.list.size()");
		System.out.println("Total Restaurents Found: "+ total);
		
		//Get the Name of the Restaurant
		String restaurant_name = res.body().path("candidates[0].name");
		System.out.println("Restaurant Name: "+restaurant_name);
		
		//Get the First Restaurant Details
		String address = res.body().path("candidates[0].formatted_address");
		System.out.println("Address: "+address);
	}
}
