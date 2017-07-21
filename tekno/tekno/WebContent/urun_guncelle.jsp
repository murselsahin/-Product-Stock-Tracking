<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Stok_ekle.java" --%><%-- /jsf:pagecode --%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Urun Guncelle</title>
<link rel="stylesheet" type="text/css" title="Style"
	href="theme/stylesheet.css">
</head>
<f:view>
	<body>
	<hx:scriptCollector preRender="#{pc_Stok_ekle.onPageLoadBegin}">
		<h:form id="form1" styleClass="form">
		<table align=center>
		<tr>
		<td><h:selectOneMenu id="menu4" styleClass="selectOneMenu" value="#{pc_Stok_ekle.url }">
		<f:selectItems value="#{pc_Stok_ekle.list_menu }" var="abc"
		itemValue="#{abc.url }" itemLabel="#{abc.baslik }"/>
		</h:selectOneMenu></td>
		<td><hx:commandExButton type="submit" value="Git" id="bgit"
								styleClass="commandExButton" action="#{pc_Stok_ekle.doBgitAction}"></hx:commandExButton></td>
		</tr>
		</table>
			<table border="1" align="center">
				<tbody>
					<tr>
						<td>Ara :</td>
						<td><h:inputText id="text1" styleClass="inputText" value="#{pc_Stok_ekle.ara }"></h:inputText></td>
						<td><hx:commandExButton type="submit" value="Urun Adini Ara" id="burunadiara"
								styleClass="commandExButton" action="#{pc_Stok_ekle.doBurunadiaraAction}"></hx:commandExButton></td>
					</tr>
					<tr>
						<td>Ust Kategori :</td>
						<td><h:selectOneMenu id="menu1" styleClass="selectOneMenu" value="#{pc_Stok_ekle.ust_tip_id }">
						<f:selectItems value="#{pc_Stok_ekle.list_ust_tip }" var="abc"
						itemValue="#{abc.ust_tip_id }" itemLabel="#{abc.adi }"/>
						</h:selectOneMenu></td>
						<td><hx:commandExButton type="submit" value="Alt Kategori Getir" id="baltgetir"
								styleClass="commandExButton" action="#{pc_Stok_ekle.doBaltgetirAction}"></hx:commandExButton></td>
					</tr>
					<tr>
						<td>Alt Kategori :</td>
						<td><h:selectOneMenu id="menu2" styleClass="selectOneMenu" value="#{pc_Stok_ekle.alt_tip_id }">
						<f:selectItems value="#{pc_Stok_ekle.list_alt_tip }" var="abc"
						itemValue="#{abc.alt_tip_id }" itemLabel="#{abc.adi }"/>
						</h:selectOneMenu></td>
						<td><hx:commandExButton type="submit" value="Urun Getir" id="burungetir"
								styleClass="commandExButton" action="#{pc_Stok_ekle.doBurungetirAction}"></hx:commandExButton></td>
					</tr>
					<tr>
						<td>Urun Adi :</td>
						<td><h:selectOneMenu id="menu3" styleClass="selectOneMenu" value="#{pc_Stok_ekle.urun_id }">
						<f:selectItems value="#{pc_Stok_ekle.list_urunler }" var="abc"
						itemValue="#{abc.urun_id }" itemLabel="#{abc.urun_adi }"/>
						</h:selectOneMenu></td>
						<td><hx:commandExButton type="submit" value="Urun Bilgisi" id="bstokbilgisi"
								styleClass="commandExButton" action="#{pc_Stok_ekle.doBstokbilgisiAction}"></hx:commandExButton></td>
						<td><h:outputText id="text2" styleClass="outputText" value="#{pc_Stok_ekle.guncel_stok }"></h:outputText></td>		
					</tr>
					<tr>
						<td>Eklenecek Stok :</td>
						<td><h:inputText id="text3" styleClass="inputText" size="8" value="#{pc_Stok_ekle.stok }"></h:inputText></td>
						<td></td>
						<td><h:outputText id="text5" styleClass="outputText" value="#{pc_Stok_ekle.guncel_fiyat }"></h:outputText></td>
					</tr>
					<tr>
					<td>Yeni Fiyati :</td>
					<td><h:inputText id="text6" styleClass="inputText" size="8" value="#{pc_Stok_ekle.fiyat }"></h:inputText></td>
					</tr>
					<tr>
						<td><hx:commandExButton type="submit" value="Stok Ekle" id="bstokekle"
								styleClass="commandExButton" action="#{pc_Stok_ekle.doBstokekleAction}"></hx:commandExButton></td>
						<td><h:commandButton type="submit" value="Fiyati Guncelle" id="bfiyatguncelle"
								styleClass="commandButton" action="#{pc_Stok_ekle.doBfiyatguncelleAction}"></h:commandButton></td>
						<td><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
								styleClass="commandExButton" action="#{pc_Stok_ekle.doBgeridonAction}"></hx:commandExButton></td>
					</tr>
					<tr>
						<td colspan=3><h:outputText id="text4" styleClass="outputText" value="#{pc_Stok_ekle.sonuc }"></h:outputText></td>
						
					</tr>
				</tbody>
			</table>
		</h:form>
</hx:scriptCollector>
	</body>
</f:view>
</html>