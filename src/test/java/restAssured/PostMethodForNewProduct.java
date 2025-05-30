package restAssured;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostMethodForNewProduct {

	@Test
	public void postUsers() {
		// Base URI of the API
		RestAssured.baseURI = "https://fakestoreapi.com";

		File jsonFile = new File("src/test/resources/product.json");
		// Sending POST request 
		Response response  =RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(jsonFile)
				.when()
				.post("/products");

		//print response
		response.prettyPrint();

		//Validate the status code
		assertEquals(200, response.getStatusCode());

		JsonPath jsonPath = response.jsonPath();

		// Validate response fields
		assertEquals(21, (int)jsonPath.get("id"));
		assertEquals("string", jsonPath.getString("title"));
		assertEquals(0.1f, jsonPath.getFloat("price"), 0.001);
		assertEquals("string", jsonPath.getString("description"));
		assertEquals("string", jsonPath.getString("category"));
		assertEquals("http://example.com", jsonPath.getString("image"));

	}

}
