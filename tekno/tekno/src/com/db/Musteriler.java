package com.db;

public class Musteriler {
	int musteri_id;
	String adi_soyadi;
	public int getMusteri_id() {
		return musteri_id;
	}
	public void setMusteri_id(int musteri_id) {
		this.musteri_id = musteri_id;
	}
	public String getAdi_soyadi() {
		return adi_soyadi;
	}
	public void setAdi_soyadi(String adi_soyadi) {
		this.adi_soyadi = adi_soyadi;
	}
	public void setAdi_soyadi(String adi,String soyadi) {
		this.adi_soyadi = adi+" "+soyadi;
	}

}
