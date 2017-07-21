package com.db;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Db {
	Connection conn;
	public Db()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:mursel2","MURSEL","123456");
			 
		}catch(Exception ex)
		{
			System.out.println(ex+"");
		}
		
	}
	
	public String sifre_algoritmasi(String sifre)
	{
		
		try
		{
			MessageDigest messageDigestNesnesi = MessageDigest.getInstance("MD5");
			messageDigestNesnesi.update(sifre.getBytes());
			byte messageDigestDizisi[] = messageDigestNesnesi.digest();
			StringBuffer sb32 = new StringBuffer();
			for(int i=0;i<messageDigestDizisi.length;i++)
				sb32.append(Integer.toString((messageDigestDizisi[i]& 0xff)+0x100,32));
			
			
			return sb32.toString();
			
		}catch(Exception ex)
		{
			return "";
		}
	}
	
	public String[] giris_kontrol(String kullanici_adi,String ssifre)
	{
		try
		{
			String[] kontrol=new String[3];
			String sifre=sifre_algoritmasi(ssifre);
			String sql="select satis_elemani_id,yetki from SATIS_ELEMANI where kullanici_adi=? AND sifre=? AND aktiflik=1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,kullanici_adi);
			ps.setString(2,sifre);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				if(rs.getInt("yetki")==1)
				{
				kontrol[0]="true";
				kontrol[1]="admin";
				kontrol[2]=rs.getInt("satis_elemani_id")+"";
				}
				if(rs.getInt("yetki")==0)
				{
				kontrol[0]="true";
				kontrol[1]="normal";
				kontrol[2]=rs.getInt("satis_elemani_id")+"";
				}
				return kontrol;
			}
			kontrol[0]="false";
			return kontrol;
			
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
	public boolean musteri_ekle(String adi,String soyadi,String telno,int yas,String cinsiyet,String adres)
	{
		try
		{
			String  sql="insert into MUSTERILER(adi,soyadi,telno,yas,cinsiyet,adres) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, adi);
			ps.setString(2, soyadi);
			ps.setString(3, telno);
			ps.setInt(4, yas);
			ps.setString(5, cinsiyet);
			ps.setString(6, adres);
			int result=ps.executeUpdate();
			if(result>0)
				return true;
			else
				return false;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return false;
		}
	}
	
	public List<Ust_tip> list_ust_tip_gonder()
	{
		try
		{
			List<Ust_tip> list=new ArrayList<Ust_tip>();
			String sql="select ust_tip_id,adi from ust_tip order by adi";
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Ust_tip u = new Ust_tip();
				u.setUst_tip_id(rs.getInt("ust_tip_id"));
				u.setAdi(rs.getString("adi"));
				list.add(u);
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
	public List<Alt_tip> list_alt_tip_gonder(int ust_tip_id)
	{
		try
		{
			List<Alt_tip> list=new ArrayList<Alt_tip>();
			String sql="select alt_tip_id,adi from alt_tip where ust_tip_id=? order by adi";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, ust_tip_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Alt_tip a = new Alt_tip();
				a.setAlt_tip_id(rs.getInt("alt_tip_id"));
				a.setAdi(rs.getString("adi"));
				list.add(a);
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
	
	public boolean urun_ekle(String urun_adi,String aciklamasi,int fiyat,int alt_tip_id,int satis_elemani_id,int garanti,int stok)
	{
		try
		{
			String sql="insert into URUNLER(urun_adi,aciklamasi,fiyati,alt_tip_id,satis_elemani_id,garanti,stok) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, urun_adi);
			ps.setString(2,aciklamasi);
			ps.setInt(3,fiyat);
			ps.setInt(4,alt_tip_id);
			ps.setInt(5,satis_elemani_id);
			ps.setInt(6,garanti);
			ps.setInt(7,stok);
			int result=ps.executeUpdate();
			if(result>0)
				return true;
			else
				return false;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return false;
		}
	}

	public List<Urunler> list_urun_adina_gore_ara(String ara)
	{
		try
		{
			List<Urunler> list = new ArrayList<Urunler>();
			ara="%"+ara+"%";
			String sql="select urun_id,urun_adi from urunler where urun_adi like ? order by urun_adi";
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setString(1,ara);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Urunler u = new Urunler();
				u.setUrun_adi(rs.getString("urun_adi"));
				u.setUrun_id(rs.getInt("urun_id"));
				list.add(u);
				
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}

	public List<Urunler> list_urun_alt_tip_idye_gore_getir(int alt_tip_id)
	{
		try
		{
			List<Urunler> list = new ArrayList<Urunler>();
		
			String sql="select urun_id,urun_adi from urunler where alt_tip_id=? order by urun_adi";
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setInt(1,alt_tip_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Urunler u = new Urunler();
				u.setUrun_adi(rs.getString("urun_adi"));
				u.setUrun_id(rs.getInt("urun_id"));
				list.add(u);
				
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}

	public int[]  urun_bilgisi_stok_fiyat(int urun_id) // 0. indis=stok   1.indis=fiyaT 
	{
		try
		{
			int[] bilgi=new int[2];
			String sql="select stok,fiyati from urunler where urun_id=?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,urun_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				bilgi[0]=rs.getInt("stok");
				bilgi[1]=rs.getInt("fiyati");
			}
			return bilgi;
			
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
		
	}

	public boolean stok_ekle(int urun_id,int stok,int satis_elemani_id)
	{
		try
		{
			String sql="update urunler set stok=stok+? where urun_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, stok);
			ps.setInt(2, urun_id);
			
			String sql2="insert into ISLEMLER(urun_id,stok,satis_elemani_id,islem_tipi) values(?,?,?,?)";
			PreparedStatement ps2=conn.prepareStatement(sql2);
			ps2.setInt(1, urun_id);
			ps2.setInt(2, stok);
			ps2.setInt(3, satis_elemani_id);
			ps2.setInt(4, 0);
			
			int result=ps.executeUpdate();
			int result2=ps2.executeUpdate();
			if(result>0 && result2>0)
				return true;
			else
				return false;
			
			
		}catch(Exception ex)
		{
			return false;
		}
	}

	public boolean fiyat_guncelle(int urun_id,int fiyat,int satis_elemani_id)
	{
		try
		{
			String sql="update urunler set fiyati=? where urun_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, fiyat);
			ps.setInt(2, urun_id);
			
			String sql2="insert into ISLEMLER(urun_id,fiyat,satis_elemani_id,islem_tipi) values(?,?,?,?)";
			PreparedStatement ps2=conn.prepareStatement(sql2);
			ps2.setInt(1, urun_id);
			ps2.setInt(2, fiyat);
			ps2.setInt(3, satis_elemani_id);
			ps2.setInt(4, 1);
			
			int result=ps.executeUpdate();
			int result2=ps2.executeUpdate();
			if(result>0 && result2>0)
				return true;
			else
				return false;
			
			
		}catch(Exception ex)
		{
			return false;
		}
	}
	
	public boolean kullanici_ekle(String adi,String soyadi,int yetki,String kullanici_adi,String ssifre)
	{
		try
		{ 
			String sifre=sifre_algoritmasi(ssifre);
			String sql="insert into SATIS_ELEMANI(adi,soyadi,yetki,kullanici_adi,sifre,aktiflik) values(?,?,?,?,?,1)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,adi);
			ps.setString(2,soyadi);
			ps.setInt(3,yetki);
			ps.setString(4,kullanici_adi);
			ps.setString(5,sifre);
			
			int result=ps.executeUpdate();
			if(result>0)
				return true;
			else
				return false;
			
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return false;
		}
	}
	
	public List<Musteriler> list_musteri_ada_gore_arama(String ara)
	{
		try
		{
			ara="%"+ara+"%";
			List<Musteriler> list = new ArrayList<Musteriler>();
			String sql="select musteri_id,adi,soyadi from musteriler where adi like ? order by adi";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ara);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Musteriler m = new Musteriler();
				m.setMusteri_id(rs.getInt("musteri_id"));
				m.setAdi_soyadi(rs.getString("adi"),rs.getString("soyadi"));
				list.add(m);
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
	public List<Musteriler> list_musteri_telno_gore_arama(String ara)
	{
		try
		{
			ara="%"+ara+"%";
			List<Musteriler> list = new ArrayList<Musteriler>();
			String sql="select musteri_id,adi,soyadi from musteriler where telno like ? order by adi";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ara);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Musteriler m = new Musteriler();
				m.setMusteri_id(rs.getInt("musteri_id"));
				m.setAdi_soyadi(rs.getString("adi"),rs.getString("soyadi"));
				list.add(m);
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	public List<Urunler> list_urun_idye_gore_getir(int urun_id)
	{
		try
		{
			List<Urunler> list = new ArrayList<Urunler>();
			
			String sql="select urun_id,urun_adi from urunler where urun_id=? order by urun_adi";
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setInt(1,urun_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Urunler u = new Urunler();
				u.setUrun_adi(rs.getString("urun_adi"));
				u.setUrun_id(rs.getInt("urun_id"));
				list.add(u);
				
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
	public String[]  urun_bilgisi_aciklama_fiyat_garanti_stok(int urun_id) // 0. indis=aciklama   1.indis=fiyaT  2.indis=garanti 3.indis=Stok 4.indis=urunadi
	{
		try
		{
			
			String[] bilgi=new String[5];
			String sql="select stok,fiyati,aciklamasi,garanti from urunler where urun_id=?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,urun_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				bilgi[3]=rs.getInt("stok")+"";
				bilgi[1]=rs.getInt("fiyati")+"";
				bilgi[0]=rs.getString("aciklamasi");
				bilgi[2]=rs.getInt("garanti")+"";
				
			}
			return bilgi;
			
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
		
	}
	
	public List<Sepet> list_sepet_getir(String[] urun_adi,int[] adet,int[] fiyat,int[] birim_fiyat,int[] urun_id)
	{
		List<Sepet> list=new ArrayList<Sepet>();
		for(int i=0;i<urun_adi.length;i++)
		{
			Sepet s = new Sepet();
			s.setAdet(adet[i]+"");
			s.setFiyat(fiyat[i]+"");
			s.setUrun_adi(urun_adi[i]);
			s.setBirim_fiyat(birim_fiyat[i]+"");
			s.setUrun_id(urun_id[i]);
			list.add(s);
		}
		return list;
	}
	
	public String urun_idden_urunadi_getir(int urun_id)
	{
		try
		{
			
			
			String sql="select urun_adi from urunler where urun_id=?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,urun_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getString("urun_adi");
				
			}
			return "";
			
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return "";
		}
	}
	public int urun_idden_stok_getir(int urun_id)
	{
		try
		{
			
			
			String sql="select stok from urunler where urun_id=?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,urun_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt("stok");
				
			}
			return -1;
			
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return -1;
		}
	}
	
	public boolean satis_yap(int urun_id,int satis_elemani_id,int musteri_id,int adet,int tutar)
	{
		try
		{
			Date date = new Date();
	        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	        
	        String sql="insert into fatura(urun_id,satis_elemani_id,musteri_id,tarih,adet,tutar) values(?,?,?,?,?,?)";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, urun_id);
	        ps.setInt(2, satis_elemani_id);
	        ps.setInt(3, musteri_id);
	        ps.setString(4, df.format(date));
	        ps.setInt(5, adet);
	        ps.setInt(6, tutar);
	        
	        int result=ps.executeUpdate();
	        if(result>0)
	        	return true;
	        else
	        	return false;
	        
	        
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return false;
		}
	}
	public List<Fatura> list_fatura_gonder(int musteri_id)
	{
		try
		{
			List<Fatura> list=new ArrayList<Fatura>();
			String sql="select s.adi,s.soyadi,u.urun_adi,f.adet,f.tutar,f.tarih from fatura f,urunler u,satis_elemani s";
			sql+=" where s.satis_elemani_id=f.satis_elemani_id and u.urun_id=f.urun_id and f.musteri_id=? order by f.fatura_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, musteri_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Fatura f = new Fatura();
				f.setAdet(rs.getInt("adet")+"");
				f.setIslemi_yapan(rs.getString("adi"),rs.getString("soyadi"));
				f.setTarih(rs.getString("tarih"));
				f.setTutar(rs.getInt("tutar")+"");
				f.setUrun_adi(rs.getString("urun_adi"));
				list.add(f);
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
	public String urunu_ekleyen(int urun_id)
	{
		try
		{
			String sql="select s.adi,s.soyadi from satis_elemani s,urunler u where s.satis_elemani_id=u.satis_elemani_id and urun_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, urun_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getString("adi")+" "+rs.getString("soyadi");
			}
			return "";
			
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return "";
		}
	}
	
	public List<Tarih> list_tarih_gonder(int urun_id,String tip)
	{
		try
		{
			List<Tarih> list = new ArrayList<Tarih>();
			String sql="select  s.adi,s.soyadi,i.fiyat,i.stok,i.adet_satis,i.islem_tipi from islemler i,satis_elemani s where s.satis_elemani_id=i.satis_elemani_id and urun_id=?";
			if(tip.equals("a-z"))
				sql+=" order by islem_id";
			if(tip.equals("z-a"))
				sql+=" order by islem_id desc";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,urun_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Tarih t = new Tarih();
				int islem_tipi=rs.getInt("islem_tipi");
				t.setIslem_tipi(rs.getInt("islem_tipi"));
				if(islem_tipi==0 )
					t.setAdet_fiyat(rs.getInt("stok")+"","adet");
				if(islem_tipi==1 )
					t.setAdet_fiyat(rs.getInt("fiyat")+"","TL");
				if(islem_tipi==2 )
					t.setAdet_fiyat(rs.getInt("adet_satis")+"","adet");
				
				t.setIslemi_yapan(rs.getString("adi"), rs.getString("soyadi"));
				list.add(t);
					
			}

			
			return list;
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	
	}
	
	public List<Menuler> list_normal_menu_gonder()
	{
		try
		{
			List<Menuler> list = new ArrayList<Menuler>();
			String sql="select baslik,url from menuler where yetki=0 order by baslik";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Menuler m = new Menuler();
				m.setBaslik(rs.getString("baslik"));
				m.setUrl(rs.getString("url"));
				list.add(m);
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	public List<Menuler> list_admin_menu_gonder()
	{
		try
		{
			List<Menuler> list = new ArrayList<Menuler>();
			String sql="select baslik,url from menuler  order by baslik";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Menuler m = new Menuler();
				m.setBaslik(rs.getString("baslik"));
				m.setUrl(rs.getString("url"));
				list.add(m);
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
}
