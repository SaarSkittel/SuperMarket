package Controller;

import java.sql.ResultSet;

import Model.ConnectToDB;
import Model.Employee;
import Model.Manager;
import Model.Storekeeper;
import Model.job;

import View.ErrorWindow;
import View.WarehouseManager;
import net.proteanit.sql.DbUtils;

public class WarehouseTableController {
	public static void setTable(WarehouseManager view, String i_ID){
		try
		{
		ConnectToDB i_Connect = new ConnectToDB();
		Employee i_emp = i_Connect.SearchEmploee(i_ID, job.Storekeeper); 
		Storekeeper i_StoreKeeper = (Storekeeper)i_emp;
		ResultSet EmployeeTable = i_StoreKeeper.ReturnWarehouseItemTable();
		
		view.gettable().setModel(DbUtils.resultSetToTableModel(EmployeeTable));
		}
		catch (Exception ex) {
			ErrorWindow i_Error = new ErrorWindow(ex.getMessage());
			i_Error.getFrame().setVisible(true);
		}
	}
}
