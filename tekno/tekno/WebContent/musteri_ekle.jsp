<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Musteri_ekle.java" --%><%-- /jsf:pagecode --%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Musteri Ekle</title>
<link rel="stylesheet" type="text/css" title="Style"
	href="theme/stylesheet.css">
</head>
<f:view>
	<body>
	<hx:scriptCollector preRender="#{pc_Musteri_ekle.onPageLoadBegin}">
		<h:form id="form1" styleClass="form">
		<table align=center>
		<tr>
		<td><h:selectOneMenu id="menu1" styleClass="selectOneMenu" value="#{pc_Musteri_ekle.url }">
		<f:selectItems value="#{pc_Musteri_ekle.list_menu }" var="abc"
		itemValue="#{abc.url }" itemLabel="#{abc.baslik }"/>
		</h:selectOneMenu></td>
		<td><h:commandButton type="submit" value="Git" id="bgit"
								styleClass="commandButton" action="#{pc_Musteri_ekle.doBgitAction}"></h:commandButton></td>
		</tr>
		</table>
			<table border="1" align="center">
				<tbody>
					<tr>
						<td>Adi :</td>
						<td><h:inputText id="text1" styleClass="inputText" value="#{pc_Musteri_ekle.adi}"></h:inputText></td>
					</tr>
					<tr>
						<td>Soyadi :</td>
						<td><h:inputText id="text2" styleClass="inputText" value="#{pc_Musteri_ekle.soyadi }"></h:inputText></td>
					</tr>
					<tr>
						<td>Tel No :</td>
						<td><h:inputText id="text3" styleClass="inputText" value="#{pc_Musteri_ekle.telno }"></h:inputText></td>
					</tr>
					<tr>
						<td>Yas :</td>
						<td><h:inputText id="text4" styleClass="inputText" size="4" value="#{pc_Musteri_ekle.yas }"></h:inputText></td>
					</tr>
					<tr>
						<td>Cinsiyet</td>
						<td><h:selectOneRadio disabledClass="selectOneRadio_Disabled"
								enabledClass="selectOneRadio_Enabled" id="radio1"
								styleClass="selectOneRadio" value="#{pc_Musteri_ekle.cinsiyet }">
							<f:selectItem itemValue="bay" itemLabel="Bay"/>	
							<f:selectItem itemValue="bayan" itemLabel="Bayan"/>	
								</h:selectOneRadio></td>
					</tr>
					<tr>
						<td>Adres :</td>
						<td><h:inputTextarea id="textarea1" styleClass="inputTextarea" rows="10" value="#{pc_Musteri_ekle.adres }"></h:inputTextarea></td>
					</tr>
					<tr>
						<td><hx:commandExButton type="submit" value="Kayit Yap" id="bkayityap"
								styleClass="commandExButton" action="#{pc_Musteri_ekle.doBkayityapAction}"></hx:commandExButton></td>
						<td><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
								styleClass="commandExButton" action="#{pc_Musteri_ekle.doBgeridonAction}"></hx:commandExButton></td>
					</tr>
					<tr>
						<td colspan=2><h:outputText id="text5" styleClass="outputText" value="#{pc_Musteri_ekle.sonuc }"></h:outputText></td>
						
					</tr>
				</tbody>
			</table>
		</h:form>
</hx:scriptCollector>
	</body>
</f:view>
</html>