package restAssured;

import static org.testng.Assert.assertEquals;
import java.io.File;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutMethodForProduct {

	@Test
	public void postUsers() {
		// Base URI of the API
		RestAssured.baseURI = "https://fakestoreapi.com";

		File jsonFile = new File("src/test/resources/product.json");

		// Sending Put request 
		Response response  =RestAssured
				.given()
				.contentType(ContentType.JSON)
				.pathParam("id", 5)
				.body(jsonFile)
				.when()
				.put("/products/{id}");

		//print response
		response.prettyPrint();

		//Validate the status code
		assertEquals(200, response.getStatusCode());

	}

}
