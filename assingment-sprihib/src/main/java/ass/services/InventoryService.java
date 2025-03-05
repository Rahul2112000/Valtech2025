package ass.services;
 
import java.util.List;
 
import ass.classes.Item;
 
 
public interface InventoryService {

	void addInventory(Item item);

	Item getInventory(int id);

	List<Item> getAll();

	void updateInventory(Item item);

	void deleteInventory(int id);

	void removeItem(int id, int i);

	void reorderItem(Item item);

}
 