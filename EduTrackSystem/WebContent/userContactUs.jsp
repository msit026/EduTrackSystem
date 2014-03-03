
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
<title>User contact us</title>
<meta http-equiv="imagetoolbar" content="no" />
<link rel="stylesheet" href="styles/layout.css" type="text/css" />
</head>
<body id="top">
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
	<div class="wrapper col2">
		<div id="topbar">
			<div style="width: 100%; float: right;" id="topnav">
				<ul style="width: 100%; float: right">
					<li><a href="adminHomePage.jsp">Home</a></li>
					<li><a href="fileUploadPage.jsp">Upload Files</a></li>
					<li><a href="#">Approve User</a>
						<ul>
							<li><a href="ShowPendingRequestsServlet">Students</a></li>
							<li><a href="ShowMentorsPendingRequestsServlet">Mentors</a></li>
						</ul></li>
					<!--      <li><a href="#">Edit Profile</a></li>     -->

					<li><a href="#">View Data</a>
						<ul>
							<li><a href="ShowRegisteredStudentsServlet">Registered
									Students</a></li>
							<li><a href="ShowUnRegisteredStudentsServlet">Unregistered
									Students</a></li>
							<li><a href="ShowRegisteredMentors">Registered Mentors</a></li>
							<li><a href="ShowUnregisteredMentors">UnRegistered
									Mentors</a></li>
							<li><a href="ShowCoursesServelt">Courses</a></li>
							<li><a href="ShowGradesServlet">Grades</a></li>
						</ul></li>

					<li><a href="Templates.jsp">Templates</a></li>
					<li class="active"><a href="userContactUs.jsp">Contact Us</a></li>
					<li style="float: right"><a href="Logout">Logout</a></li>
				</ul>
			</div>
			<br class="clear" />
		</div>
	</div>
	<div class="wrapper col4">
		<div id="container">
			<div id="content"></div>
			<div style="width: 1000px" id="content">
				<h3 align="center">Reach us here</h3>
				<div style="width: 100%" id="column1">
					<div style="width: 100%" class="holder">
						<table style="width: 1009px; height: 525px;">
							<tbody>
								<tr>
									<td
										style="border-right: 1px solid #CCCCCC; border-bottom: 1px solid #CCCCCC; align: center">
										<div class="fl_right">
											<br /> <br /> <br /> <br /> <img src="images/harika.jpg"
												height="150" width="120" alt="" />
										</div>
										<div class="fl_left">
											<br /> <br /> <br /> <br /> <b>Harika</b><br /> <br />
											Contact No:8790208504<br /> <br />
											E-mail:matha.harika@gmail.com<br /> <br /> <a
												title="Mouseover Description" href=""><img
												alt="Text Description" src="images/fb.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <a
												title="Mouseover Description" href=""><img
												alt="Text Description" src="images/twitter.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <a
												title="Mouseover Description"
												href="https://plus.google.com/u/0/117135051341167516147/posts"><img
												alt="Text Description" src="images/gplus.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <br /> <br />
											<br />
										</div>
									</td>
									<td
										style="border-right: 1px solid #CCCCCC; border-bottom: 1px solid #CCCCCC; align: center">
										<div class="fl_right">
											<br /> <br /> <br /> <br /> <img src="images/sneha.jpg "
												width="120" height="150" alt="" />
										</div>
										<div class="fl_left">
											<br /> <br /> <br /> <br /> <b>Sneha PVS</b><br /> <br />
											Contact No:7702725478<br /> <br />
											E-mail:snehapvs477@gmail.com<br /> <br /> <a
												title="Mouseover Description" href=""><img
												alt="Text Description" src="images/fb.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <a
												title="Mouseover Description" href="https://twitter.com/"><img
												alt="Text Description" src="images/twitter.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <a
												title="Mouseover Description"
												href="https://plus.google.com/u/0/"><img
												alt="Text Description" src="images/gplus.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <br /> <br />
											<br />
										</div>
									</td>
									<td style="border-bottom: 1px solid #CCCCCC;">
										<div class="fl_right">
											<br /> <br /> <br /> <br /> <img
												src="images/somayajulu.jpg" height="150" width="120" alt="" />
										</div>
										<div class="fl_left">
											<br /> <br /> <br /> <br /> <b>Krishna Somayajulu</b><br />
											<br /> Contact No:9703060103<br /> <br />
											E-mail:krishna1490@gmail.com<br /> <br /> <a
												title="Mouseover Description" href=""><img
												alt="Text Description" src="images/fb.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <a
												title="Mouseover Description" href=""><img
												alt="Text Description" src="images/twitter.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <a
												title="Mouseover Description" href=""><img
												alt="Text Description" src="images/gplus.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <br /> <br />
											<br />
										</div>
									</td>
								</tr>
								<tr>
									<td style="border-right: 1px solid #CCCCCC; align: center">
										<div class="fl_right">
											<br /> <br /> <br /> <br /> <img src="images/manoj.jpg"
												height="150" width="120" alt="" />
										</div>
										<div class="fl_left">
											<br /> <br /> <br /> <br /> <b>Manoj Kumar</b><br /> <br />
											Contact No:9441940141<br /> <br />
											E-mail:mano2mail@gmail.com<br /> <br /> <a
												title="Mouseover Description" href=""><img
												alt="Text Description" src="images/fb.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <a
												title="Mouseover Description"
												href="https://twitter.com/manoManojKumar"><img
												alt="Text Description" src="images/twitter.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <a
												title="Mouseover Description" href=""><img
												alt="Text Description" src="images/gplus.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <br /> <br />
											<br />
										</div>
									</td>
									<td style="border-right: 1px solid #CCCCCC; align: center">
										<div class="fl_right">
											<br /> <br /> <br /> <br /> <img src="images/ujvala.jpg"
												height="150" width="120" alt="" />
										</div>
										<div class="fl_left">
											<br /> <br /> <br /> <br /> <b>Ujvala</b><br /> <br />
											Contact No:9563249963<br /> <br />
											E-mail:ujvala.9040@gmail.com<br /> <br /> <a
												title="Mouseover Description"
												href="%0A%09%09%09%09%09%09https://www.facebook.com/rockstreetani?fref=ts"><img
												alt="Text Description" src="images/fb.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <a
												title="Mouseover Description"
												href="%0A%09%09%09%09%09%09https://www.twitter.com/"><img
												alt="Text Description" src="images/twitter.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <a
												title="Mouseover Description"
												href="%0A%09%09%09%09%09%09https://plus.google.com/"><img
												alt="Text Description" src="images/gplus.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <br /> <br />
											<br />
										</div>
									</td>
									<td>









										<div class="fl_right">
											<br /> <br /> <br /> <br /> <img src="images/sunil.jpg"
												height="150" width="120" alt="" />
										</div>
										<div class="fl_left">
											<br /> <br /> <br /> <br /> <b>Suneel Singh</b><br /> <br />
											Contact No:8106199128<br /> <br />
											E-mail:sun30nil@gmail.com<br /> <br /> <a
												title="Mouseover Description" href=""><img
												alt="Text Description" src="images/fb.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <a
												title="Mouseover Description" href=""><img
												alt="Text Description" src="images/twitter.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <a
												title="Mouseover Description" href=""><img
												alt="Text Description" src="images/gplus.png"
												style="width: 30px; height: 30px; border: 0;" /></a> <br /> <br />
											<br />
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<br class="clear" /> <br class="clear" />
			<br class="clear">
			<br class="clear">
		</div>
	</div>


	<div class="wrapper col7">
		<div id="copyright">
			<p class="fl_left">
				Copyright � 2014 - All Rights Reserved - <a href="#">MSITMedhas</a>
			</p>
			<br class="clear" />
		</div>
	</div>
</body>
</html>

<%
	}
%>