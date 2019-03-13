package Tests;

import static org.junit.Assert.*;

import org.junit.Test;
import controlLayer.ItemController;
import modelLayer.Item;
import modelLayer.ItemContainer;

/**
 * 
 * All test should be run independently
 *
 */
public class ItemControllerTest {
	ItemContainer itemContainer = ItemContainer.getInstance();
	ItemController itemController = new ItemController();
	
	
	@Test
	public void createItemAndAddItToTheContainer() {		
		itemController.createItem(20, "This is a nail", "Nail", "FHN", true, 100);
		assertEquals(1, itemContainer.getAllItems().size());
	}

	@Test
	public void addQuantityToItemAndRemoveAgain(){
		Item item = itemController.createItem(25, "This is not a nail", "NotNail", "NFHN", true, 0);
		
		itemController.addQuantityToItem(item, 20000);
		assertEquals(20000, itemController.findItemByName("NotNail").getQuantity());
		itemController.removeQuantity(item, 21000);
		System.out.println(itemController.findItemByName("NotNail").getQuantity());
		assertEquals(20000, itemController.findItemByName("NotNail").getQuantity());
		itemController.removeQuantity(item, 20000);
		assertEquals(0, itemController.findItemByName("NotNail").getQuantity());
	}
	
	@Test
	public void updateItemAndChangeActivityTest() {
		itemController.createItem(20, "Nice", "yes", "ThisCantBeChanged", true, 0);
		
		itemController.updateItem(itemController.findItemByName("yes"), 10, "This is a screw.", "Screw", true);
		assertEquals("Screw", itemController.findItemByName("Screw").getName());
		System.out.println(itemController.findItemByName("Screw").isActive());
		itemController.setActivity(itemController.findItemByName("Screw"));
		assertFalse(itemController.findItemByName("Screw").isActive());
	}
}
