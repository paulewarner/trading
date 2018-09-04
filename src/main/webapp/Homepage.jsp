<%@ page language="java" contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.sapient.trading.models.Portfolio1" %>
<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<script type="text/javascript">
function handle(form)
{
  
  document.forms[0].action="profile";
  

  return true;
}
</script>
</head>
<body>

<p>${portfolios }</p>
<form ... onsubmit="return handle(this);">

<input type="submit" name="portfolio" value ="101">

</form>
</body>
</html> --%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Home</title>
    <script type="text/javascript" src="Js/main.js"></script>
    <!-- <link rel="stylesheet" href="Styles\styles.css"> -->
    <style type="text/css">
			html, body{
			  padding: 0px;
			  margin: 0px;
			  width: 100%;
			  height: 100%;
			}
			
			p{
			  -webkit-margin-before: 0px;
			  -webkit-margin-after: 0px;
			  -webkit-margin-start: 0px;
			  -webkit-margin-end: 0px;
			}
			
			div.containerDiv{
			  width:100%;
			  padding: 1%;
			  -webkit-box-sizing: border-box;
			          box-sizing: border-box;
			  background-color: #47525E;
			}
			
			div#portfolioInfoContainer{
			  width:65%;
			  float: left;
			  pad
			  cursor: pointer; pointer;
			}
			
			div.watchlistContainer{
			  width:30%;
			  float: left;
			  padding: 1%;
			}
			
			div.portfolio{
			  width:95%;
			  height:25%;
			  background-color: #969faa;
			  color:white;
			  font-family: Arial, Helvetica, sans-serif;
			  border-radius: 10px;
			  padding: 1.5%;
			  margin-bottom: 1%;
			}
			
			div.portfolio > p{
			  line-height: 1.5em;
			}
			
			div.stocks{
			  width:95%;
			  background-color: lightgray;
			  border-radius: 10px;
			  overflow: auto;
			  padding: 1%;
			}
			
			div.news{
			  width:95%;
			  background-color:red;
			  border-radius: 10px;
			  padding: 1%;
			  margin-top: 1%;
			}
			
			.containerDiv::after{
			  clear: both;
			  content: "";
			  display: table;
			}
			
			#watchListStockDetails{
			  background-color: #ffffff;
			  border-radius: 10px;
			}
			
			.stock{
			  display: -webkit-box;
			  display: -ms-flexbox;
			  display: flex;
			  -webkit-box-pack: justify;
			      -ms-flex-pack: justify;
			          justify-content: space-between;
			}
			
			#stocksHead{
			  font-weight: bold;
			  margin: 2%;
			}
			
			#stockName{
			 font: bold;
			 padding: 2%;
			}
			
			#stockDetails{
			 width:30%;
			 display: -webkit-box;
			 display: -ms-flexbox;
			 display: flex;
			 -ms-flex-pack: distribute;
			     justify-content: space-around;
			 padding: 2%;
			}
			
			#percentChange{
			  background-color: green;
			  color: white;
			  font-size: 0.7em;
			  border-radius: 5px;
			  padding-top: 0.15em;
			}
    	
    </style>
  </head>
  <body onload="showPortfolios()">
    <!-- <div id="portfolioInfoContainer">
    </div> -->

    <div class="containerDiv">
        <div id="portfolioInfoContainer">
        <%
        	HashSet<Portfolio1> portfolios = (HashSet<Portfolio1>)request.getAttribute("portfolios");int i=0;
        %>
        <%
        	for(Portfolio1 portfolio: portfolios){
        %>
				<div class="portfolio" onclick="gotoPortfilioContent(<%=portfolio.getPortfolioid()%>)">
	        	<p>Portfolio ID: <%=portfolio.getPortfolioid()%></p>
	        	<p>Client: <%=portfolio.getPortfolioname()%></p>
	        	<p>Portfolio Manager: <%=portfolio.getPortfoliomanager()%></p>
	        	<p>Traders:<%for(String trader: portfolio.getTraders()){ %><span id="tradersList<%=i++%>"><%=trader+", " %></span><%} %>
	        	</p>
      		</div>
      	<%} %>
        </div>
        <div class="watchlistContainer">
          <div class="stocks">
            <span id="stocksHead">STOCKS</span>
             <div id="watchListStockDetails">
              <div class="stock">
                <div id="stockName">
                    GE
                </div>
                <div id="stockDetails">
                  <div id="price">
                      12.78
                  </div>
                  <div id="percentChange">
                      +0.12%
                  </div>
                </div>
              </div>
              <hr width="90%">
            </div>
        </div>
        <div class="news">
            news
        </div>
    </div>

  </body>
  <script>
  	function gotoPortfilioConte+portfolioIdId){
  		location.href = "profile?pId="+portfolioId;
  	}
  </script>
</html>
