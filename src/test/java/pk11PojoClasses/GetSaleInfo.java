package pk11PojoClasses;

import java.util.List;

public class GetSaleInfo {
	private String country;
	private String saleability;
	private boolean isEbook;
	private GetListPrice listPrice;
	private GetRetialPrice retailPrice;
	private String buyLink;
	private List<GetOffers> offers;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getSaleability() {
		return saleability;
	}
	public void setSaleability(String saleability) {
		this.saleability = saleability;
	}
	public boolean getIsEbook() {
		return isEbook;
	}
	public void setEbook(boolean isEbook) {
		this.isEbook = isEbook;
	}
	public GetListPrice getListPrice() {
		return listPrice;
	}
	public void setListPrice(GetListPrice listPrice) {
		this.listPrice = listPrice;
	}
	public GetRetialPrice getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(GetRetialPrice retailPrice) {
		this.retailPrice = retailPrice;
	}
	public String getBuyLink() {
		return buyLink;
	}
	public void setBuyLink(String buyLink) {
		this.buyLink = buyLink;
	}
	public List<GetOffers> getOffers() {
		return offers;
	}
	public void setOffers(List<GetOffers> offers) {
		this.offers = offers;
	}
		
}
