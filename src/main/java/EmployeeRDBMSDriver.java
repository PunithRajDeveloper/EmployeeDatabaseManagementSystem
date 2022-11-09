import java.util.Scanner;

public class EmployeeRDBMSDriver {
	public static void main(String[] args) {
		//	Scanner scanner=new Scanner(System.in);
		//	System.out.println("enter employee id");
		//	int id=scanner.nextInt();

		//	System.out.println("enter employee name");
		//	String name=scanner.next();

		//	System.out.println("enter employee phonenumber");
		//	long num=scanner.nextLong();
		//	
		Employee employee=new Employee();
		//	employee.setId(id);
		//  employee.setName(name);
		//	employee.setPhone(num);

		EmployeeRDBMS edbms=new EmployeeRDBMS();

		try {
			//edbms.saveEmployeeData(employee);
			//edbms.upDateEmployeeData(id, employee);
			//edbms.deleteEmployeeData(id, employee);
			//edbms.retriveEmployeeDataByID(id, employee);
			edbms.retriverCompleteEmployeeData();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
