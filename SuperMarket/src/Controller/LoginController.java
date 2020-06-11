package Controller;
import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener{
	private UserLogin m_UserLogin;
	
	public LoginController(UserLogin i_UserLogin) {
		m_UserLogin = i_UserLogin;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		if(e.getActionCommand().equals("OK")) {
			ConnectToDB i_Connect = new ConnectToDB();
			
			Employee i_emp = i_Connect.SearchEmploee(m_UserLogin.getIDField().getText(), job.valueOf(m_UserLogin.getJob())); 
			m_UserLogin.SelectJobWindow(m_UserLogin.getIDField().getText(), m_UserLogin.getJob());
		}
		else if(e.getActionCommand().equals("Cancel")) {
			m_UserLogin.CancleClicked();
		}
		}
		catch (Exception ex) {
			ErrorWindow i_Error = new ErrorWindow(ex.getMessage());
			i_Error.getFrame().setVisible(true);
		}
	}
}
