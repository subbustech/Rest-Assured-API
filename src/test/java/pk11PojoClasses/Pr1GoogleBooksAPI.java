package pk11PojoClasses;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Pr1GoogleBooksAPI {

	@Test
	public void googleBookStore() {
		
		RestAssured.baseURI = "https://www.googleapis.com";

		GetBooks gb = given().
				param("q","java").
				when().
					get("/books/v1/volumes").
					then().extract().response().as(GetBooks.class);
		
		System.out.println("Total Items : "+gb.getTotalItems());
		
		for(int i=0; i<gb.getItems().size(); i++) {
			System.out.println("Title "+(i+1)+": "+gb.getItems().get(i).getVolumeInfo().getTitle());
		}
	}
}
