package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Storekeeper extends Employee{
	private static Model.job i_StorekeeperJob =job.Storekeeper;
	public Storekeeper(String i_Name,String i_ID, float i_HourlyWage) {
		super(i_ID, i_Name, i_HourlyWage,i_StorekeeperJob);
	
	}
	public Storekeeper(String i_Name,String i_ID, float i_HourlyWage, float i_MonthlyWage) {
		super(i_ID, i_Name, i_HourlyWage, i_MonthlyWage,i_StorekeeperJob);
	
	}
	
	public ResultSet ReturnWarehouseItemTable() throws Exception
	 {
		 ConnectToDB i_DB = new  ConnectToDB();
		 Connection i_Connection = i_DB.Connect();
	     String i_SqlMess = "SELECT Barcode,Name,AvailableInWarehouse,MaxStockWarehouse FROM Items";
	     PreparedStatement i_Statement =  i_Connection.prepareStatement(i_SqlMess);
	     ResultSet i_TableFromDB = i_Statement.executeQuery();
	     i_Statement.closeOnCompletion();
	     i_DB.Connect().close();
	     return i_TableFromDB;
	 }
	 public void AddItem(Item i_NewItem) throws Exception {
		 ConnectToDB i_DB = new  ConnectToDB();
		 Connection i_Connection = i_DB.Connect();
		 String i_SqlStatement ="INSERT INTO Items VALUES(?,?,?,?,?,?,?)";
		 PreparedStatement i_Statement = i_Connection.prepareStatement(i_SqlStatement);
		 i_Statement.setString(1, i_NewItem.getBarcode());
		 i_Statement.setString(2, i_NewItem.getItemName());
		 i_Statement.setFloat(3, i_NewItem.getPrice());
		 i_Statement.setInt(4, i_NewItem.getMaxStockStore());
		 i_Statement.setInt(5, i_NewItem.getMaxStockWarehouse());
		 i_Statement.setInt(6, i_NewItem.getAvailableInStore());
		 i_Statement.setInt(7, i_NewItem.getAvailableInWarehouse());
		 i_Statement.execute();
		 i_Statement.close();
		 i_DB.Connect().close();
	 }
	 public void UpdateItem(Item i_NewItem) throws Exception {
		 ConnectToDB i_DB = new  ConnectToDB();
	     Connection i_Connection = i_DB.Connect();
		 String i_SqlStatement =" UPDATE Employees SET Name = ?, = ?, Job = ? WHERE Barcode = ?";
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
}
