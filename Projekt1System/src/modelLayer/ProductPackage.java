package modelLayer;

import java.util.ArrayList;

public class ProductPackage extends Item{
	private ArrayList<Item> items;

	public ProductPackage(double price, String description, String name, String barcode, boolean active, int quantity) {
		super(price, description, name, barcode, active, quantity);
		items = new ArrayList<>();
	}
	
	public Item addProduct(Product product) {
		items.add(product);
		return product;
	}
	
	public Item addProductPackage(ProductPackage productPackage) {
		items.add(productPackage);
		return productPackage;
	}
	
	public ArrayList<Item> getPackageList(){
		return new ArrayList<Item>(items);
	}
}
