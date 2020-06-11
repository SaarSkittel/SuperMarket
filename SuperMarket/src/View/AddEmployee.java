package View;
import Controller.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import Model.job;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEmployee {

	private JFrame frmAddEmployee;
	private JTextField textHourlyWageField;
	private JTextField textNameField;
	private JTextField textIDField;
	private JComboBox comboBoxJob;
	private EmployeeManager m_Manager;

	/**
	 * Create the application.
	 */
	public AddEmployee(EmployeeManager i_Manager) {
		m_Manager = i_Manager; 
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AddEmployeeController i_AddEmployeeController = new AddEmployeeController(this);
		frmAddEmployee = new JFrame();
		frmAddEmployee.setTitle("Add Employee");
		frmAddEmployee.setBounds(100, 100, 412, 345);
		frmAddEmployee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddEmployee.getContentPane().setLayout(null);
		frmAddEmployee.setVisible(true);
		
		JLabel lblID = new JLabel("ID");
		lblID.setHorizontalAlignment(SwingConstants.TRAILING);
		lblID.setBounds(23, 38, 50, 35);
		frmAddEmployee.getContentPane().add(lblID);
		
		JLabel lblHourlyWage = new JLabel("HourlyWage");
		lblHourlyWage.setHorizontalAlignment(SwingConstants.LEFT);
		lblHourlyWage.setBounds(23, 134, 72, 35);
		frmAddEmployee.getContentPane().add(lblHourlyWage);
		
		JLabel lblJob = new JLabel("Job");
		lblJob.setBounds(54, 182, 50, 35);
		frmAddEmployee.getContentPane().add(lblJob);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(43, 86, 72, 35);
		frmAddEmployee.getContentPane().add(lblName);
		
		textHourlyWageField = new JTextField();
		textHourlyWageField.setBounds(116, 140, 116, 22);
		frmAddEmployee.getContentPane().add(textHourlyWageField);
		textHourlyWageField.setColumns(10);
		
		textNameField = new JTextField();
		textNameField.setBounds(116, 92, 116, 22);
		frmAddEmployee.getContentPane().add(textNameField);
		textNameField.setColumns(10);
		
		textIDField = new JTextField();
		textIDField.setBounds(116, 44, 116, 22);
		frmAddEmployee.getContentPane().add(textIDField);
		textIDField.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(i_AddEmployeeController);
		btnAdd.setBounds(72, 258, 97, 25);
		frmAddEmployee.getContentPane().add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(i_AddEmployeeController);
		
		btnCancel.setBounds(223, 258, 97, 25);
		frmAddEmployee.getContentPane().add(btnCancel);
		
		comboBoxJob = new JComboBox();
		comboBoxJob.setModel(new DefaultComboBoxModel(job.values()));
		comboBoxJob.setBounds(111, 188, 121, 29);
		frmAddEmployee.getContentPane().add(comboBoxJob);
	}

	public String getID() {
		return m_Manager.getID();
	}

	public JTextField getTextHourlyWageField() {
		return textHourlyWageField;
	}

	public JTextField getTextNameField() {
		return textNameField;
	}

	public JTextField getTextIDField() {
		return textIDField;
	}

	public JComboBox getComboBoxJob() {
		return comboBoxJob;
	}
	
	public void finished() {
		frmAddEmployee.dispose();
		EmployeeTabelController.setTable(m_Manager, m_Manager.getID());
		
	}
}
