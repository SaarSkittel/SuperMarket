package Model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

public class ItemDB {
	private String fileLocation;
	private Set<Item>ItemData;
	public ItemDB() {
		fileLocation="Item.dat";
		ObjectInputStream inputStream = null;
		try {
		 inputStream =new ObjectInputStream(new FileInputStream(fileLocation));
		 ItemData =(Set<Item>) inputStream.readObject();
		}
		catch(IOException  | ClassNotFoundException e){
			e.printStackTrace();
		} finally{
			try {
				inputStream.close();
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}
