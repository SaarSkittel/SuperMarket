package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.AddItemController;
import Controller.EmployeeTabelController;
import Controller.WarehouseTableController;

import javax.swing.JButton;

public class AddItem {

	private JFrame frmAddItem;
	
	private JTextField textBarcode;
	private JTextField textName;
	private JTextField textAvailableInWarehouse;
	private JTextField textMaxStockWarehouse;
	private WarehouseManager m_Manager;
	public AddItem(WarehouseManager i_Manager) {
		m_Manager = i_Manager;
		initialize();
	}

	private void initialize() {
		AddItemController i_Controller = new AddItemController(this);
		frmAddItem = new JFrame();
		frmAddItem.setTitle("Add Item");
		frmAddItem.setBounds(100, 100, 818, 566);
		frmAddItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddItem.getContentPane().setLayout(null);
		frmAddItem.setVisible(true);
		JLabel lblBarcode = new JLabel("Barcode:");
		lblBarcode.setBounds(56, 74, 46, 14);
		frmAddItem.getContentPane().add(lblBarcode);
		
		textBarcode = new JTextField();
		textBarcode.setBounds(103, 71, 86, 20);
		frmAddItem.getContentPane().add(textBarcode);
		textBarcode.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(56, 132, 46, 14);
		frmAddItem.getContentPane().add(lblName);
		
		textName = new JTextField();
		textName.setBounds(103, 129, 86, 20);
		frmAddItem.getContentPane().add(textName);
		textName.setColumns(10);
		
		JLabel lblAvailableInWarehouse = new JLabel("Available In Warehouse:");
		lblAvailableInWarehouse.setBounds(10, 191, 131, 14);
		frmAddItem.getContentPane().add(lblAvailableInWarehouse);
		
		textAvailableInWarehouse = new JTextField();
		textAvailableInWarehouse.setBounds(134, 188, 86, 20);
		frmAddItem.getContentPane().add(textAvailableInWarehouse);
		textAvailableInWarehouse.setColumns(10);
		
		JLabel lblMaxStockWarehouse = new JLabel("Max Stock In Warehouse:");
		lblMaxStockWarehouse.setBounds(33, 243, 131, 14);
		frmAddItem.getContentPane().add(lblMaxStockWarehouse);
		
		textMaxStockWarehouse = new JTextField();
		textMaxStockWarehouse.setBounds(172, 240, 86, 20);
		frmAddItem.getContentPane().add(textMaxStockWarehouse);
		textMaxStockWarehouse.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(i_Controller);
		btnAdd.setBounds(134, 464, 89, 23);
		frmAddItem.getContentPane().add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(i_Controller);
		btnCancel.setBounds(467, 464, 89, 23);
		frmAddItem.getContentPane().add(btnCancel);
	}
	public void finished() {
		frmAddItem.dispose();
		WarehouseTableController.setTable(m_Manager, m_Manager.getID());
		
	}
	public String getID() {
		return m_Manager.getID();
	}

	
	public String getBarcode() {
		return textBarcode.getText();
	}

	public String getName() {
		return textName.getText();
	}

	public int getAvailableInWarehouse() {
		return Integer.valueOf(textAvailableInWarehouse.getText());
	}

	public int getMaxStockWarehouse() {
		return Integer.valueOf(textMaxStockWarehouse.getText());
	}
	
}
