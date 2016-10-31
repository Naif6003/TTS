package Objects;


public class Items {
	int itemId;
	String itemName;
	String itemDescription;
	User user;
	
	public Items(int itemId, String itemName, String itemDescription, User user) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.user = user;
	}
	public Items(int itemId, String itemName, String itemDescription) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
	}

	
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	
	
	
}
