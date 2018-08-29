package getRequest;

import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutData {
	String api = "http://ec2-54-174-213-136.compute-1.amazonaws.com:3000";
	public static Map< String, String > map = new HashMap < String, String >();
	@BeforeTest
	public void putdata(){
		map.put("userId", "2");
		map.put("id", "19");
		map.put("title", "this is projectdebug.com");
		map.put("body", "i am testing REST api with REST-Assured and sending a PUT request.");	
		RestAssured.baseURI = api;
		RestAssured.basePath = "/posts/";
	}

	
	
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
		Response response = request.put("/posts");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
}
