/**
 * 
 */
package pagecode;

import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;

import com.db.Db;
import com.db.Menuler;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.session.Session;
/**
 * @author Emre
 *
 */
public class Anasayfa extends PageCodeBase {
	public List<Menuler> getList_normal_menu() {
		return list_normal_menu;
	}

	public List<Menuler> getList_admin_menu() {
		return list_admin_menu;
	}

	List<Menuler> list_normal_menu;
	List<Menuler> list_admin_menu;
	String kullanici_adi;
	String sifre;
	String sonuc;
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

	public String getSonuc() {
		return sonuc;
	}

	protected HtmlInputText text1;
	protected HtmlForm form1;
	protected HtmlInputSecret secret1;
	protected HtmlCommandExButton bgiris;
	protected HtmlOutputText text2;

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

	protected HtmlCommandExButton getBgiris() {
		if (bgiris == null) {
			bgiris = (HtmlCommandExButton) findComponentInRoot("bgiris");
		}
		return bgiris;
	}

	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}

	public void onPageLoadBegin(FacesContext facescontext) {
		Session.admin_giris=false;
		Session.normal_giris=false;
		Session.satis_elemani_id=0;
	}

	public String doBgirisAction() {
		String[] kontrol=new Db().giris_kontrol(kullanici_adi, sifre);
		if(kontrol[0].equals("false"))
		{
			Session.admin_giris=false;
			Session.normal_giris=false;
			Session.satis_elemani_id=0;
			sonuc="Kullanici Adi,Sifre Hatali";
		}
		if(kontrol[0].equals("true"))
		{
			if(kontrol[1].equals("admin"))
			{
				Session.admin_giris=true;
				Session.normal_giris=false;
				Session.satis_elemani_id=Integer.parseInt(kontrol[2]);
				return "admin_giris?faces-redirect=true";
				
			}
			if(kontrol[1].equals("normal"))
			{
				Session.admin_giris=false;
				Session.normal_giris=true;
				Session.satis_elemani_id=Integer.parseInt(kontrol[2]);
				return "normal_giris?faces-redirect=true";
			}
		}
		return "";
	}

}