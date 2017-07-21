/**
 * 
 */
package pagecode;

import java.util.List;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.context.FacesContext;

import com.db.Db;
import com.db.Menuler;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.session.Session;
/**
 * @author Emre
 *
 */
public class Musteri_ekle extends PageCodeBase {
	String url;
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

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getYas() {
		return yas;
	}

	public void setYas(String yas) {
		this.yas = yas;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getSonuc() {
		return sonuc;
	}

	String adi;
	String soyadi;
	String telno;
	String yas;
	String cinsiyet;
	String adres;
	String sonuc;
	protected HtmlForm form1;
	protected HtmlInputText text1;
	protected HtmlInputText text2;
	protected HtmlInputText text3;
	protected HtmlInputText text4;
	protected HtmlSelectOneRadio radio1;
	protected HtmlInputTextarea textarea1;
	protected HtmlCommandExButton bkayityap;
	protected HtmlCommandExButton bgeridon;
	protected HtmlOutputText text5;
	protected HtmlSelectOneMenu menu1;
	protected HtmlCommandButton bgit;
	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	public String doBgeridonAction() {
		adi="";
		soyadi="";
		telno="";
		yas="";
		cinsiyet="";
		adres="";
		sonuc="";
		list_menu=null;
		url="";
		if(Session.admin_giris)
			return "admin_giris?faces-redirect=true";
		if(Session.normal_giris)
			return "normal_giris?faces-redirect=true";
		return "";
	}

	public String doBkayityapAction() {
		try
		{
			int yas=Integer.parseInt(this.yas);
			if(adi.length()>0 && soyadi.length()>0 && telno.length()>0 && cinsiyet.length()>0
					&& adres.length()>0 )
			{
				if(new Db().musteri_ekle(adi, soyadi, telno, yas, cinsiyet, adres))
				{
					adi="";
					soyadi="";
					telno="";
					this.yas="";
					cinsiyet="";
					adres="";
					sonuc="";
					sonuc="Kayit Basarili";
				}
				else
				{
					sonuc="Sorun var";
				}
				
			}else
			{
				sonuc="Girdiler Yanlis yada Bos";
			}
			
			
		}catch(Exception ex)
		{
			sonuc="Yas Girdisi Sayi Degil";
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

	protected HtmlSelectOneRadio getRadio1() {
		if (radio1 == null) {
			radio1 = (HtmlSelectOneRadio) findComponentInRoot("radio1");
		}
		return radio1;
	}

	protected HtmlInputTextarea getTextarea1() {
		if (textarea1 == null) {
			textarea1 = (HtmlInputTextarea) findComponentInRoot("textarea1");
		}
		return textarea1;
	}

	protected HtmlCommandExButton getBkayityap() {
		if (bkayityap == null) {
			bkayityap = (HtmlCommandExButton) findComponentInRoot("bkayityap");
		}
		return bkayityap;
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

	protected HtmlSelectOneMenu getMenu1() {
		if (menu1 == null) {
			menu1 = (HtmlSelectOneMenu) findComponentInRoot("menu1");
		}
		return menu1;
	}

	protected HtmlCommandButton getBgit() {
		if (bgit == null) {
			bgit = (HtmlCommandButton) findComponentInRoot("bgit");
		}
		return bgit;
	}

	public String doBgitAction() {
		adi="";
		soyadi="";
		telno="";
		yas="";
		cinsiyet="";
		adres="";
		sonuc="";
		list_menu=null;
		return url;
	}

}