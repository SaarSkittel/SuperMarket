package View;
import Model.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.Console;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.util.*;
public class MainWindow {

	private JFrame frmMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		/*try {
		Model.ConnectToDB c = new Model.ConnectToDB();
		ArrayList<Employee> em = c.GetEmployeesList();
		for(int i = 0; i < em.size();++i ) {
			System.out.println(em.get(i).getName());
		}
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}*/
		
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
		frmMainMenu = new JFrame();
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.setBounds(100, 100, 450, 424);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.setVisible(true);
		JButton btnManager = new JButton("Manager");
		btnManager.setBounds(110, 76, 194, 52);
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogin i_Login = new UserLogin("Manager");
				i_Login.setVisible(true);
				frmMainMenu.dispose();
			}
		});
		frmMainMenu.getContentPane().setLayout(null);
		frmMainMenu.getContentPane().add(btnManager);
		
		JButton btnStorekeeper = new JButton("Storekeeper");
		btnStorekeeper.setBounds(110, 141, 194, 64);
		btnStorekeeper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogin i_Login = new UserLogin("Storekeeper");
				i_Login.setVisible(true);
				frmMainMenu.dispose();
			}
		});
		frmMainMenu.getContentPane().add(btnStorekeeper);
		
		JButton btnStoreWoker = new JButton("Store Worker");
		btnStoreWoker.setBounds(110, 226, 194, 64);
		btnStoreWoker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogin i_Login = new UserLogin("StoreWorker");
				i_Login.setVisible(true);
				frmMainMenu.dispose();
			}
		});
		frmMainMenu.getContentPane().add(btnStoreWoker);
	}

}
