/**
 * 
 */
package pagecode;

import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;

import com.db.Db;
import com.db.Fatura;
import com.db.Menuler;
import com.db.Musteriler;
import com.ibm.faces.component.UIColumnEx;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.ibm.faces.component.html.HtmlDataTableEx;
import com.session.Session;
/**
 * @author Emre
 *
 */
public class Fatura_goruntule extends PageCodeBase {
	String ara;
	int musteri_id;
	List<Musteriler> list_musteri;
	List<Fatura> list_fatura;
	String url;
	List<Menuler> list_menu;
	public List<Menuler> getList_menu() {
		return list_menu;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAra() {
		return ara;
	}
	public void setAra(String ara) {
		this.ara = ara;
	}
	public int getMusteri_id() {
		return musteri_id;
	}
	public void setMusteri_id(int musteri_id) {
		this.musteri_id = musteri_id;
	}
	public List<Musteriler> getList_musteri() {
		return list_musteri;
	}
	public List<Fatura> getList_fatura() {
		return list_fatura;
	}
	protected HtmlForm form1;
	protected HtmlInputText text1;
	protected HtmlCommandExButton bmusttelara;
	protected HtmlCommandExButton bmustadiara;
	protected HtmlSelectOneMenu menu1;
	protected HtmlCommandExButton bfaturagetir;
	protected HtmlCommandExButton bgeridon;
	protected HtmlDataTableEx tableEx1;
	protected UIColumnEx columnEx1;
	protected HtmlOutputText text2;
	protected UIColumnEx columnEx3;
	protected HtmlOutputText text3;
	protected UIColumnEx columnEx4;
	protected HtmlOutputText text4;
	protected UIColumnEx columnEx5;
	protected HtmlOutputText text5;
	protected UIColumnEx columnEx6;
	protected HtmlOutputText text6;
	protected HtmlOutputText text7;
	protected HtmlOutputText text8;
	protected HtmlOutputText text9;
	protected HtmlOutputText text10;
	protected HtmlOutputText text11;
	protected HtmlSelectOneMenu menu2;
	protected HtmlCommandExButton bgit;
	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}
	protected HtmlInputText getText1() {
		if (text1 == null) {
			text1 = (HtmlInputText) findComponentInRoot("text1");
		}
		return text1;
	}
	protected HtmlCommandExButton getBmusttelara() {
		if (bmusttelara == null) {
			bmusttelara = (HtmlCommandExButton) findComponentInRoot("bmusttelara");
		}
		return bmusttelara;
	}
	protected HtmlCommandExButton getBmustadiara() {
		if (bmustadiara == null) {
			bmustadiara = (HtmlCommandExButton) findComponentInRoot("bmustadiara");
		}
		return bmustadiara;
	}
	protected HtmlSelectOneMenu getMenu1() {
		if (menu1 == null) {
			menu1 = (HtmlSelectOneMenu) findComponentInRoot("menu1");
		}
		return menu1;
	}
	protected HtmlCommandExButton getBfaturagetir() {
		if (bfaturagetir == null) {
			bfaturagetir = (HtmlCommandExButton) findComponentInRoot("bfaturagetir");
		}
		return bfaturagetir;
	}
	public String doBgeridonAction() {
		ara="";
		musteri_id=0;
		list_musteri=null;
		list_fatura=null;
		url="";
		list_menu=null;
		if(Session.admin_giris)
			return "admin_giris?faces-redirect=true";
		if(Session.normal_giris)
			return "normal_giris?faces-redirect=true";
		return "";
	}
	protected HtmlCommandExButton getBgeridon() {
		if (bgeridon == null) {
			bgeridon = (HtmlCommandExButton) findComponentInRoot("bgeridon");
		}
		return bgeridon;
	}
	protected HtmlDataTableEx getTableEx1() {
		if (tableEx1 == null) {
			tableEx1 = (HtmlDataTableEx) findComponentInRoot("tableEx1");
		}
		return tableEx1;
	}
	protected UIColumnEx getColumnEx1() {
		if (columnEx1 == null) {
			columnEx1 = (UIColumnEx) findComponentInRoot("columnEx1");
		}
		return columnEx1;
	}
	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}
	protected UIColumnEx getColumnEx3() {
		if (columnEx3 == null) {
			columnEx3 = (UIColumnEx) findComponentInRoot("columnEx3");
		}
		return columnEx3;
	}
	protected HtmlOutputText getText3() {
		if (text3 == null) {
			text3 = (HtmlOutputText) findComponentInRoot("text3");
		}
		return text3;
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
	protected UIColumnEx getColumnEx5() {
		if (columnEx5 == null) {
			columnEx5 = (UIColumnEx) findComponentInRoot("columnEx5");
		}
		return columnEx5;
	}
	protected HtmlOutputText getText5() {
		if (text5 == null) {
			text5 = (HtmlOutputText) findComponentInRoot("text5");
		}
		return text5;
	}
	protected UIColumnEx getColumnEx6() {
		if (columnEx6 == null) {
			columnEx6 = (UIColumnEx) findComponentInRoot("columnEx6");
		}
		return columnEx6;
	}
	protected HtmlOutputText getText6() {
		if (text6 == null) {
			text6 = (HtmlOutputText) findComponentInRoot("text6");
		}
		return text6;
	}
	protected HtmlOutputText getText7() {
		if (text7 == null) {
			text7 = (HtmlOutputText) findComponentInRoot("text7");
		}
		return text7;
	}
	protected HtmlOutputText getText8() {
		if (text8 == null) {
			text8 = (HtmlOutputText) findComponentInRoot("text8");
		}
		return text8;
	}
	protected HtmlOutputText getText9() {
		if (text9 == null) {
			text9 = (HtmlOutputText) findComponentInRoot("text9");
		}
		return text9;
	}
	protected HtmlOutputText getText10() {
		if (text10 == null) {
			text10 = (HtmlOutputText) findComponentInRoot("text10");
		}
		return text10;
	}
	protected HtmlOutputText getText11() {
		if (text11 == null) {
			text11 = (HtmlOutputText) findComponentInRoot("text11");
		}
		return text11;
	}
	public String doBmusttelaraAction() {
		list_musteri=new Db().list_musteri_telno_gore_arama(ara);
		return "";
	}
	public String doBmustadiaraAction() {
		list_musteri=new Db().list_musteri_ada_gore_arama(ara);
		return "";
	}
	public String doBfaturagetirAction() {
		list_fatura=new Db().list_fatura_gonder(musteri_id);
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
		ara="";
		musteri_id=0;
		list_musteri=null;
		list_fatura=null;
		list_menu=null;
		return url;
	}

}