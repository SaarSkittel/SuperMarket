package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class EmployeeManager {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeManager window = new EmployeeManager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 706);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnCalculateWages = new JButton("Calculate Wages");
		btnCalculateWages.setBounds(132, 78, 141, 35);
		btnCalculateWages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnCalculateWages);
		
		JButton btnDisplayEmployeeSInfo = new JButton("Display Employees Information");
		btnDisplayEmployeeSInfo.setBounds(117, 153, 188, 47);
		btnDisplayEmployeeSInfo.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(btnDisplayEmployeeSInfo);
		
		JButton btnUpdateEmployeeInfo = new JButton("Update Employee Information");
		btnUpdateEmployeeInfo.setBounds(124, 240, 181, 40);
		btnUpdateEmployeeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnUpdateEmployeeInfo);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setBounds(139, 318, 134, 35);
		frame.getContentPane().add(btnAddEmployee);
		
		JButton btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteEmployee.setBounds(151, 393, 122, 35);
		frame.getContentPane().add(btnDeleteEmployee);
	}
}
