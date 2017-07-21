<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Fatura_goruntule.java" --%><%-- /jsf:pagecode --%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fatura Goruntule</title>
<link rel="stylesheet" type="text/css" title="Style"
	href="theme/stylesheet.css">
</head>
<f:view>
	<body>
	
<hx:scriptCollector preRender="#{pc_Fatura_goruntule.onPageLoadBegin}">
		<h:form id="form1" styleClass="form">
		<table align=center>
		<tr>
		<td><h:selectOneMenu id="menu2" styleClass="selectOneMenu" value="#{pc_Fatura_goruntule.url }">
		<f:selectItems value="#{pc_Fatura_goruntule.list_menu }" var="abc"
		itemValue="#{abc.url }" itemLabel="#{abc.baslik }"/>
		</h:selectOneMenu></td>
		<td><hx:commandExButton type="submit" value="Git" id="bgit"
								styleClass="commandExButton" action="#{pc_Fatura_goruntule.doBgitAction}"></hx:commandExButton></td>
		</tr>
		</table>
			<table align="center">
				<tbody>
					<tr>
						<td>Ara :</td>
						<td><h:inputText id="text1" styleClass="inputText" value="#{pc_Fatura_goruntule.ara }"></h:inputText></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td><hx:commandExButton type="submit" value="Must. Tel Ara" id="bmusttelara"
								styleClass="commandExButton" action="#{pc_Fatura_goruntule.doBmusttelaraAction}"></hx:commandExButton></td>
						<td><hx:commandExButton type="submit" value="Must. Adi Ara" id="bmustadiara"
								styleClass="commandExButton" action="#{pc_Fatura_goruntule.doBmustadiaraAction}"></hx:commandExButton></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>Musteri Adi :</td>
						<td><h:selectOneMenu id="menu1" styleClass="selectOneMenu" value="#{pc_Fatura_goruntule.musteri_id}">
						<f:selectItems value="#{pc_Fatura_goruntule.list_musteri }" var="abc"
						itemValue="#{abc.musteri_id }" itemLabel="#{abc.adi_soyadi }"/>
						</h:selectOneMenu></td>
						<td><hx:commandExButton type="submit" value="Fatura Getir" id="bfaturagetir"
								styleClass="commandExButton" action="#{pc_Fatura_goruntule.doBfaturagetirAction}"></hx:commandExButton></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="4"><hx:dataTableEx border="0" cellpadding="2"
								cellspacing="0" columnClasses="columnClass1"
								headerClass="headerClass" footerClass="footerClass"
								rowClasses="rowClass1, rowClass2" id="tableEx1"
								styleClass="dataTableEx" value="#{pc_Fatura_goruntule.list_fatura }" var="abc">
								<hx:columnEx id="columnEx1">
									<f:facet name="header">
										<h:outputText id="text2" styleClass="outputText"
											value="Urun Adi"></h:outputText>
									</f:facet>
									<h:outputText id="text7" styleClass="outputText" value="#{abc.urun_adi }"></h:outputText>
								</hx:columnEx>
								<hx:columnEx id="columnEx3">
									<f:facet name="header">
										<h:outputText id="text3" styleClass="outputText"
											value="Adet Miktari"></h:outputText>
									</f:facet>
									<h:outputText id="text8" styleClass="outputText" value="#{abc.adet }"></h:outputText>
								</hx:columnEx>
								<hx:columnEx id="columnEx4">
									<f:facet name="header">
										<h:outputText id="text4" styleClass="outputText"
											value="Tutar"></h:outputText>
									</f:facet>
									<h:outputText id="text9" styleClass="outputText" value="#{abc.tutar }"></h:outputText>
								</hx:columnEx>
								<hx:columnEx id="columnEx5">
									<f:facet name="header">
										<h:outputText id="text5" styleClass="outputText"
											value="Tarih"></h:outputText>
									</f:facet>
									<h:outputText id="text10" styleClass="outputText" value="#{abc.tarih }"></h:outputText>
								</hx:columnEx>
								<hx:columnEx id="columnEx6">
									<f:facet name="header">
										<h:outputText id="text6" styleClass="outputText"
											value="Islemi Yapan"></h:outputText>
									</f:facet>
									<h:outputText id="text11" styleClass="outputText" value="#{abc.islemi_yapan }"></h:outputText>
								</hx:columnEx>
							</hx:dataTableEx></td>
					
					</tr>
					
					<tr>
						<td><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
								styleClass="commandExButton" action="#{pc_Fatura_goruntule.doBgeridonAction}"></hx:commandExButton></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</h:form>
		</hx:scriptCollector>
	</body>
</f:view>
</html>