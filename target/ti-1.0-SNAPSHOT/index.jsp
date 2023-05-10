<%@ page import="pk.wieik.ti.model.WWuzytkownik" %>
<%@ page import="pk.wieik.ti.model.Narzedzia" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    WWuzytkownik uzytkownik = (WWuzytkownik) session.getAttribute("uzytkownik");
    if (uzytkownik == null) {
        uzytkownik = new WWuzytkownik();
        session.setAttribute("uzytkownik", uzytkownik);
    }
    String strona = request.getParameter("strona");
    if (uzytkownik.getUprawnienia() >= 1)
        strona = Narzedzia.parsujStrone(strona, "glowna;kwadratowe;trzecia;ustawienia");
    else strona = Narzedzia.parsujStrone(strona, "glowna;kwadratowe;trzecia");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1"/>
    <title>TI-Lab7</title>
    <link rel="stylesheet" type="text/css" href="styl.css"/>
    <script type="text/javascript" src="pierwsze.js"></script>
    <script type="text/javascript" src="kwadratowe.js"></script>
</head>
<body onload="funkcje(); zegarek(); setInterval(zegarek, 1000); podpiecie()">
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
