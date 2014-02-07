
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="EN" dir="ltr" xml:lang="EN" xmlns="http://www.w3.org/1999/xhtml">
  <head profile="http://gmpg.org/xfn/11">
    <meta http-equiv="content-type" content="application/xhtml+xml; charset=iso-8859-1" />
    <title>Show Pending Requests Page</title>
    <meta content="no" http-equiv="imagetoolbar" />
    <link type="text/css" href="styles/layout.css" rel="stylesheet" />
	
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
            <li class="active"><a href="adminHomePage.html">Home</a></li>
            <li><a href="fileUploadPage.html">Upload Files</a> </li>
            <li class="active"><a href="#">Approve User</a></li>
      <!--       <li><a href="#">Edit Profile</a></li>   -->
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
         	<form action="Approve" method="get">

					<%
						boolean flag = true;
						ResultSet rs = (ResultSet) request.getAttribute("studentRequests");
						if(!rs.isBeforeFirst())
						{
							%><label>No details to display</label>
							<br class="clear" />
							<br class="clear" />
							<br class="clear" />
							<br class="clear" />
							<br class="clear" />
							<br class="clear" />
							<br class="clear" />
							<br class="clear" />
							<br class="clear" />
							<br class="clear" />
							<br class="clear" />
							<br class="clear" />
							<br class="clear" />
							<br class="clear" />
							<br class="clear" />
							<br class="clear" />
							<br class="clear" />
							<br class="clear" />
						<%}
						else
						{
					%>
					<table name="showRequest" style = "border:1px solid #CCCCCC">
					<tr>
						<th style = "border:1px solid #CCCCCC">Select</th>
						<th style = "border:1px solid #CCCCCC">Student Id</th>
						<th style = "border:1px solid #CCCCCC">Student Name</th>
						<th style = "border:1px solid #CCCCCC">Program</th>
						<th style = "border:1px solid #CCCCCC">Admitted Year</th>
		
					</tr>
					<%
						while (rs.next()) {
							flag = false;
					%>
					<tr>
						<td style = "border:1px solid #CCCCCC"><input type="checkbox"
							name="checkedRows"
							value="<%=rs.getString("sd_student_id")%>" /></td>
							<td style = "border:1px solid #CCCCCC"><%=rs.getString("sd_student_id")%></td>
						<td style = "border:1px solid #CCCCCC"><%=rs.getString("sd_name")%></td>
						<td style = "border:1px solid #CCCCCC"><%=rs.getString("sd_program")%></td>
						<td style = "border:1px solid #CCCCCC"><%=rs.getString("sd_admitted_year")%></td>
					</tr>
					<tr>
						<td colspan=5  style = "border:1px solid #CCCCCC">
							<center>
								<input type="submit" name="Submit" value="Approve" />
							</center>
						</td>
					</tr>
					<%} }%>
				</table>
			</form>
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
        <a href="#"></a>
        <br class="clear" />
      </div>
    </div>
  </body>
</html>
