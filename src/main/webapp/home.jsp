<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
	<jsp:attribute name="headerFiles">
		<link rel="stylesheet" type="text/css" href="/trading/style.css" />
	</jsp:attribute>
	<jsp:attribute name="header">
		<h4>${profileType} Profile</h4>
		<br />
		<h2>Welcome, ${name}!</h2>
	</jsp:attribute>
	<jsp:attribute name="leftnavitem">
		<button type="button" class="btn header-button">Logout</button>
	</jsp:attribute>
	<jsp:body>
		<ul class="container" id="bodyitems">
			<li>This is the home page!</li>
			<li>This is the create order page</li>
			<li>This is the search page</li>
		</ul>
	</jsp:body>
</t:layout>