package Model;
import java.io.*;
import java.util.*;

public class EmployeeDB  {
private String fileLocation;
private Set<Employee> EmployeeData;
public EmployeeDB() {
	fileLocation="Employee.dat";
	ObjectInputStream inputStream = null;
	try {
	 inputStream =new ObjectInputStream(new FileInputStream(fileLocation));
	 EmployeeData =(Set<Employee>) inputStream.readObject();
	}
	catch(IOException  | ClassNotFoundException e){
		e.printStackTrace();
	} finally{
		try {
			inputStream.close();
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
}
}
