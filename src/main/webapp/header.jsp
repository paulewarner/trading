<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% Boolean isOrdersPage = (Boolean)request.getAttribute("isOrdersPage"); %> 
<% Integer activeTab = (Integer)request.getAttribute("activeTab"); %>
<div class="titlebar">
	<div class="titlebar-content">
 		<% if (isOrdersPage) { %>
			<p>Orders page</p>
		<% } else { %>
				<h4>Trader Profile</h4>
				<br />
				<h2>Hello, ${name}</h2>
		<% } %>
	</div>
	</div>
		<div class="nav">
		<ul id="navitems" class="nav nav-tabs">
			<li id="firstTab" class="nav-item nav-link <%= activeTab == 0 ? "active" : "" %>">
				<a href="/trading/mvc/Home">Home</a>
			</li>
			<li class="nav-item nav-link <%= activeTab == 1 ? "active" : "" %>">
				<a href="/trading/mvc/CreateOrder">Create Order</a>
			</li>
			<li class="nav-item nav-link <%= activeTab == 2 ? "active" : "" %>">
			    <a href="/trading/mvc/Search">Search</a>
			</li>
		</ul>
<span class="left-navitem"><button type="button" class="btn header-button">Logout</button></span>
</div>