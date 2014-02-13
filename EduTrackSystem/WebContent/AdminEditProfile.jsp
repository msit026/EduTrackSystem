<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%
  if(session.getAttribute("userType")==null)
  	{
  		response.sendRedirect("Logout");
  	}else
  	{
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="EN" xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN" dir="ltr">
  <head profile="http://gmpg.org/xfn/11">
    <meta http-equiv="content-type" content="application/xhtml+xml; charset=iso-8859-1" />
    <title>Admin Home Page</title>
    <meta http-equiv="imagetoolbar" content="no" />
    <link rel="stylesheet" href="styles/layout.css" type="text/css" />
    <script>
    	function checkPassword(password)
    	{
    		if(document.getElementById("oldPassword").value != password)
    			{
    				alert('Password does not match with the one in database!');
    				document.getElementById("oldPassword").value = "";
    			}
    	}
    	
    	function matchPassword()
    	{
    		if(document.getElementById("newPassword").value != document.getElementById("confirmPassword").value)
    			{
    				alert('New password and confirm password do not match!');
    				document.getElementById("newPassword").value = "";
    				document.getElementById("confirmPassword").value = "";
    			}
    	}
    </script>
  </head>
  <body id="top">
    <div class="wrapper col1">
      <div id="header">
        <div id="logo">
          <h1><a href="#">LC Solutions</a></h1>
          <p><strong>Helping you build your dream</strong></p>
        </div>
        <br class="clear" />
      </div>
    </div>
    <div class="wrapper col2">
      <div id="topbar">
        <div style="width:100%;float:right;" id="topnav">
          <ul style="width:100%;float:right">
            <li><a href="adminHomePage.html">Home</a></li>
            <li><a href="fileUploadPage.html">Upload Files</a> </li>
            <li><a href="ShowPendingRequestsServlet">Approve User</a></li>
            <li  class="active"><a href="#">Edit Profile</a></li>
            <li><a href="userContactUs.html">Contact Us</a></li>
            <li style="float:right"><a href="Logout">Logout</a></li>
          </ul>
        </div>
        <br class="clear" />
      </div>
    </div>
    <div class="wrapper col4">
	  <div id="container">
        <div id="content">
          <h2>Edit Your Profile</h2>
          <% if(request.getAttribute("oldPassword") != null)
            	 {%>
           <form name = "myForm" id = "myForm" method="post" action="AdminEditProfile" >
             <fieldset> <legend>NewsLetter</legend>
             <table>
              <tr><td> <input type = "password" id = "oldPassword" name = "oldPassword" onchange = "checkPassword('<%=request.getAttribute("oldPassword")%>')" placeholder = "Current Password"></input></td></tr>
			 <tr><td> <input type = "password" id = "newPassword" name = "newPassword" placeholder = "New Password"></input>
			</td></tr>
			<tr><td> <input type = "password" id = "confirmPassword" name = "confirmPassword" placeholder = "Confirm Password" onchange = "matchPassword()"></input>
			</td></tr>
			 <tr><td><input type = "submit" id = "buttonSubmit" name = "buttonSubmit" value = "Change" /></td></tr>
              </table>
          </form>
          <%} %>
        </div>
    </div>
      <br class="clear" />
      <br class="clear" />
      <br class="clear" />
      <br class="clear" />
      <br class="clear" />
      <br class="clear" />
      <br class="clear" />
      <br class="clear" />
      <br class="clear" />
      <div class="wrapper col7">
        <div id="copyright">
          <p class="fl_left">Copyright © 2014 - All Rights Reserved - <a href="#">MSITMedhas</a></p>
          <br class="clear" />
        </div>
      </div>
  </body>
</html>
<%}%>