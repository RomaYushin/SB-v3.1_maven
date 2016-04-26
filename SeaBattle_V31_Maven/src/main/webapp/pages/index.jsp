<%-- 
    Document   : index
    Created on : 03.04.2016, 12:17:57
    Author     : Roman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> SEA BATTLE V3.0 </title>
        <link href="${pageContext.request.contextPath}/css/SeaBattle_V30_index.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <p id="headerName"> SEA BATTLE </p>
            </div>

            <div id="GamerVSComputer">
                <a href="${pageContext.request.contextPath}/ControllerServlet?action=PREPARATION_VS_COMPUTER">
                    <button id="btn1"> 
                        Gamer VS Computer 
                    </button>
                </a>
            </div>

            <div id="Gamer1VSGamer2">			
                <a href="${pageContext.request.contextPath}/ControllerServlet?action=PREPARATION_VS_SECOND_GAMER">
                    <button disabled id="btn2">
                        Gamer1 VS Gamer2 
                    </button>
                </a>				
            </div>	

    </body>
</html>
