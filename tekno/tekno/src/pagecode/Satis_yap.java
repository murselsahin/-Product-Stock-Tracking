/**
 * 
 */
package pagecode;

import java.util.List;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneListbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;

import com.db.Alt_tip;
import com.db.Db;
import com.db.Menuler;
import com.db.Musteriler;
import com.db.Sepet;
import com.db.Urunler;
import com.db.Ust_tip;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.session.Session;
/**
 * @author Emre
 *
 */
public class Satis_yap extends PageCodeBase {
	String ara;
	int musteri_id;
	List<Musteriler> list_musteri;
	int ust_tip_id;
	List<Ust_tip> list_ust_tip;
	int alt_tip_id;
	List<Alt_tip> list_alt_tip;
	int urun_id;
	List<Urunler> list_urunler;
	String aciklama;
	String fiyat;
	String stok;
	String garanti;
	String adet;
	int secilen_urun_id;
	String satis_sonuc;
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
	public String getSatis_sonuc() {
		return satis_sonuc;
	}

	public int getSecilen_urun_id() {
		return secilen_urun_id;
	}

	public void setSecilen_urun_id(int secilen_urun_id) {
		this.secilen_urun_id = secilen_urun_id;
	}

	int[] dizi_urun_id=new int[0];
	String[] dizi_urun_adi=new String[0];
	int[] dizi_adet=new int[0];
	int[] dizi_fiyat=new int[0];
	int[] dizi_birim_fiyat=new int[0];
	String sepet_ekle_sonuc;
	List<Sepet> list_sepet;
	String toplam_fiyat;
	
	
	
	
	public String getToplam_fiyat() {
		int t_fiyat=0;
		for(int i=0;i<dizi_fiyat.length;i++)
			t_fiyat+=dizi_fiyat[i];
		toplam_fiyat=t_fiyat+" TL";
		return toplam_fiyat;
	}

	public List<Sepet> getList_sepet() {
		return list_sepet;
	}

	public String getSepet_ekle_sonuc() {
		return sepet_ekle_sonuc;
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

	public String getAdet() {
		return adet;
	}

	public void setAdet(String adet) {
		this.adet = adet;
	}

	public List<Musteriler> getList_musteri() {
		return list_musteri;
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

	public String getAciklama() {
		return aciklama;
	}

	public String getFiyat() {
		return fiyat;
	}

	public String getStok() {
		return stok;
	}

	public String getGaranti() {
		return garanti;
	}

	protected HtmlInputText text1;
	protected HtmlForm form1;
	protected HtmlCommandExButton bmusttelara;
	protected HtmlCommandExButton bmustisimara;
	protected HtmlCommandExButton burunidara;
	protected HtmlCommandExButton burunadiara;
	protected HtmlSelectOneMenu menu1;
	protected HtmlSelectOneMenu menu2;
	protected HtmlCommandExButton baltgetir;
	protected HtmlSelectOneMenu menu3;
	protected HtmlCommandExButton burunlerigetir;
	protected HtmlSelectOneMenu menu4;
	protected HtmlCommandExButton burunbilgisi;
	protected HtmlOutputText text2;
	protected HtmlOutputText text3;
	protected HtmlOutputText text4;
	protected HtmlOutputText text5;
	protected HtmlInputText text6;
	protected HtmlCommandExButton bsepeteekle;
	protected HtmlSelectOneListbox listbox1;
	protected HtmlSelectOneListbox listbox2;
	protected HtmlOutputText text7;
	protected HtmlCommandExButton bsatisyap;
	protected HtmlOutputText text8;
	protected HtmlCommandButton bgeridon;
	protected HtmlOutputText text9;
	protected HtmlSelectOneListbox listbox3;
	protected HtmlSelectOneListbox listbox5;
	protected HtmlCommandExButton bsepetbosalt;
	protected HtmlSelectOneMenu menu5;
	protected HtmlCommandButton bgit;
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

	protected HtmlCommandExButton getBmusttelara() {
		if (bmusttelara == null) {
			bmusttelara = (HtmlCommandExButton) findComponentInRoot("bmusttelara");
		}
		return bmusttelara;
	}

	protected HtmlCommandExButton getBmustisimara() {
		if (bmustisimara == null) {
			bmustisimara = (HtmlCommandExButton) findComponentInRoot("bmustisimara");
		}
		return bmustisimara;
	}

	protected HtmlCommandExButton getBurunidara() {
		if (burunidara == null) {
			burunidara = (HtmlCommandExButton) findComponentInRoot("burunidara");
		}
		return burunidara;
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

	protected HtmlSelectOneMenu getMenu2() {
		if (menu2 == null) {
			menu2 = (HtmlSelectOneMenu) findComponentInRoot("menu2");
		}
		return menu2;
	}

	protected HtmlCommandExButton getBaltgetir() {
		if (baltgetir == null) {
			baltgetir = (HtmlCommandExButton) findComponentInRoot("baltgetir");
		}
		return baltgetir;
	}

	protected HtmlSelectOneMenu getMenu3() {
		if (menu3 == null) {
			menu3 = (HtmlSelectOneMenu) findComponentInRoot("menu3");
		}
		return menu3;
	}

	protected HtmlCommandExButton getBurunlerigetir() {
		if (burunlerigetir == null) {
			burunlerigetir = (HtmlCommandExButton) findComponentInRoot("burunlerigetir");
		}
		return burunlerigetir;
	}

	protected HtmlSelectOneMenu getMenu4() {
		if (menu4 == null) {
			menu4 = (HtmlSelectOneMenu) findComponentInRoot("menu4");
		}
		return menu4;
	}

	protected HtmlCommandExButton getBurunbilgisi() {
		if (burunbilgisi == null) {
			burunbilgisi = (HtmlCommandExButton) findComponentInRoot("burunbilgisi");
		}
		return burunbilgisi;
	}

	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}

	protected HtmlOutputText getText3() {
		if (text3 == null) {
			text3 = (HtmlOutputText) findComponentInRoot("text3");
		}
		return text3;
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

	protected HtmlInputText getText6() {
		if (text6 == null) {
			text6 = (HtmlInputText) findComponentInRoot("text6");
		}
		return text6;
	}

	protected HtmlCommandExButton getBsepeteekle() {
		if (bsepeteekle == null) {
			bsepeteekle = (HtmlCommandExButton) findComponentInRoot("bsepeteekle");
		}
		return bsepeteekle;
	}

	protected HtmlSelectOneListbox getListbox1() {
		if (listbox1 == null) {
			listbox1 = (HtmlSelectOneListbox) findComponentInRoot("listbox1");
		}
		return listbox1;
	}

	protected HtmlSelectOneListbox getListbox2() {
		if (listbox2 == null) {
			listbox2 = (HtmlSelectOneListbox) findComponentInRoot("listbox2");
		}
		return listbox2;
	}

	protected HtmlOutputText getText7() {
		if (text7 == null) {
			text7 = (HtmlOutputText) findComponentInRoot("text7");
		}
		return text7;
	}

	protected HtmlCommandExButton getBsatisyap() {
		if (bsatisyap == null) {
			bsatisyap = (HtmlCommandExButton) findComponentInRoot("bsatisyap");
		}
		return bsatisyap;
	}

	protected HtmlOutputText getText8() {
		if (text8 == null) {
			text8 = (HtmlOutputText) findComponentInRoot("text8");
		}
		return text8;
	}

	protected HtmlCommandButton getBgeridon() {
		if (bgeridon == null) {
			bgeridon = (HtmlCommandButton) findComponentInRoot("bgeridon");
		}
		return bgeridon;
	}

	public String doBgeridonAction() {
		ara="";
		musteri_id=0;
		list_musteri=null;
		ust_tip_id=0;
		list_ust_tip=null;
		alt_tip_id=0;
		list_alt_tip=null;
		urun_id=0;
		list_urunler=null;
		aciklama="";
		fiyat="";
		stok="";
		garanti="";
		adet="";
		secilen_urun_id=0;
		satis_sonuc="";
		dizi_urun_id=new int[0];
		dizi_urun_adi=new String[0];
		dizi_adet=new int[0];
		dizi_fiyat=new int[0];
		dizi_birim_fiyat=new int[0];
		sepet_ekle_sonuc="";
		list_sepet=null;
		toplam_fiyat="";
		list_menu=null;
		
		
		if(Session.admin_giris)
			return "admin_giris?faces-redirect=true";
		if(Session.normal_giris)
			return "normal_giris?faces-redirect=true";
		return "";
	}

	public String doBmusttelaraAction() {
		list_musteri=new Db().list_musteri_telno_gore_arama(ara);
		return "";
	}

	public String doBmustisimaraAction() {
		list_musteri=new Db().list_musteri_ada_gore_arama(ara);
		return "";
	}

	public String doBurunidaraAction() {
		try
		{
			int urun_id=Integer.parseInt(ara);
			list_urunler=new Db().list_urun_idye_gore_getir(urun_id);
			
		}catch(Exception ex)
		{
			
		}
		return "";
	}

	public String doBurunadiaraAction() {
		list_urunler=new Db().list_urun_adina_gore_ara(ara);
		return "";
	}

	public String doBaltgetirAction() {
		if(ust_tip_id==0)
			return "";
		list_alt_tip=new Db().list_alt_tip_gonder(ust_tip_id);
		return "";
	}

	public String doBurunlerigetirAction() {
		if(alt_tip_id==0)
			return "";
		list_urunler=new Db().list_urun_alt_tip_idye_gore_getir(alt_tip_id);
		return "";
	}

	public String doBurunbilgisiAction() {
		if(urun_id==0)
			return "";
		String[] bilgi=new Db().urun_bilgisi_aciklama_fiyat_garanti_stok(urun_id);
		aciklama=bilgi[0];
		fiyat=bilgi[1]+" TL";
		garanti=bilgi[2]+" YIL";
		stok=bilgi[3]+ " adet";
		return "";
	}

	public String doBsepeteekleAction() {
		try
		{
			int adet=Integer.parseInt(this.adet);
			if(adet<0)
				return "";
			if(urun_id==0)
				return "";
			String[] bilgi=new Db().urun_bilgisi_aciklama_fiyat_garanti_stok(urun_id);
			int birim_fiyat=Integer.parseInt(bilgi[1]);
			String urun_adi=new Db().urun_idden_urunadi_getir(urun_id);
			int index=urun_varmi(urun_id);
			int boyut=dizi_urun_id.length;
			int stok = new Db().urun_idden_stok_getir(urun_id);
			if(index==-1) //aynı urunden yok
			{
				
				if(adet>stok)
				{
					
					sepet_ekle_sonuc="Stok yetersiz";
					return "";
					
				}
				int[] temp_urun_id=new int[boyut];
				String[] temp_urun_adi=new String[boyut];
				int[] temp_adet=new int[boyut];
				int[] temp_fiyat=new int[boyut];
				int[] temp_birim_fiyat=new int[boyut];
				for(int i=0;i<boyut;i++)
				{
					temp_urun_id[i]=dizi_urun_id[i];
					temp_urun_adi[i]=dizi_urun_adi[i];
					temp_adet[i]=dizi_adet[i];
					temp_fiyat[i]=dizi_fiyat[i];
					temp_birim_fiyat[i]=dizi_birim_fiyat[i];
				}
				dizi_urun_id=new int[boyut+1];
				dizi_urun_adi=new String[boyut+1];
				dizi_adet=new int[boyut+1];
				dizi_fiyat=new int[boyut+1];
				dizi_birim_fiyat=new int[boyut+1];
				for(int i=0;i<boyut;i++)
				{
					dizi_urun_id[i]=temp_urun_id[i];
					dizi_urun_adi[i]=temp_urun_adi[i];
					dizi_adet[i]=temp_adet[i];
					dizi_fiyat[i]=temp_fiyat[i];
					dizi_birim_fiyat[i]=temp_birim_fiyat[i];
				}
				dizi_urun_id[boyut]=urun_id;
				dizi_urun_adi[boyut]=urun_adi;
				dizi_birim_fiyat[boyut]=birim_fiyat;
				dizi_adet[boyut]=adet;
				dizi_fiyat[boyut]=dizi_adet[boyut]*birim_fiyat;
				
				
				
			}
			else //aynı_urunden var
			{
				if(dizi_adet[index]+adet>stok)
				{
					sepet_ekle_sonuc="Stok yetersiz";
					return "";
					
				}
				dizi_adet[index]=dizi_adet[index]+adet;
				dizi_fiyat[index]=dizi_adet[index]*dizi_birim_fiyat[index];
				
			}
			sepet_ekle_sonuc="";
			list_sepet=new Db().list_sepet_getir(dizi_urun_adi, dizi_adet, dizi_fiyat,dizi_birim_fiyat,dizi_urun_id);
			this.adet="";
		
			
			
		}catch(Exception ex)
		{
			sepet_ekle_sonuc="Girdi Hatali";
		}
		return "";
	}
	public int urun_varmi(int urun_id)
	{
		for(int i=0;i<dizi_urun_id.length;i++)
			if(dizi_urun_id[i]==urun_id)
				return i;
		return -1;
		
	}

	protected HtmlOutputText getText9() {
		if (text9 == null) {
			text9 = (HtmlOutputText) findComponentInRoot("text9");
		}
		return text9;
	}

	protected HtmlSelectOneListbox getListbox3() {
		if (listbox3 == null) {
			listbox3 = (HtmlSelectOneListbox) findComponentInRoot("listbox3");
		}
		return listbox3;
	}

	protected HtmlSelectOneListbox getListbox5() {
		if (listbox5 == null) {
			listbox5 = (HtmlSelectOneListbox) findComponentInRoot("listbox5");
		}
		return listbox5;
	}

	protected HtmlCommandExButton getBsepetbosalt() {
		if (bsepetbosalt == null) {
			bsepetbosalt = (HtmlCommandExButton) findComponentInRoot("bsepetbosalt");
		}
		return bsepetbosalt;
	}

	public String doBsepetbosaltAction() {
		dizi_urun_id=new int[0];
		dizi_urun_adi=new String[0];
		dizi_adet=new int[0];
		dizi_fiyat=new int[0];
		dizi_birim_fiyat=new int[0];
		list_sepet=null;
		
		return "";
	}

	public String doBsatisyapAction() {
		if(musteri_id==0)
		{
			satis_sonuc="Musteriyi Seciniz";
			return "";
		}
		if(dizi_urun_id.length==0)
		{
			satis_sonuc="Sepet Bos";
			return "";
		}
		satis_sonuc="Satis Basarili";
		for(int i=0;i<dizi_urun_id.length;i++)
		{
			if(!(new Db().satis_yap(dizi_urun_id[i], Session.satis_elemani_id, musteri_id, dizi_adet[i], dizi_fiyat[i])))
				satis_sonuc="Sorun Olustu";
		}
		if(satis_sonuc.equals("Satis Basarili"))
			doBsepetbosaltAction();
		
		return "";
	}

	protected HtmlSelectOneMenu getMenu5() {
		if (menu5 == null) {
			menu5 = (HtmlSelectOneMenu) findComponentInRoot("menu5");
		}
		return menu5;
	}

	protected HtmlCommandButton getBgit() {
		if (bgit == null) {
			bgit = (HtmlCommandButton) findComponentInRoot("bgit");
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
		ust_tip_id=0;
		list_ust_tip=null;
		alt_tip_id=0;
		list_alt_tip=null;
		urun_id=0;
		list_urunler=null;
		aciklama="";
		fiyat="";
		stok="";
		garanti="";
		adet="";
		secilen_urun_id=0;
		satis_sonuc="";
		dizi_urun_id=new int[0];
		dizi_urun_adi=new String[0];
		dizi_adet=new int[0];
		dizi_fiyat=new int[0];
		dizi_birim_fiyat=new int[0];
		sepet_ekle_sonuc="";
		list_sepet=null;
		toplam_fiyat="";
		list_menu=null;
		return url;
	}

	

}