package com.supermarket.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.supermarket.models.ConnectToDB;
import com.supermarket.models.DBSingleton;
import com.supermarket.models.Employee;
import com.supermarket.models.ItemFactory;
import com.supermarket.models.Storekeeper;
import com.supermarket.models.job;
import com.supermarket.views.ErrorWindow;
import com.supermarket.views.OrderItemWarehouse;
import com.supermarket.views.UpdateItemWarehouse;

public class OrderItemWarehouseController implements ActionListener {
private OrderItemWarehouse m_orderItem;
	
	public OrderItemWarehouseController(OrderItemWarehouse i_orderItem) {
		m_orderItem = i_orderItem;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		if(e.getActionCommand().equals("Order")) {
			int i_AmountToOrder = m_orderItem.getAmountToOrder();
			//ConnectToDB i_Connect = new ConnectToDB();
			//Employee i_emp = i_Connect.SearchEmploee(m_orderItem.getManager().getID(), job.Storekeeper); 
			Employee i_emp = DBSingleton.getInstance().Database.SearchEmploee(m_orderItem.getManager().getID(), job.Storekeeper); 
			Storekeeper i_Storekeeper = (Storekeeper)i_emp;
			
			i_Storekeeper.OrderItem(ItemFactory.CreateNewItemWarehouse(m_orderItem.getBarcodeValue(), m_orderItem.getNameValue(), m_orderItem.getAvailableInWarehouse(), m_orderItem.getMaxStockWarehouse()), i_AmountToOrder);
			//i_Connect.Connect().close();
			m_orderItem.finished();
		}
		else if(e.getActionCommand().equals("Cancel")) {
			m_orderItem.finished();
		}
		}
		catch(Exception ex) {
			ErrorWindow i_Error = new ErrorWindow(ex.getMessage());
			i_Error.getFrame().setVisible(true);
		}
	
	}
	public int ReturnMaxOrder(String i_Barcode) throws Exception{
		Employee i_emp = DBSingleton.getInstance().Database.SearchEmploee(m_orderItem.getManager().getID(), job.Storekeeper); 
		Storekeeper i_Storekeeper = (Storekeeper)i_emp;
		return i_Storekeeper.ReturnMaxOrder(i_Barcode);
	}
	/*
	public static int ReturnMaxOrder(String i_Barcode) throws Exception{
		 ConnectToDB i_DB = new  ConnectToDB();
		 Connection i_Connection = i_DB.Connect();
		 String i_SqlMess = "SELECT * FROM Orders WHERE Barcode = ?";
		 PreparedStatement i_Statement =  i_Connection.prepareStatement(i_SqlMess);
		 i_Statement.setString(1, i_Barcode);
		 ResultSet i_TableFromDB = i_Statement.executeQuery();
		 int i_ValueToReturn;
		 		 
		 if(i_TableFromDB.isClosed()) {
			 i_ValueToReturn= 0;
		 }
		 else {
			 i_ValueToReturn= i_TableFromDB.getInt("WarehouseOrder");
		 }
		 i_Statement.close();
		 i_DB.Connect().close();
		 return i_ValueToReturn;
	}*/
}
