package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.ConnectToDB;
import Model.Employee;
import Model.Manager;
import Model.job;
import View.CalculateWage;
import View.ErrorWindow;

public class CalculateWageController implements ActionListener {
	private CalculateWage m_CalcWage;
	public CalculateWageController(CalculateWage i_CalcWage) {
		m_CalcWage=i_CalcWage;
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getActionCommand().equals("Calculate")) {
				ConnectToDB i_Connect = new ConnectToDB();
				Employee i_emp = i_Connect.SearchEmploee(m_CalcWage.GetManagerID(), job.Manager); 
				Manager i_Manager = (Manager)i_emp;
				ResultSet WageTable = i_Manager.ReturnWageTable();
				this.CreateWageReport(WageTable);
				i_Connect.Connect().close();
				m_CalcWage.finished();
			}
			else if(e.getActionCommand().equals("Cancel")){
				m_CalcWage.finished();
			}
		}
		catch(Exception ex) {
			ErrorWindow i_Error = new ErrorWindow(ex.getMessage());
			i_Error.getFrame().setVisible(true);
		}
	}
	
	public void CreateWageReport(ResultSet i_WageTable) throws Exception {
		
		FileWriter fstream = new FileWriter("WageFile.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		out.write("Name\tID\tWage\t");
		out.newLine();
		while (i_WageTable.next()) { 
			out.write(i_WageTable.getString("Name") + "\t");
	        out.write(i_WageTable.getString("ID") + "\t");
	        out.write(Float.toString(i_WageTable.getFloat("Wage")) + "\t");
	        out.newLine();
		}
		out.close();
	}

}
