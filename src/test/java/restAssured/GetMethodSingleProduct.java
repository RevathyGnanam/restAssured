package restAssured;


import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetMethodSingleProduct {

	@Test
	public void getUsers() {

		// Base URI of the API
		RestAssured.baseURI = "https://fakestoreapi.com";

		int productId = 5;

		// Sending GET request with path parameter
		Response response = 
				RestAssured.given()
				.pathParam("id", productId)
				.when()
				.get("/products/{id}");

		// Print the response
		response.prettyPrint();

		// Validate the response
		int actualId = response.jsonPath().getInt("id");
		assert actualId == productId;

	}

}
