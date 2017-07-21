/**
 * 
 */
package pagecode;


import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.context.FacesContext;

import com.db.Alt_tip;
import com.db.Db;
import com.db.Menuler;
import com.db.Tarih;
import com.db.Urunler;
import com.db.Ust_tip;
import com.ibm.faces.component.UIColumnEx;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.ibm.faces.component.html.HtmlDataTableEx;
import com.session.Session;



/**
 * @author Emre
 *
 */
public class Urun_tarihi extends PageCodeBase {
	String ara;
	int ust_tip_id;
	List<Ust_tip> list_ust_tip;
	int alt_tip_id;
	List<Alt_tip> list_alt_tip;
	int urun_id;
	List<Urunler> list_urunler;
	String siralama;
	String urunu_ekleyen;
	List<Tarih> list_tarih;
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

	public List<Tarih> getList_tarih() {
		return list_tarih;
	}

	public String getAra() {
		return ara;
	}

	public void setAra(String ara) {
		this.ara = ara;
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

	public int getUrun_id() {
		return urun_id;
	}

	public void setUrun_id(int urun_id) {
		this.urun_id = urun_id;
	}

	public String getSiralama() {
		return siralama;
	}

	public void setSiralama(String siralama) {
		this.siralama = siralama;
	}

	public String getUrunu_ekleyen() {
		return urunu_ekleyen;
	}

	public void setUrunu_ekleyen(String urunu_ekleyen) {
		this.urunu_ekleyen = urunu_ekleyen;
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

	protected HtmlForm form1;
	protected HtmlInputText text1;
	protected HtmlCommandExButton burunadiara;
	protected HtmlSelectOneMenu menu1;
	protected HtmlCommandExButton baltgetir;
	protected HtmlSelectOneMenu menu2;
	protected HtmlCommandExButton burunlerigetir;
	protected HtmlSelectOneMenu menu3;
	protected HtmlCommandExButton buruntarihi;
	protected HtmlSelectOneRadio radio1;
	protected HtmlOutputText text2;
	protected HtmlDataTableEx tableEx1;
	protected UIColumnEx columnEx4;
	protected HtmlOutputText text4;
	protected HtmlOutputText text5;
	protected HtmlOutputText text6;
	protected HtmlCommandExButton bgeridon;
	protected HtmlOutputText text3;
	protected UIColumnEx header;
	protected HtmlOutputText text7;
	protected UIColumnEx columnEx6;
	protected HtmlOutputText text8;
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
		siralama="";
		urunu_ekleyen="";
		list_tarih=null;
		list_menu=null;
		url="";
		return "admin_giris?faces-redirect=true";
	}

	public String doBurunadiaraAction() {
		list_urunler=new Db().list_urun_adina_gore_ara(ara);
		return "";
	}

	public String doBaltgetirAction() {
		list_alt_tip=new Db().list_alt_tip_gonder(ust_tip_id);
		return "";
	}

	public String doBurunlerigetirAction() {
		list_urunler=new Db().list_urun_alt_tip_idye_gore_getir(alt_tip_id);
		return "";
	}

	public String doBuruntarihiAction() {
		if(urun_id==0)
			return "";
		
		urunu_ekleyen="Urunu Ekleyen "+new Db().urunu_ekleyen(urun_id);
		
		if(siralama.equals("a-z"))
		{
			list_tarih=new Db().list_tarih_gonder(urun_id,"a-z");
			
		}else if(siralama.equals("z-a"))
		{
			list_tarih=new Db().list_tarih_gonder(urun_id,"z-a");
		}else
		{
			return "";
		}
			
			
		
		return "";
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

	protected HtmlCommandExButton getBurunlerigetir() {
		if (burunlerigetir == null) {
			burunlerigetir = (HtmlCommandExButton) findComponentInRoot("burunlerigetir");
		}
		return burunlerigetir;
	}

	protected HtmlSelectOneMenu getMenu3() {
		if (menu3 == null) {
			menu3 = (HtmlSelectOneMenu) findComponentInRoot("menu3");
		}
		return menu3;
	}

	protected HtmlCommandExButton getBuruntarihi() {
		if (buruntarihi == null) {
			buruntarihi = (HtmlCommandExButton) findComponentInRoot("buruntarihi");
		}
		return buruntarihi;
	}

	protected HtmlSelectOneRadio getRadio1() {
		if (radio1 == null) {
			radio1 = (HtmlSelectOneRadio) findComponentInRoot("radio1");
		}
		return radio1;
	}

	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}

	protected HtmlDataTableEx getTableEx1() {
		if (tableEx1 == null) {
			tableEx1 = (HtmlDataTableEx) findComponentInRoot("tableEx1");
		}
		return tableEx1;
	}

	protected UIColumnEx getColumnEx4() {
		if (columnEx4 == null) {
			columnEx4 = (UIColumnEx) findComponentInRoot("columnEx4");
		}
		return columnEx4;
	}

	protected HtmlOutputText getText4() {
		if (text4 == null) {
			text4 = (HtmlOutputText) findComponentInRoot("text4");
		}
		return text4;
	}

	protected HtmlOutputText getText5() {
		if (text5 == null) {
			text5 = (HtmlOutputText) findComponentInRoot("text5");
		}
		return text5;
	}

	protected HtmlOutputText getText6() {
		if (text6 == null) {
			text6 = (HtmlOutputText) findComponentInRoot("text6");
		}
		return text6;
	}

	protected HtmlCommandExButton getBgeridon() {
		if (bgeridon == null) {
			bgeridon = (HtmlCommandExButton) findComponentInRoot("bgeridon");
		}
		return bgeridon;
	}

	protected HtmlOutputText getText3() {
		if (text3 == null) {
			text3 = (HtmlOutputText) findComponentInRoot("text3");
		}
		return text3;
	}

	protected UIColumnEx getHeader() {
		if (header == null) {
			header = (UIColumnEx) findComponentInRoot("header");
		}
		return header;
	}

	protected HtmlOutputText getText7() {
		if (text7 == null) {
			text7 = (HtmlOutputText) findComponentInRoot("text7");
		}
		return text7;
	}

	protected UIColumnEx getColumnEx6() {
		if (columnEx6 == null) {
			columnEx6 = (UIColumnEx) findComponentInRoot("columnEx6");
		}
		return columnEx6;
	}

	protected HtmlOutputText getText8() {
		if (text8 == null) {
			text8 = (HtmlOutputText) findComponentInRoot("text8");
		}
		return text8;
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
		siralama="";
		urunu_ekleyen="";
		list_tarih=null;
		list_menu=null;
		return url;
	}

	public void onPageLoadBegin(FacesContext facescontext) {
		if(Session.admin_giris)
			list_menu=new Db().list_admin_menu_gonder();
		if(Session.normal_giris)
			list_menu=new Db().list_normal_menu_gonder();
	}



	

}