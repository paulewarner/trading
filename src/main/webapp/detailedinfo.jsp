<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>More Stock Info</title>
</head>
<body>
    <h1>Company name: ${company.getName()}</h1>
    
    <p>Ticker: ${company.getTick()}</p>
    <p>Price: ${company.getPrice()}</p>
    <p>Day to Day Price Change: ${company.getPriceChange()}</p>
    <p>Percent Change: ${company.getPercentChange()}</p>

    <table>
        <tr><td>Open: </td> 
            <td>${company.getOpen()}</td></tr>
        <tr><td>Close: </td>
            <td>${company.getClose()}</td></tr>
        <tr><td>High: </td>
            <td>${company.getHigh()}</td></tr>
        <tr><td>Low: </td>
            <td>${company.getLow()}</td></tr>
        <tr><td>Market Cap: </td>
            <td>${company.getMrktCap()}</td></tr>
        <tr><td>Average Total Volume: </td>
            <td>${company.getAvgTotVolume()}</td></tr>
        <tr><td>52 Week High: </td>
            <td>${company.getFifty2WeekHigh()}</td></tr>
        <tr><td>52 Week Low: </td>
            <td>${company.getFifty2WeekLow()}</td></tr>
        <tr><td>P/E Ratio: </td>
            <td>${company.getPeRatio()}</td></tr>
        <tr><td>YTD Change: </td>
            <td>${company.getYtdChange()}</td></tr>
        <tr><td>Previous Close: </td>
            <td>${company.getPrevClose()}</td></tr>
    </table>


</body>
</html>