<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
                    <h2 id="stckName"><b>APPLE</b></h2>
                    <h4 id="smbl">(NASDAQ:AAPL)</h4>
                    <p><b>From API</b></p>
                    <p id="demo">Date: </p>
                </div>
                
                <div class="col-sm-3">
                    <p>
                        Portfolio ID
                    </p> 
                    <select name="Portfolio_ID">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                    </select> 
                </div>
            </div>

            
            <div id="dash"></div>
            
            <div>
                <form action="">
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
                            <select name="priceType" id="">
                                <option value="0">Current Price</option>
                                <option value="1">Limit Price</option>
                            </select>
                            <input type="number" name="price" id="price" step="any" min="0" oninput="calculate()" required>
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
                            <input type="text" name="note" id="" minlength=50 placeholder="Minimum 50 characters">
                        </div>

                        <div class="col-sm-1"></div>
                        <div class="col-sm-2">
                            <input type="submit" class="order-button" value="Order">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
   
</body>
<script>
var d = new Date();
document.getElementById("demo").innerHTML+= d;

function calculate(){
var quant = document.getElementById('quantity').value; 
var prc = document.getElementById('price').value;
var result = document.getElementById('amount'); 
var myResult = quant * prc;
result.value = myResult;

}
</script>
<%@ include file="scripts.jsp" %>
</html>