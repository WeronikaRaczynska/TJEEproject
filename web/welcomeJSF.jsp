<%--
    Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.

--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%--
    This file is an entry point for JavaServer Faces application.
--%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="Style/css/styles.css">
            <title>BLAKE</title>
        </head>
        <body>
            <div id="header">
                <h1><h:outputText value="HASH FUNCTION WITH BLAKE ALGORITHM"/></h1>
            </div>

            <div id ="hash">
                <form method="post" action="/Final1/webresources/newhash">
                    <h3><h:outputText value="Text for hash:"/></h3>   
                    <input class="intext" name="text" value="text" maxlength="20"><br/>
                    <input class="insubmit" type="submit" value="Generate hash"/>
                </form>
            </div>
            <div id="base">
                <form action="./ShowDatabase">
                <h3><h:outputText value="Hash history"/></h3>
                <input class="insubmit"  type="submit" value="Show full history"/> 
                </form>
            </div>            
            <div id="save">
                <form action="./Insert">
                    <h4><h:outputText value="New hash: "/><h:outputText value="#{bean.hashFunction}"/></h4>
                    <h4><h:outputText value="New text: "/><h:outputText value="#{bean.newText}"/></h4>
                   <input class="insubmit" type="submit" value="Save"/>
                </form>
            </div> 
        </body>
    </html>
</f:view>
