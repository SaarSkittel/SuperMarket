package com.supermarket.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.supermarket.models.ConnectToDB;
import com.supermarket.models.DBSingleton;
import com.supermarket.models.Employee;
import com.supermarket.models.Item;
import com.supermarket.models.ItemFactory;
import com.supermarket.models.StoreWorker;
import com.supermarket.models.job;
import com.supermarket.views.ErrorWindow;
import com.supermarket.views.OrderItemStore;
import com.supermarket.views.UserLogin;



public class OrderItemStoreController implements ActionListener {
	private  OrderItemStore m_OrderItemStore;
	
	public OrderItemStoreController(OrderItemStore i_OrderItemStore) {
		m_OrderItemStore = i_OrderItemStore;	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		if(e.getActionCommand().equals("Order")) {
			//ConnectToDB i_Connect = new ConnectToDB();			
			//Employee i_emp = i_Connect.SearchEmploee(m_OrderItemStore.GetStoreWorkerID(), job.StoreWorker); 
			Employee i_emp = DBSingleton.getInstance().Database.SearchEmploee(m_OrderItemStore.GetStoreWorkerID(), job.StoreWorker); 
			StoreWorker i_StoreWorker = (StoreWorker)i_emp;
			Item i_Item = ItemFactory.CreateNewStoreItem(m_OrderItemStore.getBarcodeValue(),m_OrderItemStore.getNameValue(),m_OrderItemStore.getManager().getSelectedPrice(),m_OrderItemStore.getAvailableInStore(),m_OrderItemStore.getMaxStockStore());
			i_StoreWorker.OrderItem(i_Item, m_OrderItemStore.getAmountToOrder());
			//i_Connect.Connect().close();
			m_OrderItemStore.finished();
		}
		else if(e.getActionCommand().equals("Cancel")) {
			m_OrderItemStore.finished();
		}
		}
		catch(Exception ex) {
			ErrorWindow i_Error = new ErrorWindow(ex.getMessage());
			i_Error.getFrame().setVisible(true);
		}
	}
	public int ReturnMaxOrder(String i_Barcode) throws Exception{
		Employee i_emp = DBSingleton.getInstance().Database.SearchEmploee(m_OrderItemStore.GetStoreWorkerID(), job.StoreWorker); 
		StoreWorker i_StoreWorker = (StoreWorker)i_emp;
		return i_StoreWorker.ReturnMaxOrder(i_Barcode);
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
        	i_ValueToReturn = 0;
        }
        else {
        	i_ValueToReturn= i_TableFromDB.getInt("StoreOrder");
        }
        i_Statement.close();
        i_DB.Connect().close();
       return i_ValueToReturn;
   }*/
}
