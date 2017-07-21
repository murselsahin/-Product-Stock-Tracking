<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Urun_ekle.java" --%><%-- /jsf:pagecode --%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Urun Ekle</title>
<link rel="stylesheet" type="text/css" title="Style"
	href="theme/stylesheet.css">
</head>
<f:view>
	<body>
	<hx:scriptCollector preRender="#{pc_Urun_ekle.onPageLoadBegin}">
		<h:form id="form1" styleClass="form">
		<table align=center>
		<tr>
		<td><h:selectOneMenu id="menu3" styleClass="selectOneMenu" value="#{pc_Urun_ekle.url }">
		<f:selectItems value="#{pc_Urun_ekle.list_menu }" var="abc"
		itemValue="#{abc.url }" itemLabel="#{abc.baslik }"/>
		</h:selectOneMenu></td>
		<td><hx:commandExButton type="submit" value="Git" id="bgit"
								styleClass="commandExButton" action="#{pc_Urun_ekle.doBgitAction}"></hx:commandExButton></td>
		</tr>
		</table>
			<table border="1" align="center">
				<tbody>
					<tr>
						<td>Ust Kategori :</td>
						<td><h:selectOneMenu id="menu1" styleClass="selectOneMenu" value="#{pc_Urun_ekle.ust_tip_id }">
						<f:selectItems value="#{pc_Urun_ekle.list_ust_tip }" var="abc"
						itemValue="#{abc.ust_tip_id }" itemLabel="#{abc.adi }"/>
						</h:selectOneMenu></td>
						<td><hx:commandExButton type="submit" value="Alt Kategori Getir" id="bgetir"
								styleClass="commandExButton" action="#{pc_Urun_ekle.doBgetirAction}"></hx:commandExButton></td>
					</tr>
					<tr>
						<td>Alt Kategori :</td>
						<td><h:selectOneMenu id="menu2" styleClass="selectOneMenu" value="#{pc_Urun_ekle.alt_tip_id }">
						<f:selectItems value="#{pc_Urun_ekle.list_alt_tip }" var="abc"
						itemValue="#{abc.alt_tip_id }" itemLabel="#{abc.adi }"/>
						</h:selectOneMenu></td>
					</tr>
					<tr>
						<td>Urun Adi :</td>
						<td><h:inputText id="text1" styleClass="inputText" value="#{pc_Urun_ekle.urun_adi }"></h:inputText></td>
					</tr>
					<tr>
						<td>Aciklamasi :</td>
						<td><h:inputTextarea id="textarea1" styleClass="inputTextarea" rows="10" value="#{pc_Urun_ekle.aciklamasi }"></h:inputTextarea></td>
					</tr>
					<tr>
						<td>Fiyati :</td>
						<td><h:inputText id="text2" styleClass="inputText" size="15" value="#{pc_Urun_ekle.fiyat }"></h:inputText></td>
					</tr>
					<tr>
						<td>Garanti Suresi :</td>
						<td><h:inputText id="text3" styleClass="inputText" size="6" value="#{pc_Urun_ekle.garanti }"></h:inputText></td>
					</tr>
					<tr>
						<td>Stok :</td>
						<td><h:inputText id="text4" styleClass="inputText" size="6" value="#{pc_Urun_ekle.stok }"></h:inputText></td>
					</tr>
					<tr>
						<td><hx:commandExButton type="submit" value="Ekle" id="burunekle"
								styleClass="commandExButton" action="#{pc_Urun_ekle.doBurunekleAction}"></hx:commandExButton></td>
						<td><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
								styleClass="commandExButton" action="#{pc_Urun_ekle.doBgeridonAction}"></hx:commandExButton></td>
					</tr>
					<tr>
					<td colspan=3><h:outputText id="text5" styleClass="outputText" value="#{pc_Urun_ekle.sonuc }"></h:outputText></td>
					</tr>
				</tbody>
			</table>
		</h:form>
		</hx:scriptCollector>
	</body>
</f:view>
</html>