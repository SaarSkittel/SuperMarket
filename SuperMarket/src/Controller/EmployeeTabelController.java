package Controller;
import View.*;
import net.proteanit.sql.DbUtils;

import java.sql.ResultSet;
import java.util.*;
import Model.*;

public class EmployeeTabelController {
	
	public static void setTable(EmployeeManager view, String i_ID){
		try
		{
		ConnectToDB i_Connect = new ConnectToDB();
		Employee i_emp = i_Connect.SearchEmploee(i_ID, job.Manager); 
		Manager i_manager = (Manager)i_emp;
		ResultSet EmployeeTable = i_manager.ReturnEmployeeTable();
		
		view.gettable().setModel(DbUtils.resultSetToTableModel(EmployeeTable));
		}
		catch (Exception ex) {
			ErrorWindow i_Error = new ErrorWindow(ex.getMessage());
			i_Error.getFrame().setVisible(true);
		}
	}
}
