<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!-- 
	@author Mani
 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="EN" xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN" dir="ltr">
  <head profile="http://gmpg.org/xfn/11">
    <meta http-equiv="content-type" content="application/xhtml+xml; charset=iso-8859-1" />
    <title>Approval Status Page</title>
    <meta http-equiv="imagetoolbar" content="no" />
    <link rel="stylesheet" href="styles/layout.css" type="text/css" />
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
    <!-- Change the menu according to the user accessing the page -->
    
    <%
    	if(session.getAttribute("userType").toString().equalsIgnoreCase("admin"))
    	{
    %>
   
    <div class="wrapper col2">
      <div id="topbar">
        <div style="width:100%;float:right;" id="topnav">
          <ul style="width:100%;float:right">
            <li><a href="adminHomePage.html">Home</a></li>
            <li><a href="fileUploadPage.html">Upload Files</a> </li>
            <li><a href="ShowPendingRequestsServlet">Approve User</a></li>
       <!--      <li><a href="#">Edit Profile</a></li>     -->
           
            <li class = "active"><a href="#">View Data</a>
            	<ul>
                <li><a href="ShowRegisteredStudentsServlet">Registered Students</a></li>
                <li><a href="ShowUnRegisteredStudentsServlet">Unregistered Students</a></li>
                <li><a href="#">Courses</a></li>
                <li><a href="ShowGradesServlet">Grades</a></li>
              </ul>
            </li>
             <li><a href="userContactUs.html">Contact Us</a></li>
            <li style="float:right"><a href="Logout">Logout</a></li>
          </ul>
        </div>
        <br class="clear" />
      </div>
    </div>
    <%	
    	}
    	else if(session.getAttribute("userType").toString().equalsIgnoreCase("mentor"))
    	{
    %>
     <div class="wrapper col2">
      <div id="topbar">
        <div style="width:100%;float:right;" id="topnav">
          <ul style="width:100%;float:right">
            <li><a href="MentorHomePage.html">Home</a></li>
            <li class="active"><a href="#">View Reports</a> 
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
    <%
    	}
    	else
    	{
    %>
    <div class="wrapper col2">
      <div id="topbar">
        <div style="width:100%;float:right;" id="topnav">
          <ul style="width:100%;float:right">
            <li><a href="StudentHomePage.html">Home</a></li>
            <li class="active"><a href="#">View Courses</a></li>
            <li><a href="#">View Result</a></li>
            <li><a href="#">View feedback</a></li>
       		<li><a href="EditProfilePage.jsp">Edit Profile</a></li>
            <li style="float:right"><a href="Logout">Logout</a></li>
          </ul>
        </div>
        <br class="clear" />
      </div>
    </div>
    <%
    	}
    %>
    <div class="wrapper col4">
      <div id="container">
        <div id="content">
          <h1><%=request.getAttribute("approvalStatus") %></h1>
          <meta http-equiv="refresh" content="3;URL=ShowPendingRequestsServlet">
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
      <br class="clear" /><br class="clear" />
      <br class="clear" />
      <br class="clear" />
      <br class="clear" />
      <br class="clear" />
      <br class="clear" />
      <br class="clear" />
      <br class="clear" />
      <br class="clear" /><br class="clear" />
      <br class="clear" />
      <br class="clear" />
      <br class="clear" />
      <br class="clear" />
      <br class="clear" />
      
      <div class="wrapper col7">
        <div id="copyright">
          <p class="fl_left">Copyright � 2014 - All Rights Reserved - <a href="#">MSITMedhas</a></p>
          <br class="clear" />
        </div>
      </div>
    </div>
  </body>
</html>
