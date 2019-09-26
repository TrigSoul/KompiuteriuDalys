package komp.kompiuteriudalys;

public enum Menu {
	
	Jungtys("/jungtys")
	, Komponentai("/komponentai");

	
	private final String itemurl;
	
	Menu( String url ) {
		this.itemurl = url;
	}
	
	public String itemurl() {
		return this.itemurl;
	}	

}
