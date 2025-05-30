package restAssured;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteMethodForProduct {

	@Test
	public void postUsers() {
		// Base URI of the API
		RestAssured.baseURI = "https://fakestoreapi.com";
			
		// Sending delete request 
		Response response  =RestAssured
				.given()
				.contentType(ContentType.JSON)
				 .pathParam("id", 5)
				.when()
				.delete("/products/{id}");

		//print response
		response.prettyPrint();

		//Validate the status code
		assertEquals(200, response.getStatusCode());
		
		





	}

}
