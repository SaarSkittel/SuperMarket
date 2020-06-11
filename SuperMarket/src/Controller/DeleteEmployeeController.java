package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.ConnectToDB;
import Model.Employee;
import Model.Manager;
import Model.job;
import View.DeleteMessage;
import View.ErrorWindow;

public class DeleteEmployeeController implements ActionListener  {
	private DeleteMessage m_delMsg;
	public DeleteEmployeeController(DeleteMessage i_delMsg) {
		m_delMsg=i_delMsg;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getActionCommand().equals("Yes")) {
				ConnectToDB i_Connect = new ConnectToDB();
				Employee i_emp = i_Connect.SearchEmploee(m_delMsg.GetManagerID(), job.Manager); 
				Manager i_Manager = (Manager)i_emp;
				i_Manager.RemoveEmployee(m_delMsg.GetSelectedId());
				i_Connect.Connect().close();
				m_delMsg.finished();
			}
			else if(e.getActionCommand().equals("No")){
				m_delMsg.finished();
			}
		}
		catch(Exception ex) {
			ErrorWindow i_Error = new ErrorWindow(ex.getMessage());
			i_Error.getFrame().setVisible(true);
		}
	}
}
