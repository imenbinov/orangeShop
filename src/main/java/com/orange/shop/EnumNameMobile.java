package com.orange.shop;

public enum EnumNameMobile {
	
	Sunusng("sunusng"),
	Ipom("ipom"),
	Weiwei("weiwei");
	
	
	private EnumNameMobile(String display){
		this.display = display;
		
	}
	private String display ;
	private String value ;
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
