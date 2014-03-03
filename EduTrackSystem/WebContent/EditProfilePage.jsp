<%@page import="java.sql.*"%>
<%@page import="com.ets.classes.*"%>
<%
	if (session.getAttribute("userType") == null) {
		response.sendRedirect("Logout");
	} else {
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="EN" xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN"
	dir="ltr">
<head profile="http://gmpg.org/xfn/11">
<meta http-equiv="content-type"
	content="application/xhtml+xml; charset=iso-8859-1" />
<title>Edit Profile</title>
<meta http-equiv="imagetoolbar" content="no" />
<link rel="stylesheet" href="styles/layout.css" type="text/css" />
<script language="Javascript" src="scripts/ValidateRegistration.js"></script>

<script>
     function inputStudentProfile()
     {
    	<% String role = (String) session.getAttribute("userType");System.out.println(role+">>>>");%>
    	 <%if (role.equals("student")) {%>
    	 <%
				Student s = new Student();
				
				
				String uid = (String) session.getAttribute("uname");
				ResultSet rs = (ResultSet) s.getAllDetails(uid);
			try{
				while (rs.next()) {
				%>
    	 		
    	     document.getElementById('regno').value="<%=rs.getString("sd_student_id")%>";
    	     document.getElementById('fname').value="<%=rs.getString("sd_name")%>";
    		 document.getElementById('address').value="<%=rs.getString("sd_address")%>";
    		 document.getElementById('dob').value="<%=rs.getString("sd_dob")%>";
    		 document.getElementById('mobileno').value="<%=rs.getString("sd_phone")%>";
    		 document.getElementById('emailId').value="<%=rs.getString("sd_email")%>";
    		 document.getElementById('password').value="<%=rs.getString("sd_password")%>";
    		 document.getElementById('reenter').value="<%=rs.getString("sd_password")%>";
    		 document.getElementById('reenter').value="<%=rs.getString("sd_password")%>";
<%} }catch(Exception e){e.printStackTrace();}%>
	document.getElementById('role').value = "Student";
<%}%>
	
		<%if (role.equals("mentor")) {%>
		//alert("mentor");
		<%
		Mentor m = new Mentor();
		String uid = (String) session.getAttribute("uname");
		System.out.println(uid+"resultset");
		ResultSet rs = (ResultSet) m.getAllDetails(uid);
		while (rs.next()) {
				%>
				//alert("mentor"+uid+"dkkd");
				document.getElementById('regno').value="<%=rs.getString("md_mentor_id")%>";
				document.getElementById('fname').value="<%=rs.getString("md_name")%>";
				document.getElementById('address').value="<%=rs.getString("md_address")%>";
				document.getElementById('dob').value="<%=rs.getString("md_dob")%>";
				document.getElementById('mobileno').value="<%=rs.getString("md_phone")%>";
				document.getElementById('emailId').value="<%=rs.getString("md_email")%>";
				document.getElementById('password').value="<%=rs.getString("md_password")%>";
				document.getElementById('reenter').value="<%=rs.getString("md_password")%>";
				document.getElementById('reenter').value="<%=rs.getString("md_password")%>";
				<%}%>
	document.getElementById('role').value = "Mentor";
<%}%>

	}
</script>
</head>
<body id="top" onload="inputStudentProfile()">
	<div class="wrapper col1">
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#">LC Solutions</a>
				</h1>
				<p>
					<strong>Helping you build your dream</strong>
				</p>
			</div>
			<br class="clear" />
		</div>
	</div>
	<%
		if (session.getAttribute("userType") != null
					&& session.getAttribute("userType").toString()
							.equalsIgnoreCase("student")) {
	%>
	<div class="wrapper col2">
		<div id="topbar">
			<div style="width: 100%; float: right;" id="topnav">
				<ul style="width: 100%; float: right">
					<li><a href="StudentHomePage.jsp">Home</a></li>
					<li><a href="ShowCoursesServelt">View Courses</a></li>
					<li><a href="ViewResult.jsp">View Result</a></li>
					<li><a href="viewStudentFeedback.jsp">View feedback</a></li>
					<li class="active"><a href="EditProfilePage.jsp">Edit Profile</a></li>
					<li style="float: right"><a href="Logout">Logout</a></li>
				</ul>
			</div>
			<br class="clear" />
		</div>
	</div>
	<%
		} else if (session.getAttribute("userType") != null
					&& session.getAttribute("userType").toString()
							.equalsIgnoreCase("mentor")) {
	%>
	<div class="wrapper col2">
		<div id="topbar">
			<div style="width: 100%; float: right;" id="topnav">
				<ul style="width: 100%; float: right">
					<li><a href="MentorHomePage.jsp">Home</a></li>
					<li><a href="#">View Reports</a>
						<ul>
							<li><a
								href="http://localhost:80/phpFiles/CourseMarksGraph.html">year
									Wise Student Report</a></li>
							<li><a href="http://localhost/phpFiles/gradeAnalysis.html">Overall
									Performance Grade Wise </a></li>
							<li><a href="http://localhost/phpFiles/gradesAjax.html">Overall
									Performance Course Wise </a></li>
							<li><a href="http://localhost/phpFiles/rollNumberAjax.html">Course
									Wise Student Report</a></li>
							<li><a
								href="http://localhost/phpFiles/studentGradesForCourse.html">Batch
									Analysis Course Wise</a></li>
							<li><a
								href="http://localhost/phpFiles/studentsCGPAGraph.html">Batch
									Wise CGPA Analysis</a></li>
						</ul></li>
					<li><a href="PredictionTool.jsp">Predict CGPA</a></li>
					<li><a href="Feedbackjsp.jsp">Give feedback</a></li>
					<li><a href="ViewFeedback.jsp">View feedback</a></li>
					<li class="active"><a href="EditProfilePage.jsp">Edit Profile</a></li>
					<li style="float: right"><a href="Logout">Logout</a></li>
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
				<div id="main">
					<form name="registration" action="UpdateProfiles">
						<center>
							<h3>
								<span style="color: black"> <b>Edit Your Details</b></span>
							</h3>
						</center>
						<fieldset name="registrationForm"
							style="margin: auto; width: 600px;">
							<legend>Registration Form</legend>
							<div id="show2" height="200"></div>
							<table style="width: 600px" align="center" cellpadding="7">
								<tbody>
									<tr>
										<td align="right"><span
											style="font-size: 12px; color: black">RegistrationID:</td>
										<td><input name="regno" id="regno" size="30"
											onblur="validateID" placeholder="RegNo"
											onchange="resetField()" type="text" readonly="readonly"><span
												style="color: black;" id="error00"> </span></td>
									</tr>
									<tr>
										<td align="right"><span
											style="font-size: 12px; color: black">First Name:</span></td>
										<td><input type="text" name="fname" id="fname" size="30"
											placeholder="First name" onblur="validateName()"
											onchange="resetField()"> <span style="color: red;"
												id="error"> </span></td>
									</tr>

									<tr>
										<td align="right"><span
											style="font-size: 12px; color: black">Address:</span></td>
										<td><textarea name="address" id="address" rows="5"
												onblur="validateAdress()" cols="24" placeholder="Address"
												onchange="resetField()"></textarea><span style="color: red;"
											id="error1"> </span></td>
									</tr>
									<tr>
										<td align="right"><span
											style="font-size: 12px; color: black">Date of birth:</span></td>
										<td><input name="dob" id="dob" size="30"
											placeholder="yyyy-mm-dd" onblur="validateDate()"
											onchange="resetField()" type="date"> <span
												style="color: red;" id="error2"> </span></td>
									</tr>

									<tr>
										<td align="right"><span
											style="font-size: 12px; color: black">MobileNo:</span></td>
										<td><span style="font-size: 12px; color: black">+91</span>
											<input name="mobileno" id="mobileno" size="25"
											placeholder="10 digits" onblur="validateMobile()"
											onchange="resetField()" type="text"><span
												style="color: red;" id="error4"> </span></td>
									</tr>
									<tr>
										<td align="right"><span
											style="font-size: 12px; color: black">Email Id:</span></td>
										<td><input name="emailId" id="emailId" size="30"
											placeholder="id@example.com" onblur="validateEmail()"
											onchange="resetField()"> <span style="color: red;"
												id="error5"> </span></td>
									</tr>
									<tr>
										<td align="right"><span
											style="font-size: 12px; color: black">Choose Password:</span></td>
										<td><input name="password" id="password"
											placeholder="min 8 characters" onblur="validatePassword()"
											onchange="resetField()" type="password"><span
												style="color: red;" id="error6"> </span></td>
									</tr>
									<tr>
										<td align="right"><span
											style="font-size: 12px; color: black">Re-Enter
												Password:</span></td>
										<td><input name="reenter" id="reenter" size="30"
											placeholder="re-enter" onblur="validateRePassword()"
											onchange="resetField()" type="password"><span
												style="color: red;" id="error7"> </span></td>
									</tr>

									<tr>
										<td align="right"><span
											style="font-size: 12px; color: black"></span></td>
										<td><input name="role" id="role" size="30" type="hidden"><span
												style="color: red;" id="error7"> </span></td>
									</tr>

									<tr>
										<td id="fill1" name="fill1" align="right"><br></td>
										<td id="fill2" name="fill2"><br></td>
									</tr>
									<tr>
										<td colspan="3">
											<center>
												
													<input value="Save" name="save" id="buttonSubmit" type="submit">
											</center>
										</td>
									</tr>
								</tbody>
							</table>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
		<br class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" />
		<div class="wrapper col7">
			<div id="copyright">
				<p class="fl_left">
					Copyright © 2014 - All Rights Reserved - <a href="#">MSITMedhas</a>
				</p>
				<br class="clear" />
			</div>
		</div>
	</div>
</body>
</html>
<%
	}
%>