import java.util.HashMap;
import java.util.Scanner;
/**
 * Stores information about a PromotionalSet inherit from{@link MenuItem} class to used in context of a menu.
 * This class stores the name, price, description of PromotionalSet {@link MenuMgr},
 * and uses HashMap to keep track of the items in PromotionalSet.
 * it also provide various method to add/remove/update the content of the PromotionalSet.
 *
 * @see         HashMap
 *
 * @author
 * @since 2021-11-5
 */
public class PromotionalSet extends MenuItem {

	private transient Scanner sc = new Scanner(System.in);

	/**
	 * HashMap that is used to keep track of the items in PromotionalSet
	 */
	private HashMap<String, Integer> items;
	
	/**
	 * Constructs a PromotionalSet with default name, price, description and type.
	 */
	PromotionalSet() {
		super("unknown", "unknown", 0);
		items = new HashMap<>();
	}
	
	/**
	 * Constructs a PromotionalSet with specific name, price, description and type.
	 *
	 * @param	name		name of the promotional set
	 * @param	description	description of the promotional set
	 * @param	price		price of the promotional set
	 */
	PromotionalSet(String name, String description, double price) {
		super(name, description, price);
		this.items = new HashMap<>();
	}
	
	/**
	 * Add an existing item in Menu into PromotionaLSet
	 *
	 * @param itemName	name of the existing item in Menu to be added into PromotionalSet
	 * @param quantity	The quantity of that certain item to be added in
	 */
	public void addItemToPromotionalSet(String itemName, int quantity) {
		this.items.putIfAbsent(itemName,quantity);
		System.out.println("Item Added!");
	}
	
	/**
	 * Remove a certain item from PromotionaLSet
	 *
	 * @param itemName	name of the item  to be removed from PromotionalSet
	 */
	public void removeItemFromPromotionalSet(String itemName) {
		if (items.containsKey(itemName)) {
			items.remove(itemName);
			System.out.println("Item Removed!");
		}
		else {
			System.out.println("No such item in Promotional Set");
		}
	}
	
	/**
	 * Update the quantity of certain item in PromotionaLSet
	 *
	 * @param itemName		name of the item to be updated in PromotionalSet
	 * @param updatedQuantity 	the updated quantity of the certain item in PromotionalSet
	 */
	public void updateItemInPromotionalSet(String itemName, int updatedQuantity) {
		if (items.containsKey(itemName)) {
			items.replace(itemName,updatedQuantity);
			System.out.println("Item Updated!");
		}
		else {
			System.out.println("No such item in Promotional Set");
		}
	}
	/**
	 * Print the items and their quantity in this PromotionalSet
	 */
	public void printPromotionalSetListOfItems() {
		System.out.println("-Contents-");
		items.entrySet().forEach(
				entry -> { System.out.println(entry.getKey() + " " + entry.getValue());
		});
	}
	/**
	 * Print all the items in this PromotionalSet which overrides the
	 * method from the abstract class {@link MenuItem}
	 */
	@Override
	public void print() {
		super.print();
		printPromotionalSetListOfItems();
	}


}
