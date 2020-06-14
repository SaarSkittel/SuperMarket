package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import View.AddItem;
import View.ErrorWindow;
import View.WarehouseManager;

public class WarehouseManagerController implements ActionListener{
	private WarehouseManager m_WarehouseManager;
	
	public WarehouseManagerController(WarehouseManager i_WarehouseManager) {
		m_WarehouseManager = i_WarehouseManager;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		if(e.getActionCommand().equals("Add New Item")) {
			AddItem i_addItem = new AddItem(m_WarehouseManager);
		}
		else if(e.getActionCommand().equals("Cancel")) {
			//m_addEmployee.cancelselected();
		}/*
		else if(e.getActionCommand().equals("Update Item Quantity")) {
			UpdateItemWarehouse i_updateItemWarehouse = new UpdateItemWarehouse(m_WarehouseManager);
		}
		else if(e.getActionCommand().equals("Order Items")) {
			OrderItemsWarehouse i_orderItemsWarehouse = new OrderItemsWarehouse (m_WarehouseManager);
		}
		else if(e.getActionCommand().equals("Delete Item")) {
			DeleteItem i_deleteItem = new DeleteItem(m_WarehouseManager);
		}*/
		else if (e.getActionCommand().equals("Refresh Table")) {
			WarehouseTableController.setTable(m_WarehouseManager, m_WarehouseManager.getID());
		}
		}
		catch (Exception ex) {
			ErrorWindow i_Error = new ErrorWindow(ex.getMessage());
			i_Error.getFrame().setVisible(true);
		}
	}
}
