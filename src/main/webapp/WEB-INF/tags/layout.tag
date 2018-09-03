<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@attribute name="body" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<html>
	<head>
		<link rel="stylesheet" href="./header.css" />
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
	
		<ul id="navitems" class="nav nav-tabs">
		  <li class="nav-item nav-link active">
		    Home
		  </li>
		  <li class="nav-item nav-link">
		    Create Order
		  </li>
		  <li class="nav-item nav-link">
		    Search
		  </li>
		</ul>
		<jsp:doBody />
		<footer>This is a footer</footer>
	<script src="./header.js" ></script>
	</body>
</html>