package getRequest;

import static io.restassured.RestAssured.get;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

public class PostData {

String api = "http://ec2-54-174-213-136.compute-1.amazonaws.com:3000";
	
	
		
		@Test
		public void postData()
		{		
			RestAssured.baseURI = api;
			RequestSpecification request = RestAssured.given();

			JSONObject requestParams = new JSONObject();
			requestParams.put("userId", 1118); // Cast
			requestParams.put("id", 1600);
			requestParams.put("title", "QA_Tester");
			requestParams.put("body", "Hello World");
			
			request.body(requestParams.toJSONString());
			Response response = request.post("/posts");

			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 201);
			
		}
	
	
	
	
	
	
	
}
