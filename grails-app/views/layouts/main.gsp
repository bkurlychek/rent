<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'login.css')}" type="text/css">
  <g:javascript library="jquery" plugin="jquery" />
  <r:require module="jquery" />	
  <g:layoutHead/>
  <r:layoutResources />
</head>
<body>
	<div id="grailsLogo" role="banner">
		<a href="/rent"><img
			src="${resource(dir: 'images', file: 'grails_logo.png')}"
			alt="Grails" /></a>
		<sec:ifLoggedIn>
			<label
				style="font-size: .9em; font-style: bold; font-family: tahoma; color: white; margin-bottom: .5em; margin-left: 25em;">
				You are logged in as <b><sec:username></sec:username></b>
			</label>
		</sec:ifLoggedIn>
		<sec:ifLoggedIn>
			<span class="menuButton"><g:link controller="logout"
					style="font-size: .9em; font-style: bold; font-family: tahoma;
			color: white; margin-bottom: .5em">Logout</g:link></span>
		</sec:ifLoggedIn>
		<sec:ifNotLoggedIn>
			<span class="menuButton"><g:link controller="login"
					style="font-size: .9em; font-style: bold; font-family: tahoma;
			color: white; margin-bottom: .5em; margin-left: 23em;">Login</g:link></span>
		</sec:ifNotLoggedIn>
		<sec:ifNotLoggedIn>
			<span class="menuButton" style="font-size: .9em; font-style: bold; font-family: tahoma;
			color: white; margin-bottom: .5em">New to HappyLandlord?<g:link controller="user" action="register" 
                        style="font-size: .9em; font-style: bold; font-family: tahoma;
			color: white;" > Sign up here!</g:link></span>
		</sec:ifNotLoggedIn>
	</div>  <div id="login">
    
    
  </div>


<g:layoutBody/>
<div class="footer" role="contentinfo"
     style="background-color: #007ca2; color: #99FFCC">
  <p style="text-align: center;">
  <g:link controller="siteinfo" action="contactus"
          style="

          text-decoration:underline;
          font-style: bold;
          font-size: 1.1em;
          font-family: tahoma
          "> Contact Us
  </g:link>


  &nbsp | &nbsp
  <g:link controller="siteinfo" action="aboutus"
          style="

          text-decoration:underline;
          font-style: bold;
          font-size: 1.1em;
          font-family: tahoma
          "> 

    About Happy Landlord      


  </g:link>
  &nbsp | &nbsp
  <g:link controller="siteinfo" action="privacy"
          style="

          text-decoration:underline;
          font-style: bold;
          font-size: 1.1em;
          font-family: tahoma
          "> 

    Privacy Policy

  </g:link>
</p>

</div>
<div id="spinner" class="spinner" style="display: none;">
  <g:message code="spinner.alt" default="Loading&hellip;" />
</div>
<g:javascript library="application" />
<r:layoutResources />
<div id="copyrights">

  <p>Copyright © 2012 Happy Landlord LLC</p>

</div>

</body>
</html>