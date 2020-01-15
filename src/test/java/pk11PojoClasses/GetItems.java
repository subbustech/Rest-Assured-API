package pk11PojoClasses;

public class GetItems {
	private String kind;
	private String id;
	private String etag;
	private String selfLink;
	private GetVolumeInfo volumeInfo;
	private GetSaleInfo saleInfo;
	private GetAccessInfo accessInfo;
	private GetSearchInfo searchInfo;
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEtag() {
		return etag;
	}
	public void setEtag(String etag) {
		this.etag = etag;
	}
	public String getSelfLink() {
		return selfLink;
	}
	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}
	public GetVolumeInfo getVolumeInfo() {
		return volumeInfo;
	}
	public void setVolumeInfo(GetVolumeInfo volumeInfo) {
		this.volumeInfo = volumeInfo;
	}
	public GetSaleInfo getSaleInfo() {
		return saleInfo;
	}
	public void setSaleInfo(GetSaleInfo saleInfo) {
		this.saleInfo = saleInfo;
	}
	public GetAccessInfo getAccessInfo() {
		return accessInfo;
	}
	public void setAccessInfo(GetAccessInfo accessInfo) {
		this.accessInfo = accessInfo;
	}
	public GetSearchInfo getSearchInfo() {
		return searchInfo;
	}
	public void setSearchInfo(GetSearchInfo searchInfo) {
		this.searchInfo = searchInfo;
	}
}
