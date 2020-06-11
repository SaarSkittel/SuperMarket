package Controller;

import java.sql.ResultSet;

import Model.ConnectToDB;
import Model.Employee;
import Model.StoreWorker;
import Model.job;
import View.EmployeeManager;
import View.ErrorWindow;
import View.StoreManager;
import net.proteanit.sql.DbUtils;

public class StoreTableController {
	public static void setTable(StoreManager view, String i_ID){
		try
		{
		ConnectToDB i_Connect = new ConnectToDB();
		Employee i_emp = i_Connect.SearchEmploee(i_ID, job.StoreWorker); 
		StoreWorker i_StoreWorker = (StoreWorker)i_emp;
		ResultSet ItemTable = i_StoreWorker.ReturnStoreItemTable();
		
		view.gettable().setModel(DbUtils.resultSetToTableModel(ItemTable));
		}
		catch (Exception ex) {
			ErrorWindow i_Error = new ErrorWindow(ex.getMessage());
			i_Error.getFrame().setVisible(true);
		}
	}
}
