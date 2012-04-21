<!doctype html>
<html>
<head>
<meta name="layout" content="main"/>
<title>Welcome to HappyLandlord.com!</title>
  
<style type="text/css" media="screen">
#register {
  background-color: white;
  border: .2em solid #00fff;
  margin: 2em 2em 1em;
  padding: 1em;
  width: 12em;
  float: right;
  -moz-box-shadow: 0px 0px 1.25em #ccc;
  -webkit-box-shadow: 0px 0px 1.25em #ccc;
  box-shadow: 0px 0px 1.25em #ccc;
  -moz-border-radius: 0.6em;
  -webkit-border-radius: 0.6em;
  border-radius: 0.6em;
}

  #
.ie6 #register {
  display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
}

#register ul {
  font-family: tahoma;
  font-size: 0.9em;
  list-style-type: none;
  margin-bottom: 0.6em;
  padding: 0;
}

#register h1 {
  font-family: tahoma;
  text-transform: uppercase;
  font-size: 1.1em;
  margin: 0 0 0.3em;
}
#login {
  font-family: tahoma;
  background-color: #eee;
  border: .2em solid #fff;
  margin: 2em 2em 1em;
  padding: 1em;
  width: 12em;
  float: right;
  -moz-box-shadow: 0px 0px 1.25em #ccc;
  -webkit-box-shadow: 0px 0px 1.25em #ccc;
  box-shadow: 0px 0px 1.25em #ccc;
  -moz-border-radius: 0.6em;
  -webkit-border-radius: 0.6em;
  border-radius: 0.6em;
}

          
.ie6 #login {
  display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
}

#leftside{
  margin-top: 4.2em;
  margin-bottom: 0.3em;
  margin-left: 1em;
  float: left;
}
                  
#page-body {
  margin: 2em 1em 1.25em 18em;
}

#page-body h1{
  font-family: tahoma;
  font-style: bold;
  color: black;
  font-size: 1.7em;
}         
#conLinks {
  margin-top: 1em;
  background-color: #eee;
  border: .2em solid #fff;
font-family: tahoma;
  padding: 1em;
  width: 20em;
  -moz-box-shadow: 0px 0px 1.25em #ccc;
  -webkit-box-shadow: 0px 0px 1.25em #ccc;
  box-shadow: 0px 0px 1.25em #ccc;
  -moz-border-radius: 0.6em;
  -webkit-border-radius: 0.6em;
  border-radius: 0.6em;


}
h2 {
  margin-top: 1em;
  margin-bottom: 0.3em;
  font-size: 1em;
  font-family: tahoma;
}

p {
  margin: 0;
  float: center
  font-family: tahoma;
}

#controller-list ul {
  list-style-position: inside;
  font-family: tahoma;
}

#controller-list li {
  list-style-position: inside;
  margin: 0.25em 0;
  font-family: tahoma;
}

@media screen and (max-width: 480px) {
  #status {
    display: none;
    }

#page-body {
margin: 0 1em 1em;
}

#page-body h1 {
margin-top: 0;
}
}
</style>
</head>
<body>
  <a href="#page-body" class="skip">
    <g:message code="default.link.skip.label" default="Skip to content&hellip;"/>
  </a>
  

<div id="leftside" role="complementary" align="left" style="font-family: tahoma; font-size: .95em;">
  <p>&nbsp&nbsp&nbsp&nbsp &nbsp  Manage & Maintain </p>
  <br>
    <img src="${resource(dir: 'images', file: 'houseumb.jpg')}" alt="Grails"/> 
    <br>
    <p> &nbsp &nbsp Your Rental Properties </p>
</div>
                      
<div id="page-body" role="main" style ="
           font-style: bold;
           font-family: sans-serif;
           font-size: 1em;
           background-color: white;
           ">

    <h2>     Welcome to HappyLandlord</h2>             
    <div>


  
    
<ul id="menu">
<li>
<g:remoteLink controller ="siteinfo" action="ajaxRandom" update="displayProp">
Next Property
</g:remoteLink>
</li>
</ul>
    <div id="displayProp">
                      
    </div>  
    </div>
   
  </div>

</body>
</html>