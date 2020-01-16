package pk13SpecBuilders;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Pr1GoogleBooksAPI {

	@Test
	public void googleBookStore() {
		
		RestAssured.baseURI = "https://www.googleapis.com";

		RequestSpecification reqspec = new RequestSpecBuilder().
									setBaseUri("https://www.googleapis.com").
									addQueryParam("q","java").
									setContentType(ContentType.JSON).build();
		
		ResponseSpecification resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		RequestSpecification res = given().spec(reqspec);
				
		GetBooks gb = res.when().
					get("/books/v1/volumes").
					then().
						spec(resspec).
						extract().response().as(GetBooks.class);
		
		System.out.println("Total Items : "+gb.getTotalItems());
		
		for(int i=0; i<gb.getItems().size(); i++) {
			System.out.println("Title "+(i+1)+": "+gb.getItems().get(i).getVolumeInfo().getTitle());
		}
	}
}
