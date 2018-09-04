<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Login</title>
    <script type="text/javascript" src="Js\main.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
   
    <style type="text/css">
    	html, body{
  width: 100%;
  height: 100%;
  padding: 0;
  margin: 0;
  -webkit-box-sizing: border-box;
          box-sizing: border-box;
  /* font-family: Arial, Helvetica, sans-serif; */

}

#loginContainer{
  width: 40%;
  background-color: #eeeeee;
  margin-left: 0;
  margin-right: 0;
  padding-left: 0;
  padding-right: 0;
  margin: 10% auto 0 auto;
  -webkit-box-sizing: border-box;
          box-sizing: border-box;
  padding: 2em;
  text-align: center;
}

#signInHeading{
  color: #47525E;
  font-size: 4em;
  padding: 0.50em;
    -webkit-margin-before: 0px;
    -webkit-margin-after: 0px;
    -webkit-margin-start: 0px;
    -webkit-margin-end: 0px;
  -webkit-box-sizing: inherit;
   box-sizing: inherit;
}

 .loginInputs{
   width: 50%;
   height: 2em;
   margin-top: 1em;
   margin-left: auto;
   margin-right: auto;
   font-size: 1em;
 }

.login-btn{
  height: 2.5em;
  background-color: #47525E;
  color: #eeeeee;
}

p{
  -webkit-margin-before: 0px;
    -webkit-margin-after: 0px;
    -webkit-margin-start: 0px;
    -webkit-margin-end: 0px;
}

p#forgotPassword{
  margin: 2em 0px;
  cursor: pointer;
}

p#forgotPassword:hover{
  color: #22B7FF;
}

#errorMessage{
	color: #b20000;
	letter-spacing: 0.07em;
}
    	
    </style>
  </head>
  <body>
    <div class="" id="loginContainer">
      <form action= "portfolioX" method="POST">
      	<p id="errorMessage"> ${message}</p>
        <h1 id="signInHeading">Sign in</h1>
        <div class="form-group loginInputs">
          <label for="exampleInputEmail1" class="hidden login">Email address</label>
          <input type="text" name ="userId" class="form-control" id="exampleInputEmail1" placeholder="UserID">
        </div>
        <div class="form-group loginInputs">
          <label for="exampleInputPassword1" class="hidden">Password</label>
          <input type="password" name ="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
        </div>
        <button type="submit" class="btn loginInputs login-btn">Sign in</button>
       <!--   <p id="forgotPassword">Forgot your password?</p>-->
      </form>
    </div>
  </body>
</html>