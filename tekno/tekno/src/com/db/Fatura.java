package com.db;

public class Fatura {
	String urun_adi;
	String adet;
	String tutar;
	String tarih;
	String islemi_yapan;
	public String getUrun_adi() {
		return urun_adi;
	}
	public void setUrun_adi(String urun_adi) {
		this.urun_adi = urun_adi;
	}
	public String getAdet() {
		return adet;
	}
	public void setAdet(String adet) {
		this.adet = adet;
	}
	public String getTutar() {
		return tutar;
	}
	public void setTutar(String tutar) {
		this.tutar = tutar+" TL";
	}
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
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
