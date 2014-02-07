<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html dir="ltr" xml:lang="EN" xmlns="http://www.w3.org/1999/xhtml" lang="EN">
  <head profile="http://gmpg.org/xfn/11">
    <meta content="text/html; charset=iso-8859-1" http-equiv="content-type">
    <title>Successful Registration</title>
    <meta content="no" http-equiv="imagetoolbar">
    <link type="text/css" href="styles/layout.css" rel="stylesheet">
    <script language="Javascript" src="scripts/ValidateRegistration.js"></script>
    <style>
	#regBg{
                display:none;
                position:fixed;
                width:100%;
                top:0;
                left:0;
                background:#333;
                z-index:9999998;

            }

            #main{
                min-width: 350px;
                position:absolute;
                left:-99999px;
                top:500;
                background:#fff;
                z-index:9999999;
                border:3px solid #222;
                -moz-border-radius:9px;
                border-radius:9px;
                -webkit-border-radius:9px;
                margin:0;
                padding:0;
                color:#333;
                text-align:left;
                font-family:arial,sans-serif;
                font-size:13px

            }
	</style>
    <!--  Author : Krishna Somayajulu -->
    <script language="Javascript">
            function unHide()
            {            	
                document.getElementById("regDiv").style.display = "block";
				funcDisplay();
            }

            function hide()
            {
                document.getElementById("regDiv").style.display = "none";
            }
            
			function resetAll(){
				document.getElementById("userName").style.border = "solid 1px #7F9DB9";
				document.getElementById("LoginPassword").style.border = "solid 1px #7F9DB9";
			}


			function alertError(){
				
				var flag = 1;
				
				if(document.myForm.LoginPassword.value=="")
				{	
					document.getElementById("errMsg").innerHTML="Password cannot be blank";
					document.getElementById("LoginPassword").style.border = "solid 1px red";
					flag = 0;
				}
				
				if(document.myForm.userName.value=="")
				{		
					document.getElementById("errMsg").innerHTML="Username cannot be blank";
					document.getElementById("userName").style.border = "solid 1px red";
					flag = 0;
				}
						
				if(flag == 0)
					return false;
				else
					return true;
			}
	</script>
  </head>
  <body id="top"> <!--  Author: Ujvala -->
    <div class="wrapper col1">
      <div id="header">
        <div id="logo">
          <h1><a href="#">LC Solutions</a></h1>
          <p><strong>Helping you build your dream</strong></p>
        </div>
        <br class="clear">
      </div>
    </div>
    <div class="wrapper col2">
      <div id="topbar">
        <div id="topnav">
          <ul>
            <li><a href="homePage.html">Home</a></li>
            <li><a href="#">Products</a>
              <ul>
                <li><a href="productPage.html">EduTrackSystem</a></li>
              </ul>
            </li>
            <li><a href="contactUs.html">Contact Us</a></li>
          </ul>
        </div>
        <br class="clear">
      </div>
    </div>
    <div class="wrapper col4">
      <div id="container">
        <div id="content">
        <%if(request.getAttribute("isSuccess").toString().equalsIgnoreCase("true")){ %>
    			Your registration was successful. 
    		<p>The administrator is yet to approve your registration. Please come back soon to verify.</p>
    	<% }
    		else
    		{
    		%>Your registration was NOT successful. 
    		<p>Check with the administrator for further details</p>
    	  <%} %>
        </div>
        
      </div>
      <br class="clear">
      <br class="clear">
      <br class="clear">
      <br class="clear">
      <br class="clear"> 
      <br class="clear">
      <br class="clear">
      <br class="clear">
      <br class="clear"> 
      <br class="clear">
      <br class="clear">
      <br class="clear">
      <br class="clear"> 
      <br class="clear">
      <br class="clear">
      <br class="clear">
      <br class="clear">
      <div class="wrapper col7">
        <div id="copyright">
          <p class="fl_left">Copyright © 2014 - All Rights Reserved - <a href="#">MSITMedhas</a></p>
          <br class="clear">
        </div>
      </div>
    </div>
  </body>
</html>
