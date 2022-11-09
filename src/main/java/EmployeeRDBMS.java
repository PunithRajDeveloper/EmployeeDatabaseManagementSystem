import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeRDBMS {

	Connection connection=new EmployeeConnectionObject().getConnectiponObject();


	public void saveEmployeeData(Employee employee) throws Exception {
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO EMPLOYEE VALUE(?,?,?)");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setLong(3,employee.getPhone());

		preparedStatement.executeUpdate();

		connection.close();

		System.out.println("data saved successfully");

	}

	public void upDateEmployeeData(long phone,Employee employee) throws Exception {

		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE EMPLOYEE SET PHONENUM = ? WHERE id=? ");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setLong(2, employee.getPhone());

		preparedStatement.executeUpdate();

		connection.close();

		System.out.println("data upDated successfully");

	}

	public void deleteEmployeeData(int id,Employee employee ) throws Exception {

		PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM EMPLOYEE WHERE id = ?");
		preparedStatement.setInt(1, employee.getId());

		preparedStatement.executeUpdate();

		connection.close();

		System.out.println("data deleted successfully");

	}

	public void retriveEmployeeDataByID(int id,Employee employee) throws Exception {
		String quary="SELECT * FROM EMPLOYEE WHERE ID=?";
		PreparedStatement preparedStatement=connection.prepareStatement(quary);
		preparedStatement.setInt(1, id);
		ResultSet resultSet=preparedStatement.executeQuery();

		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong(3));
			System.out.println("------------------------");
		}

		System.out.println("DATA RETRIVED SUCCESSFULLY");
	}

	public void retriverCompleteEmployeeData() throws Exception {
		String query="SELECT * FROM EMPLOYEE ";
		Statement statement=connection.createStatement();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		ResultSet resultSet=preparedStatement.executeQuery();

		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong(3));
			System.out.println("------------------------");
		}
     connection.close();
		System.out.println("DATA RETRIVED SUCCESSFULLY");
	}



}
