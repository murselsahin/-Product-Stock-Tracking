<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Kullanici_ekle.java" --%><%-- /jsf:pagecode --%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kullanici Ekle</title>
<link rel="stylesheet" type="text/css" title="Style"
	href="theme/stylesheet.css">
</head>
<f:view>
	<body>
	<hx:scriptCollector preRender="#{pc_Kullanici_ekle.onPageLoadBegin}">
		<h:form id="form1" styleClass="form">
		<table align=center>
		<tr>
		<td><h:selectOneMenu id="menu2" styleClass="selectOneMenu" value="#{pc_Kullanici_ekle.url }">
		<f:selectItems value="#{pc_Kullanici_ekle.list_menu }" var="abc"
		itemValue="#{abc.url }" itemLabel="#{abc.baslik }"/>
		</h:selectOneMenu></td>
		<td><hx:commandExButton type="submit" value="Git" id="bgit"
								styleClass="commandExButton" action="#{pc_Kullanici_ekle.doBgitAction}"></hx:commandExButton></td>
		</tr>
		</table>
			<table border="1" align="center">
				<tbody>
					<tr>
						<td>Kullanici Adi :</td>
						<td><h:inputText id="text1" styleClass="inputText" value="#{pc_Kullanici_ekle.kullanici_adi }"></h:inputText></td>
					</tr>
					<tr>
						<td>Sifre :</td>
						<td><h:inputSecret id="secret1" styleClass="inputSecret"  value="#{pc_Kullanici_ekle.sifre }"></h:inputSecret></td>
					</tr>
					<tr>
						<td>Adi :</td>
						<td><h:inputText id="text2" styleClass="inputText" value="#{pc_Kullanici_ekle.adi }"></h:inputText></td>
					</tr>
					<tr>
						<td>Soyadi :</td>
						<td><h:inputText id="text3" styleClass="inputText" value="#{pc_Kullanici_ekle.soyadi }"></h:inputText></td>
					</tr>
					<tr>
						<td>Yetki</td>
						<td><h:selectOneMenu id="menu1" styleClass="selectOneMenu" value="#{pc_Kullanici_ekle.yetki }">
						<f:selectItem itemValue="1" itemLabel="Ust Yetkili"/>
						<f:selectItem itemValue="0" itemLabel="Normal Yetili"/>
						</h:selectOneMenu></td>
					</tr>
					<tr>
						<td><hx:commandExButton type="submit" value="Ekle" id="bekle"
								styleClass="commandExButton" action="#{pc_Kullanici_ekle.doBekleAction}"></hx:commandExButton></td>
						<td><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
								styleClass="commandExButton" action="#{pc_Kullanici_ekle.doBgeridonAction}"></hx:commandExButton></td>
					</tr>
					<tr>
						<td colspan="2"><h:outputText id="text4" styleClass="outputText" value="#{pc_Kullanici_ekle.sonuc }"></h:outputText></td>
						
					</tr>
				</tbody>
			</table>
		</h:form>
</hx:scriptCollector>
	</body>
</f:view>
</html>