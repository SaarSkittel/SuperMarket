package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Manager extends Employee {
	private static Model.job i_ManagerJob =job.Manager;
	
	public Manager(String i_Name,String i_ID, float i_HourlyWage) {
		super(i_ID, i_Name, i_HourlyWage,i_ManagerJob);
	
	}
	public Manager(String i_Name,String i_ID, float i_HourlyWage, float i_MonthlyWage) {
        super(i_ID,i_Name, i_HourlyWage, i_MonthlyWage,i_ManagerJob);

    }
	
	 public void AddEmployee(Employee i_NewEmployee) throws Exception {
		 ConnectToDB i_DB = new  ConnectToDB();
	     Connection i_Connection = i_DB.Connect();
	     String i_SqlMess = "Insert into Employees (ID,Job,Name,HourlyWage,MonthlyHours) Values(?,?,?,?,?)";
	     PreparedStatement i_Statement =  i_Connection.prepareStatement(i_SqlMess);
	     i_Statement.setString(1, i_NewEmployee.getID());
	     i_Statement.setString(2, i_NewEmployee.getJobType().toString());
	     i_Statement.setString(3, i_NewEmployee.getName());
	     i_Statement.setFloat(4, i_NewEmployee.getHourlyWage());
	     i_Statement.setFloat(5, i_NewEmployee.getMountlyHours());
	     i_Statement.execute();
	     i_Statement.close();
	     i_DB.Connect().close();
	     }
	
	 public void UpdateEmployee(Employee i_Employee) throws Exception {
		 ConnectToDB i_DB = new  ConnectToDB();
	     Connection i_Connection = i_DB.Connect();
		 String i_SqlStatement =" UPDATE Employees SET Name = ?, MonthlyHours = ?, HourlyWage = ?, Job = ? WHERE ID = ?";
		 PreparedStatement i_Statement =  i_Connection.prepareStatement(i_SqlStatement);
	     i_Statement.setString(1, i_Employee.getName());
	     i_Statement.setFloat(2, i_Employee.getMountlyHours());
	     i_Statement.setFloat(3, i_Employee.getHourlyWage());
	     i_Statement.setString(4, i_Employee.getJobType().toString());
	     i_Statement.setString(5, i_Employee.getID());
	     i_Statement.executeUpdate();
	     i_Statement.close();
	     i_DB.Connect().close();
	 }
	 public ResultSet ReturnWageTable() throws Exception
     {
         ConnectToDB i_DB = new  ConnectToDB();
         Connection i_Connection = i_DB.Connect();
         String i_SqlMess = "SElECT ID,Name,(HourlyWage*MonthlyHours) as Wage FROM Employees";
         PreparedStatement i_Statement =  i_Connection.prepareStatement(i_SqlMess);
         ResultSet i_TableFromDB = i_Statement.executeQuery();
         i_DB.Connect().close();
         return i_TableFromDB;
     }
	public void RemoveEmployee(String i_ID) throws Exception
	{
		ConnectToDB i_DB = new  ConnectToDB();
	    Connection i_Connection = i_DB.Connect();
	    String i_SqlMess = "DELETE FROM Employees WHERE ID = ?";
	    PreparedStatement i_Statement =  i_Connection.prepareStatement(i_SqlMess);
	    i_Statement.setString(1, i_ID);
	    i_Statement.executeUpdate();
	    i_Statement.close();
	    i_DB.Connect().close();
	}
	
/*	 public  ArrayList<Employee> GetEmployeesList() throws Exception {
		 	ConnectToDB i_DB = new  ConnectToDB();
		 	Connection i_Connection = i_DB.Connect();
			ArrayList<Employee> i_ListOfEmployees = new ArrayList<Employee>();
			String i_SqlStatement = "SELECT ID, Name, HourlyWage, MonthlyWage, Job FROM Employees";
			Statement i_Statement = i_Connection.createStatement();
			ResultSet i_TableFromDB = i_Statement.executeQuery(i_SqlStatement);
			//return ResultSet instead of ArrayList 
			while(i_TableFromDB.next()) {
				i_ListOfEmployees.add(EmployeeFactory.creatEmployee(i_TableFromDB.getString("ID"),i_TableFromDB.getString("Name"),i_TableFromDB.getFloat("HourlyWage"), i_TableFromDB.getFloat("MonthlyWage") ,job.valueOf(i_TableFromDB.getString("Job"))));
				
			}
			i_Statement.close();
			return i_ListOfEmployees;
		  }
	 */
	 
	public ResultSet ReturnEmployeeTable() throws Exception
	 {
		 ConnectToDB i_DB = new  ConnectToDB();
		 Connection i_Connection = i_DB.Connect();
	     String i_SqlMess = "SElECT * FROM Employees";
	     PreparedStatement i_Statement =  i_Connection.prepareStatement(i_SqlMess);
	     ResultSet i_TableFromDB = i_Statement.executeQuery();
	     i_Statement.closeOnCompletion();
	     i_DB.Connect().close();
	     return i_TableFromDB;
	 }
}

