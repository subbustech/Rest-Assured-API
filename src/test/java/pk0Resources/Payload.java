package pk0Resources;

public class Payload {
	public static String returnAddNewStudentBody() {
		String addNewStudentBody = "{"+
			    "\"firstName\": \"Venkat\","+
			    "\"lastName\": \"Dinavahi\","+
			    "\"email\": \"venkatd1235@gmail.com\","+
			    "\"programme\": \"Computer Science\","+
			    "\"courses\": ["+
			        "\"Java\","+
			        "\"Php\","+
			        "\"Data Science\""+
			    "]"+
			"}";
		
		return addNewStudentBody;
	}
}
