package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import Controller.StoreTableController;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StoreManager {

	private JFrame frmStoreManager;
	private JTable table;
	private String m_ID;
	private JButton btnUpdate;
	private String m_Barcode;
	private String m_Name;
	private float m_Price;
	private int m_MaxStockStore;
	private int m_AvailableInStore;
	public StoreManager(String i_ID) {
		m_ID = i_ID;
		initialize();
	}

	
	private void initialize() {
		frmStoreManager = new JFrame();
		frmStoreManager.setTitle("Store Manager");
		frmStoreManager.setBounds(100, 100, 788, 543);
		frmStoreManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStoreManager.getContentPane().setLayout(null);
		frmStoreManager.setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 36, 545, 408);
		frmStoreManager.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				m_Barcode=table.getModel().getValueAt(row, 0).toString();
				m_Name=table.getModel().getValueAt(row, 1).toString();
				m_Price= Float.valueOf(table.getModel().getValueAt(row, 2).toString());
				m_AvailableInStore = Integer.valueOf(table.getModel().getValueAt(row, 0).toString());
				m_MaxStockStore=Integer.valueOf(table.getModel().getValueAt(row, 4).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		btnUpdate = new JButton("New button");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBounds(650, 66, 89, 23);
		frmStoreManager.getContentPane().add(btnUpdate);
		StoreTableController.setTable(this, m_ID);
	}
	public JTable gettable(){
		return this.table;
	}
}
