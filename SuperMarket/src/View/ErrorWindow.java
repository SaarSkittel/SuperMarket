package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErrorWindow {

	private JFrame frame;

	
	public ErrorWindow(String i_ErrorMsg) {
		initialize(i_ErrorMsg);
	}

	
	private void initialize(String i_ErrorMsg) {
		frame = new JFrame();
		frame.setBounds(100, 100, 534, 245);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(i_ErrorMsg);
		lblNewLabel.setBounds(12, 26, 492, 75);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(195, 114, 112, 43);
		frame.getContentPane().add(btnNewButton);
	}


	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	
}
