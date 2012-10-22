package dao;

import java.util.Collection;
import java.util.Date;

import entity.Item;

public interface ItemDao {

	/**
	 * returns all items (costs and salary) in the given time
	 * 
	 * @param start
	 *            startdate
	 * @param end
	 *            enddate
	 * @return Collection of items
	 */
	public Collection<Item> getItems(Date start, Date end);

	/**
	 * creates a new Item
	 * 
	 * @param item
	 */
	public void createItem(Item item);

	/**
	 * deletes an item
	 * 
	 * @param item
	 */
	public void deleteItem(Item item);
}
