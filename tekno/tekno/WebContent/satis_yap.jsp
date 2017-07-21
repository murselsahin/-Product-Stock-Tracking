<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Satis_yap.java" --%><%-- /jsf:pagecode --%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Satis Yap</title>
<link rel="stylesheet" type="text/css" title="Style"
	href="theme/stylesheet.css">
</head>
<f:view>
	<body>
	<hx:scriptCollector preRender="#{pc_Satis_yap.onPageLoadBegin}">
		<h:form id="form1" styleClass="form">
		<table align=center>
		<tr>
		<td><h:selectOneMenu id="menu5" styleClass="selectOneMenu" value="#{pc_Satis_yap.url }">
		<f:selectItems value="#{pc_Satis_yap.list_menu }" var="abc"
		itemValue="#{abc.url }" itemLabel="#{abc.baslik }"/>
		</h:selectOneMenu></td>
		<td><h:commandButton type="submit" value="Git" id="bgit"
							styleClass="commandButton" action="#{pc_Satis_yap.doBgitAction}"></h:commandButton></td>
		</tr>
		</table>
			<table border="1" align="center">
				<tbody>
					<tr>
						<td><table>
								<tbody>
									<tr>
										<td>Ara :</td>
										<td><h:inputText id="text1" styleClass="inputText" value="#{pc_Satis_yap.ara }"></h:inputText></td>
									</tr>
									<tr>
										<td><hx:commandExButton type="submit" value="Must. Tel Ara"
												id="bmusttelara" styleClass="commandExButton" action="#{pc_Satis_yap.doBmusttelaraAction}"></hx:commandExButton></td>
										<td><hx:commandExButton type="submit" value="Must. Isim Ara"
												id="bmustisimara" styleClass="commandExButton" action="#{pc_Satis_yap.doBmustisimaraAction}"></hx:commandExButton></td>
									</tr>
									<tr>
										<td><hx:commandExButton type="submit" value="Urun ID Ara"
												id="burunidara" styleClass="commandExButton" action="#{pc_Satis_yap.doBurunidaraAction}"></hx:commandExButton></td>
										<td><hx:commandExButton type="submit" value="Urun Adi Ara"
												id="burunadiara" styleClass="commandExButton" action="#{pc_Satis_yap.doBurunadiaraAction}"></hx:commandExButton></td>
									</tr>
									<tr>
										<td>Musteri Adi :</td>
										<td><h:selectOneMenu id="menu1" styleClass="selectOneMenu" value="#{pc_Satis_yap.musteri_id }">
										<f:selectItems value="#{pc_Satis_yap.list_musteri }" var="abc"
										itemValue="#{abc.musteri_id }" itemLabel="#{abc.adi_soyadi }"/>
										</h:selectOneMenu></td>
									</tr>
									<tr>
										<td>Ust Kategori :</td>
										<td><h:selectOneMenu id="menu2" styleClass="selectOneMenu" value="#{pc_Satis_yap.ust_tip_id }">
										<f:selectItems value="#{pc_Satis_yap.list_ust_tip }" var="abc"
										itemValue="#{abc.ust_tip_id }" itemLabel="#{abc.adi }"/>
										</h:selectOneMenu></td>
										<td><hx:commandExButton type="submit" value="Alt Kat. Getir"
												id="baltgetir" styleClass="commandExButton" action="#{pc_Satis_yap.doBaltgetirAction}"></hx:commandExButton></td>
									</tr>
									<tr>
										<td>Alt Kategori :</td>
										<td><h:selectOneMenu id="menu3" styleClass="selectOneMenu" value="#{pc_Satis_yap.alt_tip_id }">
										<f:selectItems value="#{pc_Satis_yap.list_alt_tip }" var="abc"
										itemValue="#{abc.alt_tip_id }" itemLabel="#{abc.adi }"/>
										</h:selectOneMenu></td>
										<td><hx:commandExButton type="submit" value="Urunleri Getir"
												id="burunlerigetir" styleClass="commandExButton" action="#{pc_Satis_yap.doBurunlerigetirAction}"></hx:commandExButton></td>
									</tr>
									<tr>
										<td>Urun Adi :</td>
										<td><h:selectOneMenu id="menu4" styleClass="selectOneMenu" value="#{pc_Satis_yap.urun_id }">
										<f:selectItems value="#{pc_Satis_yap.list_urunler }" var="abc"
										itemValue="#{abc.urun_id }" itemLabel="#{abc.urun_adi }"/>
										</h:selectOneMenu></td>
										<td><hx:commandExButton type="submit" value="Urun Bilgisi"
												id="burunbilgisi" styleClass="commandExButton" action="#{pc_Satis_yap.doBurunbilgisiAction}"></hx:commandExButton></td>
									</tr>
									<tr>
										<td>Aciklamasi :</td>
										<td><h:outputText id="text2" styleClass="outputText" value="#{pc_Satis_yap.aciklama }"></h:outputText></td>
									</tr>
									<tr>
										<td>Fiyati :</td>
										<td><h:outputText id="text3" styleClass="outputText" value="#{pc_Satis_yap.fiyat }"></h:outputText></td>
									</tr>
									<tr>
										<td>Stok Durumu :</td>
										<td><h:outputText id="text4" styleClass="outputText" value="#{pc_Satis_yap.stok }"></h:outputText></td>
									</tr>
									<tr>
										<td>Garanti :</td>
										<td><h:outputText id="text5" styleClass="outputText" value="#{pc_Satis_yap.garanti }"></h:outputText></td>
									</tr>
									<tr>
										<td>Adet :</td>
										<td><h:inputText id="text6" styleClass="inputText" size="8" value="#{pc_Satis_yap.adet }"></h:inputText></td>
									</tr>
									<tr>
										<td colspan="2" align="center"><hx:commandExButton
												type="submit" value="Sepete Ekle" id="bsepeteekle"
												styleClass="commandExButton" action="#{pc_Satis_yap.doBsepeteekleAction}"></hx:commandExButton></td>
										
									</tr>
									<tr>
									<td colspan=2><h:outputText id="text9" styleClass="outputText" value="#{pc_Satis_yap.sepet_ekle_sonuc }"></h:outputText></td>
									</tr>
								</tbody>
							</table></td>
						<td valign="top"><table>
								<tbody>
									<tr>
										<td colspan=3 align=center><h4>Sepet</h4></td>
										
									</tr>
									<tr>
										<td>Urun Adi</td>
										<td>Adet</td>
										<td>Birim Fiyat</td>
										<td>Toplam Fiyat</td>
									</tr>
									<tr>
										<td><h:selectOneListbox id="listbox1"
												styleClass="selectOneListbox" size="13" value="#{pc_Satis_yap.secilen_urun_id }">
												<f:selectItems value="#{pc_Satis_yap.list_sepet }" var="abc"
												itemLabel="#{abc.urun_adi }" itemValue="#{abc.urun_id }"/>
												</h:selectOneListbox></td>
										<td><h:selectOneListbox id="listbox2"
												styleClass="selectOneListbox"  size="13" disabled="true">
												<f:selectItems value="#{pc_Satis_yap.list_sepet }" var="abc"
												itemLabel="#{abc.adet }"/>
												</h:selectOneListbox></td>
										<td>
										<h:selectOneListbox id="listbox5"
												styleClass="selectOneListbox"  size="13" disabled="true">
											<f:selectItems value="#{pc_Satis_yap.list_sepet }" var="abc"
												itemLabel="#{abc.birim_fiyat}"/>	
												</h:selectOneListbox>
										</td>
										<td><h:selectOneListbox id="listbox3"
												styleClass="selectOneListbox"  size="13" disabled="true">
											<f:selectItems value="#{pc_Satis_yap.list_sepet }" var="abc"
												itemLabel="#{abc.fiyat }"/>	
												</h:selectOneListbox></td>
									</tr>
									<tr>
										<td colspan="3">Toplam Fiyat <h:outputText id="text7"
												styleClass="outputText" value="#{pc_Satis_yap.toplam_fiyat }"></h:outputText></td>
										
									</tr>
									<tr>
										<td><hx:commandExButton type="submit" value="Satis Yap"
												id="bsatisyap" styleClass="commandExButton" action="#{pc_Satis_yap.doBsatisyapAction}"></hx:commandExButton></td>
										
												
												<td colspan=2><hx:commandExButton type="submit" value="Sepeti Bosalt"
												id="bsepetbosalt" styleClass="commandExButton" action="#{pc_Satis_yap.doBsepetbosaltAction}"></hx:commandExButton></td>
										
									</tr>
									<tr>
										<td colspan=2><h:outputText id="text8" styleClass="outputText" value="#{pc_Satis_yap.satis_sonuc }"></h:outputText></td>
										
									</tr>
									<tr>
									<td><h:commandButton type="submit" value="Geri Don" id="bgeridon"
												styleClass="commandButton" action="#{pc_Satis_yap.doBgeridonAction}"></h:commandButton></td>
									</tr>
								</tbody>
							</table></td>
					</tr>
				</tbody>
			</table>
		</h:form>
</hx:scriptCollector>
	</body>
</f:view>
</html>