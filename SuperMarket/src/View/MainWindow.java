package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnManager = new JButton("Manager");
		btnManager.setBounds(146, 93, 113, 35);
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserLogin().setVisible(true);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnManager);
		
		JButton btnStorekeeper = new JButton("Storekeeper");
		btnStorekeeper.setBounds(134, 166, 145, 35);
		btnStorekeeper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserLogin().setVisible(true);
			}
		});
		frame.getContentPane().add(btnStorekeeper);
		
		JButton btnStoreWoker = new JButton("Store Worker");
		btnStoreWoker.setBounds(134, 226, 155, 35);
		btnStoreWoker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserLogin().setVisible(true);
			}
		});
		frame.getContentPane().add(btnStoreWoker);
	}

}
