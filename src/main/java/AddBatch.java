import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddBatch {
public static void main(String[] args) throws Exception {
	Scanner scanner=new Scanner(System.in);
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "root");
	PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO EMPLOYEE VALUE(?,?,?)");
	
	for(int i=1;i<=5;i++) {
		System.out.println("enter the id");
		int id=scanner.nextInt();
		System.out.println("enter the name");
		String name=scanner.next();
		System.out.println("enter the phone number");
		long phnoe=scanner.nextLong();
		
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setLong(3, phnoe);
		
		preparedStatement.addBatch();
	}
	

	preparedStatement.executeBatch();

	connection.close();

	System.out.println("data saved successfully");
	
}
}
