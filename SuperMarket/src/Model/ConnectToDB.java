package Model;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public  class ConnectToDB {
	
 public  Connection Connect() throws Exception
 {
	 String i_Url = "jdbc:sqlite:Resources\\StoreDB.db";
	 Connection i_Conn= null;
	 i_Conn = DriverManager.getConnection(i_Url);
	 if(i_Conn == null) {
	   throw new Exception("Error connecting to Database");
	 }
	return i_Conn;
 }
 
 public void AddItem(Item i_NewItem) throws Exception {
	 Connection i_Conn = this.Connect();
	 String i_SqlStatement ="INSERT INTO Item VALUES(?,?,?,?,?,?,?)";
	 PreparedStatement i_Statement = i_Conn.prepareStatement(i_SqlStatement);
	 i_Statement.setString(1, i_NewItem.getBarcode());
	 i_Statement.setString(2, i_NewItem.getItemName());
	 i_Statement.setFloat(3, i_NewItem.getPrice());
	 i_Statement.setInt(4, i_NewItem.getMaxStockStore());
	 i_Statement.setInt(5, i_NewItem.getMaxStockWarehouse());
	 i_Statement.setInt(6, i_NewItem.getAvailableInStore());
	 i_Statement.setInt(7, i_NewItem.getAvailableInWarehouse());
	 i_Statement.execute();
	 i_Statement.close();
 }
 
 public void UpdateItem(Item i_NewItem) throws Exception {
	 Connection i_Conn = this.Connect();
	 String i_SqlStatement ="UPDATE Item SET Name = ?, Price = ?, MaxStockInStore = ?, MaxStockWarehouse = ?,  AvailableInStore = ?, AvailableInWarehouse = ? WHERE Barcode = ?";
	 PreparedStatement i_Statement = i_Conn.prepareStatement(i_SqlStatement);
	 i_Statement.setString(1, i_NewItem.getBarcode());
	 i_Statement.setString(2, i_NewItem.getItemName());
	 i_Statement.setFloat(3, i_NewItem.getPrice());
	 i_Statement.setInt(4, i_NewItem.getMaxStockStore());
	 i_Statement.setInt(5, i_NewItem.getMaxStockWarehouse());
	 i_Statement.setInt(6, i_NewItem.getAvailableInStore());
	 i_Statement.setInt(7, i_NewItem.getAvailableInWarehouse());
	 i_Statement.executeUpdate();
	 i_Statement.close();
 }
	
public void RemoveItem(Item i_Item) throws Exception {
	 Connection i_Conn = this.Connect();
	 String i_SqlStatement ="DELETE FROM Item WHERE Barcode = ?";
	 PreparedStatement i_Statement = i_Conn.prepareStatement(i_SqlStatement);
	 i_Statement.setString(1, i_Item.getBarcode());
	 i_Statement.executeUpdate();
	 i_Statement.close();
}
public Employee SearchEmploee(String i_ID, job i_Job) throws Exception {
	 Employee i_new = null;
	
	 Connection i_Conn = this.Connect();
	 String i_SqlStatement ="select * from Employees where ID= ? and Job= ?";
	 PreparedStatement i_Statement = i_Conn.prepareStatement(i_SqlStatement);
	 i_Statement.setString(1, i_ID);
	 i_Statement.setString(2, i_Job.toString());
	 ResultSet i_TableFromDB = i_Statement.executeQuery();
	 
	 if( !i_TableFromDB.isClosed()) {
		 i_new =  EmployeeFactory.creatEmployee(i_TableFromDB.getString("ID"),i_TableFromDB.getString("Name"),i_TableFromDB.getFloat("HourlyWage"), i_TableFromDB.getFloat("MonthlyHours") ,job.valueOf(i_TableFromDB.getString("Job"))); 
	 }
	 else {
		 
		 throw new Exception("Invalid ID.");
	 }
	 i_Conn.close();
	 i_Statement.close();
	 return i_new;
}

}
