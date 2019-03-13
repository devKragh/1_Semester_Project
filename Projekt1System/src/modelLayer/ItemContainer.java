package modelLayer;

import java.util.ArrayList;

public class ItemContainer {
	private ArrayList<Item> items;
	private static ItemContainer instance;
	
	private ItemContainer() {
		items = new ArrayList<>();
	}
	
	public static ItemContainer getInstance() {
		if(instance == null) {
			instance = new ItemContainer();
		}
		return instance;
	}
	
	public Item addItem(Item item) {
		items.add(item);
		return item;		
	}
	
	public ArrayList<Item> getAllItems(){
		return new ArrayList<Item>(items);
	}
	
	public Item getItemByName(String name) {
		Item res = null; 
		for(Item element: items) {
			if(element.getName().equals(name) == true) {
				res = element;
			}
		}
		return res; 
	}
}
