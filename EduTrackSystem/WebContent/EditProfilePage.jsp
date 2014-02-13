 <%
  if(session.getAttribute("userType")==null)
  	{
  		response.sendRedirect("Logout");
  	}else
  	{
  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="EN" xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN" dir="ltr">
  <head profile="http://gmpg.org/xfn/11">
    <meta http-equiv="content-type" content="application/xhtml+xml; charset=iso-8859-1" />
    <title>Edit Profile</title>
    <meta http-equiv="imagetoolbar" content="no" />
    <link rel="stylesheet" href="styles/layout.css" type="text/css" />
     <script language="Javascript" src="scripts/ValidateRegistration.js"></script>
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
    <%if(session.getAttribute("userType") != null && session.getAttribute("userType").toString().equalsIgnoreCase("student")){ %>
    <div class="wrapper col2">
      <div id="topbar">
        <div style="width:100%;float:right;" id="topnav">
          <ul style="width:100%;float:right">
            <li><a href="StudentHomePage.jsp">Home</a></li>
            <li><a href="ShowCoursesServelt">View Courses</a></li>
            <li><a href="#">View Result</a></li>
            <li><a href="#">View feedback</a></li>
       		<li class = "active"><a href="#">Edit Profile</a></li>
            <li style="float:right"><a href="Logout">Logout</a></li>
          </ul>
        </div>
        <br class="clear" />
      </div>
    </div>
    <%}else if(session.getAttribute("userType") != null && session.getAttribute("userType").toString().equalsIgnoreCase("mentor")){ %>
    <div class="wrapper col2">
      <div id="topbar">
        <div style="width:100%;float:right;" id="topnav">
          <ul style="width:100%;float:right">
            <li><a href="MentorHomePage.jsp">Home</a></li>
            <li><a href="#">View Reports</a> 
            	<ul>
                <li><a href="#">Course Report</a></li>
                <li><a href="#">Student Performance</a></li>
              </ul>
            </li>
            <li><a href="#">Give feedback</a></li>
      		<li><a href="#">Send Request</a></li>
             <li><a href="#">Edit Profile</a></li>
            <li style="float:right"><a href="Logout">Logout</a></li>
          </ul>
        </div>
        <br class="clear" />
      </div>
    </div>
    <%} %>
    <div class="wrapper col4">
      <div id="container">
        <div id="content">
          <div id="main">
		      <form name="registration" action="EditProfile">
		        <center>
		        	<h3><span style = "color : black"> <b>Edit Your Details</b></span></h3>
		        </center>
		        <fieldset name="registrationForm" style="margin:auto; width:600px;  "> <legend>Registration
		            Form</legend>
		          <div id="show2" height="200"> </div>
		          <table style="width:600px" align="center" cellpadding="7">
		            <tbody>                
		              <tr>
		                <td align="right"><span style="font-size:12px;color:black">RegistrationID:</td>
		                <td><input name="ID" id="id" size="30" onblur="validateID" placeholder="RegNo"
		
		                    onchange="resetField()" type="text" disabled = "disabled"><span style="color: black;"
		
		                    id="error00" > </span></td>
		              </tr>
		              <tr>
		                <td align="right"><span style="font-size:12px;color:black">First
		                    Name:</span></td>
		                <td><input name="fname" id="fname" size="30" placeholder="First name"
		
		                    onblur="validateName()" onchange="resetField()"> <span style="color: red;"
		
		                    id="error"> </span></td>
		              </tr>
		              <tr>
		                <td align="right"><span style="font-size:12px;color:black">Last
		                    Name:</span></td>
		                <td><input name="lname" id="lname" size="30" placeholder="Last name"
		
		                    onblur="validateLname()" onchange="resetField()"> <span style="color: red;"
		
		                    id="error000"> </span></td>
		              </tr>
		              <tr>
		                <td align="right"><span style="font-size:12px;color:black">Address:</span></td>
		                <td><textarea name="address" id="address" rows="5" onblur="validateAdress()"
		
		                    cols="24" placeholder="Address" onchange="resetField()"></textarea><span
		
		                    style="color: red;" id="error1"> </span></td>
		              </tr>
		              <tr>
		                <td align="right"><span style="font-size:12px;color:black">Date
		                    of birth:</span></td>
		                <td><input name="dob" id="dob" size="30" placeholder="yyyy-mm-dd"
		
		                    onblur="validateDate()" onchange="resetField()" type="date">
		                  <span style="color: red;" id="error2"> </span></td>
		              </tr>
		              
		              <tr>
		                <td align="right"><span style="font-size:12px;color:black">MobileNo:</span></td>
		                <td><span style="font-size:12px;color:black">+91</span> <input
		
		                    name="mobileno" id="mobileno" size="25" placeholder="10 digits"
		
		                    onblur="validateMobile()" onchange="resetField()" type="text"><span
		
		                    style="color: red;" id="error4"> </span></td>
		              </tr>
		              <tr>
		                <td align="right"><span style="font-size:12px;color:black">Email
		                    Id:</span></td>
		                <td><input name="emailId" id="emailId" size="30" placeholder="id@example.com"
		
		                    onblur="validateEmail()" onchange="resetField()"> <span style="color: red;"
		
		                    id="error5"> </span></td>
		              </tr>
		              <tr>
		                <td align="right"><span style="font-size:12px;color:black">Choose
		                    Password:</span></td>
		                <td><input name="password" id="password" placeholder="min 8 characters"
		
		                    onblur="validatePassword()" onchange="resetField()" type="password"><span
		
		                    style="color: red;" id="error6"> </span></td>
		              </tr>
		              <tr>
		                <td align="right"><span style="font-size:12px;color:black">Re-Enter
		                    Password:</span></td>
		                <td><input name="reenter" id="reenter" size="30" placeholder="re-enter"
		
		                    onblur="validateRePassword()" onchange="resetField()" type="password"><span
		
		                    style="color: red;" id="error7"> </span></td>
		              </tr>
		              <tr>
		                <td id="fill1" name="fill1" align="right"><br>
		                </td>
		                <td id="fill2" name="fill2"><br>
		                </td>
		              </tr>
		              <tr>
		                <td colspan="3">
		                  <center> <input value="Reset" name="reset" id="reset" onclick="resetField();resetFields()"
		
		                      type="reset"> <input value="Register" name="register" id="register"
		
		                      type="submit"> </center>
		                </td>
		              </tr>
		            </tbody>
		          </table>
		        </fieldset>
		      </form>
		    </div>
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
    </div>
  </body>
</html>
<%}%>