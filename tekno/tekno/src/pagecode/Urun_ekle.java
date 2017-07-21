/**
 * 
 */
package pagecode;

import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;

import com.db.Alt_tip;
import com.db.Db;
import com.db.Menuler;
import com.db.Ust_tip;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.session.Session;

/**
 * @author Emre
 *
 */
public class Urun_ekle extends PageCodeBase {

	int ust_tip_id;
	List<Ust_tip>  list_ust_tip;
	int alt_tip_id;
	List<Alt_tip> list_alt_tip;
	String urun_adi;
	String aciklamasi;
	String fiyat;
	String garanti;
	String stok;
	String sonuc;
	List<Menuler> list_menu;
	String url;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Menuler> getList_menu() {
		return list_menu;
	}

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

	public String getUrun_adi() {
		return urun_adi;
	}

	public void setUrun_adi(String urun_adi) {
		this.urun_adi = urun_adi;
	}

	public String getAciklamasi() {
		return aciklamasi;
	}

	public void setAciklamasi(String aciklamasi) {
		this.aciklamasi = aciklamasi;
	}

	public String getFiyat() {
		return fiyat;
	}

	public void setFiyat(String fiyat) {
		this.fiyat = fiyat;
	}

	public String getGaranti() {
		return garanti;
	}

	public void setGaranti(String garanti) {
		this.garanti = garanti;
	}

	public String getStok() {
		return stok;
	}

	public void setStok(String stok) {
		this.stok = stok;
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

	protected HtmlForm form1;
	protected HtmlSelectOneMenu menu1;
	protected HtmlCommandExButton bgetir;
	protected HtmlSelectOneMenu menu2;
	protected HtmlInputText text1;
	protected HtmlInputTextarea textarea1;
	protected HtmlInputText text2;
	protected HtmlInputText text3;
	protected HtmlInputText text4;
	protected HtmlCommandExButton burunekle;
	protected HtmlCommandExButton bgeridon;
	protected HtmlOutputText text5;
	protected HtmlSelectOneMenu menu3;
	protected HtmlCommandExButton bgit;
	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	public String doBgeridonAction() {
		ust_tip_id=0;
		list_ust_tip=null;
		alt_tip_id=0;
		 list_alt_tip=null;
		urun_adi="";
		aciklamasi="";
		fiyat="";
		garanti="";
		stok="";
		sonuc="";
		list_menu=null;
		url="";
		
			return "admin_giris?faces-redirect=true";
		
	}

	public String doBgetirAction() {
		list_alt_tip=new Db().list_alt_tip_gonder(ust_tip_id);
		return "";
	}

	public String doBurunekleAction() {
		try
		{
			int fiyat=Integer.parseInt(this.fiyat);
			int garanti=Integer.parseInt(this.garanti);
			int stok=Integer.parseInt(this.stok);
			if(alt_tip_id>0 && urun_adi.length()>0 && aciklamasi.length()>0 && 
					fiyat>0 && garanti>0 && stok>0)
			{
				if(new Db().urun_ekle(urun_adi, aciklamasi, fiyat, alt_tip_id, Session.satis_elemani_id, garanti, stok))
				{
					urun_adi="";
					aciklamasi="";
					this.fiyat="";
					this.garanti="";
					this.stok="";
					sonuc="";	
					
				sonuc="Urun Eklendi";
				}
				else
				{
					sonuc="Hata Olustu";
				}
			}
			else
			{
				sonuc="Girdiler Yanlis";
			}
				
				
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			sonuc="Girdiler Yanlis";
		}
		
		return "";
	}

	public void onPageLoadBegin(FacesContext facescontext) {
		if(Session.admin_giris)
			list_menu=new Db().list_admin_menu_gonder();
		if(Session.normal_giris)
			list_menu=new Db().list_normal_menu_gonder();
	}

	protected HtmlSelectOneMenu getMenu1() {
		if (menu1 == null) {
			menu1 = (HtmlSelectOneMenu) findComponentInRoot("menu1");
		}
		return menu1;
	}

	protected HtmlCommandExButton getBgetir() {
		if (bgetir == null) {
			bgetir = (HtmlCommandExButton) findComponentInRoot("bgetir");
		}
		return bgetir;
	}

	protected HtmlSelectOneMenu getMenu2() {
		if (menu2 == null) {
			menu2 = (HtmlSelectOneMenu) findComponentInRoot("menu2");
		}
		return menu2;
	}

	protected HtmlInputText getText1() {
		if (text1 == null) {
			text1 = (HtmlInputText) findComponentInRoot("text1");
		}
		return text1;
	}

	protected HtmlInputTextarea getTextarea1() {
		if (textarea1 == null) {
			textarea1 = (HtmlInputTextarea) findComponentInRoot("textarea1");
		}
		return textarea1;
	}

	protected HtmlInputText getText2() {
		if (text2 == null) {
			text2 = (HtmlInputText) findComponentInRoot("text2");
		}
		return text2;
	}

	protected HtmlInputText getText3() {
		if (text3 == null) {
			text3 = (HtmlInputText) findComponentInRoot("text3");
		}
		return text3;
	}

	protected HtmlInputText getText4() {
		if (text4 == null) {
			text4 = (HtmlInputText) findComponentInRoot("text4");
		}
		return text4;
	}

	protected HtmlCommandExButton getBurunekle() {
		if (burunekle == null) {
			burunekle = (HtmlCommandExButton) findComponentInRoot("burunekle");
		}
		return burunekle;
	}

	protected HtmlCommandExButton getBgeridon() {
		if (bgeridon == null) {
			bgeridon = (HtmlCommandExButton) findComponentInRoot("bgeridon");
		}
		return bgeridon;
	}

	protected HtmlOutputText getText5() {
		if (text5 == null) {
			text5 = (HtmlOutputText) findComponentInRoot("text5");
		}
		return text5;
	}

	protected HtmlSelectOneMenu getMenu3() {
		if (menu3 == null) {
			menu3 = (HtmlSelectOneMenu) findComponentInRoot("menu3");
		}
		return menu3;
	}

	protected HtmlCommandExButton getBgit() {
		if (bgit == null) {
			bgit = (HtmlCommandExButton) findComponentInRoot("bgit");
		}
		return bgit;
	}

	public String doBgitAction() {
		ust_tip_id=0;
		list_ust_tip=null;
		alt_tip_id=0;
		 list_alt_tip=null;
		urun_adi="";
		aciklamasi="";
		fiyat="";
		garanti="";
		stok="";
		sonuc="";
		list_menu=null;
		return url;
		
	}

}