package View;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JTable;

import Controller.EmployeeTabelController;
import Controller.WarehouseTableController;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WarehouseManager {

	private JFrame frame;
	private JTable table;
	private String m_ID;
	private String m_Barcode;
	private String m_Name;
	private float m_Price;
	private int m_MaxStockWarehouse;
	private int m_AvailableInWarehouse;
	
	public WarehouseManager(String i_ID) {
		m_ID=i_ID;
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 917, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 46, 628, 458);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				m_Barcode=table.getModel().getValueAt(row, 0).toString();
				m_Name=table.getModel().getValueAt(row, 1).toString();
				m_Price= Float.valueOf(table.getModel().getValueAt(row, 2).toString());
				m_AvailableInWarehouse = Integer.valueOf(table.getModel().getValueAt(row, 0).toString());
				m_MaxStockWarehouse=Integer.valueOf(table.getModel().getValueAt(row, 4).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Add New Item");
		btnAdd.setBounds(679, 60, 166, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnUpdate = new JButton("Update Item Quantity");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBounds(679, 94, 166, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnOrder = new JButton("Order Items");
		btnOrder.setBounds(679, 128, 166, 23);
		frame.getContentPane().add(btnOrder);
		
		JButton btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteItem.setBounds(679, 161, 166, 23);
		frame.getContentPane().add(btnDeleteItem);
		WarehouseTableController.setTable(this,m_ID);
	}
	public JTable gettable(){
		return this.table;
	}
}
