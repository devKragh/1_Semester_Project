package uiLibary;

import modelLayer.Item;

public class ItemRenderer implements ListRenderer<Item> {

	@Override
	public String display(Item t) {
		String res = t.getName();
		return res;
	}

}
