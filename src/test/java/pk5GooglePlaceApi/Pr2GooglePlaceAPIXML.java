package pk5GooglePlaceApi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import pk0Resources.CommonFunctions;

public class Pr2GooglePlaceAPIXML {
	@Test
	public void googlePlaces() {
		
		RestAssured.baseURI = "https://maps.googleapis.com";

		Response res = given().
				queryParam("key","AIzaSyBz4ejBo5dEKJPlNGGYUzC95FCQcDlCF84").
				queryParam("input", "Mangolian grill").
				queryParam("inputtype", "textquery").
				queryParam("fields", "photos,formatted_address,name,opening_hours,rating").
				log().all().
				when().
					get("/maps/api/place/findplacefromtext/xml").
					then().
						extract().response();
		
		//Get the XML Body
		XmlPath xp = CommonFunctions.returnXmlBody(res);
		
		//Get the size of the array in response
		int total = xp.get("FindPlaceFromTextResponse.candidates.size()");
		System.out.println("Total Restaurents Found: "+ total);
		
		//Get the Name of the Restaurant
		String restaurant_name = xp.get("FindPlaceFromTextResponse.candidates[0].name");
		System.out.println("Restaurant Name: "+restaurant_name);
		
		//Get the First Restaurant Details
		String address = xp.get("FindPlaceFromTextResponse.candidates[0].formatted_address");
		System.out.println("Address: "+address);
	}
}
