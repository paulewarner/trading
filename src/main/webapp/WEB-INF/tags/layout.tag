<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@attribute name="body" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="leftnavitem" fragment="true" %>
<%@attribute name="headerFiles" fragment="true" %>
<%@attribute name="tabText" required="true" %>
<html>
	<head>
		<jsp:invoke fragment="headerFiles" />
		<link rel="stylesheet" href="/trading/header.css" />
		<link rel="stylesheet" href="/trading/modal.css" />
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	</head>
	<body>
		<div class="titlebar">
			<div class="titlebar-content">
				<jsp:invoke fragment="header" />
			</div>
		</div>
		<div class="nav">
			<jsp:invoke fragment="leftnavitem" />
			<ul id="navitems" class="nav nav-tabs">
				<li id="firstTab" class="nav-item nav-link active">
					${tabText}
				</li>
				<li class="nav-item nav-link">
				    Create Order
				</li>
				<li class="nav-item nav-link">
				    Search
				</li>
			</ul>
			<span class="left-navitem"><button type="button" class="btn header-button">Logout</button></span>
		</div>
		<jsp:doBody />
		<footer>This is a footer</footer>
	<script src="./header.js" ></script>
	</body>
</html>