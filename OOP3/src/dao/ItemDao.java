package dao;

import java.util.Collection;
import java.util.Date;

import entity.Item;

// SCHLECHT: Wird nie verwendet
public interface ItemDao {

	public Collection<Item> getItems(Date start, Date end);

	public void createItem(Item item);

	public void deleteItem(Item item);
}
