<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Urun_tarihi.java" --%><%-- /jsf:pagecode --%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Urun Gecmisi</title>
<link rel="stylesheet" type="text/css" title="Style"
	href="theme/stylesheet.css">
<script type="text/javascript">
function func_1(thisObj, thisEvent) {
submit();
}</script></head>
<f:view>
	<body>
	<hx:scriptCollector preRender="#{pc_Urun_tarihi.onPageLoadBegin}">
		<h:form id="form1" styleClass="form">
		<table align=center>
		<tr>
		<td><h:selectOneMenu id="menu4" styleClass="selectOneMenu" value="#{pc_Urun_tarihi.url }">
		<f:selectItems value="#{pc_Urun_tarihi.list_menu }" var="abc"
		itemValue="#{abc.url }" itemLabel="#{abc.baslik }"/>
		</h:selectOneMenu></td>
		<td><hx:commandExButton type="submit" value="Git" id="bgit"
								styleClass="commandExButton" action="#{pc_Urun_tarihi.doBgitAction}"></hx:commandExButton></td>
		</tr>
		</table>
			<table border="0" align="center">
				<tbody>
					<tr>
						<td>Ara :</td>
						<td><h:inputText id="text1" styleClass="inputText" value="#{pc_Urun_tarihi.ara }"></h:inputText></td>
						<td><hx:commandExButton type="submit" value="Urun Adi Ara" id="burunadiara"
								styleClass="commandExButton" action="#{pc_Urun_tarihi.doBurunadiaraAction}"></hx:commandExButton></td>
						<td></td>
					</tr>
					<tr>
						<td>Ust Kategori :</td>
						<td><h:selectOneMenu id="menu1" styleClass="selectOneMenu" value="#{pc_Urun_tarihi.ust_tip_id }">
						<f:selectItems value="#{pc_Urun_tarihi.list_ust_tip }" var="abc"
						itemValue="#{abc.ust_tip_id }" itemLabel="#{abc.adi }"/>
						</h:selectOneMenu></td>
						<td><hx:commandExButton type="submit" value="Alt Kat. Getir" id="baltgetir"
								styleClass="commandExButton" action="#{pc_Urun_tarihi.doBaltgetirAction}"></hx:commandExButton></td>
						<td></td>
					</tr>
					<tr>
						<td>Alt Kategori :</td>
						<td><h:selectOneMenu id="menu2" styleClass="selectOneMenu" value="#{pc_Urun_tarihi.alt_tip_id }">
						<f:selectItems value="#{pc_Urun_tarihi.list_alt_tip }" var="abc"
						itemValue="#{abc.alt_tip_id }" itemLabel="#{abc.adi }"/>
						</h:selectOneMenu></td>
						<td><hx:commandExButton type="submit" value="Urunleri Getir" id="burunlerigetir"
								styleClass="commandExButton" action="#{pc_Urun_tarihi.doBurunlerigetirAction}"></hx:commandExButton></td>
						<td></td>
					</tr>
					<tr>
						<td>Urun Adi :</td>
						<td><h:selectOneMenu id="menu3" styleClass="selectOneMenu" value="#{pc_Urun_tarihi.urun_id }">
						<f:selectItems value="#{pc_Urun_tarihi.list_urunler }" var="abc"
						itemValue="#{abc.urun_id }" itemLabel="#{abc.urun_adi }"/>
						</h:selectOneMenu></td>
						<td><hx:commandExButton type="submit" value="Tarihi" id="buruntarihi"
								styleClass="commandExButton" action="#{pc_Urun_tarihi.doBuruntarihiAction}"></hx:commandExButton></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="4"><h:selectOneRadio
								disabledClass="selectOneRadio_Disabled"
								enabledClass="selectOneRadio_Enabled" id="radio1"
								styleClass="selectOneRadio" value="#{pc_Urun_tarihi.siralama }">
								<f:selectItem itemValue="a-z" itemLabel="Once Ilk Islem"/>
								<f:selectItem itemValue="z-a" itemLabel="Once Son Islem"/>
								</h:selectOneRadio></td>
						
						
					</tr>
					<tr>
						<td colspan=4><h:outputText id="text2" styleClass="outputText" value="#{pc_Urun_tarihi.urunu_ekleyen }"></h:outputText></td>
						
					</tr>
					<tr>
						<td colspan=4><hx:dataTableEx border="0" cellpadding="2"
								cellspacing="0" columnClasses="columnClass1"
								headerClass="headerClass" footerClass="footerClass"
								rowClasses="rowClass1, rowClass2" id="tableEx1"
								styleClass="dataTableEx" value="#{pc_Urun_tarihi.list_tarih}" var="abc">
								<hx:columnEx id="columnEx4">
									<f:facet name="header">
										<h:outputText id="text4" styleClass="outputText"
											value="Islem Tipi"></h:outputText>
									</f:facet>
									<h:outputText id="text3" styleClass="outputText" value="#{abc.islem_tipi }"></h:outputText>
								</hx:columnEx>
								<hx:columnEx id="header">
									<f:facet name="header">
										<h:outputText id="text5" styleClass="outputText"
											value="Adet , Fiyat"></h:outputText>
									</f:facet>
									<h:outputText id="text7" styleClass="outputText" value="#{abc.adet_fiyat }"></h:outputText>
								</hx:columnEx>
								<hx:columnEx id="columnEx6">
									<f:facet name="header">
										<h:outputText id="text6" styleClass="outputText"
											value="Islemi Yapan"></h:outputText>
									</f:facet>
									<h:outputText id="text8" styleClass="outputText" value="#{abc.islemi_yapan }"></h:outputText>
								</hx:columnEx>
							</hx:dataTableEx></td>
						
					</tr>
					<tr>
						<td><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
								styleClass="commandExButton" action="#{pc_Urun_tarihi.doBgeridonAction}"></hx:commandExButton></td>
						<td>
						
								</td>
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