package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.ConnectToDB;
import Model.Employee;

import Model.ItemFactory;

import Model.Storekeeper;
import Model.job;

import View.AddItem;
import View.ErrorWindow;

public class AddItemController  implements ActionListener {
	private AddItem m_addItem;
	public AddItemController(AddItem i_addItem) {
		m_addItem = i_addItem;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			
		if(e.getActionCommand().equals("Add")) {
			ConnectToDB i_Connect = new ConnectToDB();
			Employee i_emp = i_Connect.SearchEmploee(m_addItem.getID(), job.Storekeeper); 
			Storekeeper i_Storekeeper = (Storekeeper)i_emp;
			i_Storekeeper.AddItem(ItemFactory.CreateNewItem(m_addItem.getBarcode(), m_addItem.getName(), m_addItem.getAvailableInWarehouse(), m_addItem.getMaxStockWarehouse()));
			i_Connect.Connect().close();
			m_addItem.finished();
		}
		else if(e.getActionCommand().equals("Cancel")) {
			m_addItem.finished();
		}
		}
		catch (Exception ex) {
			ErrorWindow i_Error = new ErrorWindow(ex.getMessage());
			i_Error.getFrame().setVisible(true);
		}
	}

}
