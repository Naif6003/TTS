package Objects;

public class Items {

	int item_id;
	String item_name;
	String item_description;
	Boolean item_exist;
	
	
	public Items(int item_id, String item_name, String item_description, Boolean item_exist) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_description = item_description;
		this.item_exist = item_exist;
	}
	
	
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_description() {
		return item_description;
	}
	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}
	public Boolean getItem_exist() {
		return item_exist;
	}
	public void setItem_exist(Boolean item_exist) {
		this.item_exist = item_exist;
	}
}
