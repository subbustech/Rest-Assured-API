package pk0Resources;

public class Payload {
	public static String returnAddNewStudentBody() {
		String addNewStudentBody = "{"+
			    "\"firstName\": \"Venkat\","+
			    "\"lastName\": \"Dinavahi\","+
			    "\"email\": \"venkatd1236@gmail.com\","+
			    "\"programme\": \"Computer Science\","+
			    "\"courses\": ["+
			        "\"Java\","+
			        "\"Php\","+
			        "\"Data Science\""+
			    "]"+
			"}";
		
		return addNewStudentBody;
	}
	
	public static String returnAddNewStudentBodyWithParams(String firstName, String lastName, String email) {
		String addNewStudentBody = "{"+
			    "\"firstName\": \""+firstName+"\","+
			    "\"lastName\": \""+lastName+"\","+
			    "\"email\": \""+email+"\","+
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
