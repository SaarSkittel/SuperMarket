package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Controller.EmployeeTabelController;
import Controller.UpdateEmployeeController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;

public class UpdateEmployee {

	private JFrame frame;
	private EmployeeManager m_Manager;
	private JTextField textName;
	private JTextField textHourlyWage;
	private JTextField textMonthlyHours;
	private String [] Jobs=  {"Manager" , "Storekeeper","StoreWorker"};
	private JComboBox comboBoxJob;
	public UpdateEmployee(EmployeeManager i_Manager) {
		m_Manager = i_Manager;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 784, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		UpdateEmployeeController i_UpdateController= new UpdateEmployeeController(this);
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(58, 58, 46, 14);
		frame.getContentPane().add(lblID);
		
		JLabel lblEmploeeID = new JLabel(m_Manager.getSelectedID());
		lblEmploeeID.setBounds(114, 58, 46, 14);
		frame.getContentPane().add(lblEmploeeID);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(58, 101, 46, 14);
		frame.getContentPane().add(lblName);
		
		textName = new JTextField();
		textName.setText(m_Manager.getSelectedName());
		textName.setBounds(99, 98, 86, 20);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		JLabel lblJob = new JLabel("Job:");
		lblJob.setBounds(42, 141, 46, 14);
		frame.getContentPane().add(lblJob);
		
		comboBoxJob = new JComboBox();
		comboBoxJob.addItem(Jobs[0]);
		comboBoxJob.addItem(Jobs[1]);
		comboBoxJob.addItem( Jobs[2]);
		comboBoxJob.setSelectedItem(m_Manager.getSelectedJob());
		comboBoxJob.setBounds(99, 138, 101, 20);
		frame.getContentPane().add(comboBoxJob);
		
		JLabel lblHourlyWage = new JLabel("Hourly Wage:");
		lblHourlyWage.setBounds(286, 58, 77, 20);
		frame.getContentPane().add(lblHourlyWage);
		
		textHourlyWage = new JTextField();
		textHourlyWage.setText(Float.toString(m_Manager.getSelectHourlyWage()));
		textHourlyWage.setBounds(373, 58, 86, 20);
		frame.getContentPane().add(textHourlyWage);
		textHourlyWage.setColumns(10);
		
		JLabel lblMonthlyHours = new JLabel("Monthly Hours:");
		lblMonthlyHours.setBounds(297, 104, 92, 20);
		frame.getContentPane().add(lblMonthlyHours);
		
		textMonthlyHours = new JTextField();
		textMonthlyHours.setText(Float.toString(m_Manager.getSelectMonthlyHours()));
		textMonthlyHours.setBounds(373, 104, 86, 20);
		frame.getContentPane().add(textMonthlyHours);
		textMonthlyHours.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(133, 455, 89, 23);
		frame.getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(i_UpdateController);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(318, 455, 89, 23);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(i_UpdateController);
		frame.setVisible(true);
	}
	
	public String getTextName() {
		return textName.getText();
	}

	public float getTextHourlyWage() {
		return Float.parseFloat(textHourlyWage.getText());
	}

	public float getTextMonthlyHours() {
		return Float.parseFloat(textMonthlyHours.getText());
	}

	public String getComboBoxJob() {
		return comboBoxJob.getSelectedItem().toString();
	}

	public EmployeeManager getManager() {
		return m_Manager;
	}
	public String GetManagerID() {
		return m_Manager.getID();
	}
	public void finished() {
		frame.dispose();
		EmployeeTabelController.setTable(m_Manager, m_Manager.getID());
	}
	
}
