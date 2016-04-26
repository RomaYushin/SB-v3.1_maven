<%-- 
    Document   : game
    Created on : 03.04.2016, 12:35:28
    Author     : Roman
--%>

<%@ taglib prefix="ex" uri="/WEB-INF/Print_Library.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.lang.String"%>
<%@page import="java.lang.Integer"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> SEA BATTLE V3.0 </title>
        <link href="${pageContext.request.contextPath}/css/SeaBattle_V30_game.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/game2.js"></script>


    </head>
    <body >
        <div id="wrapper">
            <div id="header"> SEA BATTLE </div>			
            <div id="Inf">
                <div id="GamerInf"> GamerInf </div>				
                <div id="ComputerInf"> ComputerInf </div>	
                <div id="PictureInf">                     
                    <div id = "showGamerWin">
                        <p> TRIUMPH !!!         </br>
                            YOU ARE WINNER!!!   </br>
                        </p>
                    </div>

                    <div id = "showComputerWin">
                        <p> COMPUTER WIN!!!    </br>
                            YOU ARE LOSER !!!   </br>
                        </p>
                    </div> 
                    
                    <div id = "showAlreadyShoot">
                        <p> YOU HAVE ALREADY SHOOT </br>
                            ON THIS COORDINATE!!! </br>
                            TRY AGAIN </br>
                        </p>
                    </div>  
                </div>	
            </div>

            <div id="Battlefield">                
                <div id="GamerBattlefield">	
                    <ex:printUsedBattlefieldGamer usedBattlefieldGamer = "${usedBattlefieldGamer}"/>
                </div> 	

                <div id="ComputerBattlefield">             
                    <ex:printUsedBattlefieldComputer usedBattlefieldComp = "${usedBattlefieldComp}"/>                    
                </div>

                <div id="GamerMove"> 
                    <!-- GamerMove -->
                    <img src = "${pageContext.request.contextPath}/images/greenTriangle_150x150.png">
                </div>

                <div id="ComputerMove"> 
                    <!-- ComputerMove -->
                    <img src = "${pageContext.request.contextPath}/images/redTriangle_150x150.png">
                </div>										
            </div>

            <div id="footer" >
                <div id="GamerFooter"> MY FLEET </div>
                <div id="ComputerFooter"> COMPUTER FLEET </div>
                <div id="EndGameFooter">
                    <a href="${pageContext.request.contextPath}/ControllerServlet?action=PREPARATION_VS_COMPUTER">
                        <button id="btn1"> 
                            NEW GAME 
                        </button></a>
                    <a href="${pageContext.request.contextPath}/ControllerServlet?action=INDEX">
                        <button id="btn2"> 
                            EXIT  
                        </button></a>
                </div>
            </div>
        </div>
    </body>
</html>
