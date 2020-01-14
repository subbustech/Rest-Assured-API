package pk0Resources;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class CommonFunctions {
	public static JsonPath returnJsonBody(Response res) {
		//Print the response
		String jsonresstr = res.asString();
				
		//Convert the string into json
		JsonPath jsonBody = new JsonPath(jsonresstr);
		
		return jsonBody;
	}
	
	public static XmlPath returnXmlBody(Response res) {
		//Print the response
		String xmlresstr = res.asString();
				
		//Convert the string (response) into XMLPath
		XmlPath xp = new XmlPath(xmlresstr);
		
		return xp;		
	}
}
