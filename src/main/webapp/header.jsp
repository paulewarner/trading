<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<div class="titlebar">
	<div class="titlebar-content">
		<div id="titlebarInfo">
			<h4>${profileType} Profile</h4>
			<br />
			<h2>Hello, ${name}!</h2>
		</div>
		<div id="titlebarPortfolioInfo">
			<h4>Client Name: <span id="clientName"></span></h4>
			<h4>Portfolio Manager: <span id="portfolioManager"></span></h4>
			<h4>Trader: <span id="traders"></span></h4>
		</div>
	</div>
	</div>
		<div class="nav">
		<ul id="navitems" class="nav nav-tabs">
			<li class="nav-item nav-link">
				<a href="/trading/mvc/Homepage">Home</a>
			</li>
			<li class="nav-item nav-link">
				<a href="/trading/mvc/seeMore?ticker=C%2BA&dropdown=ticker">Create Order</a>
			</li>
			<li class="nav-item nav-link">
			    <a href="/trading/mvc/start">Search</a>
			</li>
		</ul>
<span class="left-navitem">
	<form action="/trading/mvc/logout" method = "Post"">
		<button type="submit" class="btn header-button">Logout</button>
	</form>

</span>
</div>