
<%
	if (session.getAttribute("userType") == null) {
		response.sendRedirect("Logout");
	} else {
%>
<html dir="ltr" xml:lang="EN" xmlns="http://www.w3.org/1999/xhtml"
	lang="EN">
<head profile="http://gmpg.org/xfn/11">
<meta content="text/html; charset=iso-8859-1" http-equiv="content-type">
<title>Notify Page</title>
<meta content="no" http-equiv="imagetoolbar">
<link type="text/css" href="styles/layout.css" rel="stylesheet">
<!--  Author : Krishna Somayajulu -->

</head>
<body id="top">
	<!--  Author: Ujvala -->
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
			<br class="clear">
		</div>
	</div>
	<div class="wrapper col2">
		<div id="topbar">
			<div id="topnav">
				<ul>
					<li><a href="homePage.jsp">Home</a></li>
					<li><a href="#">Products</a>
						<ul>
							<li><a href="productPage.html">EduTrackSystem</a></li>
						</ul></li>
					<li><a href="contactUs.html">Contact Us</a></li>
				</ul>
			</div>
			<br class="clear">
		</div>
	</div>
	<div class="wrapper col4">
		<div id="container">
			<div id="content">
				A mail has been sent to your e-mail ID.
				<p>Please use the password sent to login!</p>
			</div>

		</div>
		<br class="clear"> <br class="clear"> <br class="clear">
		<br class="clear"> <br class="clear"> <br class="clear">
		<br class="clear"> <br class="clear"> <br class="clear">
		<br class="clear"> <br class="clear"> <br class="clear">
		<br class="clear"> <br class="clear"> <br class="clear">
		<br class="clear"> <br class="clear">
		<div class="wrapper col7">
			<div id="copyright">
				<p class="fl_left">
					Copyright © 2014 - All Rights Reserved - <a href="#">MSITMedhas</a>
				</p>
				<br class="clear">
			</div>
		</div>
	</div>
</body>
</html>
<%
	}
%>