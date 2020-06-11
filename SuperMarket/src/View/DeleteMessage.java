package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.DeleteEmployeeController;
import Controller.EmployeeTabelController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteMessage {

	private JFrame frame;
	private EmployeeManager m_Manager;

	
	public DeleteMessage(EmployeeManager i_Manager) {
		m_Manager= i_Manager;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		DeleteEmployeeController i_DeleteController = new DeleteEmployeeController(this); 
		JLabel lblDeleteMsg = new JLabel("Are you sure you want to delete employee?");
		lblDeleteMsg.setBounds(107, 98, 259, 39);
		frame.getContentPane().add(lblDeleteMsg);
		
		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(i_DeleteController);
		btnYes.setBounds(52, 211, 99, 23);
		frame.getContentPane().add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(i_DeleteController);
		btnNo.setBounds(277, 211, 118, 23);
		frame.getContentPane().add(btnNo);
		frame.setVisible(true);
	}
	public String GetManagerID() {
		return m_Manager.getID();
	}
	public String GetSelectedId() {
		return m_Manager.getSelectedID();
	}
	public void finished() {
		frame.dispose();
		EmployeeTabelController.setTable(m_Manager, m_Manager.getID());
		
	}
}
