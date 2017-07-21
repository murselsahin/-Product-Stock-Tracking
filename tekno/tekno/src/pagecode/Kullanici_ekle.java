/**
 * 
 */
package pagecode;

import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;

import com.db.Db;
import com.db.Menuler;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.session.Session;
/**
 * @author Emre
 *
 */
public class Kullanici_ekle extends PageCodeBase {
	String kullanici_adi;
	String sifre;
	String adi;
	String soyadi;
	String yetki;
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

	public String getSonuc() {
		return sonuc;
	}

	public void setSonuc(String sonuc) {
		this.sonuc = sonuc;
	}

	public String getKullanici_adi() {
		return kullanici_adi;
	}

	public void setKullanici_adi(String kullanici_adi) {
		this.kullanici_adi = kullanici_adi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getSoyadi() {
		return soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

	public String getYetki() {
		return yetki;
	}

	public void setYetki(String yetki) {
		this.yetki = yetki;
	}

	protected HtmlInputText text1;
	protected HtmlForm form1;
	protected HtmlInputSecret secret1;
	protected HtmlInputText text2;
	protected HtmlInputText text3;
	protected HtmlSelectOneMenu menu1;
	protected HtmlCommandExButton bekle;
	protected HtmlCommandExButton bgeridon;
	protected HtmlOutputText text4;
	protected HtmlSelectOneMenu menu2;
	protected HtmlCommandExButton bgit;

	protected HtmlInputText getText1() {
		if (text1 == null) {
			text1 = (HtmlInputText) findComponentInRoot("text1");
		}
		return text1;
	}

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected HtmlInputSecret getSecret1() {
		if (secret1 == null) {
			secret1 = (HtmlInputSecret) findComponentInRoot("secret1");
		}
		return secret1;
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

	protected HtmlSelectOneMenu getMenu1() {
		if (menu1 == null) {
			menu1 = (HtmlSelectOneMenu) findComponentInRoot("menu1");
		}
		return menu1;
	}

	protected HtmlCommandExButton getBekle() {
		if (bekle == null) {
			bekle = (HtmlCommandExButton) findComponentInRoot("bekle");
		}
		return bekle;
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

	public String doBgeridonAction() {
		kullanici_adi="";
		sifre="";
		adi="";
		soyadi="";
		sonuc="";
		list_menu=null;
		url="";
			return "admin_giris?faces-redirect=true";
		
		
	}

	public String doBekleAction() {
		if(kullanici_adi.length()>0 && sifre.length()>0 && adi.length()>0 && soyadi.length()>0 )
		{
			if(new Db().kullanici_ekle(adi, soyadi, Integer.parseInt(yetki), kullanici_adi, sifre))
			{
				sonuc="Kayit Basarili";
				kullanici_adi="";
				sifre="";
				adi="";
				soyadi="";
				
			}
			else
			{
				sonuc="Hata";
			}
			
		}
		else
		{
			sonuc="Girdiler Hatali";
		}
		return "";
	}

	protected HtmlSelectOneMenu getMenu2() {
		if (menu2 == null) {
			menu2 = (HtmlSelectOneMenu) findComponentInRoot("menu2");
		}
		return menu2;
	}

	protected HtmlCommandExButton getBgit() {
		if (bgit == null) {
			bgit = (HtmlCommandExButton) findComponentInRoot("bgit");
		}
		return bgit;
	}

	public void onPageLoadBegin(FacesContext facescontext) {
		
		
		if(Session.admin_giris)
			list_menu=new Db().list_admin_menu_gonder();
		if(Session.normal_giris)
			list_menu=new Db().list_normal_menu_gonder();
		
	}

	public String doBgitAction() {
		kullanici_adi="";
		sifre="";
		adi="";
		soyadi="";
		sonuc="";
		list_menu=null;
		return url;
	}

}