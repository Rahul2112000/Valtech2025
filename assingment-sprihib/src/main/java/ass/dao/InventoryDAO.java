package ass.dao;

import java.util.List;

import ass.classes.Item;

public interface InventoryDAO {

	void addInventory(Item item);

	Item getInventory(int id);

	List<Item> getAll();

	void updateInventory(Item item);

	void deleteInventory(int id);

	Item getItem(int itemId);

	void updateItem(Item item);

}
