<%@ page language="java" contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8"%>
		<%@ page import="java.util.*" %>
<%@ page import="com.sapient.trading.models.PortfolioContent" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@include file="commonheader.jsp" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <style> 
    html, body{
            padding: 0px;
            margin: 0px;
            width: 100%;
            height: 100%;
        }
    div.ordersContainer{
            width:100%;
            background-color: #47525E;
            margin: 2% auto 2% auto;
            border-radius: 5px;
            box-sizing: border-box;
        }
    
    div.orderDetailsContainer{
            width:95%; 
            padding: 1%;
            display: flex;
            justify-content: space-around;
            color:white;
            font-family: Arial, Helvetica, sans-serif;
            flex-wrap: wrap;
            box-sizing: border-box;
        }
    div.orderInfoContainerParent{
        display: flex;
        width: 100%;
    }    
    div.orderInfoContainer{
        display: flex;
        width: 80%;
        box-sizing: border-box;
        justify-content: space-around;
        cursor: pointer;
    }
    .button{
    background-color: #969faa;   
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    font-family: Arial, Helvetica, sans-serif;
    border-radius: 10px;
    }
    div.popWindowContainer{
            width:80%;
            background-color: #47525E;
            border-radius: 5px;
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            color:white;
    }
    #popWindowContainerForwarded{
        display: none;
    }
    #popWindowContainerUnForwarded{
        display: none;
    }
    div.popWindowContainerElement{
        min-width: 25%;
        padding: 1%;
    }
    div.popWindowContainerElement1{
        min-width: 25%;
        padding: 1%;
    }
    div.statusContainer{
        display: flex;
    }
    div.pending{
        color: red;
        margin-left: 1em;
    }
    div.completed{
        color: green;
        margin-left: 1em;
    }
    </style>
    <title>Document</title>
</head>
       
<body>
	<%@ include file="header.jsp" %>
        <h1>Orders</h1>
    <div class="ordersContainer">
    <%List<PortfolioContent> portfolioContents= (List<PortfolioContent>)request.getAttribute("portfoliocontents");%>
    <%for(PortfolioContent portfolioContent: portfolioContents){ if(portfolioContent.getStatus()!=0){%>
         <div class="orderDetailsContainer">
             <div class="orderInfoContainerParent">
                <div class="orderInfoContainer" onclick="showPopupForward()">
                    <p>NASDAQ:<%=portfolioContent.getSymbol() %></p>
                    <p>Quantity Held: <%=portfolioContent.getQuantity() %></p>
                    <p>Total Equity: $<%=portfolioContent.getValue() %></p>
                    <p>Status:<%=portfolioContent.getStatus() %></p>
              </div>
              <div class="buyORsellContainer">
                    <a href="/trading/mvc/createOrder" class="button">Buy/Sell</a>
              </div>
             </div>
              <div class="popWindowContainer" id="popWindowContainerForwarded">
                    <div class="popWindowContainerElement">Stock Name: <%=portfolioContent.getStockname() %></div>
                    <div class="popWindowContainerElement">Limit Price: $<%=portfolioContent.getLimitprice() %></div>
                    <div class="popWindowContainerElement">Stop Price:$<%=portfolioContent.getStopprice() %></div>
                    <div class="popWindowContainerElement">Created By: Sam Smith</div>
                    <div class="popWindowContainerElement">Broker Name: Mit Kurale</div>
                    <div class="popWindowContainerElement statusContainer"> 
                        <div>Status:</div>
                        <div>
                            <div class="completed">65000: Completed</div>
                            <div class="pending">35000: Pending</div>
                        </div>
                    </div>

              </div>
         </div>
	<%}} %>

    </div>

    <h2>Unforwarded</h2>
    <div class="ordersContainer">
    <%for(PortfolioContent portfolioContent: portfolioContents){ if(portfolioContent.getStatus()==0){%>
            <div class="orderDetailsContainer">
                <div class="orderInfoContainerParent">
                   <div class="orderInfoContainer" onclick="showPopupUnForward()">
                       <p>Date Created:08/29/18</p>
                       <p>NYSE: <%=portfolioContent.getSymbol() %></p>
                       <p>Number of Stocks:<%=portfolioContent.getQuantity() %></p>
                       <p>Total Equity:$<%=portfolioContent.getValue() %></p>
                 </div>
                 <div class="buyORsellContainer">
                 
                     <form action="mvc/forwardOrder" method="POST">
                         <button class="button" type="submit" name="order" value="">Forward Order</button>
                     </form>
                       <!-- <a href="#" class="button">Forward Order</a> -->
                  </div>
                </div>
            </div>
            <div class="popWindowContainer" id="popWindowContainerUnForwarded">
                            <div class="popWindowContainerElement1">Stock Name: <%=portfolioContent.getStockname() %></div>
                            <div class="popWindowContainerElement1">Stock Quantity:<%=portfolioContent.getQuantity() %></div>
                            <div class="popWindowContainerElement1">Stop Price:$<%=portfolioContent.getStopprice() %></div>
                            <div class="popWindowContainerElement1">Limit Price: $<%=portfolioContent.getLimitprice() %></div>
                            <div class="popWindowContainerElement1">Created By: Sam Smith</div>
                            <div class="popWindowContainerElement1">Broker Name: Mit Kurale</div>
                            <div class="popWindowContainerElement statusContainer"> 
            </div>
     <%}} %>
     </div>
</body>
<script>
    function showPopupForward(){
        document.getElementById("popWindowContainerForwarded").style.display= "flex";
        document.getElementById("popWindowContainerUnForwarded").style.display= "none";
    }
    function showPopupUnForward(){
        document.getElementById("popWindowContainerUnForwarded").style.display= "flex";
        document.getElementById("popWindowContainerForwarded").style.display= "none";
    }
    
    document.getElementById('navitems').children[0].classList.add('active');
</script>
</html>