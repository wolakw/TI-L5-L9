<%@ page import="pk.wieik.ti.model.WWuzytkownik" %>
<%@ page import="pk.wieik.ti.model.Narzedzia" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="uzytkownik" class="pk.wieik.ti.model.WWuzytkownik" scope="session"/>
<%
    String strona = request.getParameter("strona");
    String podstrony = "glowna;kwadratowe;trzecia";
    if (uzytkownik.getUprawnienia() > 0) {
        podstrony += ";ustawienia";
    }
    if (uzytkownik.getUprawnienia() == 2) {
        podstrony += ";administracja";
    }
    strona = Narzedzia.parsujStrone(strona, podstrony);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1"/>
    <title>TI-Lab8</title>
    <link rel="stylesheet" type="text/css" href="styl.css"/>
    <script type="text/javascript" src="pierwsze.js"></script>
    <script type="text/javascript" src="kwadratowe.js"></script>
</head>
<body onload="funkcje(); zegarek(); setInterval(zegarek, 1000); podpiecie()">
<html style="background-color: ${(empty applicationScope.kolorTla) ?
                                '#DAF7DC' : applicationScope.kolorTla}">
<div id="kontener">
    <div id="naglowek">
        <jsp:include page="/WEB-INF/widok/naglowek.jsp"/>
    </div>
    <div id="srodek">
        <div id="menu">
            <jsp:include page="/WEB-INF/widok/menu.jsp"/>
        </div>
        <div id="tresc">
            <jsp:include page="/WEB-INF/widok/tresc.jsp">
                <jsp:param name="jaka_strona" value="<%=strona%>"/>
            </jsp:include>
        </div>
    </div>
    <div id="stopka">
        <jsp:include page="/WEB-INF/widok/stopka.jsp"/>
    </div>
</div>
</body>
</html>
