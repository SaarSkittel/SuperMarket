package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.CalculateWageController;
import Controller.DeleteEmployeeController;
import Controller.EmployeeTabelController;

import javax.swing.JButton;

public class CalculateWage {

	private JFrame frame;
	private EmployeeManager m_Manager;

	public CalculateWage(EmployeeManager i_Manager) {
		m_Manager= i_Manager;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 362, 236);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		CalculateWageController i_CalculateController = new CalculateWageController(this); 
		JLabel lblCalculateMsg = new JLabel("Are you sure?");
		lblCalculateMsg.setBounds(134, 48, 164, 14);
		frame.getContentPane().add(lblCalculateMsg);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(i_CalculateController);
		btnCalculate.setBounds(61, 112, 89, 23);
		frame.getContentPane().add(btnCalculate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(i_CalculateController);
		btnCancel.setBounds(181, 112, 89, 23);
		frame.getContentPane().add(btnCancel);
		this.frame.setVisible(true);
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
