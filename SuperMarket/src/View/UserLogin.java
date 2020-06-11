package View;
import Controller.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.print.DocFlavor.STRING;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField IDField;
	private String m_Job;
	
	
	public UserLogin(String i_Job) {
		setTitle("Login Page");
		m_Job=i_Job;
		LoginController i_LoginController = new LoginController(this);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter ID:");
		lblNewLabel.setBounds(31, 55, 92, 26);
		contentPanel.add(lblNewLabel);
		
		IDField = new JTextField();
	
		IDField.setBounds(129, 52, 186, 32);
		contentPanel.add(IDField);
		IDField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(i_LoginController);			
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(i_LoginController);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void SelectJobWindow(String i_ID, String i_Job) {
		dispose();
		if(i_Job == "Manager") {
			EmployeeManager i_Manager = new EmployeeManager(i_ID);
		}
		else if (i_Job == "Storekeeper") {
			WarehouseManager i_WarehouseManager = new WarehouseManager(i_ID);
		}
		else if(i_Job == "StoreWorker") {
			StoreManager i_StroeManager = new StoreManager(i_ID);
		}
	}
	public void CancleClicked() {
		MainWindow i_Main = new MainWindow();
		dispose();
	}
	public String getJob() {
		return m_Job;
	}


	public void setJob(String i_Job) {
		this.m_Job = i_Job;
	}


	public JTextField getIDField() {
		return IDField;
	}


	public void setIDField(JTextField iDField) {
		IDField = iDField;
	}
	
}
