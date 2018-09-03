<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,com.sapient.trading.models.Company"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<script>
    function submit(id, string){
        document.getElementById("tick").value = string;
        document.getElementById("form").submit();
    }
</script>
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

.results {
	margin-left: auto;
	margin-right: auto;
}

.results-list tr {
	background-color: white;
}

.results-list tr:hover {
	background-color: #DAE2EB;
}
</style>

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

						<input type="text" class="form-control" name="ticker"
							placeholder="" style="color: rgb(112, 119, 129)"> <span
							class="input-group-btn">
							<button type="submit" class="btn btn-light">Search</button>
						</span>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="results">
		<div class="row">
			<div class="col-xs-8 col-xs-offset-2">
				<div class="results-list">
					<table class="table table-bordered">
						<thead>
							<tr style="background-color: #F2F4F9">
								<th>Watchlist</th>
								<th>Name</th>
								<th>Price (USD)</th>
								<th>Change</th>
								<th>% Change</th>
							</tr>
						</thead>
						<form id="form" action="seeMore" method="GET">
							<input type="hidden" id="tick" name="ticker">
							<% 	List<Company> results = (List<Company>) request.getAttribute("companies");
                                int i = 1;
                                        for(Company c : results) { 
                                            request.setAttribute("company", c);
                                            request.setAttribute("row_num", i);
                                            i++;
                                        %>
							<tr id="${row_num}" onclick="submit('${row_num}', '${company.getTick()}')">
								<td></td>
								<td>${company.getName()}(${company.getTick()})</td>
								<td>${company.getPrice()}</td>
								<td>${company.getPriceChange()}</td>
								<td>${company.getPercentChange()}</td>

							</tr>

							<% } %>
						</form>
					</table>
				</div>
			</div>
		</div>
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