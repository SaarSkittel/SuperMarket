package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.ConnectToDB;
import Model.Employee;
import Model.EmployeeFactory;
import Model.Manager;
import Model.job;
import View.ErrorWindow;
import View.UpdateEmployee;

public class UpdateEmployeeController implements ActionListener {
	private UpdateEmployee m_updateEmployee;
	public UpdateEmployeeController(UpdateEmployee i_updateEmployee) {
		m_updateEmployee = i_updateEmployee;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		if(e.getActionCommand().equals("Update")) {
			ConnectToDB i_Connect = new ConnectToDB();
			
			Employee i_emp = i_Connect.SearchEmploee(m_updateEmployee.GetManagerID(), job.Manager); 
			Manager i_Manager = (Manager)i_emp;
			 Employee i_Employee = EmployeeFactory.creatEmployee(m_updateEmployee.getTextName(), m_updateEmployee.getManager().getSelectedID(), m_updateEmployee.getTextHourlyWage(),m_updateEmployee.getTextMonthlyHours(), job.valueOf(m_updateEmployee.getComboBoxJob()));
			i_Employee.setMounthlyHours(m_updateEmployee.getTextMonthlyHours());
			 i_Manager.UpdateEmployee(i_Employee);
			i_Connect.Connect().close();
			m_updateEmployee.finished();
		}
		else if(e.getActionCommand().equals("Cancel")) {
			m_updateEmployee.finished();
		}
		}
		catch(Exception ex) {
			ErrorWindow i_Error = new ErrorWindow(ex.getMessage());
			i_Error.getFrame().setVisible(true);
		}
	}
}

