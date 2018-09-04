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
				<a href="/trading/mvc/Home">Home</a>
			</li>
			<li class="nav-item nav-link">
				<a href="/trading/mvc/CreateOrder">Create Order</a>
			</li>
			<li class="nav-item nav-link">
			    <a href="/trading/mvc/Search">Search</a>
			</li>
		</ul>
<span class="left-navitem"><button type="button" class="btn header-button">Logout</button></span>
</div>