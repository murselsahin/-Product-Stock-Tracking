<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Admin_giris1.java" --%><%-- /jsf:pagecode --%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Yonetici Giris</title>
<link rel="stylesheet" type="text/css" title="Style"
	href="theme/stylesheet.css">
</head>
<f:view>
	<body>
		<table align="center" border="1">
			<tr>
				<td><hx:outputLinkEx id="linkEx1" styleClass="outputLinkEx"
						value="kullanici_ekle.jsp">
						<h:outputText id="text1" styleClass="outputText"
							value="Kullanici Ekle"></h:outputText>
					</hx:outputLinkEx></td>
				<td><hx:outputLinkEx id="linkEx2" styleClass="outputLinkEx"
						value="musteri_ekle.jsp">
						<h:outputText id="text2" styleClass="outputText"
							value="Musteri Ekle"></h:outputText>
					</hx:outputLinkEx></td>
				<td><hx:outputLinkEx id="linkEx3" styleClass="outputLinkEx"
						value="urun_ekle.jsp">
						<h:outputText id="text3" styleClass="outputText" value="Urun Ekle"></h:outputText>
					</hx:outputLinkEx></td>
				<td><hx:outputLinkEx id="linkEx4" styleClass="outputLinkEx"
						value="urun_guncelle.jsp">
						<h:outputText id="text4" styleClass="outputText"
							value="Urun Guncelle"></h:outputText>
					</hx:outputLinkEx></td>
				<td><hx:outputLinkEx id="linkEx5" styleClass="outputLinkEx"
						value="satis_yap.jsp">
						<h:outputText id="text5" styleClass="outputText" value="Satis Yap"></h:outputText>
					</hx:outputLinkEx></td>
				<td><hx:outputLinkEx id="linkEx6" styleClass="outputLinkEx"
						value="fatura_goruntule.jsp">
						<h:outputText id="text6" styleClass="outputText"
							value="Fatura Goruntule"></h:outputText>
					</hx:outputLinkEx></td>
					<td><hx:outputLinkEx id="linkEx8" styleClass="outputLinkEx"
						value="urun_tarihi.jsp">
						<h:outputText id="text8" styleClass="outputText"
							value="Urun Tarihi"></h:outputText>
					</hx:outputLinkEx></td>
				<td><hx:outputLinkEx id="linkEx7" styleClass="outputLinkEx"
						value="anasayfa.jsp">
						<h:outputText id="text7" styleClass="outputText" value="Cikis"></h:outputText>
					</hx:outputLinkEx></td>
			</tr>
		</table>
	</body>
</f:view>
</html>