<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
     <meta name="layout" content="main"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sample title</title>
  </head>
  <body>
    <h1> Contact Us</h1>
    
    <g:form controller="siteinfo" action="contactus" style ="font-family: tahoma; font-size: .9em;
                margin-left: 19em;">
            <dl>
                <dt>Your email Address</dt>
                <dd><g:textField name="email" />
          
                </dd>
                
                <dt>Your Name</dt>
                <dd><g:textField name="fullName" />

                </dd>
                
                <dt>Question/Comments</dt>
                <dd><g:textArea name="comments" />
                
                </dd>
                
                
                <br> 
                <dt><g:submitButton name="contactus" value="Submit" style="font-family: tahoma;"/></dt>
            </dl>

        </g:form>
  </body>
</html>
