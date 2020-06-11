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
	     String i_SqlMess = "SELECT Barcode,Name,Price,AvailableInWarehouse,MaxStockWarehouse FROM Items";
	     PreparedStatement i_Statement =  i_Connection.prepareStatement(i_SqlMess);
	     ResultSet i_TableFromDB = i_Statement.executeQuery();
	     //i_Statement.close();
	     i_DB.Connect().close();
	     return i_TableFromDB;
	 }
	
}
