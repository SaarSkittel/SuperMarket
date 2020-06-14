package Model;

public class ItemFactory {
public static Item CreateNewItem(String i_Barcode,String i_Name,int i_AvailableInWarehouse,int i_MaxStockWarehouse) {
	Item i_NewItem = new Item(i_Name, i_Barcode, 0, 0, i_MaxStockWarehouse, 0, i_AvailableInWarehouse);
	return i_NewItem;
}
}
