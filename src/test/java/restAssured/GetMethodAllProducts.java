package restAssured;

import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetMethodAllProducts {

	@Test
	public void getUsers() {

		// Base URI of the API
		RestAssured.baseURI = "https://fakestoreapi.com";

		// Sending GET request 
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.when()
				.get("/products")
				.then()
				.extract()
				.response();

		//print response
		response.prettyPrint();

		// Print status code
		System.out.println("Status Code: " + response.getStatusCode());

		JsonPath jsonpath = response.jsonPath();

		List<Map<String, Object>> allItems = jsonpath.getList("");
		for (Map<String, Object> products : allItems) {
			//getting all the values from the response
			int id = (int) products.get("id");
			String titles = (String) products.get("title");
			float  prices = Float.parseFloat(products.get("price").toString())	;
			String desc = (String) products.get("description");
			String catdesc = (String) products.get("category");

			Map<String, Object>rating = (Map<String, Object>) products.get("rating");
			float rate =  Float.parseFloat(rating.get("rate").toString());
			int count = (int) rating.get("count");

			//printing all the values
			System.out.println("Id values--------"+id);
			System.out.println("titles values--------"+titles);
			System.out.println("prices values--------"+prices);
			System.out.println("desc values--------"+desc);
			System.out.println("catdesc values--------"+catdesc);
			System.out.println("rate values--------"+rate);
			System.out.println("count values--------"+count);

			//Simple validation for specific title
			if(id==1 && titles.contains("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"))
				System.out.println("Title validation is passed for specific id");
			else
				System.out.println("Title validation is failed for other id");

		}

	}




}
