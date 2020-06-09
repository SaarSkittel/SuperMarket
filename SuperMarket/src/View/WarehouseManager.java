package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class WarehouseManager extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarehouseManager frame = new WarehouseManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WarehouseManager() {
		setTitle("Store Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1045, 753);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddNewItem = new JButton("Add New Item");
		btnAddNewItem.setBounds(880, 80, 139, 36);
		contentPane.add(btnAddNewItem);
		
		JButton btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.setBounds(880, 127, 139, 36);
		contentPane.add(btnDeleteItem);
		
		JButton btnUpdateItemQuantity = new JButton("Update Item Quantity");
		btnUpdateItemQuantity.setBounds(880, 174, 139, 36);
		contentPane.add(btnUpdateItemQuantity);
		
		JButton btnDisplayItem = new JButton("Display Items In Stock");
		btnDisplayItem.setBounds(880, 221, 139, 36);
		contentPane.add(btnDisplayItem);
		
		JButton btnOrderItems = new JButton("Order Items");
		btnOrderItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrderItems.setBounds(880, 268, 139, 36);
		contentPane.add(btnOrderItems);
		
		table = new JTable();
		table.setBounds(46, 80, 783, 536);
		contentPane.add(table);
	}

}
