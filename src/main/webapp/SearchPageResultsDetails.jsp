<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        
        <style>
        html, body{
        height: 100%;
        }
        .row{
            justify-content: center;
        }
    
        .container{
            margin-left: auto;
            margin-right: auto;
        }
    
        .results{
            margin-left: auto;
            margin-right: auto;
        }
        .results-list tr{
            background-color: #DAE2EB;
        }
        .results-box{
            border: 10px solid #DAE2EB;
            padding: 10px;
            background-color: #F1F3F6;
            width: 530.91px;
            position:relative;
            overflow: auto;
            height:250px;
        }
        .result-details{
            position: absolute;
            top:0;
            right:0;
            margin: 10px;
        }
        #date-stamp{
            position:absolute;
            bottom:0;
            left:0;
            margin:10px;
        }
        .create-order-button{
            position: absolute;
            bottom:0;
            right:0;
            background-color: #2D6E78;
            padding:10px;
            margin:10px;
            color: white;
            border-radius: 5px;
        }
        </style>
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        
    </head>
    <body style="background-color: #e5e9f2">
        
           
        <div class="container">
            <div class="row">    
                <div class="col-xs-8 col-xs-offset-2">
                    <div class="input-group">
                        <form class="form-inline" action="find" method="GET">
                            <div class="form-group">
                                <select name="dropdown" class="form-control" id="exampleFormControlSelect1" style="background-color: #AFBAC7">
                                <option value="ticker">Ticker</option>
                                <option value="company">Company</option>
                                </select>
                            </div>
                           
                            <input type="text" class="form-control" name="ticker" placeholder="" style="color: rgb(112,119,129)">
                                <span class="input-group-btn">
                                    <button type="submit" class="btn btn-light">Search</button>
                                </span>
                            </form>
                     </div>
                </div>
            </div>
        </div>

        
        <div>
            <div class="row">
                <div class="results-box">
                    <div class="col-xs-8 col-xs-offset-2">
                        <div class="result-main-details" style="float:left">
                            <b>${company.getName()} (${company.getTick()})</b> </br>
                            ${company.getPrice()} ${company.getPriceChange()} ${company.getPercentChange()}</br>
                            ${company.getAvgTotVolume()} </br>
                        </div>
                        <table class="result-details" style="float:right">
                            <tr><td><b>Bid/Ask</b></td> <td> N/A </td> <td><b>Div Yield</b></td>  <td>1.01%</td></tr>
                            <tr><td><b>Open</b></td>    <td> ${company.getOpen()} </td> <td><b>Prev Close</b></td> <td>${company.getPrevClose()}</td></tr>
                            <tr><td><b>High</b></td>    <td> ${company.getHigh()} </td> <td><b>52-wk High</b></td> <td>${company.getFifty2WeekHigh()}</td></tr>
                            <tr><td><b>Low</b></td>     <td> ${company.getLow()} </td> <td><b>52-wk Low</b></td>  <td>${company.getFifty2WeekLow()}</td></br>
                            <tr><td><b>Market Cap</b></td> <td>${company.getMrktCap()}</td><td><b>P/E Ratio</b></td>  <td>${company.getPeRatio()}</td></br>
                        </table>
                        <div id="date-stamp">
                            <small><p id="datetime"></p></small>

                            <script>
                                var dt = new Date();
                                document.getElementById("datetime").innerHTML = (("0"+dt.getDate()).slice(-2)) +"/"+ (("0"+(dt.getMonth()+1)).slice(-2)) +"/"+ (dt.getFullYear()) +" "+ (("0"+dt.getHours()).slice(-2)) +":"+ (("0"+dt.getMinutes()).slice(-2));
                            </script>
                        </div>
                        <div class="create-order-button">
                            Create Order
                        </div>
                    </div>
                </div>
            </div>
        </div>
    
    
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
            
    </body>
    </html>