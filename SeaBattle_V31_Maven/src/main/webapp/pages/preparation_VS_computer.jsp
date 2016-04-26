<%-- 
    Document   : preparationGame
    Created on : 03.04.2016, 12:26:28
    Author     : Roman
--%>
<%@ taglib prefix="ex" uri="/WEB-INF/Print_Library.tld" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> SEA BATTLE V3.0 </title>
        <link href="${pageContext.request.contextPath}/css/SeaBattle_V30_preparationGame.css" type="text/css" rel="stylesheet">

        <script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/preparation_VS_computer.js" type="text/javascript"></script>
        <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
        <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>


    </head>
    <body>
        <div id="wrapper">	

            <div id="header">
                <p> SEA BATTLE </p>
            </div>

            <div id="header2">
                <p> PREPARATION GAME VS COMPUTER </p>
            </div>		

            <div id="Buttons">
                <div> 
                    <a href="${pageContext.request.contextPath}/ControllerServlet?action=INDEX">
                        <button id="btn1"> 
                            BACK 
                        </button>
                    </a>	
                </div>

                <div> 
                    <a href="${pageContext.request.contextPath}/ControllerServlet?action=ARRANGE_SHIPS_RANDOMLY">             
                        <button id="btn2" > 
                            ARRANGE SHIPS RANDOMLY 
                        </button>            
                </div>

                <div> 
                    <a href="${pageContext.request.contextPath}/ControllerServlet?action=GAME" id = "GO_ON">
                        <button disabled id="btn3"> 
                            GO ON! 
                        </button>
                    </a>
                </div>
            </div>	

            <div id="mainContent">
                <div id = "ships">
                    <table class="deck4" >
                        <tbody>
                            <tr>
                                <th class = "yesShip"> </th>
                                <th class = "yesShip"> </th>
                                <th class = "yesShip"> </th>
                                <th class = "yesShip"> </th>
                            </tr>
                        </tbody>
                    </table>
                    <table class="deck3">
                        <tbody>
                            <tr>
                                <th class = "yesShip"> </th>
                                <th class = "yesShip"> </th>
                                <th class = "yesShip"> </th>
                            </tr>
                        </tbody>
                    </table>

                    <table class="deck2">
                        <tbody>
                            <tr>
                                <th class = "yesShip"> </th>
                                <th class = "yesShip"> </th>
                            </tr>
                        </tbody>
                    </table>
                    <table class="deck1">
                        <tbody>
                            <tr>
                                <th class = "yesShip"> </th>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div id="shipNumber">
                    <p class = "p_deck4">x 1</p>
                    <p class = "p_deck3">x 2</p>
                    <p class = "p_deck2">x 3</p>
                    <p class = "p_deck1">x 4</p>
                </div>

                <div id="GamerBattlefield">                    
                    <ex:printBattlefieldGamer battlefieldGamer = "${battlefieldGamer}"/>                                                    
                </div>
            </div>
    </body>
</html>
