package pk13SpecBuilders;

public class GetEpub {
	private boolean isAvailable;
	private String acsTokenLink;
	private String downloadLink;

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getAcsTokenLink() {
		return acsTokenLink;
	}

	public void setAcsTokenLink(String acsTokenLink) {
		this.acsTokenLink = acsTokenLink;
	}
	
	public String getDownloadLink() {
		return downloadLink;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}
	
}
