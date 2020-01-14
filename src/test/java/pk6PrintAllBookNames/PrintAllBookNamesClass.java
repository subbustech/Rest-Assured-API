package pk6PrintAllBookNames;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pk0Resources.CommonFunctions;

public class PrintAllBookNamesClass {
	@Test
	public void printAllBookNames() {
		
		RestAssured.baseURI = "https://www.googleapis.com";

		Response res = given().
				param("q","java").
				when().
					get("/books/v1/volumes").
					then().extract().response();
		
		JsonPath jsonBody = CommonFunctions.returnJsonBody(res);
		
		//System.out.println(res.asString());
		int totalBooks = jsonBody.get("items.size()");
		System.out.println("Total Books: "+totalBooks);
		System.out.println("\n");
		for(int i=0; i<totalBooks; i++) {
			System.out.println("Title: ");
			System.out.println(jsonBody.get("items["+i+"].volumeInfo.title"));
			System.out.println("Authors: ");
			int noOfAuthors = jsonBody.get("items["+i+"].volumeInfo.authors.size()");
			for(int j=0; j<noOfAuthors; j++) {
				System.out.println(jsonBody.get("items["+i+"].volumeInfo.authors["+j+"]"));
			}
			System.out.println("\n");
		}
	}
}
