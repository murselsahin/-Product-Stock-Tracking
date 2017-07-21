package com.db;

public class Tarih {
	String islem_tipi;
	String adet_fiyat;
	String islemi_yapan;
	public String getIslem_tipi() {
		return islem_tipi;
	}
	public void setIslem_tipi(String islem_tipi) {
		this.islem_tipi = islem_tipi;
	}
	public void setIslem_tipi(int islem_tipi) {
		if(islem_tipi==0)
			this.islem_tipi="Stok Ekleme";
		if(islem_tipi==1)
			this.islem_tipi="Fiyat Guncelleme";
		if(islem_tipi==2)
			this.islem_tipi="Satis İslemi";
		
	}
	public String getAdet_fiyat() {
		return adet_fiyat;
	}
	public void setAdet_fiyat(String adet_fiyat) {
		this.adet_fiyat = adet_fiyat;
	}
	public void setAdet_fiyat(String adet_fiyat,String tip) {
		
		
		this.adet_fiyat = adet_fiyat+" "+tip;
	}
	public String getIslemi_yapan() {
		return islemi_yapan;
	}
	public void setIslemi_yapan(String islemi_yapan) {
		this.islemi_yapan = islemi_yapan;
	}
	public void setIslemi_yapan(String adi,String soyadi) {
		this.islemi_yapan = adi+" "+soyadi;
	}

}
