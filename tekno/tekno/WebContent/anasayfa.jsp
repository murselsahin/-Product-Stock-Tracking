<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Anasayfa.java" --%><%-- /jsf:pagecode --%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ana Sayfa</title>
<link rel="stylesheet" type="text/css" title="Style"
	href="theme/stylesheet.css">
</head>
<f:view>
	<body>
	<hx:scriptCollector preRender="#{pc_Anasayfa.onPageLoadBegin}">
		<h:form id="form1" styleClass="form">
			<table border="1" align="center">
				<tbody>
					<tr>
						<td>Kullanici Adi :</td>
						<td><h:inputText id="text1" styleClass="inputText" value="#{pc_Anasayfa.kullanici_adi }"></h:inputText></td>
					</tr>
					<tr>
						<td>Sifre :</td>
						<td><h:inputSecret id="secret1" styleClass="inputSecret" value="#{pc_Anasayfa.sifre }"></h:inputSecret></td>
					</tr>
					<tr>
						<td><hx:commandExButton type="submit" value="Giris" id="bgiris"
								styleClass="commandExButton" action="#{pc_Anasayfa.doBgirisAction}"></hx:commandExButton></td>
						<td></td>
					</tr>
					<tr>
						<td colspan=2><h:outputText id="text2" styleClass="outputText" value="#{pc_Anasayfa.sonuc }"></h:outputText></td>
						
					</tr>
				</tbody>
			</table>
		</h:form>
		</hx:scriptCollector>
		
	</body>
</f:view>
</html>