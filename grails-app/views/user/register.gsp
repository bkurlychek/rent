<html>
    <head style="font-family: tahoma; margin-left: 14em;">
        <title >Register New Landlord</title>
        <meta name="layout" content="main" style="font-family: tahoma;"/>
        <style>
            dd {
                text-align: left;
                margin-left: 5em;
                margin-top: 1em;
                font-family: tahoma;
            }
        </style>
    </head>
    <body>

        <h1 style="font-family: tahoma; margin-left: 18em">&nbsp&nbsp Register New Landlord</h1>
        <br><br>
        <g:form action="register" style ="font-family: tahoma; font-size: .9em;
                margin-left: 23em;">
            <dl>
                <dt>User Id</dt>
                <dd><g:textField name="username" value="${user?.username}"/>
                <g:hasErrors bean="${user}" field="username">
                        <g:eachError bean="${user}" field="username">
                            <p style="color: red;"><g:message error="${it}"/></p>
                        </g:eachError>
                    </g:hasErrors>
                </dd>
                
                <dt>First Name</dt>
                <dd><g:textField name="firstName" value="${user?.firstName}"/>
                <g:hasErrors bean="${user}" field="firstName">
                        <g:eachError bean="${user}" field="firstName">
                            <p style="color: red;"><g:message error="${it}"/></p>
                        </g:eachError>
                    </g:hasErrors> 
                </dd>
                
                <dt>Last Name</dt>
                <dd><g:textField name="lastName" value="${user?.lastName}"/>
                <g:hasErrors bean="${user}" field="lastName">
                        <g:eachError bean="${user}" field="lastName">
                            <p style="color: red;"><g:message error="${it}"/></p>
                        </g:eachError>
                    </g:hasErrors>
                </dd>
                
                <dt>Password</dt>
                <dd>
                <g:passwordField name="password" value="${user?.password}"/> 
                <g:hasErrors bean="${user}" field="password">
                        <g:eachError bean="${user}" field="password">
                            <p style="color: red;"><g:message error="${it}"/></p>
                        </g:eachError>
                    </g:hasErrors>
                </dd>
                
                <dt>Email</dt>
                <dd>
                    <g:textField name="email" value="${user?.email}"/>
                    <g:hasErrors bean="${user}" field="email">
                        <g:eachError bean="${user}" field="email">
                            <p style="color: red;"><g:message error="${it}"/></p>
                        </g:eachError>
                    </g:hasErrors>
                </dd>
                
                <dt>Phone Number: </dt>
                <dd>
                  <g:textField name="phone" value="${user?.phone}"/>
                  <g:hasErrors bean="${user}" field="phone">
                        <g:eachError bean="${user}" field="phone">
                            <p style="color: red;"><g:message error="${it}"/></p>
                        </g:eachError>
                    </g:hasErrors>  
                </dd>
                <br> 
                <dt><g:submitButton name="register" value="Register" style="font-family: tahoma;"/></dt>
            </dl>

        </g:form>

    </body>
</html>