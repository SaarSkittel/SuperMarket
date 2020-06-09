package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JList;
import javax.swing.JTable;

public class StoreManager extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreManager frame = new StoreManager();
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
	public StoreManager() {
		setTitle("Store Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1077, 738);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUpadeItemQuantity = new JButton("Upade Item Quantity");
		btnUpadeItemQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpadeItemQuantity.setBounds(888, 83, 146, 37);
		contentPane.add(btnUpadeItemQuantity);
		
		JButton btnDisplayItemQuantity = new JButton("Display Item Quantity");
		btnDisplayItemQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDisplayItemQuantity.setBounds(888, 146, 146, 37);
		contentPane.add(btnDisplayItemQuantity);
		
		JButton btnOrderItem = new JButton("Order Item");
		btnOrderItem.setBounds(888, 206, 146, 37);
		contentPane.add(btnOrderItem);
		
		table = new JTable();
		table.setBounds(74, 69, 772, 528);
		contentPane.add(table);
	}
}
