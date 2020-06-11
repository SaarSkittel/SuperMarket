package Controller;
import View.*;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.*;

public class EmployeeManagerController implements ActionListener{
	private EmployeeManager m_EmployeeManager;
	
	public EmployeeManagerController(EmployeeManager i_EmployeeManager) {
		m_EmployeeManager = i_EmployeeManager;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		if(e.getActionCommand().equals("Add Employee")) {
			AddEmployee i_addEmployee = new AddEmployee(m_EmployeeManager);
		}
		else if(e.getActionCommand().equals("Cancel")) {
			//m_addEmployee.cancelselected();
		}
		else if(e.getActionCommand().equals("Delete Employee")) {
			DeleteMessage i_deleteEmployee = new DeleteMessage(m_EmployeeManager);
		}
		else if(e.getActionCommand().equals("Update Employee Information")) {
			UpdateEmployee i_updateEmployee = new UpdateEmployee(m_EmployeeManager);
		}
		else if (e.getActionCommand().equals("Refresh Table")) {
			EmployeeTabelController.setTable(m_EmployeeManager, m_EmployeeManager.getID());
		}
		}
		catch (Exception ex) {
			ErrorWindow i_Error = new ErrorWindow(ex.getMessage());
			i_Error.getFrame().setVisible(true);
		}
	}
}
