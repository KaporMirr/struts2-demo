<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:url action="hello" var="helloLink">
    <s:param name="userName">Bruce Pillips</s:param>
</s:url>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Struts 2 Playground Application</title>
        <s:head />
        <style>
            body {
                font-family: sans-serif;
            }
        </style>
    </head>
    <body>
        <p>
            <input type="button" onclick="location.reload()" value="Browser Reload">
            <input type="button" onclick="window.location.assign('<s:url action="index" />')" value="Self">
        </p>
        <h1>Welcome to Struts 2!</h1>
        <p><input type="button" onclick="window.location.assign('<s:url action="otsDemo" />')" value="🧩 Go To Demo"></p>
        <p><input type="button" onclick="window.location.assign('<s:url action="newSession" />')" value="⚡️ New Session"></p>
        <p><a href="index.jsp">index.jsp</a></p>
    </body>
</html>