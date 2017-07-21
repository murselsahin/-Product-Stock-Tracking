/**
 * 
 */
package pagecode;

import java.util.List;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;

import com.db.Alt_tip;
import com.db.Db;
import com.db.Menuler;
import com.db.Urunler;
import com.db.Ust_tip;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.session.Session;

/**
 * @author Emre
 *
 */
public class Stok_ekle extends PageCodeBase {
	String ara;
	int ust_tip_id;
	List<Ust_tip> list_ust_tip;
	int alt_tip_id;
	List<Alt_tip> list_alt_tip;
	int urun_id;
	List<Urunler> list_urunler;
	String stok;
	String fiyat;
	String guncel_stok;
	String guncel_fiyat;
	String sonuc;
	List<Menuler> list_menu;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Menuler> getList_menu() {
		return list_menu;
	}

	String url;

	public int getUst_tip_id() {
		return ust_tip_id;
	}

	public void setUst_tip_id(int ust_tip_id) {
		this.ust_tip_id = ust_tip_id;
	}

	public int getAlt_tip_id() {
		return alt_tip_id;
	}

	public void setAlt_tip_id(int alt_tip_id) {
		this.alt_tip_id = alt_tip_id;
	}

	public int getUrun_id() {
		return urun_id;
	}

	public void setUrun_id(int urun_id) {
		this.urun_id = urun_id;
	}

	public String getStok() {
		return stok;
	}

	public void setStok(String stok) {
		this.stok = stok;
	}

	public String getFiyat() {
		return fiyat;
	}

	public void setFiyat(String fiyat) {
		this.fiyat = fiyat;
	}

	public String getGuncel_stok() {
		return guncel_stok;
	}

	public void setGuncel_stok(String guncel_stok) {
		this.guncel_stok = guncel_stok;
	}

	public String getGuncel_fiyat() {
		return guncel_fiyat;
	}

	public void setGuncel_fiyat(String guncel_fiyat) {
		this.guncel_fiyat = guncel_fiyat;
	}

	public String getSonuc() {
		return sonuc;
	}

	public void setSonuc(String sonuc) {
		this.sonuc = sonuc;
	}

	public List<Ust_tip> getList_ust_tip() {
		list_ust_tip=new Db().list_ust_tip_gonder();
		return list_ust_tip;
	}

	public List<Alt_tip> getList_alt_tip() {
		return list_alt_tip;
	}

	public List<Urunler> getList_urunler() {
		return list_urunler;
	}

	public String getAra() {
		return ara;
	}

	public void setAra(String ara) {
		this.ara = ara;
	}

	protected HtmlForm form1;
	protected HtmlInputText text1;
	protected HtmlCommandExButton burunadiara;
	protected HtmlSelectOneMenu menu1;
	protected HtmlCommandExButton baltgetir;
	protected HtmlSelectOneMenu menu2;
	protected HtmlCommandExButton burungetir;
	protected HtmlSelectOneMenu menu3;
	protected HtmlCommandExButton bstokbilgisi;
	protected HtmlOutputText text2;
	protected HtmlInputText text3;
	protected HtmlOutputText text5;
	protected HtmlInputText text6;
	protected HtmlCommandExButton bstokekle;
	protected HtmlCommandButton bfiyatguncelle;
	protected HtmlCommandExButton bgeridon;
	protected HtmlOutputText text4;
	protected HtmlSelectOneMenu menu4;
	protected HtmlCommandExButton bgit;
	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	public String doBgeridonAction() {
		ara="";
		ust_tip_id=0;
		list_ust_tip=null;
		alt_tip_id=0;
		list_alt_tip=null;
		urun_id=0;
		list_urunler=null;
		stok="";
		fiyat="";
		guncel_stok="";
		guncel_fiyat="";
		sonuc="";
		list_menu=null;
		url="";
			return "admin_giris?faces-redirect=true";
		
	}

	public String doBurunadiaraAction() {
		list_urunler=new Db().list_urun_adina_gore_ara(ara);
		guncel_stok="";
		guncel_fiyat="";
		return "";
	}

	public String doBaltgetirAction() {
		list_alt_tip=new Db().list_alt_tip_gonder(ust_tip_id);
		return "";
	}

	public String doBurungetirAction() {
		list_urunler=new Db().list_urun_alt_tip_idye_gore_getir(alt_tip_id);
		guncel_stok="";
		guncel_fiyat="";
		return "";
	}

	public String doBstokbilgisiAction() {
		
		
		int[] bilgi=new Db().urun_bilgisi_stok_fiyat(urun_id);
		guncel_stok="Guncel Stok : "+bilgi[0];
		guncel_fiyat="Guncel Fiyat : "+bilgi[1]+" TL";
		
		
		return "";
	}

	public String doBstokekleAction() {
		if(urun_id<=0)
			return "";
		try
		{
			int stok=Integer.parseInt(this.stok);
			if(stok>0)
			{
				if(new Db().stok_ekle(urun_id, stok, Session.satis_elemani_id))
				{
					this.stok="";
					sonuc="Stok Guncellendi";
					doBstokbilgisiAction();
				}
				else
				{
					sonuc="Hatali";
				}
			}
			else
			{
				sonuc="Girdi Hatali";
			}
			
				
				
			
		}catch(Exception ex)
		{
			sonuc="Girdi Hatali";
		}
		return "";
	}

	public String doBfiyatguncelleAction() {
		if(urun_id<=0)
		{
			
			return "";
		}
		try
		{
			int fiyat=Integer.parseInt(this.fiyat);
			if(fiyat>0)
			{
				if(new Db().fiyat_guncelle(urun_id, fiyat, Session.satis_elemani_id))
				{
					this.fiyat="";
					sonuc="Fiyat Guncellendi";
					doBstokbilgisiAction();
				}
				else
				{
					sonuc="Hatali";
				}
			}
			else
			{
				sonuc="Girdi Hatali";
			}
			
				
				
			
		}catch(Exception ex)
		{
			sonuc="Girdi Hatali";
		}
		return "";
	}

	public void onPageLoadBegin(FacesContext facescontext) {
		if(Session.admin_giris)
			list_menu=new Db().list_admin_menu_gonder();
		if(Session.normal_giris)
			list_menu=new Db().list_normal_menu_gonder();
	}

	protected HtmlInputText getText1() {
		if (text1 == null) {
			text1 = (HtmlInputText) findComponentInRoot("text1");
		}
		return text1;
	}

	protected HtmlCommandExButton getBurunadiara() {
		if (burunadiara == null) {
			burunadiara = (HtmlCommandExButton) findComponentInRoot("burunadiara");
		}
		return burunadiara;
	}

	protected HtmlSelectOneMenu getMenu1() {
		if (menu1 == null) {
			menu1 = (HtmlSelectOneMenu) findComponentInRoot("menu1");
		}
		return menu1;
	}

	protected HtmlCommandExButton getBaltgetir() {
		if (baltgetir == null) {
			baltgetir = (HtmlCommandExButton) findComponentInRoot("baltgetir");
		}
		return baltgetir;
	}

	protected HtmlSelectOneMenu getMenu2() {
		if (menu2 == null) {
			menu2 = (HtmlSelectOneMenu) findComponentInRoot("menu2");
		}
		return menu2;
	}

	protected HtmlCommandExButton getBurungetir() {
		if (burungetir == null) {
			burungetir = (HtmlCommandExButton) findComponentInRoot("burungetir");
		}
		return burungetir;
	}

	protected HtmlSelectOneMenu getMenu3() {
		if (menu3 == null) {
			menu3 = (HtmlSelectOneMenu) findComponentInRoot("menu3");
		}
		return menu3;
	}

	protected HtmlCommandExButton getBstokbilgisi() {
		if (bstokbilgisi == null) {
			bstokbilgisi = (HtmlCommandExButton) findComponentInRoot("bstokbilgisi");
		}
		return bstokbilgisi;
	}

	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}

	protected HtmlInputText getText3() {
		if (text3 == null) {
			text3 = (HtmlInputText) findComponentInRoot("text3");
		}
		return text3;
	}

	protected HtmlOutputText getText5() {
		if (text5 == null) {
			text5 = (HtmlOutputText) findComponentInRoot("text5");
		}
		return text5;
	}

	protected HtmlInputText getText6() {
		if (text6 == null) {
			text6 = (HtmlInputText) findComponentInRoot("text6");
		}
		return text6;
	}

	protected HtmlCommandExButton getBstokekle() {
		if (bstokekle == null) {
			bstokekle = (HtmlCommandExButton) findComponentInRoot("bstokekle");
		}
		return bstokekle;
	}

	protected HtmlCommandButton getBfiyatguncelle() {
		if (bfiyatguncelle == null) {
			bfiyatguncelle = (HtmlCommandButton) findComponentInRoot("bfiyatguncelle");
		}
		return bfiyatguncelle;
	}

	protected HtmlCommandExButton getBgeridon() {
		if (bgeridon == null) {
			bgeridon = (HtmlCommandExButton) findComponentInRoot("bgeridon");
		}
		return bgeridon;
	}

	protected HtmlOutputText getText4() {
		if (text4 == null) {
			text4 = (HtmlOutputText) findComponentInRoot("text4");
		}
		return text4;
	}

	protected HtmlSelectOneMenu getMenu4() {
		if (menu4 == null) {
			menu4 = (HtmlSelectOneMenu) findComponentInRoot("menu4");
		}
		return menu4;
	}

	protected HtmlCommandExButton getBgit() {
		if (bgit == null) {
			bgit = (HtmlCommandExButton) findComponentInRoot("bgit");
		}
		return bgit;
	}

	public String doBgitAction() {
		ara="";
		ust_tip_id=0;
		list_ust_tip=null;
		alt_tip_id=0;
		list_alt_tip=null;
		urun_id=0;
		list_urunler=null;
		stok="";
		fiyat="";
		guncel_stok="";
		guncel_fiyat="";
		sonuc="";
		list_menu=null;
		return url;
	}
	

}