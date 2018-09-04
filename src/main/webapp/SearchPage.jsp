<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<style>
html, body {
	height: 100%;
}

.row {
	justify-content: center;
}

.container {
	margin-left: auto;
	margin-right: auto;
}

#myUL li {
	display: none;
}

#myInput {
	font-size: 16px; /* Increase font-size */
	border: 1px solid #ddd; /* Add a grey border */
}

#myUL {
	/* Remove default list styling */
	list-style-type: none;
	padding: 0;
	margin: 0;
}

#myUL li a {
	border: 1px solid #ddd; /* Add a border to all links */
	margin-top: -1px; /* Prevent double borders */
	background-color: #f6f6f6; /* Grey background color */
	padding: 12px; /* Add some padding */
	text-decoration: none; /* Remove default text underline */
	font-size: 18px; /* Increase the font-size */
	color: black; /* Add a black text color */
	display: block;
	/* Make it into a block element to fill the whole list */
	width: 75%; /* Full-width */
	margin-left: auto;
	margin-right: auto;
}
#myUL
 
li
 
a
:hover
:not
 
(
.header
 
)
{
background-color
:
 
#eee
;
/* Add a hover effect to all links, except for headers */


}
</style>

<script>
	function myFunction() {
		// Declare variables
		var input, filter, ul, li, a, i;
		input = document.getElementById('myInput');
		filter = input.value.toUpperCase();
		ul = document.getElementById("myUL");
		li = ul.getElementsByTagName('li');

		// Loop through all list items, and hide those who don't match the search query
		for (i = 0; i < li.length; i++) {
			a = li[i].getElementsByTagName("a")[0];
			if (filter.length == 0) {
				li[i].style.display = "none";
			} else if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
				li[i].style.display = "block";
			} else {
				li[i].style.display = "none";
			}
		}
	}
	function submitform(row, name) {
		document.getElementById("comp").value = name;
		document.getElementById("myForm").submit();
	}
</script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

</head>
<body style="background-color: #e5e9f2">


	<div class="container">
		<div class="row">
			<div class="col-xs-8 col-xs-offset-2">
				<div class="input-group">
					<form class="form-inline" action="find" method="GET">
						<div class="form-group">
							<select name="dropdown" class="form-control"
								id="exampleFormControlSelect1" style="background-color: #AFBAC7">
								<option value="ticker">Ticker</option>
								<option value="company">Company</option>
							</select>
						</div>
						<input type="text" id="myInput"
							placeholder="Search for companies..." onkeyup="myFunction()"
							class="form-control" name="ticker" placeholder=""
							style="color: rgb(112, 119, 129)"> <span
							class="input-group-btn">
							<button type="submit" class="btn btn-light">Search</button>
						</span>
					</form>
				</div>
			</div>
		</div>
		<form id="myForm" action="seeMore" method="GET">
			<input type="hidden" name="ticker" id="comp"></input> <input
				type="hidden" name="dropdown" value="company"></input>
			<ul id="myUL">
				<%
					List<String> comps = (List<String>) request.getAttribute("companies");
					int i = 1;
					for (String c : comps) {
						request.setAttribute("c", c);
						request.setAttribute("row", i);
						i++;
				%>

				<li id="${row}" onclick="submitform('${row}', '${c}')"><a>${c}</a></li>

				<%
					}
				%>

			</ul>
		</form>

	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>

</body>
</html>