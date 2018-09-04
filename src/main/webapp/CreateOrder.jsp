<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>

	function change(currentprice){
		console.log(currentprice);
		var pricevalue = document.getElementById('price');
		var pricetype=document.getElementById('priceType').value;
		if(pricetype==0){
			pricevalue.value=currentprice;
			pricevalue.disabled=true;
		}else{
			pricevalue.value="";
			pricevalue.disabled=false;
		}
	}


</script>

 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<style>
.box{
    background-color: rgb(50, 54, 69);
    padding: 1%;
    border-radius: 15px;
    margin: 1%;
}

.inner_box{
    background-color: white;
    padding: 0.5%;
    border-radius: 10px;
}

#stckName{
    display: inline-block;
    margin-top: auto;
    margin-bottom: auto;
}

#smbl{
    display: inline-block;
    margin-top: auto;
    margin-bottom: auto;
    
}

#dash{
    border-bottom: 1px rgb(50, 54, 69) dashed;
}

.order-button {
	color: rgb(255, 255, 255);
    background-color: rgb(0, 109, 114);
    border: none;
}


input[type='number'] {
    -moz-appearance:textfield;
}

/* Webkit browsers like Safari and Chrome */
input[type=number]::-webkit-inner-spin-button,
input[type=number]::-webkit-outer-spin-button {
    -webkit-appearance: none;
    margin: 0;
}
</style>
<%@ include file="commonheader.jsp" %>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="box">
        <div class="inner_box">
            <div class="row">
                <div class="col-sm-9">
                    <h2 id="stckName"><b>${cname}</b></h2>
                    <h4 id="smbl">${ticker}</h4>
                    <p><b>Price: ${price}</b></p>
                    <p id="demo">Date: </p>
                </div>
                
                
                <form action="createOrder" method="POST">
                <div class="col-sm-3">
                    <p>
                        Portfolio ID
                    </p> 
                    <select name="Portfolio_ID">
                        <option value="201">1</option>
                        <option value="202">2</option>
                        <option value="203">3</option>
                    </select> 
                </div>
            </div>

            
            <div id="dash"></div>
            
            <div>
                
                <input type="hidden" name="ticker" value="${ticker}">
                <input type="hidden" name="compName" value="${cname}">
                <input type="hidden" name="currentPrice" value="${price}">
                    <div class="row">
                        <div class="col-sm-2">
                                <label for="quantity">Quantity</label><br>
                                <input type="number" name="quantity" id="quantity" placeholder="Quantity" min="0" oninput="calculate()" required>
                        </div>
                        <div class="col-sm-1">
                            <br>
                            <p>@</p>
                        </div>

                        <div class="col-sm-4">
                            <label for="price">Price</label><br>
                            <select name="priceType" id="priceType" onchange="change('${price}')">
                                <option value="0">Current Price</option>
                                <option value="1">Limit Price</option>
                            </select>
                            <input type="number" name="price" id="price" step="any" min="0" value="${price}" disabled=true oninput="calculate()" required>
                        </div>

                        <div class="col-sm-1">
                            <br>
                            <p>=</p>
                        </div>

                        <div class="col-sm-2">
                                <label for="amount">Invested Amount</label><br>
                                <input type="number" name="amount" id="amount" min="0" placeholder="Amount" readonly>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="target">Target</label><br>
                            <input type="number" name="target" id="" placeholder="Target">
                        </div>

                        <div class="col-sm-2">
                            <label for="stop">Stop Loss</label><br>
                            <input type="number" name="stop" id="" placeholder="Stop Loss">
                        </div>

                        <div class="col-sm-1"></div>
                        <div class="col-sm-4">
                            <label for="note">Note</label><br>
                            <input type="text" name="note" id="" placeholder="Minimum 50 characters">
                        </div>

                        <div class="col-sm-1"></div>
                        <div class="col-sm-2">
                            <input type="submit" class="order-button" value="Order">
                        </div>
                    </div>
                    </div>
                </form>
            
        </div>
    </div>
   
</body>
<script>
var d = new Date();
document.getElementById("demo").innerHTML+= d;

document.getElementById('navitems').children[1].classList.add("active");

function calculate(){
var quant = document.getElementById('quantity').value; 
var prc = document.getElementById('price').value;
var result = document.getElementById('amount'); 
var myResult = quant * prc;
result.value = myResult;

}
</script>
</html>