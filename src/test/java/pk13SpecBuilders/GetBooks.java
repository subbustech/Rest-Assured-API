package pk13SpecBuilders;

import java.util.List;

public class GetBooks {
	private String kind;
	private String totalItems;
	private List<GetItems> items;

	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public String getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(String totalItems) {
		this.totalItems = totalItems;
	}
	
	public List<GetItems> getItems() {
		return items;
	}
	public void setItems(List<GetItems> items) {
		this.items = items;
	}
}