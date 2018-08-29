package getRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
public class TestGetRequest  {
	
	String api1 = "http://ec2-54-174-213-136.compute-1.amazonaws.com:3000/posts";
	String api2= "http://ec2-54-174-213-136.compute-1.amazonaws.com:3000/comments";
	String api3 ="http://ec2-54-174-213-136.compute-1.amazonaws.com:3000/users";
	
	
	//this testcase can be use for other two urls (api2 and api3, we just need to change it to api2 and api3)
	@Test
	public void testResponseCode(){
		
		int code = get(api1).getStatusCode();
		System.out.println("Code: "+code);
		Assert.assertEquals(code, 200);
	}
	@Test
	public void responseTimeCheck() {
	
	Long time=get(api1).getTime();
	System.out.println("Response Time: "+time);
	Assert.assertTrue(time<200);
	}
	
	
	@Test
	public void UserIdBody()
	{
		

		RestAssured.baseURI = api1;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/2");
		ResponseBody body = response.getBody();
		System.out.println("Response Body is: " + body.asString());
		
		String bodyAsString = body.asString();
		Assert.assertEquals(bodyAsString.contains("userId") /*Expected value*/, true /*Actual Value*/, "Response body contains userId");
	}
	
	@Test
	public void VerifyIdinResponse()
	{
		RestAssured.baseURI = api1;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/2");
		JsonPath jsonPathEvaluator = response.jsonPath();
		int id = jsonPathEvaluator.get("id");
		System.out.println("id received from Response " + id);
		// Validate the response
		Assert.assertEquals(id, 2, "Correct id received in the Response");

	}
	

}
