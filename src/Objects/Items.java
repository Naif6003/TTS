package Objects;


public class Items {
	int itemId;
	String itemName;
	String itemDescription;
	public User user;
	public int userId;
	String itemPhoto;
	
	public Items(int itemId, String itemName, String itemDescription, User user) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.user = user;
	}
	public Items(int itemId, String itemName, String itemDescription, int userId) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.userId = userId;
	}

	public Items(int itemId, String itemName, String itemDescription, String itemPhoto) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPhoto = itemPhoto;
	}
	
	 public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getItemPhoto() {
			return itemPhoto;
		}
		public void setItemPhoto(String itemPhoto) {
			this.itemPhoto = itemPhoto;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	
	
}
