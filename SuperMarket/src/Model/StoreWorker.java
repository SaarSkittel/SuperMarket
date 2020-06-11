package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StoreWorker extends Employee {
	private static Model.job i_StoreWorkerJob =job.StoreWorker;
	public StoreWorker(String i_Name,String i_ID, float i_HourlyWage) {
		super(i_ID, i_Name, i_HourlyWage,i_StoreWorkerJob);
	
	}
	public StoreWorker(String i_Name,String i_ID, float i_HourlyWage, float i_MonthlyWage) {
        super(i_ID, i_Name, i_HourlyWage, i_MonthlyWage, i_StoreWorkerJob);
    }
	
	public ResultSet ReturnStoreItemTable() throws Exception
	 {
		 ConnectToDB i_DB = new  ConnectToDB();
		 Connection i_Connection = i_DB.Connect();
	     String i_SqlMess = "SELECT Barcode,Name,Price,AvailableInStore,MaxStockStore FROM Items";
	     PreparedStatement i_Statement =  i_Connection.prepareStatement(i_SqlMess);
	     ResultSet i_TableFromDB = i_Statement.executeQuery();
	     //i_Statement.close();
	     i_DB.Connect().close();
	     return i_TableFromDB;
	 }
	
}
